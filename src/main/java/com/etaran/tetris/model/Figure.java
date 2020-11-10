package com.etaran.tetris.model;

public enum Figure {

    CYAN_I(Color.CYAN, Shape.I),
    YELLOW_O(Color.YELLOW, Shape.O),
    PURPLE_T(Color.PURPLE, Shape.T),
    GREEN_S(Color.GREEN, Shape.S),
    BLUE_J(Color.BLUE, Shape.J),
    RED_Z(Color.RED, Shape.Z),
    ORANGE_L(Color.ORANGE, Shape.L);

    private final Shape shape;
    private final Color color;

    Figure(Color color, Shape shape) {
        this.shape = shape;
        this.color = color;
    }

    public Shape getShape() {
        return shape;
    }

    public Color getColor() {
        return color;
    }
}
