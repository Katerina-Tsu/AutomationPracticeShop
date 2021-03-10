package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

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

    @Override
    void waitForPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated((By) createAnAccountLabel));
    }


    public void fillInEmailAndClickCreateAccountBtn(String emailAddress) {
        emailAddressFieldInput.sendKeys(emailAddress);
        createAnAccountButton.click();
    }

    public boolean isPageOpened() {
        return createAnAccountLabel.isDisplayed();
    }

    public String getEmailAddressText() {
        return errorWrongEmailAddressInField.getText();
    }

    public void openPage(String url) {
        super.openPage(SIGN_IN_URL);
    }
}
