package com.etaran.tetris.model;

public class Cell {

    private boolean busy = false;
    private Color color = null;

    public boolean isBusy() {
        return busy;
    }


    public Color getColor() {
        return color;
    }

    public void setBusy(boolean busy, Color color) {
        this.busy = busy;
        this.color = color;
    }
}
