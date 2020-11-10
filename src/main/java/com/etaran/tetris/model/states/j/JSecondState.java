package com.etaran.tetris.model.states.j;

import com.etaran.tetris.model.FigureState;

public class JSecondState implements FigureState {

    public static final JSecondState J_SECOND_STATE = new JSecondState();

    @Override
    public FigureState nextState() {
        return JThirdState.J_THIRD_STATE;
    }
}
