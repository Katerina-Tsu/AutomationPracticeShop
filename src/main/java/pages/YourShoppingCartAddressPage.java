package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YourShoppingCartAddressPage extends HeaderPage{

    @FindBy(xpath = "//*[@id='center_column']//self::*[contains(text(),'Proceed to checkout')]")
    WebElement proceedToCheckoutOnYSCSignInButton;

    public YourShoppingCartAddressPage(WebDriver driver) {
        super(driver);
    }

    public void clickProceedToCheckoutYSCSignInButton() {
        proceedToCheckoutOnYSCSignInButton.click();
    }
}