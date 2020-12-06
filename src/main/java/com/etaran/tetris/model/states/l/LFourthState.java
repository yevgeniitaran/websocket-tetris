package com.etaran.tetris.model.states.l;

import com.etaran.tetris.model.FigureState;

/**
 * _Y_
 * _Y_
 * YY_
 */
public class LFourthState implements FigureState {

    private LFourthState() {}

    public static final LFourthState INSTANCE = new LFourthState();

    @Override
    public FigureState nextState() {
        return LFirstState.INSTANCE;
    }
}
