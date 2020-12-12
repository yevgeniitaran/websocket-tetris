package com.etaran.tetris.controller.dto;

public class FieldDto {

    private String field;
    int score;

    public FieldDto(String field, int score) {
        this.field = field;
        this.score = score;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
