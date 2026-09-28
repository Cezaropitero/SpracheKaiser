package org.example.services;

import org.example.models.Challenge;
import org.example.loader.ChallengeLoader;

import java.util.List;
import java.util.Random;

public class ChallengeService {

    private final List<Challenge> challenges;
    private final Random random = new Random();

    public ChallengeService() {
        ChallengeLoader loader = new ChallengeLoader();
        challenges = loader.loadChallenges();
    }

    public Challenge getRandomChallenge() {

        int randomIndex = random.nextInt(challenges.size());

        return challenges.get(randomIndex);
    }
}
