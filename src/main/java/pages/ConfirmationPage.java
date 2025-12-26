package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

public class ConfirmationPage extends BasePage{

    // Element locators
    private SelenideElement confirmationMessage() { return $(By.id("confirmation-message")); }

    public boolean isConfirmationMessageDisplayed() {
        return confirmationMessage().shouldBe(Condition.visible).isDisplayed();
    }

    public String getConfirmationMessage() {
        return confirmationMessage().shouldBe(Condition.visible).getText();
    }
}
