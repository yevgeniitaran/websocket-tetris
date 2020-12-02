package com.etaran.tetris.model.states.z;

import com.etaran.tetris.model.FigureState;

/**
 * __X
 * _XX
 * _X_
 */
public class ZSecondState implements FigureState {

    private ZSecondState() {}

    public final static ZSecondState INSTANCE = new ZSecondState();

    @Override
    public FigureState nextState() {
        return ZFirstState.INSTANCE;
    }
}
