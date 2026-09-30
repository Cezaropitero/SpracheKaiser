package com.piotrek.sprachekaiser.services;

import com.piotrek.sprachekaiser.loader.QuestionLoader;
import com.piotrek.sprachekaiser.models.Question;
import com.piotrek.sprachekaiser.models.QuestionFilter;

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

        if (questions.isEmpty()) {
            throw new IllegalStateException("No questions available.");
        }

        return getRandomFromList(questions);
    }

    public Question getRandomQuestion(QuestionFilter filter) {

        List<Question> filteredQuestions = questions.stream()

                // LEVEL
                .filter(question ->
                        filter.getLevel().equals("All")
                                || question.getLevel()
                                .equalsIgnoreCase(filter.getLevel())
                )

                // THEME
                .filter(question ->
                        filter.getTheme().equals("All themes")
                                || question.getTheme()
                                .equalsIgnoreCase(filter.getTheme())
                )

                .toList();

        if (filteredQuestions.isEmpty()) {
            throw new IllegalStateException(
                    "No questions match selected filters."
            );
        }

        return getRandomFromList(filteredQuestions);
    }

    private Question getRandomFromList(List<Question> questionList) {

        if (questionList.size() == 1) {
            return questionList.get(0);
        }

        int randomIndex;

        do {
            randomIndex = random.nextInt(questionList.size());
        } while (randomIndex == previousQuestionIndex);

        previousQuestionIndex = randomIndex;

        return questionList.get(randomIndex);
    }
}