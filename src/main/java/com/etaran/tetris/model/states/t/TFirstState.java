package com.etaran.tetris.model.states.t;

import com.etaran.tetris.model.FigureState;

/**
 * _Y_
 * YYY
 * ___
 */
public class TFirstState implements FigureState {

    private TFirstState() {}

    public static final TFirstState INSTANCE = new TFirstState();

    @Override
    public FigureState nextState() {
        return TSecondState.INSTANCE;
    }
}
