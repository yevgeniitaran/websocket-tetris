package com.etaran.tetris.service;

import com.etaran.tetris.controller.dto.Action;
import com.etaran.tetris.model.Cell;
import com.etaran.tetris.model.Field;
import com.etaran.tetris.model.MoveDirection;
import com.etaran.tetris.model.Point;
import com.etaran.tetris.service.draw.DrawService;
import com.etaran.tetris.service.rotation.RotationService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public void produceNewFigure() {
        drawService.drawFigure(field, randomFigureGenerator.produceFigure());
    }

    public void tick() {
        if (field.isFigureCollapsed()) {
            clearLines();
            field.clearCurrentFigure();
        }
        if (field.isGameEnded()) {
            field = new Field();
            return;
        }
        if (field.getCurrentFigure() == null) {
            produceNewFigure();
        } else {
            moveCurrentFigureToBottom();
        }
    }

    private void moveCurrentFigureToBottom() {
        if (field.isFigureCollapsed()) {
            clearLines();
            field.clearCurrentFigure();
            return;
        }
        List<Point> movedPoints = new ArrayList<>();
        synchronized (field) {
            for (Point figurePoint : field.getFigurePoints()) {
                Point movedPoint = new Point(figurePoint.x + 1, figurePoint.y);
                movedPoints.add(movedPoint);
            }
            field.setFigureCenter(new Point(field.getFigureCenter().x + 1, field.getFigureCenter().y));
            field.redrawFigure(movedPoints);
        }
    }

    private void moveCurrentFigure(MoveDirection direction) {
        int yChange = direction == MoveDirection.LEFT ? -1 : 1;
        synchronized (field) {
            List<Point> movedPoints = new ArrayList<>();
            for (Point figurePoint : field.getFigurePoints()) {
                Point movedPoint = new Point(figurePoint.x, figurePoint.y + yChange);
                if (field.isPointBusy(movedPoint)) {
                    return;
                }
                movedPoints.add(movedPoint);
            }
            field.setFigureCenter(new Point(field.getFigureCenter().x, field.getFigureCenter().y + yChange));
            field.redrawFigure(movedPoints);
        }
    }

    private void clearLines() {
        Set<Integer> rowsForCheck = new HashSet<>();
        for (Point figurePoint : field.getFigurePoints()) {
            rowsForCheck.add(figurePoint.x);
        }
        for (Integer rowNumber : rowsForCheck) {
            boolean rowComplete = true;
            for (int i = 0; i < Field.FIELD_WIDTH; i++) {
                if (!field.getCells()[rowNumber][i].isBusy()) {
                    rowComplete = false;
                }
            }
            synchronized (field) {
                if (rowComplete) {
                    for (int i = rowNumber; i > 1; i--) {
                        field.getCells()[i] = field.getCells()[i - 1];
                    }
                    for (int rowNum = 0; rowNum <= 1; rowNum++) {
                        field.getCells()[rowNum] = new Cell[Field.FIELD_WIDTH];
                        for (int i = 0; i < Field.FIELD_WIDTH; i++) {
                            field.getCells()[rowNum][i] = new Cell();
                        }
                    }
                    field.setScore(field.getScore() + 10);
                }
            }
        }
    }



    public void performAction(Action action) {
        if (field.getCurrentFigure() == null) {
            return;
        }
        if (action == Action.LEFT) {
            moveCurrentFigure(MoveDirection.LEFT);
        } else if (action == Action.RIGHT) {
            moveCurrentFigure(MoveDirection.RIGHT);
        } else if (action == Action.DOWN) {
            moveCurrentFigureToBottom();
        } else if (action == Action.ROTATE) {
            rotationService.rotateFigure(field);
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public Field getField() {
        return field;
    }
}
