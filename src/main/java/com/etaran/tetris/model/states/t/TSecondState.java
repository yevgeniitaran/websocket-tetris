package com.etaran.tetris.model.states.t;

import com.etaran.tetris.model.FigureState;

/**
 * _Y_
 * _YY
 * _Y_
 */
public class TSecondState implements FigureState {

    private TSecondState() {}

    public static final TSecondState INSTANCE = new TSecondState();

    @Override
    public FigureState nextState() {
        return TThirdState.INSTANCE;
    }
}
