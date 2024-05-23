package com.example.labwork_6.models;
public class RectangleModel {
    private String rectangleColor;
    private String textColor;

    private String text;

    // Конструктор
    public RectangleModel(String rectangleColor, String textColor, String text) {
        this.rectangleColor = rectangleColor;
        this.textColor = textColor;
        this.text = text;
    }

    // Геттеры и сеттеры
    public String getRectangleColor() {
        return rectangleColor;
    }

    public void setRectangleColor(String rectangleColor) {
        this.rectangleColor = rectangleColor;
    }

    public String getTextColor() {
        return textColor;
    }

    public void setTextColor(String textColor) {
        this.textColor = textColor;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}