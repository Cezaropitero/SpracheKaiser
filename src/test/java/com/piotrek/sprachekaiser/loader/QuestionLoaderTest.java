package com.piotrek.sprachekaiser.loader;

import com.piotrek.sprachekaiser.models.Question;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

class QuestionLoaderTest {

    @Test
    void shouldLoadQuestionsFromCsv() {
        // Przygotowanie
        QuestionLoader loader = new QuestionLoader();

        // Działanie
        List<Question> questions = loader.loadQuestions();

        // Sprawdzenie
        assertFalse(questions.isEmpty());
    }
}
