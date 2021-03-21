package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YourShoppingCartPaymentPage extends HeaderPage{

    @FindBy(xpath = "//*[@class='bankwire']")
    WebElement payBankWire;

    @FindBy(xpath = "//*[@id='cart_navigation']//ancestor::*[contains(text(),'I confirm my order')]")
    WebElement paymentEndBtnIConf;

    public YourShoppingCartPaymentPage(WebDriver driver) {
        super(driver);
    }

    public void clickBankWireBtn() {
        payBankWire.click();
    }

    public void clickPaymentBtn() {
        paymentEndBtnIConf.click();
    }
}