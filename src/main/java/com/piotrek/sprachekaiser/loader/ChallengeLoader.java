package com.piotrek.sprachekaiser.loader;

import com.piotrek.sprachekaiser.models.Challenge;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class ChallengeLoader {

    public List<Challenge> loadChallenges() {
        return loadChallenges("/challenges.csv");
    }

    public List<Challenge> loadChallenges(String resourcePath) {

        List<Challenge> challenges = new ArrayList<>();

        InputStream inputStream =
                getClass().getResourceAsStream(resourcePath);

        if (inputStream == null) {
            throw new RuntimeException(resourcePath + " not found");
        }

        try (
                Reader reader = new InputStreamReader(
                        inputStream,
                        StandardCharsets.UTF_8
                )
        ) {

            CSVFormat format = CSVFormat.DEFAULT.builder()
                    .setHeader()
                    .setSkipHeaderRecord(true)
                    .get();

            Iterable<CSVRecord> records = format.parse(reader);

            for (CSVRecord record : records) {

                Challenge challenge = new Challenge(
                        record.get("Challenge"),
                        record.get("German Help"),
                        record.get("Theme"),
                        record.get("Accessibility"),
                        record.get("Difficulty"),
                        record.get("Engagement")
                );

                challenges.add(challenge);
            }

        } catch (IOException e) {
            throw new RuntimeException(
                    "Error reading " + resourcePath,
                    e
            );
        }

        return challenges;
    }
}
