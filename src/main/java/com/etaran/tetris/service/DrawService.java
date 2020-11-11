package com.etaran.tetris.service;

import com.etaran.tetris.model.Field;

public class DrawService {

    public void drawElement(Field field) {
        field.setFigureCenterX(5);
        field.setFigureCenterY(1);

    }
}
