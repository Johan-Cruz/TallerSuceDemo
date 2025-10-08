# TallerSauceDemo 🧪

## 📖 Proyecto
Este proyecto implementa un marco de automatización de pruebas funcionales basado en **Serenity BDD** con el patrón **Screenplay**.
Su propósito es automatizar los escenarios de la página [SauceDemo](https://www.saucedemo.com/), validando las historias de usuario (escenarios) **Login** y **Purcharse**.

El patrón **Screenplay** organiza el código en capas, esta estructurado de la siguiente manera.
---

## 🗂️ Estructura del proyecto (Screenplay)
```
src
├── main
│   └── java/com/challenge
│       ├── exceptions        
│       ├── interactions      
│       ├── models            
│       ├── questions         
│       ├── tasks             
│       ├── userinterfaces    
│       └── utilities         
└── test
    ├── java/com/challenge
    │   ├── hooks             
    │   ├── listeners         
    │   ├── runners           
    │   └── stepdefinitions   
    └── resources
        ├── features          
        │   ├── login
        │   │   └── login.feature
        │   └── purchase
        │       └── purchase.feature
        ├── serenity.conf     
        ├── logback-test.xml  
        └── testdata          
```

---

## ⚙️ Herramientas
- **Languaje**: Java (JDK 11 or higher)
- **Test Framework**: [Serenity BDD](https://serenity-bdd.github.io)
- **Patron**: Screenplay
- **BDD Framework**: [Cucumber](https://cucumber.io) **Gherkin (English)**
- **Compilación**: 
  - Gradle
- **Navegador**: Chrome (Configurado **incognito** y **maximized**)

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
---

## 🌐 Escenarios Features (Ingles como lo pedía el taller)
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

## 🚀 Ejecución
### Con Gradle
```bash
./gradlew clean test
```

### Directamente desde los Runner
```
- LoginRunner
- PurchaseRunner
```
## 📊 Reporte de Serenity
Después de cada ejecución se genera el reporte en la ruta:
```
target/site/serenity/index.html
