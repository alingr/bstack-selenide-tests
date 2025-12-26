package stepdefinitions;

import context.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;

public class CommonSteps {
    private TestContext testContext;

    public CommonSteps(TestContext testContext) {
        this.testContext = testContext;
    }

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        // Browser is already opened to login page in Hooks
        Assert.assertTrue(testContext.getLoginPage().isLoginPageDisplayed(),
                "Login page should be displayed");
    }

    @Then("the URL should contain {string}")
    public void theURLShouldContain(String urlPart) {
        webdriver().shouldHave(urlContaining(urlPart));
    }
}
