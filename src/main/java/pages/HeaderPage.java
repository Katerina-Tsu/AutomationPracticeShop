package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderPage extends BasePage{
    public HeaderPage(WebDriver driver) {
        super(driver);
    }

//    @FindBy(xpath = "//*[@id='email']")
//    WebElement emailAddressFieldInputSignIn;
//
//    @FindBy(xpath = "//*[@id='passwd']")
//    WebElement passwordFieldInputSignIn;

//    @FindBy(xpath = "//*[@id='SubmitLogin']")
//    WebElement signInButton;

    @FindBy(xpath = "//*[@id='header']//ancestor::*[contains(text(), 'Sign out')]")
    WebElement clickOnSignOutButton ;

    void waitForPageOpened() {
    }

    public void clickFillInSignInForm() {
//        emailAddressFieldInputSignIn.sendKeys(emailAddress);
//        passwordFieldInputSignIn.sendKeys(password);
//        signInButton.click();
        clickOnSignOutButton.click();
    }

//    public boolean isSignInButtonDisplayed() { return signInButton.isDisplayed(); }
}
