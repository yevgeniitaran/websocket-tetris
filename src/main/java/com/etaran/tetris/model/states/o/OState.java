package com.etaran.tetris.model.states.o;

import com.etaran.tetris.model.FigureState;
import com.etaran.tetris.model.states.j.JFirstState;

public class OState implements FigureState {

    private OState() {}

    public static final OState OState = new OState();

    @Override
    public FigureState nextState() {
        return null;
    }
}
