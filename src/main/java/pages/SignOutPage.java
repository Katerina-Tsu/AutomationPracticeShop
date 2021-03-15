package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignOutPage extends BasePage{
    public SignOutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='email']")
    WebElement emailAddressFieldInputSignIn;

    @FindBy(xpath = "//*[@id='passwd']")
    WebElement passwordFieldInputSignIn;

    @FindBy(xpath = "//*[@id='SubmitLogin']")
    WebElement signInButton;

    @FindBy(xpath = "//*[@id='header']//ancestor::*[contains(text(), 'Sign out')]")
    WebElement signOutButtom;

    void waitForPageOpened() {
    }

    public void fillInSignInAndBtn(String emailAddress, String password) {
        emailAddressFieldInputSignIn.sendKeys(emailAddress);
        passwordFieldInputSignIn.sendKeys(password);
        signInButton.click();
        signOutButtom.click();
    }

    public boolean isMainPageClose() { return signInButton.isDisplayed(); }
}
