package pages;

import io.qameta.allure.Link;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HeaderPage extends BasePage {

    @FindBy(xpath = "//*[@id='header']//ancestor::*[contains(text(),'Sign out')]")
    WebElement signOutBtn;

    @FindBy(xpath = "//*[@class='login']//ancestor::*[contains(text(),'Sign in')]")
    WebElement signInHeaderButton;

    @FindBy(xpath = "//*[@class='page-heading']")
    WebElement myAccountTextLabel;

    @FindBy(xpath = "//*[@class='ajax_cart_no_product']")
    WebElement shoppingCartIsEmptyHeaderText;

    private static final String MENU_WOMEN_LINK = "//*[@class='sf-with-ul']//ancestor::*[contains(text(),'%s')]";

    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    @Step("Opening main product page ")
    @Link("http://automationpractice.com/index.php")
    public void openHeaderPage() {
        driver.get(AUTOMATION_PRACTICE_SHOP_URL);
    }

    @Step("Click on tab in menu: '{tabHeader}' ")
    public void clickMenuHeaderLink(String tabHeader) {
        driver.findElement(By.xpath(String.format(MENU_WOMEN_LINK, tabHeader))).click();
    }

    @Step("Click on sign out button")
    public void clickSignOutBtnOnMyAccPage() {
        signOutBtn.click();
    }

    public boolean isSignInHeaderButtonShown() {
        return signInHeaderButton.isDisplayed();
    }

    public void waitForMyAccountPageOpened() {
        wait.until(ExpectedConditions.visibilityOf(myAccountTextLabel));
    }

    @Step("Getting an error text that shopping cart is empty")
    public String getShoppingCartIsEmptyHeaderText() {
        return shoppingCartIsEmptyHeaderText.getText();
    }
}