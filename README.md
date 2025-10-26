# 🛒 Ecommerce Automation Framework (Selenium + Java)

## 📘 Overview
The **Ecommerce Automation Framework** is a **Hybrid Selenium Automation Framework** built using **Java**, designed to automate workflows for the [Automation Exercise](https://automationexercise.com/) demo e-commerce website.

It combines **Data-driven**, **Keyword-driven**, and **Modular** design patterns to achieve a **scalable**, **maintainable**, and **reusable** testing solution.

---

This framework enables automation of workflows such as:
- User registration and login
- Product search and filtering
- Adding/removing products from the cart
- Checkout and order confirmation
- Order placement and verification

The goal is to simplify test case management, improve reusability, and provide detailed reporting for quality assurance.

---

## ⚙️ Tech Stack
- **Language:** Java  
- **Automation Tools:** Selenium WebDriver 
- **Test Management:** TestNG  
- **Build Tool:** Maven  
- **Logging:** Log4J  
- **Reporting:** Extent Reports  
- **Data Handling:** Jackson Databind (JSON)  
- **CI/CD Integration:** Jenkins (UI-based)  
- **Version Control:** Git & GitHub  
- **Cross-browser Testing:** Chrome, Edge, Firefox  

---

## 🧩 Key Features
- Hybrid Framework (Data-driven + Keyword-driven + Modular)  
- Thread-safe WebDriver for parallel execution  
- Page Object Model (POM) for maintainable UI interaction  
- Log4J integrated for detailed logging  
- Extent Reports with screenshots on failure  
- Maven for dependency management & build automation  
- Jenkins UI integration for automated test execution & reporting  
- Reusable utilities for common validations  
- JSON-based test data management  

---

## 📊 Reports & Dashboards

| **Report Type**         | **Description**                     | **URL (Link)** |
|-------------------------|-------------------------------------|----------------|
| **UI Extent Report**    | Detailed UI execution summary        | [UI Report](./ExtentReport/Spark.html) 🔗 |
| **API Extent Report**   | API test execution status            | [API Report](./Reports/APIExtentReport.html) 🔗 |
| **Screenshots Gallery** | Visual evidence of UI test steps     | [Screenshots](./Reports/Screenshots/) 🔗 |

<img width="1154" height="330" alt="image" src="https://github.com/user-attachments/assets/dd8a49b8-11c4-491e-aa7e-e10ea3fbbb99" />



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

