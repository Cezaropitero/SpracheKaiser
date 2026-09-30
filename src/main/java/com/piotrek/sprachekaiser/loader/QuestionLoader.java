package com.piotrek.sprachekaiser.loader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import com.piotrek.sprachekaiser.models.Question;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class QuestionLoader {

    public List<Question> loadQuestions() {
        return loadQuestions("/questions.csv");
    }

    public List<Question> loadQuestions(String resourcePath) {

        List<Question> questions = new ArrayList<>();

        InputStream inputStream =
                getClass().getResourceAsStream(resourcePath);

        if (inputStream == null) {
            throw new RuntimeException(resourcePath + " not found");
        }

        try (Reader reader =
                     new InputStreamReader(inputStream, StandardCharsets.UTF_8)) {

            CSVFormat format = CSVFormat.DEFAULT.builder()
                    .setHeader()
                    .setSkipHeaderRecord(true)
                    .get();

            for (CSVRecord record : format.parse(reader)) {

                Question question = new Question(
                        record.get("German Question"),
                        record.get("English Meaning"),
                        record.get("German Help"),
                        record.get("Level"),
                        record.get("Theme")
                );

                questions.add(question);
            }

        } catch (IOException e) {
            throw new RuntimeException(
                    "Error reading " + resourcePath, e
            );
        }

        return questions;
    }
}
