package com.etaran.tetris.service.rotation;

import com.etaran.tetris.model.Field;
import com.etaran.tetris.model.Point;

import java.util.List;

public abstract class AbstractRotateService {

    public void rotateFigure(Field field) {
        synchronized (field) {
            List<Point> rotatedFigurePoints = calculateRotatedPoints(field);
            for (Point rotatedFigurePoint : rotatedFigurePoints) {
                if (field.isPointBusy(rotatedFigurePoint)) {
                    return;
                }
            }

            field.setFigureState(field.getFigureState().nextState());
            field.redrawFigure(rotatedFigurePoints);
        }
    }

    public abstract List<Point> calculateRotatedPoints(Field field);
}
