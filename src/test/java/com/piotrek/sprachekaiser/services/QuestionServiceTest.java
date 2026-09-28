package com.piotrek.sprachekaiser.services;

import com.piotrek.sprachekaiser.models.Question;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;

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
}