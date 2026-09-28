package com.piotrek.sprachekaiser.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QuickResponseTest {

    @Test
    void shouldStoreProvidedValues() {
        QuickResponse response = new QuickResponse(
                "Someone thanks you",
                "Use a polite response",
                "A1",
                "Bitte schön!"
        );

        assertEquals("Someone thanks you", response.getSituation());
        assertEquals("Use a polite response", response.getHelp());
        assertEquals("A1", response.getDifficulty());
        assertEquals("Bitte schön!", response.getExampleAnswer());
    }
}