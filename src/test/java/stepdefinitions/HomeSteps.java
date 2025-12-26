package stepdefinitions;

import context.TestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;

public class HomeSteps {
    private TestContext testContext;

    public HomeSteps(TestContext testContext) {
        this.testContext = testContext;
    }

    @Then("I should see the home page")
    public void iShouldSeeTheHomePage() {
        HomePage homePage = testContext.getHomePage();
        Assert.assertTrue(homePage.isHomePageDisplayed(),
                "Home page should be displayed");
    }

    @Then("the home page should be displayed")
    public void theHomePageShouldBeDisplayed() {
        HomePage homePage = testContext.getHomePage();
        Assert.assertTrue(homePage.isHomePageDisplayed(),
                "Home page should be displayed");
    }

    @Then("the dashboard heading should not be empty")
    public void theDashboardHeadingShouldNotBeEmpty() {
        HomePage homePage = testContext.getHomePage();
        String heading = homePage.getDashboardHeading();
        Assert.assertFalse(heading.isEmpty(),
                "Dashboard heading should not be empty");
    }

    @Then("I should see a welcome message")
    public void iShouldSeeAWelcomeMessage() {
        HomePage homePage = testContext.getHomePage();
        String welcomeMsg = homePage.getWelcomeMessage();
        Assert.assertNotNull(welcomeMsg,
                "Welcome message should not be null");
    }

    @Then("the welcome message should contain {string}")
    public void theWelcomeMessageShouldContain(String expectedText) {
        HomePage homePage = testContext.getHomePage();
        String welcomeMsg = homePage.getWelcomeMessage();
        Assert.assertTrue(welcomeMsg.contains(expectedText),
                "Welcome message should contain '" + expectedText + "'");
    }

    @When("I click logout")
    public void iClickLogout() {
        HomePage homePage = testContext.getHomePage();
        LoginPage loginPage = homePage.logout();
        testContext.setLoginPage(loginPage);
    }

    @When("I click on the profile link")
    public void iClickOnTheProfileLink() {
        HomePage homePage = testContext.getHomePage();
        homePage.clickProfile();
    }

    @When("I click on the settings link")
    public void iClickOnTheSettingsLink() {
        HomePage homePage = testContext.getHomePage();
        homePage.clickSettings();
    }
}
