# TallerSauceDemo 🧪

## 📖 Project Definition
This project implements a functional test automation framework based on **Serenity BDD** with the **Screenplay pattern**.  
Its purpose is to automate scenarios of the [SauceDemo](https://www.saucedemo.com/) page, validating the **login** and **purchase** flows.

The **Screenplay** pattern organizes the code into layers, allowing better maintainability, readability, and reusability of components.

---

## 🗂️ Project Structure (Screenplay)
```
src
├── main
│   └── java/com/challenge
│       ├── exceptions        # Custom exceptions
│       ├── interactions      # Custom interactions (e.g., waits, iframes)
│       ├── models            # Data models (UserData, etc.)
│       ├── questions         # Validations and queries to the UI state
│       ├── tasks             # High-level tasks (Login, Purchase, etc.)
│       ├── userinterfaces    # PageObjects (UI element mapping)
│       └── utilities         # Utilities (CSV reader, helpers)
└── test
    ├── java/com/challenge
    │   ├── hooks             # Scenario configuration (SetTheStage)
    │   ├── listeners         # TestListener for console output
    │   ├── runners           # Cucumber Runners (Login, Purchase)
    │   └── stepdefinitions   # Step definitions (glue code)
    └── resources
        ├── features          # .feature files in Gherkin
        │   ├── login
        │   │   └── login.feature
        │   └── purchase
        │       └── purchase.feature
        ├── serenity.conf     # Serenity configuration
        ├── logback-test.xml  # Logs configuration
        └── testdata          # Test data (CSV, JSON, etc.)
```

---

## ⚙️ Technologies
- **Language**: Java (JDK 11 or higher)
- **Test Framework**: [Serenity BDD](https://serenity-bdd.github.io)
- **Design Pattern**: Screenplay
- **BDD Framework**: [Cucumber](https://cucumber.io) with **Gherkin (English)**
- **Build Tools**: 
  - Gradle (recommended)
  - Maven (optional alternative)
- **Browser**: Chrome (configured **incognito** and **maximized**)

---

## 📦 Dependencies
### Gradle (`build.gradle`)
```gradle
testImplementation "net.serenity-bdd:serenity-core:3.9.8"
testImplementation "net.serenity-bdd:serenity-screenplay:3.9.8"
testImplementation "net.serenity-bdd:serenity-screenplay-webdriver:3.9.8"
testImplementation "net.serenity-bdd:serenity-cucumber:3.9.8"
testImplementation "io.cucumber:cucumber-java:7.14.0"
testImplementation "io.cucumber:cucumber-junit:7.14.0"
testImplementation "junit:junit:4.13.2"
```

### Maven (`pom.xml`)
```xml
<dependency>
  <groupId>net.serenity-bdd</groupId>
  <artifactId>serenity-core</artifactId>
  <version>3.9.8</version>
</dependency>
<dependency>
  <groupId>net.serenity-bdd</groupId>
  <artifactId>serenity-screenplay</artifactId>
  <version>3.9.8</version>
</dependency>
<dependency>
  <groupId>net.serenity-bdd</groupId>
  <artifactId>serenity-cucumber</artifactId>
  <version>3.9.8</version>
</dependency>
<dependency>
  <groupId>io.cucumber</groupId>
  <artifactId>cucumber-java</artifactId>
  <version>7.14.0</version>
</dependency>
```

---

## 🌐 Gherkin Features (English)
### Feature 1: Login
```gherkin
Feature: User login on SauceDemo

  @login
  Scenario Outline: Successful login with valid user credentials
    Given the user opens the SauceDemo website
    When the user logs in with username "<username>" and password "<password>"
    Then the inventory page should be displayed

    Examples:
      | username      | password     |
      | visual_user   | secret_sauce |
      | standard_user | secret_sauce |
```

### Feature 2: Purchase
```gherkin
Feature: Successful purchase process on SauceDemo

  @purchase
  Scenario: Complete a successful purchase of two products
    Given the user has logged in successfully
    When the user adds the products to the cart
    And the user completes the checkout process
    Then the confirmation message "Thank you for your order!" should be displayed
```

---

## 🚀 Execution
### With Gradle
```bash
./gradlew clean test
```

### With Maven
```bash
mvn clean verify
```

---

## 📊 Reports
After running the tests, Serenity generates the report in:
```
target/site/serenity/index.html
```
