package com.etaran.tetris;

import com.etaran.tetris.model.Field;
import com.etaran.tetris.model.Figure;
import com.etaran.tetris.service.draw.*;
import com.etaran.tetris.service.FieldService;
import com.etaran.tetris.service.RandomFigureGenerator;
import com.etaran.tetris.service.rotation.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class JFigureTest {

    FieldService fieldService;

    @BeforeEach
    void setupServices() {
        RandomFigureGenerator randomFigureGenerator = mock(RandomFigureGenerator.class);
        when(randomFigureGenerator.produceFigure()).thenReturn(Figure.BLUE_J);

        fieldService = new FieldService(new RotationService(new JRotationService(), new ZRotationService(),
                new SRotationService(), new TRotationService()),
                new DrawService(new DrawJService(), new DrawOService(), new DrawZService(), new DrawSService(),
                        new DrawTService()), randomFigureGenerator);
    }

    @Test
    void J_draw_processedSuccessfully() {
        fieldService.tick();

        assertTrue(fieldService.getField().getCells()[DrawService.FIGURE_ON_APPEARANCE_CENTER][DrawService.FIELD_CENTER].isBusy());
        assertTrue(fieldService.getField().getCells()[DrawService.FIGURE_ON_APPEARANCE_CENTER][DrawService.FIELD_CENTER + 1].isBusy());
        assertTrue(fieldService.getField().getCells()[DrawService.FIGURE_ON_APPEARANCE_CENTER][DrawService.FIELD_CENTER - 1].isBusy());
        assertTrue(fieldService.getField().getCells()[DrawService.FIGURE_ON_APPEARANCE_CENTER - 1][DrawService.FIELD_CENTER - 1].isBusy());
        assertEquals(DrawService.FIGURE_ON_APPEARANCE_CENTER, fieldService.getField().getFigureCenter().x);
        assertEquals(DrawService.FIELD_CENTER, fieldService.getField().getFigureCenter().y);
    }

    @Test
    void J_moves_successfully() {
        fieldService.tick();
        fieldService.tick();
        assertFalse(fieldService.getField().getCells()[DrawService.FIGURE_ON_APPEARANCE_CENTER - 1][DrawService.FIELD_CENTER].isBusy());
        assertTrue(fieldService.getField().getCells()[DrawService.FIGURE_ON_APPEARANCE_CENTER + 1][DrawService.FIELD_CENTER].isBusy());
        assertTrue(fieldService.getField().getCells()[DrawService.FIGURE_ON_APPEARANCE_CENTER + 1][DrawService.FIELD_CENTER + 1].isBusy());
        assertTrue(fieldService.getField().getCells()[DrawService.FIGURE_ON_APPEARANCE_CENTER + 1][DrawService.FIELD_CENTER - 1].isBusy());
        assertTrue(fieldService.getField().getCells()[DrawService.FIGURE_ON_APPEARANCE_CENTER][DrawService.FIELD_CENTER - 1].isBusy());
    }

    @Test
    void J_moves_to_bottom_successfully() {
        for (int i = 0; i < Field.FIELD_HEIGHT - 1; i++) {
            fieldService.tick();
        }

        assertTrue(fieldService.getField().getCells()[Field.FIELD_HEIGHT - 1][DrawService.FIELD_CENTER].isBusy());
        assertTrue(fieldService.getField().getCells()[Field.FIELD_HEIGHT - 1][DrawService.FIELD_CENTER + 1].isBusy());
        assertTrue(fieldService.getField().getCells()[Field.FIELD_HEIGHT - 1][DrawService.FIELD_CENTER - 1].isBusy());
        assertTrue(fieldService.getField().getCells()[Field.FIELD_HEIGHT - 2][DrawService.FIELD_CENTER - 1].isBusy());
    }

    @Test
    void afterCollapse_newFigureProduced() {
        for (int i = 0; i < Field.FIELD_HEIGHT; i++) {
            fieldService.tick();
        }
        //figure at he bottom
        assertTrue(fieldService.getField().getCells()[Field.FIELD_HEIGHT - 1][DrawService.FIELD_CENTER].isBusy());
        assertTrue(fieldService.getField().getCells()[Field.FIELD_HEIGHT - 1][DrawService.FIELD_CENTER + 1].isBusy());
        assertTrue(fieldService.getField().getCells()[Field.FIELD_HEIGHT - 1][DrawService.FIELD_CENTER - 1].isBusy());
        assertTrue(fieldService.getField().getCells()[Field.FIELD_HEIGHT - 2][DrawService.FIELD_CENTER - 1].isBusy());

        //figure at the top
        assertTrue(fieldService.getField().getCells()[DrawService.FIGURE_ON_APPEARANCE_CENTER][DrawService.FIELD_CENTER].isBusy());
        assertTrue(fieldService.getField().getCells()[DrawService.FIGURE_ON_APPEARANCE_CENTER][DrawService.FIELD_CENTER + 1].isBusy());
        assertTrue(fieldService.getField().getCells()[DrawService.FIGURE_ON_APPEARANCE_CENTER][DrawService.FIELD_CENTER - 1].isBusy());
        assertTrue(fieldService.getField().getCells()[DrawService.FIGURE_ON_APPEARANCE_CENTER - 1][DrawService.FIELD_CENTER - 1].isBusy());

        assertEquals(DrawService.FIGURE_ON_APPEARANCE_CENTER, fieldService.getField().getFigureCenter().x);
        assertEquals(DrawService.FIELD_CENTER, fieldService.getField().getFigureCenter().y);
    }

    @Test
    void testCollision() {
        for (int i = 0; i < Field.FIELD_HEIGHT - 1; i++) {
            fieldService.tick();
        }

        for (int i = 0; i < Field.FIELD_HEIGHT - 3; i++) {
            fieldService.tick();
        }

        //figure collide with figure
        assertTrue(fieldService.getField().getCells()[Field.FIELD_HEIGHT - 3][DrawService.FIELD_CENTER].isBusy());
        assertTrue(fieldService.getField().getCells()[Field.FIELD_HEIGHT - 3][DrawService.FIELD_CENTER + 1].isBusy());
        assertTrue(fieldService.getField().getCells()[Field.FIELD_HEIGHT - 3][DrawService.FIELD_CENTER - 1].isBusy());
        assertTrue(fieldService.getField().getCells()[Field.FIELD_HEIGHT - 4][DrawService.FIELD_CENTER - 1].isBusy());
    }
}

