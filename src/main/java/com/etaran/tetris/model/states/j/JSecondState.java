package com.etaran.tetris.model.states.j;

import com.etaran.tetris.model.FigureState;

/**
 * _YY
 * _Y_
 * _Y_
 */
public class JSecondState implements FigureState {

    private JSecondState() {}

    public static final JSecondState INSTANCE = new JSecondState();

    @Override
    public FigureState nextState() {
        return JThirdState.INSTANCE;
    }
}
