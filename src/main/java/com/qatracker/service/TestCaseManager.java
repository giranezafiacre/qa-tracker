package com.qatracker.service;

import java.util.ArrayList;
import java.util.List;

import com.qatracker.model.TestCase;
import com.qatracker.model.TestStatus;

public class TestCaseManager {

    private List<TestCase> testCases;
    private int nextId;

    public TestCaseManager(List<TestCase> testCases) {
        this.testCases = new ArrayList<>(testCases);
        this.nextId = 1;

        // Find the next available ID
        for (TestCase testCase : testCases) {
            if (testCase.getId() >= nextId) {
                nextId = testCase.getId() + 1;
            }
        }
    }

    public int generateId() {
        return nextId++;
    }

    public void addTestCase(TestCase testCase) {
        testCases.add(testCase);
    }

    public List<TestCase> getAllTestCases() {
        return testCases;
    }

    public TestCase findById(int id) {
        for (TestCase testCase : testCases) {
            if (testCase.getId() == id) {
                return testCase;
            }
        }

        return null;
    }

   public void updateTestStatus(int id, TestStatus status){
      TestCase tcUpdate=findById(id);
      if(tcUpdate!=null){
        tcUpdate.setStatus(status);
      }else{
        System.out.println("status not found");
      }
   }

    public List<TestCase> search(String keyword) {

        List<TestCase> results = new ArrayList<>();

        for (TestCase testCase : testCases) {

            if (keyword == null || keyword.trim().isEmpty()) {
                results.add(testCase);
                continue;
            }

            String searchWord = keyword.toLowerCase();

            if (testCase.getTitle().toLowerCase()
                    .contains(searchWord) ||
                testCase.getDescription().toLowerCase()
                    .contains(searchWord)) {

                results.add(testCase);
            }
        }

        return results;
    }

    public int countByStatus(TestStatus status) {

        int count = 0;

        for (TestCase testCase : testCases) {
            if (testCase.getStatus() == status) {
                count++;
            }
        }

        return count;
    }

    public int countManual() {

        int count = 0;

        for (TestCase testCase : testCases) {
            if (testCase.getType().equals("Manual")) {
                count++;
            }
        }

        return count;
    }

    public int countAutomated() {

        int count = 0;

        for (TestCase testCase : testCases) {
            if (testCase.getType().equals("Automated")) {
                count++;
            }
        }

        return count;
    }

    public int getTotalCount() {
        return testCases.size();
    }
}
