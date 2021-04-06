package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class MainProductsPage extends HeaderPage {

    @FindBy(xpath = "//*[@id='email_create']")
    WebElement emailAddressFieldInput;

    @FindBy(xpath = "//*[@id='SubmitCreate']")
    WebElement createAnAccountButton;

    @FindBy(xpath = "//*[@class='cross']")
    WebElement cartStorePageLabel;

    @FindBy(xpath = "//*[@class='icon-ok']")
    WebElement tickProductAddedToCartLabel;

    private static final String PRODUCT_NAME = "//*[@class='product-name']//self::*[contains(text(),'%s')]";

    private static final String PRODUCT_NAME_ON_MAIN_PAGE_TEXT = "//*[@id='homefeatured']//self::*[contains(text(),'%s')]";

    public MainProductsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Searches for a product name and selects it with product name: '{productNameItem}'")
    public void findProductNameOnPage(String productNameItem) {
        log.info(String.format("Finding and clicking a product on page with name '%s'", productNameItem));
        driver.findElement(By.xpath(String.format(PRODUCT_NAME_ON_MAIN_PAGE_TEXT, productNameItem))).click();
    }

    @Step("Click on the selected product name: '{productNameItem}'")
    public void clickProductName(String productNameItem) {
        log.info(String.format("Adding a product with name '%s'", productNameItem));
        driver.findElement(By.xpath(String.format(PRODUCT_NAME, productNameItem))).click();
    }
}