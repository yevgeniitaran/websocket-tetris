package com.etaran.tetris.model.states.i;

import com.etaran.tetris.model.FigureState;

/**
 * ____
 * YYYY
 * ____
 * ____
 */
public class IFirstState implements FigureState {

    private IFirstState() {}

    public static final IFirstState INSTANCE = new IFirstState();

    @Override
    public FigureState nextState() {
        return ISecondState.INSTANCE;
    }
}
