package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
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
        log.info("Click on Pay Bank Wire button: " + payBankWire);
        payBankWire.click();
    }

    @Step("Click on Payment End button")
    public void clickPaymentBtn() {
        log.info("Click on Payment End button: " + paymentEndBtnIConf);
        paymentEndBtnIConf.click();
    }
}