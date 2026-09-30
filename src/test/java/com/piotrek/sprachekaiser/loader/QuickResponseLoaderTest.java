package com.piotrek.sprachekaiser.loader;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuickResponseLoaderTest {

    @Test
    void shouldLoadQuickResponsesFromCsv() {
        QuickResponseLoader loader = new QuickResponseLoader();

        var responses = loader.loadResponses();

        assertFalse(responses.isEmpty());
    }

    @Test
    void shouldLoadAllFieldsCorrectly() {
        QuickResponseLoader loader = new QuickResponseLoader();

        var responses =
                loader.loadResponses("/quick-responses-test.csv");

        assertEquals(3, responses.size());

        var first = responses.get(0);

        assertAll(
                () -> assertEquals(
                        "You are at a bakery. Buy two loaves of bread.",
                        first.getSituation()
                ),
                () -> assertEquals(
                        "ich hätte gern + zwei Brote",
                        first.getHelp()
                ),
                () -> assertEquals(
                        "EASY",
                        first.getDifficulty()
                ),
                () -> assertEquals(
                        "Ich hätte gern zwei Brote, bitte.",
                        first.getExampleAnswer()
                ),
                () -> assertEquals(
                        "SHOPPING",
                        first.getTheme()
                )
        );
    }
}