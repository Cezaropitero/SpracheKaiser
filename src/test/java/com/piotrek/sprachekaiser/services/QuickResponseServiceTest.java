package com.piotrek.sprachekaiser.services;

import com.piotrek.sprachekaiser.models.QuickResponse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;

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

        assertNotSame(first, second);
    }
}