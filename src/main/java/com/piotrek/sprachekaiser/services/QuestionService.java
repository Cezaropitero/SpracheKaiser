package com.piotrek.sprachekaiser.services;

import com.piotrek.sprachekaiser.models.Question;
import com.piotrek.sprachekaiser.loader.QuestionLoader;

import java.util.List;
import java.util.Random;

public class QuestionService {

    private final List<Question> questions;
    private final Random random = new Random();

    private int previousQuestionIndex = -1;

    public QuestionService() {
        QuestionLoader loader = new QuestionLoader();
        questions = loader.loadQuestions();
    }

    public Question getRandomQuestion() {

        int randomIndex;

        do {
            randomIndex = random.nextInt(questions.size());
        } while (randomIndex == previousQuestionIndex);

        previousQuestionIndex = randomIndex;

        return questions.get(randomIndex);
    }
}