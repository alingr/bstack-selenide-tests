package stepdefinitions;

import context.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.CheckoutPage;
import pages.ConfirmationPage;
import pages.HomePage;

import java.util.Map;

public class CheckoutSteps {
    private TestContext testContext;

    public CheckoutSteps(TestContext testContext) {
        this.testContext = testContext;
    }

    @When("I add a product to the cart")
    public void iAddAProductToTheCart() {
        HomePage homePage = testContext.getHomePage();
        homePage = homePage.addProductToCart();
        testContext.setHomePage(homePage);
    }

    @When("I proceed to checkout")
    public void iProceedToCheckout() {
        HomePage homePage = testContext.getHomePage();
        CheckoutPage checkoutPage = homePage.checkout();
        testContext.setCheckoutPage(checkoutPage);
    }

    @When("I enter shipping address with the following details:")
    public void iEnterShippingAddressWithTheFollowingDetails(DataTable dataTable) {
        Map<String, String> shippingData = dataTable.asMap(String.class, String.class);

        String firstName = shippingData.get("First Name");
        String lastName = shippingData.get("Last Name");
        String address = shippingData.get("Address");
        String state = shippingData.get("State");
        String postalCode = shippingData.get("Postal Code");

        CheckoutPage checkoutPage = testContext.getCheckoutPage();
        ConfirmationPage confirmationPage = checkoutPage.enterShippingAddress(
                firstName, lastName, address, state, postalCode);
        testContext.setConfirmationPage(confirmationPage);
    }

    @Then("I should see the order confirmation message")
    public void iShouldSeeTheOrderConfirmationMessage() {
        ConfirmationPage confirmationPage = testContext.getConfirmationPage();
        Assert.assertTrue(confirmationPage.isConfirmationMessageDisplayed(),
                "Confirmation message should be displayed");
    }

    @Then("the confirmation message should contain {string}")
    public void theConfirmationMessageShouldContain(String expectedText) {
        ConfirmationPage confirmationPage = testContext.getConfirmationPage();
        String actualMessage = confirmationPage.getConfirmationMessage();
        Assert.assertTrue(actualMessage.contains(expectedText),
                "Confirmation message should contain '" + expectedText + "' but was '" + actualMessage + "'");
    }
}
