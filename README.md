# QA Tracker – Test Case Management System

A Java-based command-line application for managing software testing activities. QA Tracker allows users to create, organize, search, update, and generate reports for manual and automated test cases.

## Features

- **Add Test Cases:** Create manual and automated test cases.
- **View Test Cases:** Display all registered test cases.
- **Update Test Status:** Track test execution using PASS, FAIL, BLOCKED, and NOT_RUN statuses.
- **Search Test Cases:** Search by title or description.
- **Generate Reports:** View test statistics, execution status counts, and pass rate.
- **File Persistence:** Save test cases locally and load them when the application starts.
- **Input Validation:** Handle invalid inputs and missing required fields.

## Technologies Used

- Java 17
- Maven
- Object-Oriented Programming (OOP)
- Java Collections Framework
- Java Enums
- Exception Handling
- File I/O and Serialization
- Git and GitHub
- Cucumber Gherkin (`.feature` files) for test case documentation

## Project Structure

```text
qa-tracker/
├── .vscode/
│
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── qatracker/
│   │               ├── App.java
│   │               ├── model/
│   │               │   ├── TestCase.java
│   │               │   ├── ManualTestCase.java
│   │               │   ├── AutomatedTestCase.java
│   │               │   └── TestStatus.java
│   │               ├── service/
│   │               │   └── TestCaseManager.java
│   │               └── storage/
│   │                   └── FileStorage.java
│   │
│   └── test/
│       └── java/
│           └── com/
│               └── qatracker/
│
├── testCases/
│   ├── accountManagement/
│   │   └── *.feature
│   │
│   ├── cartManagement/
│   │   └── *.feature
│   │
│   ├── checkout/
│   │   └── *.feature
│   │
│   └── productBrowsing/
│       └── *.feature
│
├── target/                 # Maven-generated build files
├── pom.xml
├── README.md
└── .gitignore
```

### Test Case Organization

The project contains four main test sets, each containing multiple test cases documented using Gherkin `.feature` files.

| Test Set | Folder | Description |
|---|---|---|
| 1 | `accountManagement/` | Account registration, login, and account management |
| 2 | `cartManagement/` | Shopping cart functionality |
| 3 | `checkout/` | Checkout and order processing |
| 4 | `productBrowsing/` | Product catalogue and product details |

Each `.feature` file can contain multiple scenarios, with each scenario representing an individual test case.

## Prerequisites

Make sure you have installed:

- Java Development Kit (JDK) 17 or later
- Apache Maven
- Git (optional, for version control)

Verify your installations:

```bash
java --version
mvn --version
git --version
```

## How to Run

1. Clone the repository:

```bash
git clone https://github.com/giranezafiacre/qa-tracker.git
```

2. Navigate to the project directory:

```bash
cd qa-tracker
```

3. Compile and run the application:

```bash
mvn clean compile exec:java
```

## Application Menu

```text
===== QA TRACKER =====
1. Add Test Case
2. View All Test Cases
3. Update Test Status
4. Search Test Cases
5. Generate Report
6. Save & Exit
```

## Test Case Types

### Manual Test Case

- Test ID
- Title
- Description
- Preconditions
- Expected Result
- Tester Name
- Execution Status

### Automated Test Case

- Test ID
- Title
- Description
- Preconditions
- Expected Result
- Automation Script Path
- Execution Status

## Test Execution Statuses

| Status | Description |
|---|---|
| PASS | Test executed successfully |
| FAIL | Test did not meet the expected result |
| BLOCKED | Test execution could not proceed |
| NOT_RUN | Test has not yet been executed |

## Test Case Documentation

Test cases are documented using Gherkin syntax in `.feature` files.

Example:

```gherkin
Feature: Customer Login

  Background:
    Given Customer is on the Login page

  Scenario: Login with valid credentials
    When Customer enters a valid username
    And Customer enters a valid password
    And Customer clicks the Login button
    Then Customer should be redirected to the dashboard
```

## Reporting

The application generates a report containing:

- Total number of test cases
- Number of manual and automated test cases
- Number of passed, failed, blocked, and unexecuted tests
- Overall pass rate

## Learning Objectives

This project demonstrates practical application of:

- Object-Oriented Programming
- Inheritance and polymorphism
- Encapsulation and abstraction
- Collections and enums
- Exception handling
- File handling and data persistence
- Modular Java application design
- Software test case management and documentation
- Gherkin-based test scenario writing

## Author

**Fiacre Giraneza**

GitHub: [@giranezafiacre](https://github.com/giranezafiacre)