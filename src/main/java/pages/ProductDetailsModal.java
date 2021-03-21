package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductDetailsModal extends HeaderPage{

    @FindBy(xpath = "//*[@id='layer_cart']//self::*[contains(text(),'Proceed to checkout')]")
    WebElement proceedToCheckoutButton;

    @FindBy(xpath = "//*[@class='cross']")
    WebElement cartStorePageLabel;

    @FindBy(xpath = "//*[@class='icon-ok']")
    WebElement tickProductAddedToCartLabel;

    public ProductDetailsModal(WebDriver driver) {
        super(driver);
    }

    public void clickProceedToCheckoutButton() {
        proceedToCheckoutButton.click();
    }

    public void waitForPageOpened() {
        wait.until(ExpectedConditions.visibilityOf(cartStorePageLabel));
    }

    public boolean isTickProductAddedToCartPageOpened() {
        return tickProductAddedToCartLabel.isDisplayed();
    }
}