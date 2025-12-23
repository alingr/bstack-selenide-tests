# Selenide Page Object Model Project

This is a Java-based Selenide automation framework using the Page Object Model (POM) design pattern with TestNG.

## Project Structure

```
selenium-pom-project/
├── src/
│   ├── main/
│   │   └── java/
│   │       ├── pages/
│   │       │   ├── BasePage.java          # Base class with common page methods
│   │       │   ├── LoginPage.java         # Login page object
│   │       │   └── HomePage.java          # Home page object
│   │       └── utils/
│   │           ├── ConfigReader.java      # Configuration reader utility
│   │           └── ScreenshotUtil.java    # Screenshot utility
│   └── test/
│       ├── java/
│       │   └── tests/
│       │       ├── BaseTest.java          # Base test class with setup/teardown
│       │       ├── LoginTest.java         # Login test cases
│       │       └── HomeTest.java          # Home page test cases
│       └── resources/
│           ├── testng.xml                 # TestNG configuration
│           └── config.properties          # Application configuration
└── pom.xml                                # Maven dependencies
```

## Technologies Used

- Java 11
- Selenide 7.0.4 (includes Selenium WebDriver)
- TestNG 7.8.0
- Maven

## Features

- Page Object Model design pattern
- Selenide's automatic WebDriver management (no need for WebDriverManager)
- Automatic waits and smart element interactions
- Built-in screenshot capture on test failures
- TestNG for test execution and reporting
- Parallel test execution support
- Cross-browser testing (Chrome, Firefox, Edge)
- Configuration management via properties file
- Concise and readable test code
- Automatic retry mechanism for flaky tests
- Reusable base classes for pages and tests

## Prerequisites

- Java JDK 11 or higher
- Maven 3.6+
- Chrome/Firefox/Edge browser installed

## Setup Instructions

1. Clone or download this project
2. Open terminal/command prompt in the project directory
3. Run the following command to download dependencies:
   ```bash
   mvn clean install
   ```

## Running Tests

### Run all tests using Maven:
```bash
mvn clean test
```

### Run tests using TestNG XML:
```bash
mvn test -DsuiteXmlFile=src/test/resources/testng.xml
```

### Run specific test class:
```bash
mvn test -Dtest=LoginTest
```

### Run with different browser:
Edit `config.properties` and change the browser value:
```properties
browser=chrome  # or firefox, edge
```

## Configuration

Edit `src/test/resources/config.properties` to configure:
- Base URL
- Browser type
- Timeouts
- Test data
- Screenshot path

## Writing New Tests

1. Create page objects in `src/main/java/pages/` extending `BasePage`
2. Create test classes in `src/test/java/tests/` extending `BaseTest`
3. Add your test class to `testng.xml`

## Page Object Model Pattern

Each page is represented by a class that:
- Extends `BasePage` for common functionality
- Contains locators for elements on that page
- Provides methods to interact with those elements
- Returns new page objects when navigation occurs
- No need to pass WebDriver (Selenide manages it globally)

Example:
```java
public class LoginPage extends BasePage {
    private By usernameField = By.id("username");

    public void enterUsername(String username) {
        type(usernameField, username);
    }

    public HomePage login(String user, String pass) {
        enterUsername(user);
        enterPassword(pass);
        clickLoginButton();
        return new HomePage();  // No driver needed!
    }
}
```

## Key Selenide Benefits

1. **No WebDriver management**: Selenide handles driver lifecycle automatically
2. **Automatic waits**: No need for explicit waits - Selenide waits for elements automatically
3. **Concise syntax**: Use `$()` for elements and fluent API for interactions
4. **Smart assertions**: Built-in conditions like `.shouldBe(visible)`, `.shouldHave(text("..."))`
5. **Automatic screenshots**: Screenshots captured on failures without extra code
6. **Less boilerplate**: Much cleaner and more readable code compared to vanilla Selenium

## Test Reports

After running tests, find reports at:
- `target/surefire-reports/index.html` - TestNG HTML report
- `target/surefire-reports/` - XML and text reports

## Notes

- Update the locators in page objects to match your actual application
- Update the base URL in `config.properties` or `BaseTest.java`
- Customize `BaseTest.java` to add additional Selenide configuration
- Screenshots are automatically saved to `build/reports/tests` on failures
- Configure Selenide properties in `BaseTest.setUp()` method
- For headless mode, set `Configuration.headless = true` in BaseTest
- Add more utility classes as needed

## Selenide Configuration Options

You can configure Selenide in `BaseTest.java`:
```java
Configuration.browser = "chrome";           // Browser type
Configuration.browserSize = "1920x1080";    // Browser window size
Configuration.timeout = 10000;              // Wait timeout in ms
Configuration.headless = false;             // Run in headless mode
Configuration.screenshots = true;           // Enable screenshots
Configuration.reportsFolder = "build/reports/tests";  // Report location
```

## Migrating from Selenium to Selenide

If you're familiar with Selenium, here are the key differences:
- `driver.findElement(By.id("x"))` → `$(By.id("x"))` or `$("#x")`
- `driver.get(url)` → `open(url)`
- `element.click()` → `$(locator).click()`
- `element.sendKeys(text)` → `$(locator).setValue(text)`
- Manual waits → Automatic (Selenide waits for elements)
- `driver.quit()` → `closeWebDriver()` (handled in BaseTest)
