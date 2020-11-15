package com.etaran.tetris.service;

import com.etaran.tetris.model.Field;
import com.etaran.tetris.model.Figure;
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

    Field field = new Field();

    public void rotateFigure() {
        rotationService.rotateFigure(field);
    }

    public void produceNewFigure() {
        drawService.drawFigure(field, randomFigureGenerator.produceFigure());
    }

    public void tick() {
        if (field.getCurrentFigure() == null) {
            produceNewFigure();
        } else {
            moveCurrentFigure();
            if (field.isFigureCollapsed()) {
                field.clearFigure();
            }
        }
    }

    private void moveCurrentFigure() {
        List<Point> movedPoints = new ArrayList<>();
        for (Point figurePoint : field.getFigurePoints()) {
            if (figurePoint.x + 1 >= Field.FIELD_HEIGHT - 1) {
                field.setFigureCollapsed(true);
            }
            movedPoints.add(new Point(figurePoint.x + 1, figurePoint.y));
        }

        field.hideFigure();
        field.getFigurePoints().clear();
        field.getFigurePoints().addAll(movedPoints);
        field.showFigure();
    }


    public Field getField() {
        return field;
    }
}
