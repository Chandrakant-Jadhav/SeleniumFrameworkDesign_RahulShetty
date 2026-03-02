# 🚀 Selenium WebDriver Automation Framework (POM)

## 📄 Project Description

This repository contains a **robust and scalable** Selenium WebDriver automation framework built using Java, TestNG, and Cucumber, designed for comprehensive web application testing. Following the **Page Object Model (POM)** architectural pattern, this framework is engineered for maintainability, reusability, and seamless integration into CI/CD pipelines.

Built to demonstrate industry-standard automation practices, this project serves as an **interview showcase** and learning resource for QA engineers, testers, and SDET professionals. It exemplifies clean code practices, comprehensive reporting, and production-ready test execution capabilities.

---

## 🧰 Tech Stack

- **Java** – Core programming language for test development
- **Selenium WebDriver 4.x** – Browser automation and UI testing
- **TestNG** – Test runner, assertions, and test management
- **Cucumber (BDD)** – Gherkin-based specifications and step definitions
- **Maven** – Build automation, dependency management, and lifecycle
- **Extent Reports** – Advanced HTML reporting with screenshots and analytics
- **Jenkins** – CI/CD integration for scheduled and pipeline-based execution
- **Git & GitHub** – Version control and collaborative development
- **IDE** – IntelliJ IDEA / Eclipse for development and debugging

---

## 🎗️ Framework Architecture

This project implements a **modular, layered architecture** promoting code reusability, maintainability, and scalability:

### Core Layers:

- **Base Layer** – WebDriver initialization, teardown, and common setup/teardown hooks
- **Page Object Layer** – Encapsulation of page-specific locators and page behaviors (POM pattern)
- **Business Logic Layer** – Reusable business flows and step definitions for Cucumber
- **Utilities Layer** – Common utilities for waits, screenshots, logging, configuration management
- **Test Layer** – TestNG test classes and Cucumber feature files with comprehensive scenarios
- **Data Layer** – Test data sourced from Excel/CSV/properties files for data-driven testing
- **Reporting Layer** – Extent Reports with step-level logs, screenshots, and detailed analytics

This architecture ensures **clear separation of concerns**, making the framework easier to maintain, extend, and onboard new team members.

---

## ✨ Features Implemented

- 🔐 **Login Functionality Automation** – Valid credentials, invalid credentials, and boundary test scenarios
- 🧹 **Page Object Model (POM)** – All application pages encapsulated as reusable page classes
- 📈 **Data-Driven Testing** – Parameterized tests using TestNG DataProviders and external data sources
- ✅ **TestNG Test Suites** – Organized test grouping, parallel execution, and reporting
- 🔄 **Cucumber BDD Integration** – Gherkin feature files mapped to Java step definitions
- 📚 **Maven Build Automation** – Dependency management and configurable build profiles
- 🔗 **Jenkins CI/CD Integration** – Automated test execution via Jenkins pipelines with report archiving
- 📄 **Extent Reports** – Rich HTML reports with step-by-step logs, screenshots, and execution timeline
- 🐭 **Screenshot Capture** – Automatic screenshots on test failures for debugging
- 🎈 **Logger Integration** – Detailed logging of test execution flow for troubleshooting
- 🚀 **Cross-Browser Support** – Execution on Chrome, Firefox, Edge, and Safari

---

## 📁 Folder Structure

