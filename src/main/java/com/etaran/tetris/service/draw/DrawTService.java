package com.etaran.tetris.service.draw;

import com.etaran.tetris.model.Field;
import com.etaran.tetris.model.Figure;
import com.etaran.tetris.model.Point;
import com.etaran.tetris.model.states.t.TFirstState;
import com.etaran.tetris.model.states.z.ZFirstState;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.etaran.tetris.service.draw.DrawService.FIELD_CENTER;
import static com.etaran.tetris.service.draw.DrawService.FIGURE_ON_APPEARANCE_CENTER;

@Service
public class DrawTService extends AbstractDrawService {
    @Override
    void prepareNewFigure(Field field) {
        List<Point> figurePoints = new ArrayList<>();
        figurePoints.add(new Point(FIGURE_ON_APPEARANCE_CENTER, FIELD_CENTER));
        figurePoints.add(new Point(FIGURE_ON_APPEARANCE_CENTER, FIELD_CENTER - 1));
        figurePoints.add(new Point(FIGURE_ON_APPEARANCE_CENTER, FIELD_CENTER + 1));
        figurePoints.add(new Point(FIGURE_ON_APPEARANCE_CENTER - 1, FIELD_CENTER));
        setFigureData(field, Figure.PURPLE_T, new Point(FIGURE_ON_APPEARANCE_CENTER, FIELD_CENTER),
                figurePoints, TFirstState.INSTANCE);
    }
}
