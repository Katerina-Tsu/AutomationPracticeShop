package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public void openSignInPage() {
        driver.get(SIGN_IN_URL);
    }

//  @Step("Create a customer account with email: '{emailAddress}'")
    public void fillInEmailAndClickCreateAccountBtn(String emailAddress) {
        emailAddressFieldInput.sendKeys(emailAddress);
        createAnAccountButton.click();
    }

//    @Step("Sign In in customer account with email: '{emailAddress}' and password: '{password}'")
    public void fillInEmailAndClickSignInBtn(String emailAddress, String password) {
        emailFieldSignIn.sendKeys(emailAddress);
        passwordFieldSignIn.sendKeys(password);
        signInButton.click();
    }

    public boolean isPageOpened() {
        return createAnAccountLabel.isDisplayed();
    }

    public String getEmailAddressText() {
        return errorWrongEmailAddressInField.getText();
    }
}