package com.piotrek.sprachekaiser;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import com.piotrek.sprachekaiser.models.QuickResponse;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class QuickResponseLoader {

    public List<QuickResponse> loadResponses() {

        List<QuickResponse> responses = new ArrayList<>();

        InputStream inputStream =
                getClass().getResourceAsStream("/QuickResponse.csv");

        if (inputStream == null) {
            throw new RuntimeException("QuickResponse.csv not found");
        }

        try (Reader reader =
                     new InputStreamReader(inputStream, StandardCharsets.UTF_8)) {

            CSVFormat format = CSVFormat.DEFAULT.builder()
                    .setHeader()
                    .setSkipHeaderRecord(true)
                    .get();

            for (CSVRecord record : format.parse(reader)) {

                QuickResponse response = new QuickResponse(
                        record.get("situation"),
                        record.get("help"),
                        record.get("difficulty"),
                        record.get("exampleAnswer")
                );

                responses.add(response);
            }

        } catch (IOException e) {
            throw new RuntimeException(
                    "Error reading quick_responses.csv", e
            );
        }

        return responses;
    }
}