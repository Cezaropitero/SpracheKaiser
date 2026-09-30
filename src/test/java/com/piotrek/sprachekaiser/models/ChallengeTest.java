package com.piotrek.sprachekaiser.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ChallengeTest {

    @Test
    void shouldStoreProvidedValues() {
        Challenge challenge = new Challenge(
                "Introduce yourself",
                "Ich heiße Piotrek.",
                "Personal information",
                "Anywhere",
                "A1",
                "Speaking"
        );

        assertEquals("Introduce yourself", challenge.getChallenge());
        assertEquals("Ich heiße Piotrek.", challenge.getHelp());
        assertEquals("Personal information", challenge.getTheme());
        assertEquals("Anywhere", challenge.getAccessibility());
        assertEquals("A1", challenge.getDifficulty());
        assertEquals("Speaking", challenge.getEngagement());
    }
}
