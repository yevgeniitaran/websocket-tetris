package com.etaran.tetris.model.states.t;

import com.etaran.tetris.model.FigureState;

/**
 * _Y_
 * YY_
 * _Y_
 */
public class TFourthState implements FigureState {

    private TFourthState() {}

    public static final TFourthState INSTANCE = new TFourthState();

    @Override
    public FigureState nextState() {
        return TFirstState.INSTANCE;
    }
}
