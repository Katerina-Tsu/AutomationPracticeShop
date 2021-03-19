package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage {
    public SignInPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='email_create']")
    WebElement emailAddressFieldInput;

    @FindBy(xpath = "//*[@id='SubmitCreate']")
    WebElement createAnAccountButton;

    @FindBy(xpath = "//*[contains(text(),'Create an account')]")
    WebElement createAnAccountLabel;

    @FindBy(xpath = "//*[@id='create_account_error']//ancestor::*[contains(text(),'Invalid email address.')]")
    WebElement errorWrongEmailAddressInField;

    @FindBy(xpath = "//*[@id='email']")
    WebElement emailAddressFieldInputSignIn;

    @FindBy(xpath = "//*[@id='passwd']")
    WebElement passwordFieldInputSignIn;

    @FindBy(xpath = "//*[@id='SubmitLogin']")
    WebElement signInButton;

    @FindBy(xpath = "//*[@id='center_column']//ancestor::*[contains(text(),'Authentication failed.')]")
    WebElement signInErrorText;

    private static final String SIGNED_IN_USERNAME_LABEL_XPATH = "//*[@id='header']//ancestor::*[contains(text(),'%s')]";

    @Override
    void waitForPageOpened() {
        //TODO: Implement this method
    }

    public void fillInEmailAndClickCreateAccountBtn(String emailAddress) {
        emailAddressFieldInput.sendKeys(emailAddress);
        createAnAccountButton.click();
    }

    public void fillInSignInForm(String emailAddress, String password) {
        emailAddressFieldInputSignIn.sendKeys(emailAddress);
        passwordFieldInputSignIn.sendKeys(password);
        signInButton.click();
    }

    public boolean isPageOpened() {
        return createAnAccountLabel.isDisplayed();
    }

    public String getEmailAddressText() {
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
    public boolean isSignedInUsernameDisplayed () { return signInButton.isDisplayed(); }



}
