Selenium Automation Framework (with Java)

**Author**: Andheboina Vijay Kumar Yadav

## Description
This project is a **Selenium Automation Framework** built using **Java**, **Selenium**, and **TestNG**. It is designed to automate end-to-end test scenarios for web applications, with support for **thread safety**, **data-driven testing**, and **cloud integration**. The framework also generates detailed **Allure reports** for test execution analysis.

## Features
- **Thread Safety**: Uses **ThreadLocal** for thread-safe WebDriver instances.
- **Data-Driven Testing**: Reads test data from **Excel sheets** using **Apache POI** and **Data Provider**.
- **Configuration Management**: Reads usernames, passwords, and other configurations from **properties files**.
- **Cloud Integration**: Supports execution on **BrowserStack** and **LambdaTest**.
- **Local and Selenoid Execution**: Can run tests locally or on **Selenoid** for containerized browser testing.
- **Code Quality**: Uses **SonarLint** for static code analysis and ensures compliance with Java standards (Java > 22).

## Technologies Used
- **Programming Language**: Java
- **Automation Tool**: Selenium WebDriver
- **Testing Framework**: TestNG
- **Build Tool**: Maven
- **Assertion Library**: AssertJ
- **Reporting**: Allure Reports
- **Data Management**: Apache POI (Excel), Properties Files
- **Cloud Grids**: BrowserStack, LambdaTest
- **Code Quality**: SonarLint

## Key Functionalities
- **Page Object Model (POM)**: Ensures maintainable and reusable code.
- **TestNG Annotations**: Uses `@Test`, `@BeforeMethod`, `@AfterMethod`, etc., for test lifecycle management.
- **Data Provider**: Enables data-driven testing using Excel sheets.
- **Thread Safety**: Uses **ThreadLocal** to handle parallel test execution.

## Reporting
- **Allure Reports**: Generates detailed and interactive test execution reports.
- Reports include:
    - Test case status (Pass/Fail).
    - Screenshots for failed tests.
    - Execution timelines and trends.

## Test Data Management
- **Excel Sheets**: Test data is stored in Excel files and read using **Apache POI**.
- **Properties Files**: Sensitive data like usernames and passwords are stored in `.properties` files for secure access.

## Configuration
- **Environment Variables**: Configurations like browser type, URL, and credentials are stored in `.properties` files.
- **Dynamic Configuration**: Supports different environments (e.g., dev, staging, prod).

## Cloud Integration
- **BrowserStack**: Run tests on multiple browsers and devices.
- **LambdaTest**: Execute tests on a cloud-based Selenium grid.
- **Selenoid**: Run tests in Docker containers for faster and isolated execution.

## Code Quality
- **SonarLint**: Ensures clean and maintainable code by detecting bugs, vulnerabilities, and code smells.
- **Java Version**: Uses Java 22 or higher for modern features and performance improvements.

## Prerequisites
Before running the tests, ensure you have the following installed:
- **Java JDK 22 or higher**
- **Maven 3.6.3 or higher**
- **ChromeDriver** (or the appropriate WebDriver for your browser)
- **Allure Commandline** (for generating reports)