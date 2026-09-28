package com.piotrek.sprachekaiser.models;

public class Challenge {

    private String challenge;
    private String help;
    private String theme;
    private String applicability;
    private String difficulty;
    private String engagement;

    public Challenge(
            String challenge,
            String help,
            String theme,
            String applicability,
            String difficulty,
            String engagement
    ) {
        this.challenge = challenge;
        this.help = help;
        this.theme = theme;
        this.applicability = applicability;
        this.difficulty = difficulty;
        this.engagement = engagement;
    }

    public String getChallenge() {
        return challenge;
    }

    public String getHelp() {
        return help;
    }

    public String getTheme() {
        return theme;
    }

    public String getApplicability() {
        return applicability;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public String getEngagement() {
        return engagement;
    }
}
