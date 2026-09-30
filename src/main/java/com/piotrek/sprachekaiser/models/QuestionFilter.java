package com.piotrek.sprachekaiser.models;

public class QuestionFilter {

    private final String level;
    private final String theme;

    public QuestionFilter(String level, String theme) {
        this.level = level;
        this.theme = theme;
    }

    public String getLevel() {
        return level;
    }

    public String getTheme() {
        return theme;
    }
}