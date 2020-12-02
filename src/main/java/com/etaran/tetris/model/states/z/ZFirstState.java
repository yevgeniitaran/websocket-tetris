package com.etaran.tetris.model.states.z;

import com.etaran.tetris.model.FigureState;

/**
 * XX_
 * _XX
 * ___
 */
public class ZFirstState implements FigureState {

    private ZFirstState() {}

    public final static ZFirstState INSTANCE = new ZFirstState();

    @Override
    public FigureState nextState() {
        return ZSecondState.INSTANCE;
    }
}
