package com.piotrek.sprachekaiser.models;

public class QuickResponse {

    private final String situation;
    private final String help;
    private final String difficulty;
    private final String exampleAnswer;

    public QuickResponse(
            String situation,
            String help,
            String difficulty,
            String exampleAnswer
    ) {
        this.situation = situation;
        this.help = help;
        this.difficulty = difficulty;
        this.exampleAnswer = exampleAnswer;
    }

    public String getSituation() {
        return situation;
    }

    public String getHelp() {
        return help;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public String getExampleAnswer() {
        return exampleAnswer;
    }
}
