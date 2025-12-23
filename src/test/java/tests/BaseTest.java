package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    protected String baseUrl = "https://bstackdemo.com/signin";

    @BeforeMethod
    @Parameters("browser")
    public void setUp(@Optional("chrome") String browser) {
        Configuration.browser = browser.toLowerCase();
        Configuration.baseUrl = baseUrl;
        Configuration.timeout = 10000;
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;
        Configuration.screenshots = true;
        Configuration.savePageSource = false;

        open(baseUrl);
    }

    @AfterMethod
    public void tearDown() {
        Selenide.closeWebDriver();
    }

    protected void navigateToUrl(String url) {
        open(url);
    }
}
