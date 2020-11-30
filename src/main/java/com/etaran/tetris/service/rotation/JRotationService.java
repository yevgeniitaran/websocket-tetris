package com.etaran.tetris.service.rotation;

import com.etaran.tetris.model.Field;
import com.etaran.tetris.model.Point;
import com.etaran.tetris.model.Shape;
import com.etaran.tetris.model.states.j.JFirstState;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JRotationService {

    public void rotateFigure(Field field) {
        if (field.getCurrentFigure().getShape() != Shape.J) {
            throw new IllegalStateException("Can't rotate non-J shape");
        }
        synchronized (field) {
            if (field.getFigureState() == JFirstState.INSTANCE) {
                Point center = field.getFigureCenter();
                List<Point> rotatedFigurePoints = List.of(
                        new Point(center.x, center.y),
                        new Point(center.x - 1, center.y),
                        new Point(center.x + 1, center.y),
                        new Point(center.x - 1, center.y + 1)
                );
                field.redrawFigure(rotatedFigurePoints);
            }
        }


    }
}
