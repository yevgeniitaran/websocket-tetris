package com.etaran.tetris;

import com.etaran.tetris.controller.dto.Action;
import com.etaran.tetris.model.Field;
import com.etaran.tetris.model.Figure;
import com.etaran.tetris.service.FieldService;
import com.etaran.tetris.service.RandomFigureGenerator;
import com.etaran.tetris.service.draw.*;
import com.etaran.tetris.service.rotation.JRotationService;
import com.etaran.tetris.service.rotation.RotationService;
import com.etaran.tetris.service.rotation.ZRotationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class OFigureTest {

    FieldService fieldService;

    @BeforeEach
    void setupServices() {
        RandomFigureGenerator randomFigureGenerator = mock(RandomFigureGenerator.class);
        when(randomFigureGenerator.produceFigure()).thenReturn(Figure.YELLOW_O);

        fieldService = new FieldService(new RotationService(new JRotationService(), new ZRotationService()),
                new DrawService(new DrawJService(), new DrawOService(), new DrawZService(), new DrawSService()), randomFigureGenerator);
    }

    @Test
    void testFieldClear() {
        fieldService.tick();
        fieldService.performAction(Action.LEFT);
        fieldService.performAction(Action.LEFT);
        fieldService.performAction(Action.LEFT);
        fieldService.performAction(Action.LEFT);
        for (int i = 0; i < Field.FIELD_HEIGHT - 2; i++) {
            fieldService.tick();
        }

        fieldService.tick();
        fieldService.performAction(Action.LEFT);
        fieldService.performAction(Action.LEFT);
        for (int i = 0; i < Field.FIELD_HEIGHT - 2; i++) {
            fieldService.tick();
        }

        fieldService.tick();
        for (int i = 0; i < Field.FIELD_HEIGHT - 2; i++) {
            fieldService.tick();
        }

        fieldService.tick();
        fieldService.performAction(Action.RIGHT);
        fieldService.performAction(Action.RIGHT);
        for (int i = 0; i < Field.FIELD_HEIGHT - 2; i++) {
            fieldService.tick();
        }

        fieldService.tick();
        fieldService.performAction(Action.RIGHT);
        fieldService.performAction(Action.RIGHT);
        fieldService.performAction(Action.RIGHT);
        fieldService.performAction(Action.RIGHT);
        for (int i = 0; i < Field.FIELD_HEIGHT - 2; i++) {
            fieldService.tick();
        }

        fieldService.tick();

        assertFalse(fieldService.getField().getCells()[Field.FIELD_HEIGHT - 1][DrawService.FIELD_CENTER].isBusy());
        assertFalse(fieldService.getField().getCells()[Field.FIELD_HEIGHT - 1][DrawService.FIELD_CENTER + 1].isBusy());
        assertFalse(fieldService.getField().getCells()[Field.FIELD_HEIGHT - 1][DrawService.FIELD_CENTER - 1].isBusy());
        assertFalse(fieldService.getField().getCells()[Field.FIELD_HEIGHT - 2][DrawService.FIELD_CENTER - 1].isBusy());
    }


}

