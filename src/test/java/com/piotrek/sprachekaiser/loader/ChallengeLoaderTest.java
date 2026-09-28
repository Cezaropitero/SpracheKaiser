package com.piotrek.sprachekaiser.loader;

import com.piotrek.sprachekaiser.models.Challenge;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

class ChallengeLoaderTest {

    @Test
    void shouldLoadChallengesFromCsv() {
        // Przygotowanie
        ChallengeLoader loader = new ChallengeLoader();

        // Działanie
        List<Challenge> challenges = loader.loadChallenges();

        // Sprawdzenie
        assertFalse(challenges.isEmpty());
    }
}
