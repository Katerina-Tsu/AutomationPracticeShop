package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YourShoppingCartShippingPage extends HeaderPage{

    @FindBy(xpath = "//*[@id='cgv']")
    WebElement iAgreeCheckBox;

    @FindBy(xpath = "//*[@id='center_column']//self::*[contains(text(),'Proceed to checkout')]")
    WebElement proceedToCheckoutOnYSCShippingButton;

    public YourShoppingCartShippingPage(WebDriver driver) {
        super(driver);
    }

    public void checkedTabShipping() {
        iAgreeCheckBox.click();
        proceedToCheckoutOnYSCShippingButton.click();
    }
}