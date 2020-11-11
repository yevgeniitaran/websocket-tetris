package com.etaran.tetris.service.rotation;

import com.etaran.tetris.model.Field;
import com.etaran.tetris.model.Shape;

public class JRotationService {

    public void rotateFigure(Field field) {
        if (field.getCurrentFigure().getShape() != Shape.J) {
            throw new IllegalStateException("Can't rotate non-J shape");
        }
        System.out.println("Successful J-Rotation");
    }
}
