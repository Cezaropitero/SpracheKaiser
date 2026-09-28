package com.piotrek.sprachekaiser.services;

import com.piotrek.sprachekaiser.models.Challenge;
import com.piotrek.sprachekaiser.loader.ChallengeLoader;

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
