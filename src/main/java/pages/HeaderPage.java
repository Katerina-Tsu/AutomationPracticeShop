package pages;

import io.qameta.allure.Link;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class HeaderPage extends BasePage {

    @FindBy(xpath = "//*[@id='email']")
    WebElement emailFieldSignIn;

    @FindBy(xpath = "//*[@id='passwd']")
    WebElement passwordFieldSignIn;

    @FindBy(xpath = "//*[@id='SubmitLogin']")
    WebElement signInButton;

    @FindBy(xpath = "//*[@id='email_create']")
    WebElement emailAddressFieldInput;

    @FindBy(xpath = "//*[@id='SubmitCreate']")
    WebElement createAnAccountButton;

    @FindBy(xpath = "//*[@id='header']//ancestor::*[contains(text(),'Sign out')]")
    WebElement signOutBtn;

    @FindBy(xpath = "//*[@class='login']//ancestor::*[contains(text(),'Sign in')]")
    WebElement signInHeaderButton;

    @FindBy(xpath = "//*[@class='page-heading']")
    WebElement myAccountTextLabel;

    @FindBy(xpath = "//*[@class='ajax_cart_no_product']")
    WebElement shoppingCartIsEmptyHeaderText;

    @FindBy(xpath = "(//*[@id='center_column']//ancestor::*[contains(text(),'Update')])[2]")
    WebElement updateButton;

    @FindBy(xpath = "//*[@title='My wishlists']")
    WebElement editWishlistButton;

    @FindBy(xpath = "//*[@name='submitWishlist']")
    WebElement saveWishlistButton;

    @FindBy(xpath = "//*[@id='name']")
    WebElement wishlistField;

    String menuLink = "//ul[not(contains(@style,'display: none;'))]/li/*[contains(text(),'%s')]";

//    private static final String MENU_WOMEN_LINK = "//*[@class='sf-with-ul']//ancestor::*[contains(text(),'%s')]";

    private static final String NEW_WISHLIST_NAME_XPATH = "//*[@id='block-history']//ancestor::*[contains(text(),'%s')]";

    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    @Step("Opening main product page ")
    @Link("http://automationpractice.com/index.php")
    public void openHeaderPage() {
        log.info("Open url: " + AUTOMATION_PRACTICE_SHOP_URL);
        driver.get(AUTOMATION_PRACTICE_SHOP_URL);
    }

    @Step("Click on tab in menu: '{tabHeader}' ")
    public void clickMenuHeaderLink(String tabHeader) {
        log.info(String.format("Clicking on type name in menu of header page with name '%s'", tabHeader));
        driver.findElement(By.xpath(String.format(menuLink, tabHeader))).click();
    }

    @Step("Click on sign out button")
    public void clickSignOutBtn() {
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

//    public void clickSignOutProfile() {signOutBtn.click();}

    public void clickOnMyWishlist() {editWishlistButton.click();}

    public void inputTextInFieldsNewWishlist(String wishlist) {
        wishlistField.sendKeys(wishlist);
    }

    public void clickWishlistButton() {saveWishlistButton.click();}

    public void clickUpdateButton() {updateButton.click();}

    public boolean isNewWishlistNameDisplayed(String headerText) {
        return driver.findElement(By.xpath(String.format(NEW_WISHLIST_NAME_XPATH, headerText))).isDisplayed();
    }

//    public void clickMenuHeaderLink(String tabHeader) {
//        driver.findElement(By.xpath(String.format(menuLink, tabHeader))).click();
//    }

//    public void clickProductName(String productNameItem) {
//        driver.findElement(By.xpath(String.format(productName, productNameItem))).click();
//    }

//    public void fillInEmailAndClickCreateAccountBtn(String emailAddress) {
//        emailAddressFieldInput.sendKeys(emailAddress);
//        createAnAccountButton.click();
//    }
}