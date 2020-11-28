package com.etaran.tetris.service;

import com.etaran.tetris.controller.dto.Action;
import com.etaran.tetris.model.Field;
import com.etaran.tetris.model.MoveDirection;
import com.etaran.tetris.model.Point;
import com.etaran.tetris.service.rotation.RotationService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FieldService {

    private final RotationService rotationService;
    private final DrawService drawService;
    private final RandomFigureGenerator randomFigureGenerator;

    public FieldService(RotationService rotationService, DrawService drawService, RandomFigureGenerator randomFigureGenerator) {
        this.rotationService = rotationService;
        this.drawService = drawService;
        this.randomFigureGenerator = randomFigureGenerator;
    }

    private Field field = new Field();

    public void rotateFigure() {
        rotationService.rotateFigure(field);
    }

    public void produceNewFigure() {
        drawService.drawFigure(field, randomFigureGenerator.produceFigure());
    }

    public void tick() {
        if (field.isGameEnded()) {
            field = new Field();
            return;
        }
        if (field.getCurrentFigure() == null) {
            produceNewFigure();
        } else {
            moveCurrentFigureToBottom();
        }
        if (field.isGameEnded()) {
            field = new Field();
        }
    }

    private void moveCurrentFigureToBottom() {
        List<Point> movedPoints = new ArrayList<>();
        synchronized (field) {
            for (Point figurePoint : field.getFigurePoints()) {
                Point movedPoint = new Point(figurePoint.x + 1, figurePoint.y);
                if (movedPoint.x >= Field.FIELD_HEIGHT - 1 || (field.getCells()[movedPoint.x + 1][movedPoint.y].isBusy()
                        && !field.getFigurePoints().contains(movedPoint))) {
                    field.setFigureCollapsed(true);
                }
                movedPoints.add(movedPoint);
            }
            redrawPoints(movedPoints);
        }

        if (field.isFigureCollapsed()) {
            field.clearCurrentFigure();
        }
    }

    private void moveCurrentFigure(MoveDirection direction) {
        int yChange = direction == MoveDirection.LEFT ? -1 : 1;
        synchronized (field) {
            List<Point> movedPoints = new ArrayList<>();
            for (Point figurePoint : field.getFigurePoints()) {
                Point movedPoint = new Point(figurePoint.x, figurePoint.y + yChange);
                if (movedPoint.y < 0 || movedPoint.y >= Field.FIELD_WIDTH ||
                        (field.getCells()[movedPoint.x][movedPoint.y].isBusy() && !field.getFigurePoints().contains(movedPoint))) {
                    return;
                }
                movedPoints.add(movedPoint);
            }

            redrawPoints(movedPoints);
        }
    }

    private void redrawPoints(List<Point> movedPoints) {
        field.hideFigure();
        field.getFigurePoints().clear();
        field.getFigurePoints().addAll(movedPoints);
        field.showFigure();
    }

    public void performAction(Action action) {
        if (action == Action.LEFT) {
            moveCurrentFigure(MoveDirection.LEFT);
            return;
        }
        if (action == Action.RIGHT) {
            moveCurrentFigure(MoveDirection.RIGHT);
            return;
        }
        if (action == Action.DOWN) {
            moveCurrentFigureToBottom();
            return;
        }
        throw new UnsupportedOperationException();
    }

    public Field getField() {
        return field;
    }
}
