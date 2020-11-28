package com.etaran.tetris.service;

import com.etaran.tetris.model.Field;
import com.etaran.tetris.model.Figure;
import com.etaran.tetris.model.Point;
import com.etaran.tetris.model.states.j.JFirstState;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
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
        field.getFigurePoints().clear();
        field.setCurrentFigure(Figure.BLUE_J);
        field.setFigureCenter(new Point(J_FIELD_VERTICAL_CENTER, FIELD_CENTER));
        List<Point> figurePoints = new ArrayList<>();
        figurePoints.add(new Point(J_FIELD_VERTICAL_CENTER, FIELD_CENTER));
        figurePoints.add(new Point(J_FIELD_VERTICAL_CENTER, FIELD_CENTER + 1));
        figurePoints.add(new Point(J_FIELD_VERTICAL_CENTER, FIELD_CENTER - 1));
        figurePoints.add(new Point(J_FIELD_VERTICAL_CENTER -1, FIELD_CENTER - 1));
        for (Point point : figurePoints) {
            if (field.getCells()[point.x][point.y].isBusy() || field.isPointCollapsed(point)) {
                field.setGameEnded(true);
            }
        }
        field.getFigurePoints().addAll(figurePoints);
        field.setFigureState(JFirstState.J_FIRST_STATE);
        field.showFigure();
    }
}
