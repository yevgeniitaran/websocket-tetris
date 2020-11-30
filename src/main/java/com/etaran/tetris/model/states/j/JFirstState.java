package com.etaran.tetris.model.states.j;

import com.etaran.tetris.model.FigureState;

/**
 * Y__
 * YYY
 * ___
 */
public class JFirstState implements FigureState {

    private JFirstState() {}

    public static final JFirstState INSTANCE = new JFirstState();

    @Override
    public FigureState nextState() {
        return JSecondState.INSTANCE;
    }
}
