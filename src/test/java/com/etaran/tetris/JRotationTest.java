package com.etaran.tetris;

import com.etaran.tetris.model.Figure;
import com.etaran.tetris.service.DrawService;
import com.etaran.tetris.service.FieldService;
import com.etaran.tetris.service.rotation.JRotationService;
import com.etaran.tetris.service.rotation.RotationService;
import org.junit.jupiter.api.Test;

public class JRotationTest {

    @Test
    void J_oneTurn_processedSuccessfully() {
        FieldService fieldService = new FieldService(new RotationService(new JRotationService()), new DrawService());
        fieldService.getField().setCurrentFigure(Figure.BLUE_J);
        fieldService.rotateFigure();
    }
}

