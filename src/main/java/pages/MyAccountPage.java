package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MyAccountPage extends HeaderPage {
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='center_column']//ancestor::*[contains(text(),'My account')]")
    WebElement myAccountPageLabel;

    @FindBy(xpath = "//*[@class='navigation_page']//ancestor::*[contains(text(),'My account')]")
    WebElement myAccountTab;

    public void waitForMyAccountPageOpened() {
        wait.until(ExpectedConditions.visibilityOf(myAccountPageLabel));
    }

    public boolean isMyAccountPagePageOpened() {
        return myAccountTab.isDisplayed();
    }
}