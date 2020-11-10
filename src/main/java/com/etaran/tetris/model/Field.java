package com.etaran.tetris.model;

import java.util.UUID;

public class Field {

    private final String fieldId = UUID.randomUUID().toString();
    private final Cell[][] cells = new Cell[40][10];
    private Figure currentFigure;
    private FigureState figureState;

    public String getFieldId() {
        return fieldId;
    }

    public Cell[][] getCells() {
        return cells;
    }

    public Figure getCurrentFigure() {
        return currentFigure;
    }

    public void setCurrentFigure(Figure currentFigure) {
        this.currentFigure = currentFigure;
    }

    public FigureState getFigureState() {
        return figureState;
    }

    public void setFigureState(FigureState figureState) {
        this.figureState = figureState;
    }
}