```
SeleniumFrameworkDesign_RahulShetty/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── base/                          # Base test class & driver management
│   │   │   ├── pages/                         # Page Object classes
│   │   │   ├── utils/                         # Utility classes (waits, logs, screenshots)
│   │   │   ├── managers/                      # DriverManager, PageManager
│   │   │   ├── constants/                     # Test constants & URLs
│   │   │   ├── config/                        # Configuration readers
│   │   │   ├─┐ stepdefinitions/             # Cucumber step definitions
│   │   └── resources/
│   │       ├── config.properties              # Configuration file
│   │       ├── log4j2.xml                     # Logging configuration
│   └── test/
│       ├── java/
│       │   ├── tests/                        # TestNG test classes
│       │   ├── runners/                      # Cucumber test runners
│       │   ├┐ hooks/                        # Cucumber hooks (Before/After)
│       └── resources/
│           ├── features/                      # Gherkin feature files
│           ├── testdata/                      # Excel/CSV test data files
│           ├└─ db/                            # Database test scripts
├── reports/                                       # HTML test execution reports
├── test-output/                                   # TestNG default reports
├── .settings/                                     # IDE configuration
├── pom.xml                                        # Maven configuration & dependencies
├── testng.xml                                      # TestNG suite configuration
├── Jenkinsfile                                     # Jenkins pipeline script
├── README.md                                       # Project documentation
├└── .gitignore                                     # Git ignore rules
```

### Directory Descriptions:

| Directory | Purpose |
|-----------|----------|
| `base/` | Contains base test class with WebDriver initialization and teardown |
| `pages/` | Page Object classes with locators and page-specific methods |
| `utils/` | Utility classes for common operations (waits, screenshots, data reading) |
| `managers/` | Manager classes for driver, page object, and configuration management |
| `tests/` | TestNG test classes with comprehensive test scenarios |
| `stepdefinitions/` | Cucumber step definition implementations |
| `features/` | Gherkin feature files with BDD scenarios |
| `testdata/` | External test data files (Excel, CSV, JSON) |
| `reports/` | Generated Extent HTML reports |

---
## ▶️ How to Run the Project

### Prerequisites

Before setting up the project, ensure you have the following installed:

1. **JDK 8 or Higher**
   ```bash
   java -version  # Verify installation
   ```
   - Set `JAVA_HOME` environment variable

2. **Maven 3.6+**
   ```bash
   mvn -version  # Verify installation
   ```

3. **Git**
   ```bash
   git --version  # Verify installation
   ```

4. **IDE** (IntelliJ IDEA or Eclipse)
   - Download and install with Maven plugin support

5. **Browser Drivers**
   - Drivers are managed automatically via WebDriver Manager (no manual setup needed)

### Step-by-Step Setup

#### 1. Clone the Repository

```bash
git clone https://github.com/Chandrakant-Jadhav/SeleniumFrameworkDesign_RahulShetty.git
cd SeleniumFrameworkDesign_RahulShetty
```

#### 2. Import Project in IDE

**IntelliJ IDEA:**
- File → Open → Select project folder
- Wait for Maven to download and index dependencies

**Eclipse:**
- File → Import → Maven → Existing Maven Projects
- Select project folder and finish

#### 3. Update Configuration

- Open `src/main/resources/config.properties`
- Update base URL, browser type, and other configurations as needed

```properties
base.url=https://your-app-url.com
browser=chrome
headless=false
implicit.wait=10
explicit.wait=15
```

#### 4. Verify Dependencies

```bash
mvn clean install  # Downloads all dependencies
```

---

## 💻 Sample Test Execution Commands

### Run All Tests

```bash
mvn clean test
```

### Run Specific TestNG Suite

```bash
mvn clean test -DsuiteXmlFile=testng.xml
```

### Run Tests by TestNG Group

```bash
mvn clean test -Dgroups=smoke
```

### Run Specific Test Class

```bash
mvn clean test -Dtest=LoginTest
```

### Run Cucumber Scenarios by Tag

```bash
mvn clean test -Dcucumber.filter.tags="@Smoke"
```

### Run with Specific Browser

```bash
mvn clean test -Dbrowser=firefox
```

### Parallel Execution (Multiple Threads)

```bash
mvn clean test -DthreadCount=5
```

---
## 📄 Reporting Details

### Extent Reports

After test execution, detailed HTML reports are generated automatically:

- **Report Location:** `reports/ExtentReport.html`
- **Accessibility:** Open in any web browser for interactive viewing

