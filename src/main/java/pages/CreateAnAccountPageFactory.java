package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAnAccountPageFactory extends BasePage {

    @FindBy(xpath = "//*[@id=\"email_create\"]")
    WebElement emailAddressFieldInput;

    @FindBy(xpath = "//*[@id=\"SubmitCreate\"]")
    WebElement createAnAccountButton;

    @FindBy(xpath = "//*[contains(text(),'Create an account')]")
    WebElement createAnAccountLabel;

    @FindBy(xpath = "//*[@class=\"form-group form-error\"]")
    WebElement errorLocatorInEmptyFieldEmailAddress;

    @FindBy(xpath = "//*[@id=\"create_account_error\"]//ancestor::*[contains(text(),'Invalid email address.')]")
    WebElement errorWrongEmailAddressInField;

    public CreateAnAccountPageFactory(WebDriver driver) {
        super(driver);
    }

    @Override
    void waitForPageOpened() {
    }

    public void login(String emailAddress) {
        emailAddressFieldInput.sendKeys(emailAddress);
        createAnAccountButton.click();
    }

    public boolean isPageOpened() {
        return createAnAccountLabel.isDisplayed();
    }

    public boolean getLocatorEmailAddressField() {
        errorLocatorInEmptyFieldEmailAddress.getText();
        return true;
    }

    public String getActualResultWrongEmailAddress() {
        return errorWrongEmailAddressInField.getText();
    }
}
