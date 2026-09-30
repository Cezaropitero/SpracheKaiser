package com.piotrek.sprachekaiser.services;

import com.piotrek.sprachekaiser.models.Question;
import com.piotrek.sprachekaiser.models.QuestionFilter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.*;

class QuestionServiceTest {

    @Test
    void shouldReturnRandomQuestion() {
        QuestionService service = new QuestionService();

        Question question = service.getRandomQuestion();

        assertNotNull(question);
    }

    @Test
    void shouldNotRepeatQuestionImmediately() {
        QuestionService service = new QuestionService();

        Question first = service.getRandomQuestion();
        Question second = service.getRandomQuestion();

        assertNotSame(first, second);
    }
    @Test
    void shouldReturnQuestionMatchingFilters() {
        QuestionService service = new QuestionService();
        QuestionFilter filter = new QuestionFilter("A1", "PERSONAL");

        Question question = service.getRandomQuestion(filter);

        assertNotNull(question);

        assertAll(
                () -> assertEquals("A1", question.getLevel()),
                () -> assertEquals("PERSONAL", question.getTheme())
        );
    }
}