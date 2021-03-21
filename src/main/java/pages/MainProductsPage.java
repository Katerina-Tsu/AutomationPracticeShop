package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainProductsPage extends HeaderPage {

    @FindBy(xpath = "//*[@id='email_create']")
    WebElement emailAddressFieldInput;

    @FindBy(xpath = "//*[@id='SubmitCreate']")
    WebElement createAnAccountButton;

    private static final String PRODUCT_NAME_ON_MAIN_PAGE_TEXT = "//*[@id='homefeatured']//self::*[contains(text(),'%s')]";

    private static final String PRODUCT_NAME = "//*[@class='product-name']//self::*[contains(text(),'%s')]";

    public MainProductsPage(WebDriver driver) {
        super(driver);
    }

//  @Step("Searches for a product name and selects it with product name: '{productNameItem}'")
    public void findProductNameOnPage(String productNameItem) {
        driver.findElement(By.xpath(String.format(PRODUCT_NAME_ON_MAIN_PAGE_TEXT, productNameItem))).click();
    }

    public void clickProductName(String productNameItem) {
        driver.findElement(By.xpath(String.format(PRODUCT_NAME, productNameItem))).click();
    }
}