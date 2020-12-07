package com.etaran.tetris.service;

import com.etaran.tetris.model.Figure;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RandomFigureGenerator {

    Random random = new Random();

    public Figure produceFigure() {
        return Figure.values()[random.nextInt(7)];
    }
}
