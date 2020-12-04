package com.etaran.tetris.service.rotation;

import com.etaran.tetris.model.Field;
import com.etaran.tetris.model.Point;
import com.etaran.tetris.model.Shape;
import com.etaran.tetris.model.states.j.JFirstState;
import com.etaran.tetris.model.states.j.JFourthState;
import com.etaran.tetris.model.states.j.JSecondState;
import com.etaran.tetris.model.states.j.JThirdState;
import com.etaran.tetris.model.states.s.SFirstState;
import com.etaran.tetris.model.states.s.SSecondState;
import com.etaran.tetris.model.states.z.ZFirstState;
import com.etaran.tetris.model.states.z.ZSecondState;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SRotationService extends AbstractRotateService {

    @Override
    public List<Point> calculateRotatedPoints(Field field) {
        Point center = field.getFigureCenter();
        if (field.getFigureState() == SFirstState.INSTANCE) {
            return List.of(
                    new Point(center.x, center.y),
                    new Point(center.x - 1, center.y),
                    new Point(center.x, center.y + 1),
                    new Point(center.x + 1, center.y + 1)
            );
        } else if (field.getFigureState() == SSecondState.INSTANCE) {
            return List.of(
                    new Point(center.x, center.y),
                    new Point(center.x, center.y + 1),
                    new Point(center.x - 1, center.y),
                    new Point(center.x - 1, center.y - 1)
            );
        }
        throw new IllegalStateException("Unknown figure state");
    }
}
