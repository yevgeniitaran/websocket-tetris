package com.etaran.tetris.service.rotation;

import com.etaran.tetris.model.Field;
import com.etaran.tetris.model.Shape;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.function.Consumer;

@Service
public class RotationService {

    private final JRotationService jRotationService;

    private final Map<Shape, Consumer<Field>> rotationProcessorsMap;

    public RotationService(JRotationService jRotationService) {
        this.jRotationService = jRotationService;
        rotationProcessorsMap = Map.of(
                Shape.J, jRotationService::rotateFigure
        );
    }

    public void rotateFigure(Field field) {
        rotationProcessorsMap.get(field.getCurrentFigure().getShape()).accept(field);
    }
}
