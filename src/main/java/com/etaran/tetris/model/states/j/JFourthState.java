package com.etaran.tetris.model.states.j;

import com.etaran.tetris.model.FigureState;

/**
 * _Y_
 * _Y_
 * YY_
 */
public class JFourthState implements FigureState {

    private JFourthState() {}

    public static final JFourthState INSTANCE = new JFourthState();

    @Override
    public FigureState nextState() {
        return JFirstState.INSTANCE;
    }
}
