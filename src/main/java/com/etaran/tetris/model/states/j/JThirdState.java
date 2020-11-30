package com.etaran.tetris.model.states.j;

import com.etaran.tetris.model.FigureState;

/**
 * ___
 * YYY
 * __Y
 */
public class JThirdState implements FigureState {

    private JThirdState() {}

    public static final JThirdState INSTANCE = new JThirdState();

    @Override
    public FigureState nextState() {
        return JFourthState.INSTANCE;
    }
}
