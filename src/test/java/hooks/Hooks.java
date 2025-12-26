package hooks;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.screenshot;

public class Hooks {
    private String baseUrl = "https://bstackdemo.com/signin";

    @Before
    public void setUp(Scenario scenario) {
        // Get browser from system property or default to chrome
        String browser = System.getProperty("browser", "chrome");

        // Configure Selenide
        Configuration.browser = browser.toLowerCase();
        Configuration.baseUrl = baseUrl;
        Configuration.timeout = 10000;
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;
        Configuration.screenshots = true;
        Configuration.savePageSource = false;

        // Open browser to base URL
        open(baseUrl);
    }

    @After
    public void tearDown(Scenario scenario) {
        // Capture screenshot if scenario failed
        if (scenario.isFailed()) {
            try {
                byte[] screenshotBytes = Selenide.screenshot(OutputType.BYTES);
                if (screenshotBytes != null) {
                    scenario.attach(screenshotBytes, "image/png", scenario.getName());
                }
            } catch (Exception e) {
                System.err.println("Failed to capture screenshot: " + e.getMessage());
            }
        }

        // Close WebDriver
        Selenide.closeWebDriver();
    }
}
