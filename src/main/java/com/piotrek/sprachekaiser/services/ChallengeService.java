package com.piotrek.sprachekaiser.services;

import com.piotrek.sprachekaiser.models.Challenge;
import com.piotrek.sprachekaiser.loader.ChallengeLoader;
import com.piotrek.sprachekaiser.models.ChallengeFilter;

import java.util.List;
import java.util.Random;

public class ChallengeService {

    private final List<Challenge> challenges;
    private final Random random = new Random();

    public ChallengeService() {
        ChallengeLoader loader = new ChallengeLoader();
        challenges = loader.loadChallenges();
    }

    public Challenge getRandomChallenge(ChallengeFilter filter) {

        List<Challenge> filteredChallenges = challenges.stream()
                .filter(challenge ->
                        filter.getTheme().equals("All themes")
                                || challenge.getTheme()
                                .equalsIgnoreCase(filter.getTheme())
                )
                .filter(challenge ->
                        filter.getAccessibility().equals("All")
                                || challenge.getAccessibility()
                                .equalsIgnoreCase(filter.getAccessibility())
                )
                .filter(challenge ->
                        filter.getDifficulty().equals("All")
                                || challenge.getDifficulty()
                                .equalsIgnoreCase(filter.getDifficulty())
                )
                .filter(challenge ->
                        filter.getEngagement().equals("All")
                                || challenge.getEngagement()
                                .equalsIgnoreCase(filter.getEngagement())
                )
                .toList();

        if (filteredChallenges.isEmpty()) {
            throw new IllegalStateException(
                    "No challenges match selected filters."
            );
        }

        Random random = new Random();

        return filteredChallenges.get(
                random.nextInt(filteredChallenges.size())
        );
    }
}
