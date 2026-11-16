package com.qatracker.model;

public class AutomatedTestCase extends TestCase {

    private static final long serialVersionUID = 1L;

    private String scriptPath;

    public AutomatedTestCase(int id, String title,
                             String description,
                             String preconditions,
                             String expectedResult,
                             String scriptPath) {

        super(id, title, description,
              preconditions, expectedResult);

        this.scriptPath = scriptPath;
    }

    public String getScriptPath() {
        return scriptPath;
    }

    @Override
    public String getType() {
        return "Automated";
    }

    @Override
    public String getSpecificDetails() {
        return "Script Path: " + scriptPath;
    }
}
