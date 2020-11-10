package com.etaran.tetris.model.states.j;

import com.etaran.tetris.model.FigureState;

public class JFourthState implements FigureState {

    public static final JThirdState J_FOURTH_STATE = new JThirdState();

    @Override
    public FigureState nextState() {
        return JFirstState.J_FIRST_STATE;
    }
}
