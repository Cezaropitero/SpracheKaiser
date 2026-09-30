package com.piotrek.sprachekaiser.loader;

import com.piotrek.sprachekaiser.models.Question;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class QuestionLoaderTest {

    @Test
    void shouldLoadQuestionsFromCsv() {
        QuestionLoader loader = new QuestionLoader();

        List<Question> questions = loader.loadQuestions();

        assertFalse(questions.isEmpty());
    }

    @Test
    void shouldLoadAllFieldsCorrectly() {
        QuestionLoader loader = new QuestionLoader();

        List<Question> questions =
                loader.loadQuestions("/questions-test.csv");

        assertEquals(3, questions.size());

        Question first = questions.get(0);

        assertAll(
                () -> assertEquals(
                        "Wie heißt du?",
                        first.getQuestion()
                ),
                () -> assertEquals(
                        "What is your name?",
                        first.getEnglishMeaning()
                ),
                () -> assertEquals(
                        "Ich heiße …",
                        first.getHelp()
                ),
                () -> assertEquals("A1", first.getLevel())
        );

        Question third = questions.get(2);

        assertAll(
                () -> assertEquals(
                        "Was machst du, wenn es regnet?",
                        third.getQuestion()
                ),
                () -> assertEquals(
                        "What do you do when it rains?",
                        third.getEnglishMeaning()
                ),
                () -> assertEquals(
                        "Wenn es regnet, bleibe ich zu Hause.",
                        third.getHelp()
                ),
                () -> assertEquals("B1", third.getLevel())
        );
    }
}
