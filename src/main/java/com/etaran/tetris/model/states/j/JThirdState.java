package com.etaran.tetris.model.states.j;

import com.etaran.tetris.model.FigureState;

public class JThirdState implements FigureState {

    public static final JThirdState J_THIRD_STATE = new JThirdState();

    @Override
    public FigureState nextState() {
        return JFourthState.J_FOURTH_STATE;
    }
}
