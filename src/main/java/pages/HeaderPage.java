package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderPage extends BasePage{
    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='block_top_menu']/ul/li[1]/a")
    WebElement womenCategoryButton;

    @FindBy(xpath = "//*[@id='header']//ancestor::*[contains(text(), 'Sign out')]")
    WebElement signOutButton ;

    void waitForPageOpened() {
    }

    public void clickSignOutProfile() {
        signOutButton.click();
    }

    public void clickOnWomenCategoryButton() {
        womenCategoryButton.click();
    }

}
