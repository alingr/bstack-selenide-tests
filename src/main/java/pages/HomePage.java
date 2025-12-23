package pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage {

    private By welcomeMessage = By.cssSelector(".welcome-message");
    private By logoutButton = By.id("logout");
    private By profileLink = By.linkText("Profile");
    private By settingsLink = By.linkText("Settings");
    private By dashboardHeading = By.className("username");
    private By addToCartButton = By.className("shelf-item__buy-btn");
    private By checkoutButton = By.className("buy-btn");

    public String getWelcomeMessage() {
        return getText(welcomeMessage);
    }

    public void clickLogout() {
        click(logoutButton);
    }

    public void clickProfile() {
        click(profileLink);
    }

    public void clickSettings() {
        click(settingsLink);
    }

    public boolean isHomePageDisplayed() {
        return isDisplayed(dashboardHeading);
    }

    public String getDashboardHeading() {
        return getText(dashboardHeading);
    }

    public LoginPage logout() {
        clickLogout();
        return new LoginPage();
    }

    public HomePage addProductToCart(){
        click(addToCartButton);
        return this;
    }

    public CheckoutPage checkout(){
        click(checkoutButton);
        return new CheckoutPage();
    }
}
