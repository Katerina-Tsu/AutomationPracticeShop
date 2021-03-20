package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HeaderPage extends BasePage {

//    @FindBy(xpath = "//*[@id='email']")
//    WebElement emailFieldSignIn;
//
//    @FindBy(xpath = "//*[@id='passwd']")
//    WebElement passwordFieldSignIn;

//    @FindBy(xpath = "//*[@id='SubmitLogin']")
//    WebElement signInButton;

//    @FindBy(xpath = "//*[@id='email_create']")
//    WebElement emailAddressFieldInput;

//    @FindBy(xpath = "//*[@id='SubmitCreate']")
//    WebElement createAnAccountButton;

    @FindBy(xpath = "//*[@id='header']//ancestor::*[contains(text(),'Sign out')]")
    WebElement signOutBtn;

    @FindBy(xpath = "//*[@class='login']//ancestor::*[contains(text(),'Sign in')]")
    WebElement signInHeaderButton;

    @FindBy(xpath = "//*[@class='page-heading']")
    WebElement myAccountTextLabel;

    private static final String MENU_WOMEN_LINK = "//*[@class='sf-with-ul']//ancestor::*[contains(text(),'%s')]";

    private static final String PRODUCT_NAME = "//*[@class='product-name']//self::*[contains(text(),'%s')]";

    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    public void clickMenuHeaderLink(String tabHeader) {
        driver.findElement(By.xpath(String.format(MENU_WOMEN_LINK, tabHeader))).click();
    }

    public void clickProductName(String productNameItem) {
        driver.findElement(By.xpath(String.format(PRODUCT_NAME, productNameItem))).click();
    }

//    public void fillInEmailAndClickCreateAccountBtn(String emailAddress) {
//        emailAddressFieldInput.sendKeys(emailAddress);
//        createAnAccountButton.click();
//    }

    public void clickSignOutBtnOnMyAccPage() {
        signOutBtn.click();
    }

    public boolean isSignInHeaderButtonShown() {
        return signInHeaderButton.isDisplayed();
    }

    public void waitForMyAccountPageOpened() {
        wait.until(ExpectedConditions.visibilityOf(myAccountTextLabel));
    }

//    public void fillInEmailAndClickSignInBtn(String emailAddress, String password) {
//        emailFieldSignIn.sendKeys(emailAddress);
//        passwordFieldSignIn.sendKeys(password);
//        signInButton.click();
//    }
}