package stepdefinitions;

import context.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.CheckoutPage;
import pages.ConfirmationPage;
import pages.HomePage;
import pages.OrdersPage;

import java.util.Map;

public class OrdersSteps {
    private TestContext testContext;

    public OrdersSteps(TestContext testContext) {
        this.testContext = testContext;
    }

    @When("I click on the orders link")
    public void iClickOnTheOrdersLink() {
        HomePage homePage = testContext.getHomePage();
        OrdersPage ordersPage = homePage.clickOrders();
        testContext.setOrdersPage(ordersPage);
    }

    @Then("I should see the existing order")
    public void iShouldSeeTheOrderConfirmationMessage() {
        OrdersPage ordersPage = testContext.getOrdersPage();
        Assert.assertTrue(ordersPage.isOrderDisplayed(),
                "Order should be displayed");
    }

    @Then("the order date should be {string}")
    public void theOrderDateShouldBe(String expectedText) {
        OrdersPage ordersPage = testContext.getOrdersPage();
        String actualOrderDate = ordersPage.getOrderDate();
        System.out.println(actualOrderDate);
        Assert.assertTrue(actualOrderDate.contains(expectedText),
                "Order date should be '" + expectedText + "' but was '" + actualOrderDate + "'");
    }

}
