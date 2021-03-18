package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class YourShoppingCartPage extends HeaderPage {

    @FindBy(xpath = "//*[@id='email']")
    WebElement emailFieldSignIn;

    @FindBy(xpath = "//*[@id='passwd']")
    WebElement passwordFieldSignIn;

    @FindBy(xpath = "//*[@id='SubmitLogin']")
    WebElement signInButton;

    @FindBy(xpath = "//*[@id='add_to_cart']/button/span")
    WebElement addToCartButton;

    @FindBy(xpath = "//*[@class='icon-plus']")
    WebElement increaseTheQuantityProductsButton;

    @FindBy(xpath = "//*[@id='cart_title']//self::*[contains(text(),'Shopping-cart summary')]")
    WebElement myCartPageWithProductsLabel;

    @FindBy(xpath = "//*[@id='center_column']//ancestor::*[contains(text(),'Your shopping cart is empty.')]")
    WebElement shoppingCartIsEmptyText;

    @FindBy(xpath = "//*[@class='ajax_cart_no_product']")
    WebElement shoppingCartIsEmptyHeaderText;

    @FindBy(xpath = "//*[@id='layer_cart']//self::*[contains(text(),'Proceed to checkout')]")
    WebElement proceedToCheckoutButton;

    @FindBy(xpath = "//*[@id='center_column']//self::*[contains(text(),'Proceed to checkout')]")
    WebElement proceedToCheckoutShCSumBtn;

    @FindBy(xpath = "//*[@id='cgv']")
    WebElement iAgreeCheckBox;

    @FindBy(xpath = "//*[@class='bankwire']")
    WebElement payBankWire;

    @FindBy(xpath = "//*[@id='cart_navigation']//ancestor::*[contains(text(),'I confirm my order')]")
    WebElement paymentEndBtnIConf;

    @FindBy(xpath = "//*[@class='cheque-indent']//ancestor::*[contains(text(),'Your order on My Store is complete.')]")
    WebElement orderIsCompleteText;

    @FindBy(xpath = "//*[@id='center_column']//ancestor::*[contains(text(),'My account')]")
    WebElement myAccountPageLabel;

    String productNameOnMainPageText = "//*[@id='homefeatured']//self::*[contains(text(),'%s')]";

    String trashButton = "//*[@class='cart_quantity_delete']";

    String quantityProductsOnCartPage = "//*[@name='quantity_2_7_0_0']";

    String totalPriceSomeItemsProduct = "//*[@id='total_product_price_2_7_0']";

    public YourShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public void fillInEmailAndClickSignInBtn(String emailAddress, String password) {
        emailFieldSignIn.sendKeys(emailAddress);
        passwordFieldSignIn.sendKeys(password);
        signInButton.click();
    }

    public void findProductNameOnMainPage(String productNameItem) {
        driver.findElement(By.xpath(String.format(productNameOnMainPageText, productNameItem))).click();
    }

    public void increaseQuantityProducts() {
        increaseTheQuantityProductsButton.click();
        addToCartButton.click();
    }

    public void checkedTabShipping() {
        iAgreeCheckBox.click();
        proceedToCheckoutShCSumBtn.click();
    }

    public void goToMyCartPageProducts() {
        proceedToCheckoutButton.click();
    }

    public void goToNextPage() {
        proceedToCheckoutShCSumBtn.click();
    }

    public void clickBankWireBtn() {
        payBankWire.click();
    }

    public void clickAddToCartButton() {
        addToCartButton.click();
    }

    public void clickTrashButton(String productNameItem) {
        driver.findElement(By.xpath(String.format(trashButton, productNameItem))).click();
    }

    public void paymentBtn() {
        paymentEndBtnIConf.click();
    }

    public String getQuantityProductsOnMyCartPageOfProducts(String productNameItem) {
        return driver.findElement(By.xpath(String.format(quantityProductsOnCartPage, productNameItem))).getAttribute("value");
    }

    public String getTotalPriceSomeItemsProduct(String productNameItem) {
        return driver.findElement(By.xpath(String.format(totalPriceSomeItemsProduct, productNameItem))).getText();
    }

    public String getShoppingCartIsEmptyText() {
        return shoppingCartIsEmptyText.getText();
    }

    public String getShoppingCartIsEmptyHeaderText() {
        return shoppingCartIsEmptyHeaderText.getText();
    }

    public void waitForMyAccountPageOpened() {
        wait.until(ExpectedConditions.visibilityOf(myAccountPageLabel));
    }

    public void waitOpeningPageMyCartPageProducts() {
        wait.until(ExpectedConditions.visibilityOf(myCartPageWithProductsLabel));
    }

    public boolean findOrderIsCompletePage() {
        return orderIsCompleteText.isDisplayed();
    }
}