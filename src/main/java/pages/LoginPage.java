package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage {

    // Element locators
    private SelenideElement usernameField() { return $(By.id("react-select-2-input")); }
    private SelenideElement passwordField() { return $(By.id("react-select-3-input")); }
    private SelenideElement loginButton() { return $(By.id("login-btn")); }
    private SelenideElement errorMessage() { return $(By.id(".error-message")); }
    private SelenideElement forgotPasswordLink() { return $(By.linkText("Forgot Password?")); }
    private SelenideElement dashboardHeading() { return $(By.className("username")); }

    public LoginPage enterUsername(String username) {
        usernameField().shouldBe(Condition.visible).setValue(username).pressEnter();
        return this;
    }

    public LoginPage enterPassword(String password) {
        passwordField().shouldBe(Condition.visible).setValue(password).pressEnter();
        return this;
    }

    public void clickLoginButton() {
        loginButton().shouldBe(Condition.enabled).click();
    }

    public HomePage login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
        dashboardHeading().shouldBe(Condition.visible);
        return new HomePage();
    }

    public boolean isErrorMessageDisplayed() {
        return errorMessage().is(Condition.visible);
    }

    public String getErrorMessage() {
        return errorMessage().shouldBe(Condition.visible).getText();
    }

    public void clickForgotPassword() {
        forgotPasswordLink().shouldBe(Condition.visible).click();
    }

    public boolean isLoginPageDisplayed() {
        return loginButton().is(Condition.visible);
    }
}
