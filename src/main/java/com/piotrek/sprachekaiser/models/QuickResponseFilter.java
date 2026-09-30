package com.piotrek.sprachekaiser.models;

public class QuickResponseFilter {

    private final String theme;
    private final String difficulty;

    public QuickResponseFilter(
            String theme,
            String difficulty
    ) {
        this.theme = theme;
        this.difficulty = difficulty;
    }

    public String getTheme() {
        return theme;
    }

    public String getDifficulty() {
        return difficulty;
    }
}