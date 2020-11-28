package com.etaran.tetris.service.draw;

import com.etaran.tetris.model.Field;
import com.etaran.tetris.model.Figure;
import com.etaran.tetris.model.Point;
import com.etaran.tetris.model.states.j.JFirstState;
import com.etaran.tetris.model.states.o.OState;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.etaran.tetris.service.draw.DrawService.*;

@Service
public class DrawOService extends AbstractDrawService {

    @Override
    void prepareNewFigure(Field field) {
        List<Point> figurePoints = new ArrayList<>();
        figurePoints.add(new Point(O_FIELD_VERTICAL_CENTER, FIELD_CENTER));
        figurePoints.add(new Point(O_FIELD_VERTICAL_CENTER - 1, FIELD_CENTER));
        figurePoints.add(new Point(O_FIELD_VERTICAL_CENTER, FIELD_CENTER - 1));
        figurePoints.add(new Point(O_FIELD_VERTICAL_CENTER -1, FIELD_CENTER - 1));
        setFigureData(field, Figure.YELLOW_O, new Point(O_FIELD_VERTICAL_CENTER, FIELD_CENTER),
                figurePoints, OState.OState);
    }
}
