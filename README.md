# QA Automation Asessment

This test auotmation framework is designed to perform functional testing on web applications using Selenium,TestNG,Cucumber and Allure reports

# Key Features

 * **Cross-Browser Support**: Chrome, Firefox, Edge.

* **Maven Integration** for dependency management and test execution.

* **Detailed Reporting** with Allure Reports.

* **Page Object Model (POM)** structure for maintainability and scalability.

# Prerequisites

|                                                                               **IntelliJ**                                                                                |                                                             **JDK 21**                                                              |                                                       **Maven 3.9**                                                       |
|:-------------------------------------------------------------------------------------------------------------------------------------------------------------------------:|:-----------------------------------------------------------------------------------------------------------------------------------:|:--------------------------------------------------------------------------------------------------------------------------:|
| [<img width="50" height="50" src="https://cdn.iconscout.com/icon/free/png-128/intellij-idea-569199.png">](https://www.jetbrains.com/es-es/idea/download/#section=windows) | [<img height="60" src="https://imagedelivery.net/-IT6z0z0Ec5yEiYj3DvVjg/4a05ca76db1fa48640b21658f2659ac656492b82/public">](https://learn.microsoft.com/es-es/java/openjdk/download#openjdk-21) | [<img height="50" src="https://maven.apache.org/images/maven-logo-black-on-white.png">](https://maven.apache.org/download.cgi) |

# Instalation

1. **Clone the repository**
```bash
 git clone https://github.com/LuisCastilloSofka/luis-assesment.git
 cd luis-assesment
```
2. **Install Dependencies** Run the following command to install the required dependencies:
```bash
 mvn clean install
```

# Project Structure

```plaintext
src
├── main
│   └── java
├── test
    ├── java
    │   ├── hooks      # Hooks for setting up @Before and @After methods
    │   ├── pageobjects # Classes representing UI elements or components
    │   ├── pages      # Classes representing the pages of the application
    │   ├── runners    # Classes to execute the tests
    │   ├── stepdefinitions # Step definitions for Cucumber
    │   └── utils      # Utility classes for the tests
    ├── resources
        ├── configs     # Configuration files like testng.xml
        └── features    # Gherkin feature files (.feature)
```

# Running the Scenarios
1.**Run with Maven**

To execute the tests suites defined in the `testng.xml` file, use the following command:
```bash
 mvn test
```
2.**Generate Allure Reports**

**a.Generate and Serve the report**
```bash
 mvn allure:serve
```
This command will open a local server to view the report

**b.Generate the Report to Disk**
```bash
 mvn allure:report
```
The report will be saved in `target/site/allure-maven-plugin`

# Aditional Configurations

**Changing the Browser**

The default browser or browsers can be configured in the `testng.xml` file under the parameter section:

```xml
<parameter name="browser" value="chrome"/>
```

You can change the browser to firefox or edge as needed.

**Parallel Executions**

Paralell execution is allowed and can be easily configured in `testng.xml` in the `thread-count` section

```xml
<suite name="Cross-Browser Testing Suite" parallel="tests" thread-count="3">
```

# Adding new Scenarios

1. Create a `.feature` file under `src/test/resources/features`.
2. Define the steps in a class under `src/test/java/stepdefinitions`
3. Create any specific methods of page behavior under 'src/tests/java/pages'
4. Optional: Extend `BasePage` and reuse any method already created
5. Define a PageObject type under `src/test/java/pageobject`


# Contact

For more information or help,contact:

* Luis Castillo
* Email : luchocd27@hotmail.com
* Phone: +573214539591