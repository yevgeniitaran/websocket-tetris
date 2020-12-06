package com.etaran.tetris.model.states.l;

import com.etaran.tetris.model.FigureState;

/**
 * _YY
 * _Y_
 * _Y_
 */
public class LSecondState implements FigureState {

    private LSecondState() {}

    public static final LSecondState INSTANCE = new LSecondState();

    @Override
    public FigureState nextState() {
        return LThirdState.INSTANCE;
    }
}
