package pages;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.*;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class BasePage {

    protected SelenideElement $(By locator) {
        return com.codeborne.selenide.Selenide.$(locator);
    }

    protected void click(By locator) {
        $(locator).click();
    }

    protected void type(By locator, String text) {
        $(locator).clear();
        $(locator).sendKeys(text);
        $(locator).pressEnter();
    }

    protected void setValue(By locator, String text) {
        $(locator).setValue(text);
    }

    protected String getText(By locator) {
        return $(locator).getText();
    }

    protected boolean isDisplayed(By locator) {
        return $(locator).isDisplayed();
    }

    protected void waitForElementToDisappear(By locator) {
        $(locator).should(com.codeborne.selenide.Condition.disappear);
    }

    public String getPageTitle() {
        return title();
    }

    public String getCurrentUrl() {
        return url();
    }
}
