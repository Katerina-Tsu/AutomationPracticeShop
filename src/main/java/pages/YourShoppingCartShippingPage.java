package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class YourShoppingCartShippingPage extends HeaderPage{

    @FindBy(xpath = "//*[@id='cgv']")
    WebElement iAgreeCheckBox;

    @FindBy(xpath = "//*[@id='center_column']//self::*[contains(text(),'Proceed to checkout')]")
    WebElement proceedToCheckoutOnYSCShippingButton;

    public YourShoppingCartShippingPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click on check box 'I Agree' and click on the 'proceed to checkout' button")
    public void checkedTabShipping() {
        log.info("Click on check box 'I Agree': " + iAgreeCheckBox);
        iAgreeCheckBox.click();
        log.info("Click on proceed to checkout button: " + proceedToCheckoutOnYSCShippingButton);
        proceedToCheckoutOnYSCShippingButton.click();
    }
}