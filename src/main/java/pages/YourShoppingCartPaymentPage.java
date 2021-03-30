package pages;

import io.qameta.allure.Step;
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

    @Step("Click on Pay Bank Wire button")
    public void clickBankWireBtn() {
        payBankWire.click();
    }

    @Step("Click on Payment End button")
    public void clickPaymentBtn() {
        paymentEndBtnIConf.click();
    }
}