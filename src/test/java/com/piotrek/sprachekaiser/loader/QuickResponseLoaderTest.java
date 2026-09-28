package com.piotrek.sprachekaiser.loader;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

class QuickResponseLoaderTest {

    @Test
    void shouldLoadQuickResponsesFromCsv() {
        // Przygotowanie
        QuickResponseLoader loader = new QuickResponseLoader();

        // Działanie
        var responses = loader.loadResponses();

        // Sprawdzenie
        assertFalse(responses.isEmpty());
    }
}