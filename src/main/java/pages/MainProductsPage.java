package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainProductsPage extends HeaderPage {

    @FindBy(xpath = "//*[@class='cross']")
    WebElement cartStorePageLabel;

    @FindBy(xpath = "//*[@class='icon-ok']")
    WebElement tickProductAddedToCartLabel;

    @FindBy(xpath = "//*[@id='add_to_cart']/button/span")
    WebElement addToCartButton;

    String productNameOnMainPageText = "//*[@id='homefeatured']//self::*[contains(text(),'%s')]";

    public MainProductsPage(WebDriver driver) {
        super(driver);
    }

    public void waitForPageOpened() {
        wait.until(ExpectedConditions.visibilityOf(cartStorePageLabel));
    }

    public void findProductNameOnMainPage(String productNameItem) {
        driver.findElement(By.xpath(String.format(productNameOnMainPageText, productNameItem))).click();
    }

    public void clickAddToCartButton() {
        addToCartButton.click();
    }

    public boolean isTickProductAddedToCartPageOpened() {
        return tickProductAddedToCartLabel.isDisplayed();
    }
}