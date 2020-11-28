package com.etaran.tetris.service.draw;

import com.etaran.tetris.model.Field;
import com.etaran.tetris.model.Figure;
import com.etaran.tetris.model.Point;
import com.etaran.tetris.model.states.j.JFirstState;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.etaran.tetris.service.draw.DrawService.FIELD_CENTER;
import static com.etaran.tetris.service.draw.DrawService.J_FIELD_VERTICAL_CENTER;

@Service
public class DrawJService extends AbstractDrawService {

    @Override
    void prepareNewFigure(Field field) {
        List<Point> figurePoints = new ArrayList<>();
        figurePoints.add(new Point(J_FIELD_VERTICAL_CENTER, FIELD_CENTER));
        figurePoints.add(new Point(J_FIELD_VERTICAL_CENTER, FIELD_CENTER + 1));
        figurePoints.add(new Point(J_FIELD_VERTICAL_CENTER, FIELD_CENTER - 1));
        figurePoints.add(new Point(J_FIELD_VERTICAL_CENTER -1, FIELD_CENTER - 1));
        setFigureData(field, Figure.BLUE_J, new Point(J_FIELD_VERTICAL_CENTER, FIELD_CENTER),
                figurePoints, JFirstState.J_FIRST_STATE);
    }
}
