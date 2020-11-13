package com.etaran.tetris.model.states.j;

import com.etaran.tetris.model.FigureState;

public class JFourthState implements FigureState {

    private JFourthState() {}

    public static final JFourthState J_FOURTH_STATE = new JFourthState();

    @Override
    public FigureState nextState() {
        return JFirstState.J_FIRST_STATE;
    }
}
