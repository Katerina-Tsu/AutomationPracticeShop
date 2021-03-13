package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class YourShoppingCartPage extends HeaderPage {

    @FindBy(xpath = "//*[@id='email_create']")
    WebElement emailAddressFieldInput;

    @FindBy(xpath = "//*[@id='SubmitCreate']")
    WebElement createAnAccountButton;

    @FindBy(xpath = "//*[@class='cross']")
    WebElement cartStorePageLabel;

    @FindBy(xpath = "//*[@id='add_to_cart']/button/span")
    WebElement addToCartButton;

    String productNameOnMainPageText = "//*[@id='homefeatured']//self::*[contains(text(),'%s')]";

    @FindBy(xpath = "//*[@class='icon-plus']")
    WebElement increaseTheQuantityProductsButton;

    @FindBy(xpath = "//*[@class='icon-trash']")
    WebElement trashButton;

    @FindBy(xpath = "//*[@id='add_to_cart']/button/span")
    WebElement addToCartButton;

    @FindBy(xpath = "//*[@id='center_column']//ancestor::*[contains(text(),'Your shopping cart is empty.')]")
    WebElement shoppingCartIsEmptyText;

    @FindBy(xpath = "//*[@id='layer_cart']//self::*[contains(text(),'Proceed to checkout')]")
    WebElement proceedToCheckoutButton;

    @FindBy(xpath = "//*[@id='cart_title']//self::*[contains(text(),'Shopping-cart summary')]")
    WebElement myCartPageWithProductsLabel;

    String quantityProductsOnCartPage = "//*[@name='quantity_2_7_0_0']";

    String totalPriceSomeItemsProduct = "//*[@id='total_product_price_2_7_0']";

    public YourShoppingCartPage(WebDriver driver) { super(driver); }

//    public void waitForPageOpened() {
//        wait.until(ExpectedConditions.visibilityOf(cartStorePageLabel));
//    }

    public void findProductNameOnMainPage(String productNameItem) {
        driver.findElement(By.xpath(String.format(productNameOnMainPageText, productNameItem))).click();
    }

    public void increaseQuantityProducts() {
        increaseTheQuantityProductsButton.click();
        addToCartButton.click();
    }

    public void waitOpeningPageMyCartPageProducts() {
        wait.until(ExpectedConditions.visibilityOf(myCartPageWithProductsLabel));
    }

    public void goToMyCartPageProducts() {
        proceedToCheckoutButton.click();
    }

    public String getQuantityProductsOnMyCartPageOfProducts(String productNameItem) {
        return driver.findElement(By.xpath(String.format(quantityProductsOnCartPage, productNameItem))).getAttribute("value");
    }

    public String getTotalPriceSomeItemsProduct(String productNameItem) {
        return driver.findElement(By.xpath(String.format(totalPriceSomeItemsProduct, productNameItem))).getText();
    }

    public void clickAddToCartButton() {
        addToCartButton.getText();

    public void clickTrashButton(){
        trashButton.click();
    }

    public String getShoppingCartIsEmptyText() {
        return shoppingCartIsEmptyText.getText();
    }
}
