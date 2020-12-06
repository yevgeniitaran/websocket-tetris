package com.etaran.tetris.model.states.l;

import com.etaran.tetris.model.FigureState;

/**
 * ___
 * YYY
 * __Y
 */
public class LThirdState implements FigureState {

    private LThirdState() {}

    public static final LThirdState INSTANCE = new LThirdState();

    @Override
    public FigureState nextState() {
        return LFourthState.INSTANCE;
    }
}
