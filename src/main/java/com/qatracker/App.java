package com.qatracker;

import java.util.List;
import java.util.Scanner;

import com.qatracker.model.AutomatedTestCase;
import com.qatracker.model.ManualTestCase;
import com.qatracker.model.TestCase;
import com.qatracker.model.TestStatus;
import com.qatracker.service.TestCaseManager;
import com.qatracker.storage.FileStorage;

/**
 * Hello world!
 *
 */
public class App {
    private static Scanner scanner = new Scanner(System.in);

    private static FileStorage storage = new FileStorage();

    private static TestCaseManager manager;

    public static void main(String[] args) {
        List<TestCase> savedCases = storage.load();

        manager = new TestCaseManager(savedCases);

        boolean running = true;

        while (running) {
            displayMenu();

            int choice = readInteger("Enter your choice: ");
            switch (choice) {

                case 1:
                    addTestCase();
                    break;

                case 2:
                    viewAllTestCases();
                    break;

                case 3:
                    updateTestStatus();
                    break;

                case 4:
                    searchTestCases();
                    break;

                case 5:
                    generateReport();
                    break;

                case 6:
                    storage.save(manager.getAllTestCases());
                    System.out.println("Thank you for using QA Tracker!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice. Select 1-6.");
            }
        }

        System.out.println("Bye Bye");

        scanner.close();
    }

    // Display application menu
    private static void displayMenu() {

        System.out.println("\n==============================");
        System.out.println("        QA TRACKER v1.0");
        System.out.println("==============================");
        System.out.println("1. Add Test Case");
        System.out.println("2. View All Test Cases");
        System.out.println("3. Update Test Status");
        System.out.println("4. Search Test Cases");
        System.out.println("5. Generate Report");
        System.out.println("6. Save & Exit");
        System.out.println("==============================");
    }

    // Read an integer safely
    private static int readInteger(String message) {

        while (true) {

            System.out.print(message);

            String input = scanner.nextLine();

            try {
                return Integer.parseInt(input.trim());

            } catch (NumberFormatException e) {

                System.out.println("Please enter a valid number.");
            }
        }
    }

    // Read required text
    private static String readRequired(String message) {

        while (true) {

            System.out.print(message);

            String input = scanner.nextLine().trim();

            if (!input.isEmpty()) {
                return input;
            }

            System.out.println("This field is required. Please try again.");
        }
    }

    // Feature 1: Add test case
    private static void addTestCase() {

        System.out.println("\n--- ADD TEST CASE ---");

        String title = readRequired("Enter title: ");

        System.out.print("Enter description: ");
        String description = scanner.nextLine();

        System.out.print("Enter preconditions: ");
        String preconditions = scanner.nextLine();

        String expectedResult = readRequired("Enter expected result: ");

        System.out.println("\nSelect Test Type:");
        System.out.println("1. Manual");
        System.out.println("2. Automated");

        int typeChoice;

        while (true) {

            typeChoice = readInteger("Enter type: ");

            if (typeChoice == 1 || typeChoice == 2) {
                break;
            }

            System.out.println("Invalid type. Select 1 or 2.");
        }

        int id = manager.generateId();

        TestCase testCase;

        if (typeChoice == 1) {

            String testerName = readRequired("Enter tester name: ");

            testCase = new ManualTestCase(
                    id,
                    title,
                    description,
                    preconditions,
                    expectedResult,
                    testerName);

        } else {

            String scriptPath = readRequired("Enter automation script path: ");

            testCase = new AutomatedTestCase(
                    id,
                    title,
                    description,
                    preconditions,
                    expectedResult,
                    scriptPath);
        }

        manager.addTestCase(testCase);

        System.out.println("\nTest case added successfully!");
        System.out.println("Assigned ID: " + id);
    }

    // Feature 2: View all test cases
    private static void viewAllTestCases() {

        System.out.println("\n--- ALL TEST CASES ---");

        List<TestCase> testCases = manager.getAllTestCases();

        displayTestCases(testCases);
    }

    // Display test cases in a formatted table
    private static void displayTestCases(List<TestCase> testCases) {

        if (testCases.isEmpty()) {

            System.out.println("No test cases found.");
            return;
        }

        System.out.printf(
                "%-5s %-25s %-12s %-12s %-30s%n",
                "ID", "TITLE", "TYPE", "STATUS", "ADDITIONAL DETAILS");

        System.out.println(
                "-----------------------------------------------------------------------------------------------");

        for (TestCase testCase : testCases) {

            System.out.printf(
                    "%-5d %-25.25s %-12s %-12s %-30.30s%n",
                    testCase.getId(),
                    testCase.getTitle(),
                    testCase.getType(),
                    testCase.getStatus(),
                    testCase.getSpecificDetails());
        }
    }

    // Feature 3: Update test status
    private static void updateTestStatus() {

        System.out.println("\n--- UPDATE TEST STATUS ---");

        int id = readInteger("Enter test case ID: ");

        TestCase testCase = manager.findById(id);

        if (testCase == null) {

            System.out.println("Error: Test case ID does not exist.");
            return;
        }

        System.out.println("Current Status: " + testCase.getStatus());

        System.out.println("\nSelect new status:");
        System.out.println("1. PASS");
        System.out.println("2. FAIL");
        System.out.println("3. BLOCKED");
        System.out.println("4. NOT_RUN");

        int choice;

        while (true) {

            choice = readInteger("Enter status: ");

            if (choice >= 1 && choice <= 4) {
                break;
            }

            System.out.println("Invalid status. Select 1-4.");
        }

        TestStatus newStatus;

        switch (choice) {

            case 1:
                newStatus = TestStatus.PASS;
                break;

            case 2:
                newStatus = TestStatus.FAIL;
                break;

            case 3:
                newStatus = TestStatus.BLOCKED;
                break;

            default:
                newStatus = TestStatus.NOT_RUN;
        }

        manager.updateStatus(id, newStatus);

        System.out.println("Test status updated successfully!");
    }

    // Feature 4: Search test cases
    private static void searchTestCases() {

        System.out.println("\n--- SEARCH TEST CASES ---");

        System.out.print("Enter keyword: ");

        String keyword = scanner.nextLine();

        List<TestCase> results = manager.search(keyword);

        System.out.println("\nSearch Results:");

        displayTestCases(results);
    }

    // Feature 5: Generate report
    private static void generateReport() {

        int total = manager.getTotalCount();

        int manual = manager.countManual();

        int automated = manager.countAutomated();

        int passed = manager.countByStatus(TestStatus.PASS);

        int failed = manager.countByStatus(TestStatus.FAIL);

        int blocked = manager.countByStatus(TestStatus.BLOCKED);

        int notRun = manager.countByStatus(TestStatus.NOT_RUN);

        double passRate = 0.0;

        if (total > 0) {
            passRate = (passed * 100.0) / total;
        }

        System.out.println("\n================================");
        System.out.println("      TEST EXECUTION REPORT");
        System.out.println("================================");

        System.out.println("Total Test Cases : " + total);

        System.out.println("  - Manual       : " + manual);
        System.out.println("  - Automated    : " + automated);

        System.out.println("--------------------------------");

        System.out.println("PASS             : " + passed);
        System.out.println("FAIL             : " + failed);
        System.out.println("BLOCKED          : " + blocked);
        System.out.println("NOT RUN          : " + notRun);

        System.out.println("--------------------------------");

        System.out.printf("Pass Rate        : %.1f%%%n", passRate);

        System.out.println("================================");
    }
}
