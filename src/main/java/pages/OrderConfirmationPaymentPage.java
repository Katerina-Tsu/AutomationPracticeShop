package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderConfirmationPaymentPage extends HeaderPage{

    @FindBy(xpath = "//*[@class='cheque-indent']//ancestor::*[contains(text(),'Your order on My Store is complete.')]")
    WebElement orderIsCompleteText;

    public OrderConfirmationPaymentPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOrderIsCompleteTextDisplayed() {
        return orderIsCompleteText.isDisplayed();
    }
}
