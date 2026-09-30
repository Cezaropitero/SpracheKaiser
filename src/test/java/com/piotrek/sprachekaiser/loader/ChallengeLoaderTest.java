package com.piotrek.sprachekaiser.loader;

import com.piotrek.sprachekaiser.models.Challenge;
import org.junit.jupiter.api.Test;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertFalse;

class ChallengeLoaderTest {

    @Test
    void shouldLoadAllFieldsCorrectly() {
        ChallengeLoader loader = new ChallengeLoader();

        List<Challenge> challenges =
                loader.loadChallenges("/challenges-test.csv");

        assertEquals(2, challenges.size());

        Challenge first = challenges.get(0);

        assertAll(
                () -> assertEquals(
                        "Open the door, then close it.",
                        first.getChallenge()
                ),
                () -> assertEquals("Öffne die Tür.", first.getHelp()),
                () -> assertEquals("HOME", first.getTheme()),
                () -> assertEquals("HIGH", first.getAccessibility()),
                () -> assertEquals("EASY", first.getDifficulty()),
                () -> assertEquals("LOW", first.getEngagement())
        );
    }
}
