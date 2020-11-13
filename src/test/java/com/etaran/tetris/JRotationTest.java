package com.etaran.tetris;

import com.etaran.tetris.model.Figure;
import com.etaran.tetris.service.DrawService;
import com.etaran.tetris.service.FieldService;
import com.etaran.tetris.service.RandomFigureGenerator;
import com.etaran.tetris.service.rotation.JRotationService;
import com.etaran.tetris.service.rotation.RotationService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class JRotationTest {

    @Test
    void J_draw_processedSuccessfully() {
        RandomFigureGenerator randomFigureGenerator = mock(RandomFigureGenerator.class);
        when(randomFigureGenerator.produceFigure()).thenReturn(Figure.BLUE_J);

        FieldService fieldService = new FieldService(new RotationService(new JRotationService()), new DrawService(), randomFigureGenerator);
        fieldService.produceNewFigure();

        assertTrue(fieldService.getField().getCells()[DrawService.FIELD_CENTER][DrawService.J_FIELD_VERTICAL_CENTER].isBusy());
        assertTrue(fieldService.getField().getCells()[DrawService.FIELD_CENTER][DrawService.J_FIELD_VERTICAL_CENTER - 1].isBusy());
        assertTrue(fieldService.getField().getCells()[DrawService.FIELD_CENTER][DrawService.J_FIELD_VERTICAL_CENTER + 1].isBusy());
        assertTrue(fieldService.getField().getCells()[DrawService.FIELD_CENTER - 1][DrawService.J_FIELD_VERTICAL_CENTER + 1].isBusy());
        assertEquals(DrawService.FIELD_CENTER, fieldService.getField().getFigureCenterX());
        assertEquals(DrawService.J_FIELD_VERTICAL_CENTER, fieldService.getField().getFigureCenterY());
    }
}

