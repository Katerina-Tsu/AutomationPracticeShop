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

    @FindBy(xpath = "//*[@class='icon-ok']")
    WebElement tickProductAddedToCartLabel;

    @FindBy(xpath = "//*[@id='add_to_cart']/button/span")
    WebElement addToCartButton;

    private static final String PRODUCT_NAME_ON_MAIN_PAGE_TEXT = "//*[@id='homefeatured']//self::*[contains(text(),'%s')]";

    public MainProductsPage(WebDriver driver) {
        super(driver);
    }

    public void waitForPageOpened() {
        wait.until(ExpectedConditions.visibilityOf(cartStorePageLabel));
    }

//  @Step("Searches for a product name and selects it with product name: '{productNameItem}'")
    public void findProductNameOnPage(String productNameItem) {
        driver.findElement(By.xpath(String.format(PRODUCT_NAME_ON_MAIN_PAGE_TEXT, productNameItem))).click();
    }

    public void clickAddToCartButton() {
        addToCartButton.click();
    }

    public boolean isTickProductAddedToCartPageOpened() {
        return tickProductAddedToCartLabel.isDisplayed();
    }
}