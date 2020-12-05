package com.etaran.tetris.model.states.i;

import com.etaran.tetris.model.FigureState;

/**
 * __Y_
 * __Y_
 * __Y_
 * __Y_
 */
public class ISecondState implements FigureState {

    private ISecondState() {}

    public static final ISecondState INSTANCE = new ISecondState();

    @Override
    public FigureState nextState() {
        return IFirstState.INSTANCE;
    }
}
