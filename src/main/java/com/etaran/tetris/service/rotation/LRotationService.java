package com.etaran.tetris.service.rotation;

import com.etaran.tetris.model.Field;
import com.etaran.tetris.model.Point;
import com.etaran.tetris.model.states.l.LFirstState;
import com.etaran.tetris.model.states.l.LFourthState;
import com.etaran.tetris.model.states.l.LSecondState;
import com.etaran.tetris.model.states.l.LThirdState;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LRotationService extends AbstractRotateService {

    @Override
    public List<Point> calculateRotatedPoints(Field field) {
        Point center = field.getFigureCenter();
        if (field.getFigureState() == LFirstState.INSTANCE) {
            return List.of(
                    new Point(center.x, center.y),
                    new Point(center.x - 1, center.y),
                    new Point(center.x + 1, center.y),
                    new Point(center.x - 1, center.y - 1)
            );
        } else if (field.getFigureState() == LSecondState.INSTANCE) {
            return List.of(
                    new Point(center.x, center.y),
                    new Point(center.x, center.y - 1),
                    new Point(center.x, center.y + 1),
                    new Point(center.x - 1, center.y + 1)
            );
        } else if (field.getFigureState() == LThirdState.INSTANCE) {
            return List.of(
                    new Point(center.x, center.y),
                    new Point(center.x - 1, center.y),
                    new Point(center.x + 1, center.y),
                    new Point(center.x + 1, center.y + 1)
            );
        } else if (field.getFigureState() == LFourthState.INSTANCE) {
            return List.of(
                    new Point(center.x, center.y),
                    new Point(center.x, center.y - 1),
                    new Point(center.x, center.y + 1),
                    new Point(center.x + 1, center.y - 1)
            );
        }
        throw new IllegalStateException("Unknown figure state");
    }
}
