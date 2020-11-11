package com.etaran.tetris.service;

import com.etaran.tetris.model.Field;
import com.etaran.tetris.model.Figure;
import com.etaran.tetris.service.rotation.RotationService;


public class FieldService {

    private final RotationService rotationService;
    private final DrawService drawService;

    public FieldService(RotationService rotationService, DrawService drawService) {
        this.rotationService = rotationService;
        this.drawService = drawService;
    }

    Field field = new Field();

    public void rotateFigure() {
        rotationService.rotateFigure(field);
    }

    public void produceNewFigure() {
        field.setCurrentFigure(Figure.BLUE_J);

    }

    private void drawFigure() {

    }

    public Field getField() {
        return field;
    }
}
