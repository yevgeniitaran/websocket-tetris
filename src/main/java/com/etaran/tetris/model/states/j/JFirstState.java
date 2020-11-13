package com.etaran.tetris.model.states.j;

import com.etaran.tetris.model.FigureState;

public class JFirstState implements FigureState {

    private JFirstState() {}

    public static final JFirstState J_FIRST_STATE = new JFirstState();

    @Override
    public FigureState nextState() {
        return JSecondState.J_SECOND_STATE;
    }
}
