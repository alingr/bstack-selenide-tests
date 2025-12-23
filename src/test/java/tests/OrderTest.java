package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ConfirmationPage;
import pages.LoginPage;

public class OrderTest extends BaseTest {
    @Test(priority = 1, description = "Verify successful order with valid user")
    public void testValidOrder() {
        LoginPage loginPage = new LoginPage();

        ConfirmationPage confirmationPage = loginPage.login("demouser", "testingisfun99")
                .addProductToCart()
                .checkout()
                .enterShippingAddress("Test First name", "Test Last Name", "Test Address Line 123", "Test State Province", "123456");

        Assert.assertTrue(confirmationPage.getConfirmationMessage()
                .contains("Your Order has been successfully placed."));

        Assert.assertTrue(confirmationPage.isConfirmationMessageDisplayed(),
                "Confirmation message should be displayed");

    }
}
