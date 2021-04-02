package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    private static final String PRODUCT_TITLE_XPATH = "//*[@title = '%s']";


    @FindBy(xpath = "//*[@name='Submit']")
    WebElement addToCart;

    @FindBy(xpath = "//*[@title='Continue shopping']")
    WebElement continueShopping;

    @FindBy(xpath = "//*[@title='View my shopping cart']")
    WebElement goOverToCart;

    private static final String SIGNED_IN_DESCRIPTION_LABEL_XPATH = "//*[@class='cart_description']//ancestor::*[contains(text(),'%s')]";

    public void clickOnProduct(String productName) {
        driver.findElement(By.xpath(String.format(PRODUCT_TITLE_XPATH,productName))).click();
    }

    public void clickAddToCart() {
        continueShopping.click();
        goOverToCart.click();
    }

    public boolean isProductDescriptionDisplayed(String headerText) {
        return driver.findElement(By.xpath(String.format(SIGNED_IN_DESCRIPTION_LABEL_XPATH, headerText))).isDisplayed();
    }

    public void clickOnAddToCartButton() {
        driver.switchTo().frame(driver.findElement(By.className("fancybox-iframe")));
        addToCart.click();
        driver.switchTo().defaultContent();
    }
}