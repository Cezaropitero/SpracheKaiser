package com.piotrek.sprachekaiser.services;

import com.piotrek.sprachekaiser.models.Challenge;
import com.piotrek.sprachekaiser.models.ChallengeFilter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChallengeServiceTest {

    @Test
    void shouldThrowWhenNoChallengesMatchFilters() {
        ChallengeService service = new ChallengeService();

        ChallengeFilter filter = new ChallengeFilter(
                "NON_EXISTENT_THEME", "All", "All", "All"
        );

        assertThrows(
                IllegalStateException.class,
                () -> service.getRandomChallenge(filter)
        );
    }

    @Test
    void shouldReturnChallengeWhenAllFiltersAreSelected() {
        ChallengeService service = new ChallengeService();

        ChallengeFilter filter = new ChallengeFilter(
                "All themes", "All", "All", "All"
        );

        Challenge challenge = service.getRandomChallenge(filter);

        assertNotNull(challenge);
    }

    @Test
    void shouldReturnChallengeMatchingFilters() {
        ChallengeService service = new ChallengeService();

        ChallengeFilter filter =
                new ChallengeFilter("HOME", "HIGH", "EASY", "LOW");

        Challenge challenge = service.getRandomChallenge(filter);

        assertNotNull(challenge);

        assertAll(
                () -> assertEquals("HOME", challenge.getTheme()),
                () -> assertEquals("HIGH", challenge.getAccessibility()),
                () -> assertEquals("EASY", challenge.getDifficulty()),
                () -> assertEquals("LOW", challenge.getEngagement())
        );
    }
}