package com.etaran.tetris.service.draw;

import com.etaran.tetris.model.Field;
import com.etaran.tetris.model.Figure;
import com.etaran.tetris.model.FigureState;
import com.etaran.tetris.model.Point;

import java.util.List;

public abstract class AbstractDrawService {

    public void drawFigure(Field field) {
        prepareNewFigure(field);
        field.showFigure();
    }

    abstract void prepareNewFigure(Field field);

    protected void setFigureData(Field field, Figure figure, Point figureCenter, List<Point> figurePoints,
                                  FigureState figureState) {
        field.setFigureCenter(figureCenter);
        field.setCurrentFigure(figure);
        field.setFigureState(figureState);
        field.setGameEnded(isGameEnded(field, figurePoints));
        field.setFigureCollapsed(field.isGameEnded());

        field.getFigurePoints().clear();
        field.getFigurePoints().addAll(figurePoints);

    }

    private boolean isGameEnded(Field field, List<Point> figurePoints) {
        for (Point point : figurePoints) {
            if (field.getCells()[point.x][point.y].isBusy() || field.isPointCollapsed(point)) {
                return true;
            }
        }

        return false;
    }


}
