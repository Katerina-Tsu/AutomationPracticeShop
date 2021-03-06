package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class YourShoppingCartSummaryPage extends HeaderPage {

    @FindBy(xpath = "//*[@id='cart_title']//self::*[contains(text(),'Shopping-cart summary')]")
    WebElement myCartPageWithProductsLabel;

    @FindBy(xpath = "//*[@id='center_column']//ancestor::*[contains(text(),'Your shopping cart is empty.')]")
    WebElement shoppingCartIsEmptyText;

    @FindBy(xpath = "//*[@id='center_column']//self::*[contains(text(),'Proceed to checkout')]")
    WebElement proceedToCheckoutOnShoppingCartSummaryButton;

    private static final String TRASH_BUTTON = "//*[@class='cart_quantity_delete']";

    private static final String QUANTITY_PRODUCTS_ON_CART_PAGE = "//*[@class='cart_quantity_input form-control grey']";

    private static final String TOTAL_PRICE_SOME_ITEMS_PRODUCT = "//*[@class='cart_total']";

    public YourShoppingCartSummaryPage(WebDriver driver) {
        super(driver);
    }

    public void clickProceedToCheckoutYSCSummaryButton() {
        log.info("Click on proceed to checkout button: " + proceedToCheckoutOnShoppingCartSummaryButton);
        proceedToCheckoutOnShoppingCartSummaryButton.click();
    }

    @Step("Deleting a product from the cart with product name: '{productNameItem}'")
    public void clickTrashButton(String productNameItem) {
        log.info("Click on trash button for product: " + productNameItem);
        driver.findElement(By.xpath(String.format(TRASH_BUTTON, productNameItem))).click();
    }

    @Step("Show the number of products in the cart with product name: '{productNameItem}'")
    public String getProductsQuantityOnMyCartPage(String productNameItem) {
        log.info("Get the quantity for product: " + productNameItem);
        return driver.findElement(By.xpath(String.format(QUANTITY_PRODUCTS_ON_CART_PAGE, productNameItem))).getAttribute("value");
    }

    @Step("Show the total price of product in the cart with product name: '{productNameItem}'")
    public String getTotalPriceProducts(String productNameItem) {
        log.info("Get total price for product: " + productNameItem);
        return driver.findElement(By.xpath(String.format(TOTAL_PRICE_SOME_ITEMS_PRODUCT, productNameItem))).getText();
    }

    @Step("Showing text that shopping cart is empty")
    public String getShoppingCartIsEmptyText() {
        log.info("Get text that shopping cart is empty: " + shoppingCartIsEmptyText);
        return shoppingCartIsEmptyText.getText();
    }

    public void waitForMyCartPageIsOpened() {
        wait.until(ExpectedConditions.visibilityOf(myCartPageWithProductsLabel));
    }
}