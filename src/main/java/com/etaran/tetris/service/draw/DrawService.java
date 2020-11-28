package com.etaran.tetris.service.draw;

import com.etaran.tetris.model.Field;
import com.etaran.tetris.model.Figure;
import org.springframework.stereotype.Service;

@Service
public class DrawService {

    public final static int FIELD_CENTER = 5;
    public final static int J_FIELD_VERTICAL_CENTER = 1;
    public final static int O_FIELD_VERTICAL_CENTER = 1;

    private final DrawJService drawJService;
    private final DrawOService drawOSerivce;

    public DrawService(DrawJService drawJService, DrawOService drawOSerivce) {
        this.drawJService = drawJService;
        this.drawOSerivce = drawOSerivce;
    }

    public void drawFigure(Field field, Figure figure) {
        switch (figure) {
            case BLUE_J -> drawJService.drawFigure(field);
//            case RED_Z ->  drawRedZ(field);
//            case GREEN_S ->  drawGreenS(field);
//            case CYAN_I -> drawCyanI(field);
//            case ORANGE_L -> drawOrangeL(field);
            case YELLOW_O  -> drawOSerivce.drawFigure(field);
//            case PURPLE_T -> drawPurpleT(field);
        }
    }
}
