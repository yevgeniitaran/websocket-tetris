package com.etaran.tetris.service.rotation;

import com.etaran.tetris.model.Field;
import com.etaran.tetris.model.Point;
import com.etaran.tetris.model.Shape;
import com.etaran.tetris.model.states.j.JFirstState;
import com.etaran.tetris.model.states.j.JFourthState;
import com.etaran.tetris.model.states.j.JSecondState;
import com.etaran.tetris.model.states.j.JThirdState;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JRotationService {

    public void rotateFigure(Field field) {
        if (field.getCurrentFigure().getShape() != Shape.J) {
            throw new IllegalStateException("Can't rotate non-J shape");
        }
        List<Point> rotatedFigurePoints = null;
        Point center = field.getFigureCenter();
        synchronized (field) {
            if (field.getFigureState() == JFirstState.INSTANCE) {
                rotatedFigurePoints = List.of(
                        new Point(center.x, center.y),
                        new Point(center.x - 1, center.y),
                        new Point(center.x + 1, center.y),
                        new Point(center.x - 1, center.y + 1)
                );
            } else if (field.getFigureState() == JSecondState.INSTANCE) {
                rotatedFigurePoints = List.of(
                        new Point(center.x, center.y),
                        new Point(center.x, center.y - 1),
                        new Point(center.x, center.y + 1),
                        new Point(center.x + 1, center.y + 1)
                );
            } else if (field.getFigureState() == JThirdState.INSTANCE) {
                rotatedFigurePoints = List.of(
                        new Point(center.x, center.y),
                        new Point(center.x - 1, center.y),
                        new Point(center.x + 1, center.y),
                        new Point(center.x + 1, center.y - 1)
                );
            } else if (field.getFigureState() == JFourthState.INSTANCE) {
                rotatedFigurePoints = List.of(
                        new Point(center.x, center.y),
                        new Point(center.x, center.y - 1),
                        new Point(center.x, center.y + 1),
                        new Point(center.x - 1, center.y - 1)
                );
            }
            for (Point rotatedFigurePoint : rotatedFigurePoints) {
                if (field.isPointBusy(rotatedFigurePoint)) {
                    return;
                }
            }

            field.setFigureState(field.getFigureState().nextState());
            field.redrawFigure(rotatedFigurePoints);

        }


    }
}
