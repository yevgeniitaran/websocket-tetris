package com.etaran.tetris.model.states.s;

import com.etaran.tetris.model.FigureState;

/**
 * _XX
 * XX_
 * ___
 */
public class SFirstState implements FigureState {

    private SFirstState() {}

    public final static SFirstState INSTANCE = new SFirstState();

    @Override
    public FigureState nextState() {
        return SSecondState.INSTANCE;
    }
}
