package pages;

import io.qameta.allure.Link;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class SignInPage extends HeaderPage {

    @FindBy(xpath = "//*[@id='email_create']")
    WebElement emailAddressFieldInput;

    @FindBy(xpath = "//*[@id='SubmitCreate']")
    WebElement createAnAccountButton;

    @FindBy(xpath = "//*[contains(text(),'Create an account')]")
    WebElement createAnAccountLabel;

    @FindBy(xpath = "//*[@id='create_account_error']//ancestor::*[contains(text(),'Invalid email address.')]")
    WebElement errorWrongEmailAddressInField;

    @FindBy(xpath = "//*[@id='email']")
    WebElement emailFieldSignIn;

    @FindBy(xpath = "//*[@id='passwd']")
    WebElement passwordFieldSignIn;

    @FindBy(xpath = "//*[@id='SubmitLogin']")
    WebElement signInButton;

    @FindBy(xpath = "//*[@id='center_column']//ancestor::*[contains(text(),'Authentication failed.')]")
    WebElement signInErrorText;

    private static final String SIGNED_IN_USERNAME_LABEL_XPATH = "//*[@id='header']//ancestor::*[contains(text(),'%s')]";

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    @Step("Opening the sign in page ")
    @Link("http://automationpractice.com/index.php?controller=authentication&back=my-account")
    public void openSignInPage() {
        log.info("Open url: " + SIGN_IN_URL);
        driver.get(SIGN_IN_URL);
    }

    @Step("Creating a customer account with email: '{emailAddress}'")
    public void fillInEmailAndClickCreateAccountBtn(String emailAddress) {
        log.info(String.format("Creating an account with email '%s'", emailAddress));
        emailAddressFieldInput.sendKeys(emailAddress);
        createAnAccountButton.click();
    }

    @Step("Sign In in customer account with email: '{emailAddress}' and password: '{password}'")
    public void fillInEmailAndClickSignInBtn(String emailAddress, String password) {
        log.info(String.format("Signing in with email '%s', password '%s'", emailAddress, password));
        emailFieldSignIn.sendKeys(emailAddress);
        passwordFieldSignIn.sendKeys(password);
        signInButton.click();
    }

    public void fillInSignInForm(String emailAddress, String password) {
        emailFieldSignIn.sendKeys(emailAddress);
        passwordFieldSignIn.sendKeys(password);
        signInButton.click();
    }

    public boolean isPageOpened() {
        log.info("Show that page is open: " + createAnAccountLabel);
        return createAnAccountLabel.isDisplayed();
    }

    @Step("Getting an error text that was inputted wrong email address")
    public String getEmailAddressText() {
        log.info("Get an error text 'wrong email address': " + errorWrongEmailAddressInField);
        return errorWrongEmailAddressInField.getText();
    }

    public String getErrorTextSignIn() {
        return signInErrorText.getText();
    }

    public void openPage(String url) {
        super.openPage(SIGN_IN_URL);
    }

    public boolean isHeaderLabelDisplayed(String headerText) {
        return driver.findElement(By.xpath(String.format(SIGNED_IN_USERNAME_LABEL_XPATH, headerText))).isDisplayed();
    }

    public boolean isSignInButtonDisplayed () { return signInButton.isDisplayed(); }
}