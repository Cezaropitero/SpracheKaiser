package com.piotrek.sprachekaiser.services;

import com.piotrek.sprachekaiser.models.QuickResponse;
import com.piotrek.sprachekaiser.loader.QuickResponseLoader;
import com.piotrek.sprachekaiser.models.QuickResponseFilter;

import java.util.List;
import java.util.Random;

public class QuickResponseService {

    private final List<QuickResponse> responses;
    private final Random random = new Random();

    private int previousResponseIndex = -1;

    public QuickResponseService() {
        QuickResponseLoader loader = new QuickResponseLoader();
        responses = loader.loadResponses();
    }

    public QuickResponse getRandomResponse() {

        if (responses.isEmpty()) {
            throw new IllegalStateException(
                    "No Quick Response situations loaded."
            );
        }

        if (responses.size() == 1) {
            return responses.get(0);
        }

        int randomIndex;

        do {
            randomIndex = random.nextInt(responses.size());
        } while (randomIndex == previousResponseIndex);

        previousResponseIndex = randomIndex;

        return responses.get(randomIndex);
    }
    public QuickResponse getRandomResponse(QuickResponseFilter filter) {

        List<QuickResponse> filteredResponses = responses.stream()

                // THEME
                .filter(response ->
                        filter.getTheme().equals("All themes")
                                || response.getTheme()
                                .equalsIgnoreCase(filter.getTheme())
                )

                // DIFFICULTY
                .filter(response ->
                        filter.getDifficulty().equals("All")
                                || response.getDifficulty()
                                .equalsIgnoreCase(filter.getDifficulty())
                )

                .toList();

        if (filteredResponses.isEmpty()) {
            throw new IllegalStateException(
                    "No responses match selected filters."
            );
        }

        return filteredResponses.get(
                random.nextInt(filteredResponses.size())
        );
    }
}