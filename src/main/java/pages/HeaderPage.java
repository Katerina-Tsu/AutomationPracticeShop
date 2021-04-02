package pages;

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

    @FindBy(xpath = "//*[@class='page-heading']")
    WebElement myAccountTextLabel;

    @FindBy(xpath = "//*[@id='header']//ancestor::*[contains(text(), 'Sign out')]")
    WebElement signOutButton ;

    @FindBy(xpath = "(//*[@id='center_column']//ancestor::*[contains(text(),'Update')])[2]")
    WebElement updateButton;

    @FindBy(xpath = "//*[@title='My wishlists']")
    WebElement editWishlistButton;

    @FindBy(xpath = "//*[@name='submitWishlist']")
    WebElement saveWishlistButton;

    @FindBy(xpath = "//*[@id='name']")
    WebElement wishlistField;

    String menuLink = "//ul[not(contains(@style,'display: none;'))]/li/*[contains(text(),'%s')]";

    String productName = "//*[@class='product-name']//self::*[contains(text(),'%s')]";

    private static final String NEW_WISHLIST_NAME_XPATH = "//*[@id='block-history']//ancestor::*[contains(text(),'%s')]";

    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    public void clickMenuHeaderLink(String tabHeader) {
        log.info("Button selection in the main menu" + tabHeader);
        driver.findElement(By.xpath(String.format(menuLink, tabHeader))).click();
    }

    public void clickProductName(String productNameItem) {
        driver.findElement(By.xpath(String.format(productName, productNameItem))).click();
    }

    public void fillInEmailAndClickCreateAccountBtn(String emailAddress) {
        emailAddressFieldInput.sendKeys(emailAddress);
        createAnAccountButton.click();
    }

    public void signOutBtnOnMyAccPage() {
        signOutBtn.click();
    }

    public void waitForMyAccountPageOpened() {
        wait.until(ExpectedConditions.visibilityOf(myAccountTextLabel));
    }

    public void fillInEmailAndClickSignInBtn(String emailAddress, String password) {
        emailFieldSignIn.sendKeys(emailAddress);
        passwordFieldSignIn.sendKeys(password);
        signInButton.click();
    }
    public void clickSignOutProfile() {
        signOutButton.click();
    }

    public void clickOnMyWishlist() {editWishlistButton.click();}

    public void inputTextInFieldsNewWishlist(String wishlist) {
        wishlistField.sendKeys(wishlist);
    }

    public void clickWishlistButton() {saveWishlistButton.click();}

    public void clickUpdateButton() {updateButton.click();}

    public boolean isNewWishlistNameDisplayed(String headerText) {
        return driver.findElement(By.xpath(String.format(NEW_WISHLIST_NAME_XPATH, headerText))).isDisplayed();
    }
}