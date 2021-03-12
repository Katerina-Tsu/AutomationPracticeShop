package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainProductsPage extends HeaderPage {

    @FindBy(xpath = "//*[@id='email_create']")
    WebElement emailAddressFieldInput;

    @FindBy(xpath = "//*[@id='SubmitCreate']")
    WebElement createAnAccountButton;

    @FindBy(xpath = "//*[@class='cross']")
    WebElement cartStorePageLabel;

//    String addToCartBtn = "//*[@id='homefeatured']//self::*[contains(text(),'Add to cart')]";

    @FindBy(xpath = "//*[@class='icon-ok']")
    WebElement tickProductAddedToCartLabel;

    @FindBy(xpath = "//*[@id='add_to_cart']/button/span")
    WebElement addToCartButton;

    String productNameOnMainPageText = "//*[@id='homefeatured']//self::*[contains(text(),'%s')]";

    @FindBy(xpath = "//*[@class='icon-plus']")
    WebElement increaseTheQuantityProductsButton;

    @FindBy(xpath = "")
    WebElement myCartPageWithProductsLabel;

    @FindBy(xpath = "")
    WebDriver quantityProductsOnCartPage;

    public MainProductsPage(WebDriver driver) {
        super(driver);
    }

    public void waitForPageOpened() {
        wait.until(ExpectedConditions.visibilityOf(cartStorePageLabel));
    }

    public void findProductNameOnMainPage(String productNameItem) {
        driver.findElement(By.xpath(String.format(productNameOnMainPageText, productNameItem))).click();
    }

    public void increaseTheQuantityProducts() {
        increaseTheQuantityProductsButton.click();
        addToCartButton.click();
    }

    public void waitOpeningPageMyCartPageWithProducts() {
        wait.until(ExpectedConditions.visibilityOf(myCartPageWithProductsLabel));
    }

    public void getQuantityProductsOnMyCartPageOfProducts() {
        quantityProductsOnCartPage.getText();
    }

    public void clickAddToCartButton() {
        addToCartButton.click();
    }

    public boolean isTickProductAddedToCartPageOpened() {
        return tickProductAddedToCartLabel.isDisplayed();
    }

    //    public void addProductToCartOnMainPage(String productNameItem) { // TODO - There are need to do RIGHT METHOD.
//        driver.findElement(By.xpath(String.format(addToCartBtn, productNameItem))).click();
//    }
}
