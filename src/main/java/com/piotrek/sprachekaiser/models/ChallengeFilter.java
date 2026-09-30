package com.piotrek.sprachekaiser.models;

public class ChallengeFilter {

    private final String theme;
    private final String accessibility;
    private final String difficulty;
    private final String engagement;

    public ChallengeFilter(
            String theme,
            String accessibility,
            String difficulty,
            String engagement
    ) {
        this.theme = theme;
        this.accessibility = accessibility;
        this.difficulty = difficulty;
        this.engagement = engagement;
    }

    public String getTheme() {
        return theme;
    }

    public String getAccessibility() {
        return accessibility;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public String getEngagement() {
        return engagement;
    }
}