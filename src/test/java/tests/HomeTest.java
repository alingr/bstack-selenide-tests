package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;

public class HomeTest extends BaseTest {

    private HomePage homePage;

    @BeforeMethod(dependsOnMethods = "setUp")
    public void login() {
        LoginPage loginPage = new LoginPage();
        homePage = loginPage.login("demouser", "testingisfun99");
    }

    @Test(priority = 1, description = "Verify home page displays correctly after login")
    public void testHomePageDisplay() {
        Assert.assertTrue(homePage.isHomePageDisplayed(),
                         "Home page should be displayed");
        Assert.assertFalse(homePage.getDashboardHeading().isEmpty(),
                          "Dashboard heading should not be empty");
    }

    @Test(priority = 2, description = "Verify welcome message is displayed")
    public void testWelcomeMessage() {
        String welcomeMsg = homePage.getWelcomeMessage();

        Assert.assertNotNull(welcomeMsg, "Welcome message should not be null");
        Assert.assertTrue(welcomeMsg.contains("Welcome"),
                         "Welcome message should contain 'Welcome'");
    }

    @Test(priority = 3, description = "Verify logout functionality")
    public void testLogout() {
        LoginPage loginPage = homePage.logout();

        Assert.assertTrue(loginPage.isLoginPageDisplayed(),
                         "Should navigate back to login page after logout");
    }

    @Test(priority = 4, description = "Verify navigation to profile page")
    public void testProfileNavigation() {
        homePage.clickProfile();

        webdriver().shouldHave(urlContaining("profile"));
    }

    @Test(priority = 5, description = "Verify navigation to settings page")
    public void testSettingsNavigation() {
        homePage.clickSettings();

        webdriver().shouldHave(urlContaining("settings"));
    }
}
