package com.qatracker.model;

public class ManualTestCase extends TestCase {

    private static final long serialVersionUID = 1L;

    private String testerName;

    public ManualTestCase(int id, String title,
            String description,
            String preconditions,
            String expectedResult,
            String testerName) {

        super(id, title, description,
                preconditions, expectedResult);

        this.testerName = testerName;
    }

    public String getTesterName() {
        return testerName;
    }

    @Override
    public String getType() {
        return "Manual";
    }

    @Override
    public String getSpecificDetails() {
        return "Tester: " + testerName;
    }
}
