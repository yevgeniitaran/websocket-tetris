package com.etaran.tetris;

import com.etaran.tetris.model.Field;
import com.etaran.tetris.model.Figure;
import com.etaran.tetris.service.DrawService;
import com.etaran.tetris.service.FieldService;
import com.etaran.tetris.service.RandomFigureGenerator;
import com.etaran.tetris.service.rotation.JRotationService;
import com.etaran.tetris.service.rotation.RotationService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class JFigureTest {

    @Test
    void J_draw_processedSuccessfully() {
        RandomFigureGenerator randomFigureGenerator = mock(RandomFigureGenerator.class);
        when(randomFigureGenerator.produceFigure()).thenReturn(Figure.BLUE_J);

        FieldService fieldService = new FieldService(new RotationService(new JRotationService()), new DrawService(), randomFigureGenerator);
        fieldService.tick();

        assertTrue(fieldService.getField().getCells()[DrawService.J_FIELD_VERTICAL_CENTER][DrawService.FIELD_CENTER].isBusy());
        assertTrue(fieldService.getField().getCells()[DrawService.J_FIELD_VERTICAL_CENTER - 1][DrawService.FIELD_CENTER].isBusy());
        assertTrue(fieldService.getField().getCells()[DrawService.J_FIELD_VERTICAL_CENTER + 1][DrawService.FIELD_CENTER].isBusy());
        assertTrue(fieldService.getField().getCells()[DrawService.J_FIELD_VERTICAL_CENTER + 1][DrawService.FIELD_CENTER - 1].isBusy());
        assertEquals(DrawService.J_FIELD_VERTICAL_CENTER, fieldService.getField().getFigureCenter().x);
        assertEquals(DrawService.FIELD_CENTER, fieldService.getField().getFigureCenter().y);
    }

    @Test
    void J_moves_successfully() {
        RandomFigureGenerator randomFigureGenerator = mock(RandomFigureGenerator.class);
        when(randomFigureGenerator.produceFigure()).thenReturn(Figure.BLUE_J);

        FieldService fieldService = new FieldService(new RotationService(new JRotationService()), new DrawService(), randomFigureGenerator);
        fieldService.tick();
        fieldService.tick();
        assertFalse(fieldService.getField().getCells()[DrawService.J_FIELD_VERTICAL_CENTER - 1][DrawService.FIELD_CENTER].isBusy());
        assertTrue(fieldService.getField().getCells()[DrawService.J_FIELD_VERTICAL_CENTER + 1][DrawService.FIELD_CENTER].isBusy());
        assertTrue(fieldService.getField().getCells()[DrawService.J_FIELD_VERTICAL_CENTER ][DrawService.FIELD_CENTER].isBusy());
        assertTrue(fieldService.getField().getCells()[DrawService.J_FIELD_VERTICAL_CENTER + 2][DrawService.FIELD_CENTER].isBusy());
        assertTrue(fieldService.getField().getCells()[DrawService.J_FIELD_VERTICAL_CENTER + 2][DrawService.FIELD_CENTER - 1].isBusy());
    }

    @Test
    void J_moves_to_bottom_successfully() {
        RandomFigureGenerator randomFigureGenerator = mock(RandomFigureGenerator.class);
        when(randomFigureGenerator.produceFigure()).thenReturn(Figure.BLUE_J);

        FieldService fieldService = new FieldService(new RotationService(new JRotationService()), new DrawService(), randomFigureGenerator);
        for (int i = 0; i < Field.FIELD_HEIGHT - 2; i++) {
            fieldService.tick();
        }

        assertTrue(fieldService.getField().getCells()[Field.FIELD_HEIGHT - 1][DrawService.FIELD_CENTER].isBusy());
        assertTrue(fieldService.getField().getCells()[Field.FIELD_HEIGHT - 2][DrawService.FIELD_CENTER].isBusy());
        assertTrue(fieldService.getField().getCells()[Field.FIELD_HEIGHT - 3][DrawService.FIELD_CENTER].isBusy());
        assertTrue(fieldService.getField().getCells()[Field.FIELD_HEIGHT - 1][DrawService.FIELD_CENTER - 1].isBusy());
    }

    @Test
    void afterCollapse_newFigureProduced() {
        RandomFigureGenerator randomFigureGenerator = mock(RandomFigureGenerator.class);
        when(randomFigureGenerator.produceFigure()).thenReturn(Figure.BLUE_J);

        FieldService fieldService = new FieldService(new RotationService(new JRotationService()), new DrawService(), randomFigureGenerator);
        for (int i = 0; i < Field.FIELD_HEIGHT - 1; i++) {
            fieldService.tick();
        }
        //figure at he bottom
        assertTrue(fieldService.getField().getCells()[Field.FIELD_HEIGHT - 1][DrawService.FIELD_CENTER].isBusy());
        assertTrue(fieldService.getField().getCells()[Field.FIELD_HEIGHT - 2][DrawService.FIELD_CENTER].isBusy());
        assertTrue(fieldService.getField().getCells()[Field.FIELD_HEIGHT - 3][DrawService.FIELD_CENTER].isBusy());
        assertTrue(fieldService.getField().getCells()[Field.FIELD_HEIGHT - 1][DrawService.FIELD_CENTER - 1].isBusy());

        //figure at the top
        assertTrue(fieldService.getField().getCells()[DrawService.J_FIELD_VERTICAL_CENTER][DrawService.FIELD_CENTER].isBusy());
        assertTrue(fieldService.getField().getCells()[DrawService.J_FIELD_VERTICAL_CENTER - 1][DrawService.FIELD_CENTER].isBusy());
        assertTrue(fieldService.getField().getCells()[DrawService.J_FIELD_VERTICAL_CENTER + 1][DrawService.FIELD_CENTER].isBusy());
        assertTrue(fieldService.getField().getCells()[DrawService.J_FIELD_VERTICAL_CENTER + 1][DrawService.FIELD_CENTER - 1].isBusy());

        assertEquals(DrawService.J_FIELD_VERTICAL_CENTER, fieldService.getField().getFigureCenter().x);
        assertEquals(DrawService.FIELD_CENTER, fieldService.getField().getFigureCenter().y);
    }

    @Test
    void testPermanentCycle() {
        RandomFigureGenerator randomFigureGenerator = mock(RandomFigureGenerator.class);
        when(randomFigureGenerator.produceFigure()).thenReturn(Figure.BLUE_J);

        FieldService fieldService = new FieldService(new RotationService(new JRotationService()), new DrawService(), randomFigureGenerator);
        for (int i = 0; i < 1000; i++) {
            fieldService.tick();
        }
    }
}

