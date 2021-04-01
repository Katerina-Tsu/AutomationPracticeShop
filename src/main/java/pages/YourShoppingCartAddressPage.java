package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class YourShoppingCartAddressPage extends HeaderPage{

    @FindBy(xpath = "//*[@id='center_column']//self::*[contains(text(),'Proceed to checkout')]")
    WebElement proceedToCheckoutOnYSCSignInButton;

    public YourShoppingCartAddressPage(WebDriver driver) {
        super(driver);
    }

    public void clickProceedToCheckoutYSCSignInButton() {
        log.info("Click on proceed to checkout button: " + proceedToCheckoutOnYSCSignInButton);
        proceedToCheckoutOnYSCSignInButton.click();
    }
}