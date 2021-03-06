package com.etaran.tetris.service.rotation;

import com.etaran.tetris.model.Field;
import com.etaran.tetris.model.Point;
import com.etaran.tetris.model.states.j.JFirstState;
import com.etaran.tetris.model.states.j.JFourthState;
import com.etaran.tetris.model.states.j.JSecondState;
import com.etaran.tetris.model.states.j.JThirdState;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JRotationService extends AbstractRotateService {

    @Override
    public List<Point> calculateRotatedPoints(Field field) {
        Point center = field.getFigureCenter();
        if (field.getFigureState() == JFirstState.INSTANCE) {
            return List.of(
                    new Point(center.x, center.y),
                    new Point(center.x - 1, center.y),
                    new Point(center.x + 1, center.y),
                    new Point(center.x - 1, center.y + 1)
            );
        } else if (field.getFigureState() == JSecondState.INSTANCE) {
            return List.of(
                    new Point(center.x, center.y),
                    new Point(center.x, center.y - 1),
                    new Point(center.x, center.y + 1),
                    new Point(center.x + 1, center.y + 1)
            );
        } else if (field.getFigureState() == JThirdState.INSTANCE) {
            return List.of(
                    new Point(center.x, center.y),
                    new Point(center.x - 1, center.y),
                    new Point(center.x + 1, center.y),
                    new Point(center.x + 1, center.y - 1)
            );
        } else if (field.getFigureState() == JFourthState.INSTANCE) {
            return List.of(
                    new Point(center.x, center.y),
                    new Point(center.x, center.y - 1),
                    new Point(center.x, center.y + 1),
                    new Point(center.x - 1, center.y - 1)
            );
        }
        throw new IllegalStateException("Unknown figure state");
    }
}
