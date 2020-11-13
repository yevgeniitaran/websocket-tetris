package com.etaran.tetris.service;

import com.etaran.tetris.model.Color;
import com.etaran.tetris.model.Field;
import com.etaran.tetris.model.Figure;
import com.etaran.tetris.model.states.j.JFirstState;

public class DrawService {

    public final static int FIELD_CENTER = 5;
    public final static int J_FIELD_VERTICAL_CENTER = 1;

    public void drawFigure(Field field, Figure figure) {
        switch (figure) {
            case BLUE_J -> drawBlueJ(field);
            case RED_Z ->  drawRedZ(field);
            case GREEN_S ->  drawGreenS(field);
            case CYAN_I -> drawCyanI(field);
            case ORANGE_L -> drawOrangeL(field);
            case YELLOW_O  -> drawYellowO(field);
            case PURPLE_T -> drawPurpleT(field);
        }
    }

    private void drawPurpleT(Field field) {
    }

    private void drawYellowO(Field field) {
    }

    private void drawOrangeL(Field field) {
    }

    private void drawCyanI(Field field) {
    }

    private void drawGreenS(Field field) {
    }

    private void drawRedZ(Field field) {
    }

    private void drawBlueJ(Field field) {
        field.setFigureCenterX(FIELD_CENTER);
        field.setFigureCenterY(J_FIELD_VERTICAL_CENTER);
        field.getCells()[FIELD_CENTER][J_FIELD_VERTICAL_CENTER].setColor(Color.BLUE);
        field.getCells()[FIELD_CENTER][J_FIELD_VERTICAL_CENTER - 1].setColor(Color.BLUE);
        field.getCells()[FIELD_CENTER][J_FIELD_VERTICAL_CENTER + 1].setColor(Color.BLUE);
        field.getCells()[FIELD_CENTER - 1][J_FIELD_VERTICAL_CENTER + 1].setColor(Color.BLUE);
        field.setFigureState(JFirstState.J_FIRST_STATE);
    }
}
