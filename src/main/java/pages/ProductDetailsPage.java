package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
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

    @Step("Increasing a number of products")
    public void increaseProductsQuantity() {
        log.info("Increasing the quantity of products: " + increaseTheQuantityProductsButton);
        increaseTheQuantityProductsButton.click();
        log.info("Adding the product to cart: " + addToCartInProductDetailsDButton);
        addToCartInProductDetailsDButton.click();
    }
}