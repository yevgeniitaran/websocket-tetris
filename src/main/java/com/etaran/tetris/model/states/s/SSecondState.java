package com.etaran.tetris.model.states.s;

import com.etaran.tetris.model.FigureState;

/**
 * _X_
 * _XX
 * __X
 */
public class SSecondState implements FigureState {

    private SSecondState() {}

    public final static SSecondState INSTANCE = new SSecondState();

    @Override
    public FigureState nextState() {
        return SFirstState.INSTANCE;
    }
}
