# Ecommerce Automation Framework

## Overview

The **Ecommerce Automation Framework** is a **Hybrid Selenium Automation Framework** built using **Java**. 
It combines data-driven, keyword-driven, and modular design approaches to achieve a scalable and maintainable 
automation testing solution for e-commerce web applications.

This framework enables automation of workflows such as:
- Product browsing and search
- Adding items to cart and checkout
- User registration and login
- Order placement and verification

The goal is to simplify test case management, improve reusability, and provide detailed reporting for quality assurance.

---

## Features

- **Hybrid Framework Architecture** (Data-driven + Keyword-driven + Modular)
- **Selenium WebDriver** integration as thread safe for parallel browser execution
- **TestNG** for test management and parallel execution
- **Page Object Model (POM)** for maintainable UI interaction
- **Log4J** for detailed logging 
- **Extent Reports** for comprehensive test reporting
- **Maven** for dependency management and build automation
- **Cross-browser testing** support (Chrome, Edge, Firefox)
- **Reusable Utilities** for common actions and validations
- **Jackson Databind** for parsing and managing JSON-based configuration or test data.
- **TakeScreenShot** on failure taking screenshot and adding it to Extent report.

---

## Project Structure

```
Ecommerce-Automation/
│
├── src/
│   ├── main/
│   │   └── java/
|   |       └── org.example/
│   │             ├── pageObjects/               
│   │             │    ├── common/               # Page Object classes for each web page
│   │             │    └── BasePage              # Key driven components(click, sendkeys, waitTillelementVisisble)
│   │             │ 
│   │             └── utils/                     # Utility classes (DriverFactory, Reporting, Json etc.)
│   │   
│   └── test/
│        ├── ExtentReport/                       # Test reports generated after execution
│        ├── java/
│        │    └── org.example.testCases/
│        │          ├── tests/                   # test case classes
│        │          ├── BaseTest                 # Base test setup and configurations
│        │          └── TestNGListener 
│        │
│        └── resources/
│             ├── scriptConfig.properties        # Script configurations
│             ├── Global.properties              # Global configurations (Credentials, dummy payment detils, etc.)
│             ├── testdata.json                  # Test data file for data-driven execution
│             └── log4j.xml                      # Logging configuration
│                    
├── pom.xml    
├── README.md                                    # Project documentation
├── regression.xml
├── smoke.xml
└── sanity.xml                        
```

---

## Prerequisites

- **Java JDK 11 or later**
- **Maven 3.6+**
- **Google Chrome / Firefox / Edge**
- **TestNG plugin** (for IDE integration)

---

## Setup Instructions

1. **Clone the Repository**
   ```bash
   git clone <repo_url>
   cd Ecommerce-Automation
   ```

2. **Import the Project**
   - Open **IntelliJ IDEA** or **Eclipse**.
   - Import as a **Maven Project**.

3. **Install Dependencies**
   Maven will automatically download all required dependencies from `pom.xml`.

4. **Configure Test Data**
   - Update `browser.properties` with your browser preferences.

---

## Execution

Run test cases using any of the following methods:

### Using Maven
```bash
mvn clean test
```

### Using TestNG XML Suite
```bash
mvn clean test -DsuiteXmlFile=regression.xml
```

### From IDE
- Right-click on the `regression.xml` file and select **Run As → TestNG Suite**.

---

## Reporting

After execution, reports will be generated automatically in the `ExtentReports` directory.

- **Extent Reports** → Provides rich HTML reports with test status and screenshots.

---


## Continuous Integration (Optional)

This framework can be integrated into **Jenkins** or any CI/CD tool for automated execution. Example command:

```bash
mvn clean test -PRegression -Dbrowser=chrome
```

---

## Contribution

1. Fork the repository.
2. Create your feature branch: `git checkout -b feature/my-feature`.
3. Commit your changes: `git commit -m "Add my feature"`.
4. Push to the branch: `git push origin feature/my-feature`.
5. Open a Pull Request.

---


