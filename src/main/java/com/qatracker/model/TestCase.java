package com.qatracker.model;

import java.io.Serializable;

public abstract class TestCase implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String title;
    private String description;
    private String preconditions;
    private String expectedResult;
    private TestStatus status;

    public TestCase(int id, String title,
            String description, String preconditions,
            String expectedResult) {

        this.id = id;
        this.title = title;
        this.description = description;
        this.preconditions = preconditions;
        this.expectedResult = expectedResult;
        this.status = TestStatus.NOT_RUN;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getPreconditions() {
        return preconditions;
    }

    public String getExpectedResult() {
        return expectedResult;
    }

    public TestStatus getStatus() {
        return status;
    }

    public void setStatus(TestStatus status) {
        this.status = status;
    }

    public abstract String getType();

    public abstract String getSpecificDetails();

    @Override
    public String toString() {
        return "ID: " + id +
                "\nTitle: " + title +
                "\nDescription: " + description +
                "\nPreconditions: " + preconditions +
                "\nExpected Result: " + expectedResult +
                "\nType: " + getType() +
                "\nStatus: " + status +
                "\nAdditional Details: " + getSpecificDetails();
    }
}
