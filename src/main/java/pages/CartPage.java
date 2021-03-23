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

    @FindBy(xpath = "//*[@class='exclusive']")
    WebElement addToCart;

    @FindBy(xpath = "//*[@id='layer_cart']/div[1]/div[2]/div[4]/span/span")
    WebElement continueShopping;

    @FindBy(xpath = "//*[@id='header']/div[3]/div/div/div[3]/div/a/b")
    WebElement goOverToCart;

    private static final String SIGNED_IN_DESCRIPTION_LABEL_XPATH = "//*[@class='cart_description']//ancestor::*[contains(text(),'%s')]";
    @Override
    void waitForPageOpened() {
    }

    public void clickOnProduct(String productName) {
        driver.findElement(By.xpath(String.format(PRODUCT_TITLE_XPATH,productName))).click();
    }

    public void clickAddToCart() {
        addToCart.click();
        continueShopping.click();
        goOverToCart.click();
    }

    public boolean isProductDescription(String headerText) {
        return driver.findElement(By.xpath(String.format(SIGNED_IN_DESCRIPTION_LABEL_XPATH, headerText))).isDisplayed();
    }

}
