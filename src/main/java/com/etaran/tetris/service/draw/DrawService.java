package com.etaran.tetris.service.draw;

import com.etaran.tetris.model.Field;
import com.etaran.tetris.model.Figure;
import org.springframework.stereotype.Service;

@Service
public class DrawService {

    public final static int FIELD_CENTER = 5;
    public final static int FIGURE_ON_APPEARANCE_CENTER = 1;

    private final DrawJService drawJService;
    private final DrawOService drawOService;
    private final DrawZService drawZService;
    private final DrawSService drawSService;

    public DrawService(DrawJService drawJService, DrawOService drawOSerivce, DrawZService drawZService, DrawSService drawSService) {
        this.drawJService = drawJService;
        this.drawOService = drawOSerivce;
        this.drawZService = drawZService;
        this.drawSService = drawSService;
    }

    public void drawFigure(Field field, Figure figure) {
        switch (figure) {
            case BLUE_J -> drawJService.drawFigure(field);
            case RED_Z ->  drawZService.drawFigure(field);
            case GREEN_S ->  drawSService.drawFigure(field);
//            case CYAN_I -> drawCyanI(field);
//            case ORANGE_L -> drawOrangeL(field);
            case YELLOW_O  -> drawOService.drawFigure(field);
//            case PURPLE_T -> drawPurpleT(field);
        }
    }
}
