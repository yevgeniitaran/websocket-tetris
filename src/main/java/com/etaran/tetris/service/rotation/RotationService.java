package com.etaran.tetris.service.rotation;

import com.etaran.tetris.model.Field;
import com.etaran.tetris.model.Shape;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.function.Consumer;

@Service
public class RotationService {

    private final Map<Shape, Consumer<Field>> rotationProcessorsMap;

    public RotationService(JRotationService jRotationService, ZRotationService zRotationService, SRotationService sRotationService,
                           TRotationService tRotationService, IRotationService iRotationService, LRotationService lRotationService) {
        rotationProcessorsMap = Map.of(
                Shape.J, jRotationService::rotateFigure,
                Shape.Z, zRotationService::rotateFigure,
                Shape.S, sRotationService::rotateFigure,
                Shape.T, tRotationService::rotateFigure,
                Shape.I, iRotationService::rotateFigure,
                Shape.L, lRotationService::rotateFigure
        );
    }

    public void rotateFigure(Field field) {
        rotationProcessorsMap.get(field.getCurrentFigure().getShape()).accept(field);
    }
}
