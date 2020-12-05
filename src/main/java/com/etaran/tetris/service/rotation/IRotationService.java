package com.etaran.tetris.service.rotation;

import com.etaran.tetris.model.Field;
import com.etaran.tetris.model.Point;
import com.etaran.tetris.model.states.i.IFirstState;
import com.etaran.tetris.model.states.i.ISecondState;
import com.etaran.tetris.model.states.s.SFirstState;
import com.etaran.tetris.model.states.s.SSecondState;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IRotationService extends AbstractRotateService {

    @Override
    public List<Point> calculateRotatedPoints(Field field) {
        Point center = field.getFigureCenter();
        if (field.getFigureState() == IFirstState.INSTANCE) {
            return List.of(
                    new Point(center.x, center.y),
                    new Point(center.x - 1, center.y),
                    new Point(center.x + 1, center.y),
                    new Point(center.x + 2, center.y)
            );
        } else if (field.getFigureState() == ISecondState.INSTANCE) {
            return List.of(
                    new Point(center.x, center.y),
                    new Point(center.x, center.y  - 1),
                    new Point(center.x, center.y + 1),
                    new Point(center.x, center.y - 2)
            );
        }
        throw new IllegalStateException("Unknown figure state");
    }
}
