package com.etaran.tetris.service;

import com.etaran.tetris.model.Figure;
import org.springframework.stereotype.Service;

@Service
public class RandomFigureGenerator {

    public Figure produceFigure() {
        return Figure.GREEN_S;
    }
}
