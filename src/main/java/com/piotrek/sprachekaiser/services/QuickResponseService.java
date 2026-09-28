package org.example.services;

import org.example.models.QuickResponse;
import org.example.loader.QuickResponseLoader;

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
}