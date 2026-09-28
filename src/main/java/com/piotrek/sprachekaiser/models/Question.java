package org.example.models;

public class Question {

    private String question;
    private String englishMeaning;
    private String help;
    private String level;

    public Question(
            String question,
            String englishMeaning,
            String help,
            String level
    ) {
        this.question = question;
        this.englishMeaning = englishMeaning;
        this.help = help;
        this.level = level;
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
}