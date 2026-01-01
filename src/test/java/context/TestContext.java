package context;

import pages.LoginPage;
import pages.HomePage;
import pages.CheckoutPage;
import pages.ConfirmationPage;
import pages.OrdersPage;

public class TestContext {
    private LoginPage loginPage;
    private HomePage homePage;
    private CheckoutPage checkoutPage;
    private ConfirmationPage confirmationPage;
    private OrdersPage ordersPage;

    public TestContext() {
        this.loginPage = new LoginPage();
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(LoginPage loginPage) {
        this.loginPage = loginPage;
    }

    public HomePage getHomePage() {
        return homePage;
    }

    public void setHomePage(HomePage homePage) {
        this.homePage = homePage;
    }

    public CheckoutPage getCheckoutPage() {
        return checkoutPage;
    }

    public void setCheckoutPage(CheckoutPage checkoutPage) {
        this.checkoutPage = checkoutPage;
    }

    public ConfirmationPage getConfirmationPage() {
        return confirmationPage;
    }

    public void setConfirmationPage(ConfirmationPage confirmationPage) {
        this.confirmationPage = confirmationPage;
    }

    public OrdersPage getOrdersPage() {
        return ordersPage;
    }

    public void setOrdersPage(OrdersPage ordersPage) {
        this.ordersPage = ordersPage;
    }
}
