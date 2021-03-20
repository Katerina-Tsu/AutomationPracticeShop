package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class YourShoppingCartPage extends HeaderPage {

//    @FindBy(xpath = "//*[@id='email']")
//    WebElement emailFieldSignIn;

//    @FindBy(xpath = "//*[@id='passwd']")
//    WebElement passwordFieldSignIn;

//    @FindBy(xpath = "//*[@id='SubmitLogin']")
//    WebElement signInButton;

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
    WebElement proceedToCheckoutOnShoppingCartSummaryButton;

    @FindBy(xpath = "//*[@id='cgv']")
    WebElement iAgreeCheckBox;

    @FindBy(xpath = "//*[@class='bankwire']")
    WebElement payBankWire;

    @FindBy(xpath = "//*[@id='cart_navigation']//ancestor::*[contains(text(),'I confirm my order')]")
    WebElement paymentEndBtnIConf;

    @FindBy(xpath = "//*[@class='cheque-indent']//ancestor::*[contains(text(),'Your order on My Store is complete.')]")
    WebElement orderIsCompleteText;

//    @FindBy(xpath = "//*[@id='center_column']//ancestor::*[contains(text(),'My account')]")
//    WebElement myAccountPageLabel;

//    private static final String PRODUCT_NAME_ON_PAGE_TEXT = "//*[@id='homefeatured']//self::*[contains(text(),'%s')]";

    private static final String TRASH_BUTTON = "//*[@class='cart_quantity_delete']";

    private static final String QUANTITY_PRODUCTS_ON_CART_PAGE = "//*[@class='cart_quantity_input form-control grey']";

    private static final String TOTAL_PRICE_SOME_ITEMS_PRODUCT = "//*[@class='cart_total']";

    public YourShoppingCartPage(WebDriver driver) {
        super(driver);
    }

//    public void fillInEmailAndClickSignInBtn(String emailAddress, String password) {
//        emailFieldSignIn.sendKeys(emailAddress);
//        passwordFieldSignIn.sendKeys(password);
//        signInButton.click();
//    }

//    public void findProductNameOnPage(String productNameItem) {
//        driver.findElement(By.xpath(String.format(PRODUCT_NAME_ON_PAGE_TEXT, productNameItem))).click();
//    }

    public void increaseProductsQuantity() {
        increaseTheQuantityProductsButton.click();
        addToCartButton.click();
    }

    public void checkedTabShipping() {
        iAgreeCheckBox.click();
        proceedToCheckoutOnShoppingCartSummaryButton.click();
    }

    public void clickProceedToCheckoutButton() {
        proceedToCheckoutButton.click();
    }

    public void goToNextPageProceedToCheckoutButton() {
        proceedToCheckoutOnShoppingCartSummaryButton.click();
    }

    public void clickBankWireBtn() {
        payBankWire.click();
    }

    public void clickAddToCartButton() {
        addToCartButton.click();
    }

    public void clickTrashButton(String productNameItem) {
        driver.findElement(By.xpath(String.format(TRASH_BUTTON, productNameItem))).click();
    }

    public void clickPaymentBtn() {
        paymentEndBtnIConf.click();
    }

    public String getProductsQuantityOnMyCartPage(String productNameItem) {
        return driver.findElement(By.xpath(String.format(QUANTITY_PRODUCTS_ON_CART_PAGE, productNameItem))).getAttribute("value");
    }

    public String getTotalPriceProducts(String productNameItem) {
        return driver.findElement(By.xpath(String.format(TOTAL_PRICE_SOME_ITEMS_PRODUCT, productNameItem))).getText();
    }

    public String getShoppingCartIsEmptyText() {
        return shoppingCartIsEmptyText.getText();
    }

    public String getShoppingCartIsEmptyHeaderText() {
        return shoppingCartIsEmptyHeaderText.getText();
    }

//    public void waitForMyAccountPageOpened() {
//        wait.until(ExpectedConditions.visibilityOf(myAccountPageLabel));
//    }

    public void waitForMyCartPageIsOpened() {
        wait.until(ExpectedConditions.visibilityOf(myCartPageWithProductsLabel));
    }

    public boolean isOrderIsCompleteTextDisplayed() {
        return orderIsCompleteText.isDisplayed();
    }
}