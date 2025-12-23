package tests;

import com.codeborne.selenide.Condition;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;

public class LoginTest extends BaseTest {

    @Test(priority = 1, description = "Verify successful login with valid credentials")
    public void testValidLogin() throws InterruptedException {
        LoginPage loginPage = new LoginPage();

        HomePage homePage = loginPage.login("demouser", "testingisfun99");

        Assert.assertTrue(homePage.isHomePageDisplayed(), "Home page should be displayed");
        /*
        Assert.assertTrue(homePage.getWelcomeMessage().contains("Welcome"),
                         "Welcome message should be displayed");
                         */
    }

    @Test(priority = 2, description = "Verify login fails with invalid credentials")
    public void testInvalidLogin() {
        LoginPage loginPage = new LoginPage();

        loginPage.enterUsername("invaliduser");
        loginPage.enterPassword("invalidpassword");
        loginPage.clickLoginButton();

        Assert.assertTrue(loginPage.isErrorMessageDisplayed(),
                         "Error message should be displayed");
        Assert.assertTrue(loginPage.getErrorMessage().contains("Invalid"),
                         "Error message should contain 'Invalid'");
    }

    @Test(priority = 3, description = "Verify login with empty credentials")
    public void testEmptyCredentialsLogin() {
        LoginPage loginPage = new LoginPage();

        loginPage.clickLoginButton();

        Assert.assertTrue(loginPage.isLoginPageDisplayed(),
                         "Should remain on login page");
    }

    @Test(priority = 4, description = "Verify forgot password link is clickable")
    public void testForgotPasswordLink() {
        LoginPage loginPage = new LoginPage();

        loginPage.clickForgotPassword();

        /*
        webdriver().shouldHave(
            urlContaining("forgot-password").or(urlContaining("reset"))
        );

         */
    }
}
