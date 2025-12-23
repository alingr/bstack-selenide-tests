package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CheckoutPage extends BasePage {

    // Element locators
    private SelenideElement firstNameField() { return $(By.id("firstNameInput")); }
    private SelenideElement lastNameField() { return $(By.id("lastNameInput")); }
    private SelenideElement addressField() { return $(By.id("addressLine1Input")); }
    private SelenideElement stateProvinceField() { return $(By.id("provinceInput")); }
    private SelenideElement postalCodeField() { return $(By.id("postCodeInput")); }
    private SelenideElement submitButton() { return $(By.id("checkout-shipping-continue")); }

    public ConfirmationPage enterShippingAddress(){
        firstNameField().shouldBe(Condition.visible).setValue("Test First Name");
        lastNameField().shouldBe(Condition.visible).setValue("Test Last Name");
        addressField().shouldBe(Condition.visible).setValue("Test Address Line 123");
        stateProvinceField().shouldBe(Condition.visible).setValue("Test State Province");
        postalCodeField().shouldBe(Condition.visible).setValue("123456");
        submitButton().shouldBe(Condition.visible).click();
        return new ConfirmationPage();
    }
}
