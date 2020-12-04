package com.etaran.tetris.service.rotation;

import com.etaran.tetris.model.Field;
import com.etaran.tetris.model.Point;
import com.etaran.tetris.model.states.j.JFirstState;
import com.etaran.tetris.model.states.j.JFourthState;
import com.etaran.tetris.model.states.j.JSecondState;
import com.etaran.tetris.model.states.j.JThirdState;
import com.etaran.tetris.model.states.t.TFirstState;
import com.etaran.tetris.model.states.t.TFourthState;
import com.etaran.tetris.model.states.t.TSecondState;
import com.etaran.tetris.model.states.t.TThirdState;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TRotationService extends AbstractRotateService {

    @Override
    public List<Point> calculateRotatedPoints(Field field) {
        Point center = field.getFigureCenter();
        if (field.getFigureState() == TFirstState.INSTANCE) {
            return List.of(
                    new Point(center.x, center.y),
                    new Point(center.x - 1, center.y),
                    new Point(center.x + 1, center.y),
                    new Point(center.x, center.y + 1)
            );
        } else if (field.getFigureState() == TSecondState.INSTANCE) {
            return List.of(
                    new Point(center.x, center.y),
                    new Point(center.x, center.y - 1),
                    new Point(center.x, center.y + 1),
                    new Point(center.x + 1, center.y)
            );
        } else if (field.getFigureState() == TThirdState.INSTANCE) {
            return List.of(
                    new Point(center.x, center.y),
                    new Point(center.x - 1, center.y),
                    new Point(center.x + 1, center.y),
                    new Point(center.x, center.y - 1)
            );
        } else if (field.getFigureState() == TFourthState.INSTANCE) {
            return List.of(
                    new Point(center.x, center.y),
                    new Point(center.x, center.y - 1),
                    new Point(center.x, center.y + 1),
                    new Point(center.x - 1, center.y)
            );
        }
        throw new IllegalStateException("Unknown figure state");
    }
}
