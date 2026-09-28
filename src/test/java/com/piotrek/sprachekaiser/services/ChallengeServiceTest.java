package com.piotrek.sprachekaiser.services;

import com.piotrek.sprachekaiser.models.Challenge;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class ChallengeServiceTest {

    @Test
    void shouldReturnRandomChallenge() {
        // Przygotowanie — wczytuje challenges.csv
        ChallengeService service = new ChallengeService();

        // Działanie
        Challenge challenge = service.getRandomChallenge();

        // Sprawdzenie
        assertNotNull(challenge);
    }
}