package com.etaran.tetris;

import com.etaran.tetris.model.Figure;
import com.etaran.tetris.service.DrawService;
import com.etaran.tetris.service.FieldService;
import com.etaran.tetris.service.RandomFigureGenerator;
import com.etaran.tetris.service.rotation.JRotationService;
import com.etaran.tetris.service.rotation.RotationService;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class JRotationTest {

    @Test
    void J_draw_processedSuccessfully() {
        RandomFigureGenerator randomFigureGenerator = mock(RandomFigureGenerator.class);
        when(randomFigureGenerator.produceFigure()).thenReturn(Figure.BLUE_J);

        FieldService fieldService = new FieldService(new RotationService(new JRotationService()), new DrawService(), randomFigureGenerator);
        fieldService.produceNewFigure();

    }
}

