package com.etaran.tetris.model.states.t;

import com.etaran.tetris.model.FigureState;

/**
 * ___
 * YYY
 * _Y_
 */
public class TThirdState implements FigureState {

    private TThirdState() {}

    public static final TThirdState INSTANCE = new TThirdState();

    @Override
    public FigureState nextState() {
        return TFourthState.INSTANCE;
    }
}
