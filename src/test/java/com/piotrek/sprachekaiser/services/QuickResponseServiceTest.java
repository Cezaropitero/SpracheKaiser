package com.piotrek.sprachekaiser.services;

import com.piotrek.sprachekaiser.models.QuickResponse;
import com.piotrek.sprachekaiser.models.QuickResponseFilter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuickResponseServiceTest {

    @Test
    void shouldReturnRandomResponse() {
        QuickResponseService service = new QuickResponseService();

        QuickResponse response = service.getRandomResponse();

        assertNotNull(response);
    }

    @Test
    void shouldNotRepeatResponseImmediately() {
        QuickResponseService service = new QuickResponseService();

        QuickResponse first = service.getRandomResponse();
        QuickResponse second = service.getRandomResponse();

        assertNotNull(first);
        assertNotNull(second);
        assertNotSame(first, second);
    }

    @Test
    void shouldReturnResponseMatchingFilters() {
        QuickResponseService service = new QuickResponseService();

        // Kolejność: temat, trudność.
        QuickResponseFilter filter =
                new QuickResponseFilter("SHOPPING", "EASY");

        QuickResponse response = service.getRandomResponse(filter);

        assertNotNull(response);

        assertAll(
                () -> assertTrue(
                        "SHOPPING".equalsIgnoreCase(response.getTheme())
                ),
                () -> assertTrue(
                        "EASY".equalsIgnoreCase(response.getDifficulty())
                )
        );
    }

    @Test
    void shouldReturnResponseWhenAllFiltersAreSelected() {
        QuickResponseService service = new QuickResponseService();

        QuickResponseFilter filter =
                new QuickResponseFilter("All themes", "All");

        QuickResponse response = service.getRandomResponse(filter);

        assertNotNull(response);
    }

    @Test
    void shouldThrowWhenNoResponsesMatchFilters() {
        QuickResponseService service = new QuickResponseService();

        QuickResponseFilter filter =
                new QuickResponseFilter("NON_EXISTENT_THEME", "All");

        assertThrows(
                IllegalStateException.class,
                () -> service.getRandomResponse(filter)
        );
    }
}