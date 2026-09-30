package com.piotrek.sprachekaiser.models;

public class Question {

    private String question;
    private String englishMeaning;
    private String help;
    private String level;
    private String theme;

    public Question(
            String question,
            String englishMeaning,
            String help,
            String level,
            String theme
    ) {
        this.question = question;
        this.englishMeaning = englishMeaning;
        this.help = help;
        this.level = level;
        this.theme = theme;
    }

    public String getQuestion() {
        return question;
    }

    public String getEnglishMeaning() {
        return englishMeaning;
    }

    public String getHelp() {
        return help;
    }

    public String getLevel() {
        return level;
    }

    public String getTheme() {
        return theme;
    }
}