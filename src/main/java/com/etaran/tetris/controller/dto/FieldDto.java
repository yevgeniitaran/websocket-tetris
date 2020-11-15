package com.etaran.tetris.controller.dto;

public class FieldDto {

    private String fieldId;

    public FieldDto(String fieldId) {
        this.fieldId = fieldId;
    }

    public String getFieldId() {
        return fieldId;
    }

    public void setFieldId(String fieldId) {
        this.fieldId = fieldId;
    }
}
