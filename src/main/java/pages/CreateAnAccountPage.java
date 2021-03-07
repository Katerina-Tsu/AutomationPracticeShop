package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateAnAccountPage extends BasePage {

    @FindBy(xpath = "//*[@id='email_create']")
    WebElement emailAddressFieldInput;

    @FindBy(xpath = "//*[@id='SubmitCreate']")
    WebElement createAnAccountButton;

    @FindBy(xpath = "//*[contains(text(),'Your personal information')]")
    WebElement yourPersonalInfoLabel;

    @FindBy(xpath = "//*[@id='customer_firstname']")
    WebElement fieldFirstName;

    @FindBy(xpath = "//*[@id='submitAccount']")
    WebElement registrationButton;

    @FindBy(xpath = "//*[@id='center_column']//ancestor::*[contains(text(),'firstname')]")
    WebElement errorTextEmptyFieldFirstname;

    @FindBy(xpath = "//*[@id='passwd']")
    WebElement fieldPassword;

    public CreateAnAccountPage(WebDriver driver) {
        super(driver);
    }

    @Override
    void waitForPageOpened() {
            wait.until(ExpectedConditions.visibilityOfElementLocated((By) yourPersonalInfoLabel));
    }

    public void login(String emailAddress) {
        emailAddressFieldInput.sendKeys(emailAddress);
        createAnAccountButton.click();
    }

    public void inputTextInFormFirstName(String firstName) {
        fieldFirstName.sendKeys(firstName);
        registrationButton.click();
    }

    public String getEmptyFirstnameText() {
        return errorTextEmptyFieldFirstname.getText();
    }

    public void inputLongPasswordInField(String password) {
        fieldPassword.sendKeys(password);
        registrationButton.click();
    }
}
