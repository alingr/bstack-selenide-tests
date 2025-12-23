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

    public ConfirmationPage enterShippingAddress(String firstName, String lastName, String address, String stateProvince, String postalCode){
        firstNameField().shouldBe(Condition.visible).setValue(firstName);
        lastNameField().shouldBe(Condition.visible).setValue(lastName);
        addressField().shouldBe(Condition.visible).setValue(address);
        stateProvinceField().shouldBe(Condition.visible).setValue(stateProvince);
        postalCodeField().shouldBe(Condition.visible).setValue(postalCode);
        submitButton().shouldBe(Condition.visible).click();
        return new ConfirmationPage();
    }
}
