package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderPage extends BasePage{

    @FindBy(xpath = "//*[@class='sf-with-ul']//ancestor::*[contains(text(),'Women')]")
    WebElement menuWomenLink;

    String productName = "//*[@class='product-name']//self::*[contains(text(),'%s')]";

    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    public void clickMenuWomenHeaderLink() {
        menuWomenLink.click();
    }

    public void clickProductName(String productNameItem) {
        driver.findElement(By.xpath(String.format(productName, productNameItem))).click();
    }
}
