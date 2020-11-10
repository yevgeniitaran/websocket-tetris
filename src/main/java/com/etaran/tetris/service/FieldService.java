package com.etaran.tetris.service;

import com.etaran.tetris.model.Field;
import com.etaran.tetris.service.rotation.RotationService;

public class FieldService {

    private final RotationService rotationService;

    public FieldService(RotationService rotationService) {
        this.rotationService = rotationService;
    }

    Field field = new Field();

    public void rotateFigure() {
        System.out.println("Successful rotation");
    }

    public Field getField() {
        return field;
    }
}
