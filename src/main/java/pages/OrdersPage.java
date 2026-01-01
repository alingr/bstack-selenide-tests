package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class OrdersPage extends BasePage  {

    // Element locators
    private SelenideElement orderDetails() { return $(By.id("1")); }
    private SelenideElement orderDate() { return $(By.xpath("//*[@class='a-color-secondary value']")); }


    public boolean isOrderDisplayed(){
        return orderDetails().shouldBe(Condition.visible).isDisplayed();
   }

    public String getOrderDate() {
        return orderDate().shouldBe(Condition.visible).getText();
    }

}
