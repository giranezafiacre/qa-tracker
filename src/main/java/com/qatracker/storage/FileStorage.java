package com.qatracker.storage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.qatracker.model.AutomatedTestCase;
import com.qatracker.model.ManualTestCase;
import com.qatracker.model.TestCase;
import com.qatracker.model.TestStatus;

public class FileStorage {
    private static final String FILE_NAME = "testcases.txt";

    public void save(List<TestCase> testCases) {

        try (PrintWriter writer = new PrintWriter(
                new FileWriter(FILE_NAME))) {

            for (TestCase testCase : testCases) {

                writer.println(testCase.getId());
                writer.println(testCase.getTitle());
                writer.println(testCase.getDescription());
                writer.println(testCase.getPreconditions());
                writer.println(testCase.getExpectedResult());
                writer.println(testCase.getType());
                writer.println(testCase.getStatus());

                if (testCase instanceof ManualTestCase) {

                    ManualTestCase manual = (ManualTestCase) testCase;

                    writer.println(manual.getTesterName());

                } else if (testCase instanceof AutomatedTestCase) {

                    AutomatedTestCase automated = (AutomatedTestCase) testCase;

                    writer.println(automated.getScriptPath());
                }

                writer.println("---");
            }

            System.out.println("Test cases saved successfully!");

        } catch (IOException e) {
            System.out.println("Error saving test cases: " + e.getMessage());
        }
    }

    // Load test cases from text file
    public List<TestCase> load() {

        List<TestCase> testCases = new ArrayList<>();

        File file = new File(FILE_NAME);

        if (!file.exists()) {
            System.out.println("No previous data found. Starting fresh.");
            return testCases;
        }

        try (BufferedReader reader = new BufferedReader(
                new FileReader(FILE_NAME))) {

            String line;

            while ((line = reader.readLine()) != null) {

                if (line.equals("---")) {
                    continue;
                }

                int id = Integer.parseInt(line);
                String title = reader.readLine();
                String description = reader.readLine();
                String preconditions = reader.readLine();
                String expectedResult = reader.readLine();
                String type = reader.readLine();
                TestStatus status = TestStatus.valueOf(reader.readLine());
                String additionalDetails = reader.readLine();

                TestCase testCase;

                if (type.equals("Manual")) {

                    testCase = new ManualTestCase(
                            id, title, description,
                            preconditions, expectedResult,
                            additionalDetails);

                } else {

                    testCase = new AutomatedTestCase(
                            id, title, description,
                            preconditions, expectedResult,
                            additionalDetails);
                }

                testCase.setStatus(status);
                testCases.add(testCase);
            }

            System.out.println("Previous test cases loaded successfully!");

        } catch (IOException | IllegalArgumentException e) {
            System.out.println("Error loading data: " + e.getMessage());
            return new ArrayList<>();
        }

        return testCases;
    }

}