### Report Features:

- 📊 **Test Summary Dashboard** – Pass/Fail/Skip statistics with execution timeline
- 📸 **Screenshot Attachments** – Automatic screenshots on failures for debugging
- 📞 **Step-Level Logs** – Detailed logs for each test step with timestamps
- 🌟 **Test Duration** – Execution time for individual tests and overall suite
- 🔖 **Environment Info** – Browser, OS, Java version, and execution machine details
- 📈 **Charts & Graphs** – Visual representation of test results and trends

### TestNG Reports

- **Default Report Location:** `test-output/`
- **Console Logs:** Real-time test execution logs in IDE console

### Jenkins Integration

When integrated with Jenkins:
- Test reports are automatically archived as build artifacts
- Access reports directly from the Jenkins job page
- Configure email notifications for test results
- Schedule periodic test runs via cron expressions

---

## 🚀 Future Enhancements

- 📊 **Allure Reports** – Integration with Allure for enhanced reporting with historical trends
- 🌐 **API Testing Layer** – REST Assured integration for unified UI + API automation
- 🐭 **Cross-Browser Grid** – Selenium Grid or BrowserStack for distributed execution
- ⚡ **Performance Testing** – Metrics collection for response times and resource usage
- 🔓 **Advanced Wait Strategies** – Custom wait conditions and Smart Wait implementation
- 📁 **Test Data Management** – Database seeding and cleanup utilities
- 🔍 **AI-Powered Selectors** – Self-healing locators for robust element identification
- 🐉 **Docker Containerization** – Framework execution in containerized environments
- 📃 **Advanced Logging** – Centralized logging with ELK stack integration
- 🪨 **Mobile Automation** – Appium integration for Android/iOS testing
- 📋 **Test Retry Logic** – Intelligent retry mechanism for flaky tests
- 🚧 **Security Testing** – OWASP compliance and security validations

---

## 👤 Author

**Name:** Chandrakant Jadhav  
**Role:** QA Automation Engineer | Test Architect | SDET  
**Expertise:** Java | Selenium WebDriver | TestNG | Cucumber | API Testing (REST Assured) | Maven | Jenkins | Git  
**Location:** Pune, Maharashtra, India  
**Experience:** 2+ years in QA Automation and Test Framework Development  

### Connect:

- 👀 **GitHub:** [Chandrakant-Jadhav](https://github.com/Chandrakant-Jadhav)
- 📧 **LinkedIn:** [Profile Link](https://www.linkedin.com/in/chandrakant-jadhav/)
- 🐗 **Email:** [chandrakant.jadhav@email.com](mailto:chandrakant.jadhav@email.com)

### About This Project:

This repository showcases **industry-standard automation practices** and is designed to demonstrate proficiency in:
- Test automation framework design and architecture
- Page Object Model implementation
- Data-driven and BDD testing approaches
- CI/CD integration and DevOps practices
- Code quality, maintainability, and scalability

The framework is continuously evolving with best practices and new features. Feel free to explore, fork, and contribute!

---

## 📃 Contributing

Contributions are welcome! Please follow these guidelines:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/NewFeature`)
3. Commit changes (`git commit -m 'Add NewFeature'`)
4. Push to branch (`git push origin feature/NewFeature`)
5. Open a Pull Request

---

## ⚠️ License

This project is open-source and available under the MIT License. See LICENSE file for details.

---

## 🙋 Support & Contact

For questions, issues, or feedback, please:

- Open an [Issue](https://github.com/Chandrakant-Jadhav/SeleniumFrameworkDesign_RahulShetty/issues) on GitHub
- Connect via [LinkedIn](https://www.linkedin.com/in/chandrakant-jadhav/)
- Drop an email for collaboration opportunities

**Last Updated:** February 2026  
**Version:** 1.0  

---

> **🌟 Tip:** If you found this framework helpful, please consider starring the repository and sharing it with your network!

---
