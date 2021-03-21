package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends HeaderPage {

    @FindBy(xpath = "//*[@id='add_to_cart']/button/span")
    WebElement addToCartInProductDetailsDButton;

    @FindBy(xpath = "//*[@class='icon-plus']")
    WebElement increaseTheQuantityProductsButton;

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    public void clickAddToCartInProductDetailButton() {
        addToCartInProductDetailsDButton.click();
    }

    //  @Step("Increasing a number of products")
    public void increaseProductsQuantity() {
        increaseTheQuantityProductsButton.click();
        addToCartInProductDetailsDButton.click();
    }
}