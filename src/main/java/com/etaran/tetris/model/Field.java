package com.etaran.tetris.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class Field {

    public static final int FIELD_WIDTH = 10;
    public static final int FIELD_HEIGHT = 40;

    private final String fieldId = UUID.randomUUID().toString();
    private final Cell[][] cells = new Cell[FIELD_HEIGHT][FIELD_WIDTH];
    private Figure currentFigure;
    private FigureState figureState;
    private Point figureCenter;
    private List<Point> figurePoints = new ArrayList<>();
    private boolean figureCollapsed;

    public Field() {
        for (Cell[] row : cells) {
            Arrays.parallelSetAll(row, (i) -> new Cell());
        }
    }

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

    public Point getFigureCenter() {
        return figureCenter;
    }

    public void setFigureCenter(Point figureCenter) {
        this.figureCenter = figureCenter;
    }

    public List<Point> getFigurePoints() {
        return figurePoints;
    }

    public boolean isFigureCollapsed() {
        return figureCollapsed;
    }

    public void setFigureCollapsed(boolean figureCollapsed) {
        this.figureCollapsed = figureCollapsed;
    }

    public void showFigure() {
        for (Point figurePoint : figurePoints) {
            cells[figurePoint.x][figurePoint.y].setBusy(true);
            cells[figurePoint.x][figurePoint.y].setColor(currentFigure.getColor());
        }
    }

    public void hideFigure() {
        for (Point figurePoint : figurePoints) {
            cells[figurePoint.x][figurePoint.y].setBusy(false);
            cells[figurePoint.x][figurePoint.y].setColor(null);
        }
    }

    public void clearFigure() {
        currentFigure = null;
        figurePoints.clear();
        figureState = null;
        figureCenter = null;
    }

    @Override
    public String toString() {
        StringBuilder fieldAsString = new StringBuilder();
        for (Cell[] cellsRow : cells) {
            for (Cell cell : cellsRow) {
                if (cell.getColor() != null) {
                    fieldAsString.append(cell.getColor().toString().charAt(0));
                }
                fieldAsString.append("N");
            }
            fieldAsString.append(",");
        }
        return fieldAsString.toString();
    }
}
