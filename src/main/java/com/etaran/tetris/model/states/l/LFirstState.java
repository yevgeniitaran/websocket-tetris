package com.etaran.tetris.model.states.l;

import com.etaran.tetris.model.FigureState;

/**
 * Y__
 * YYY
 * ___
 */
public class LFirstState implements FigureState {

    private LFirstState() {}

    public static final LFirstState INSTANCE = new LFirstState();

    @Override
    public FigureState nextState() {
        return LSecondState.INSTANCE;
    }
}
