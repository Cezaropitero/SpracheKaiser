package com.piotrek.sprachekaiser.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QuestionTest {

    @Test
    void shouldStoreProvidedValues() {
        Question question = new Question(
                "Wie heißt du?",
                "What is your name?",
                "Ich heiße Piotrek.",
                "A1"
        );

        assertEquals("Wie heißt du?", question.getQuestion());
        assertEquals("What is your name?", question.getEnglishMeaning());
        assertEquals("Ich heiße Piotrek.", question.getHelp());
        assertEquals("A1", question.getLevel());
    }
}