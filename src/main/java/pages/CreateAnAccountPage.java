package pages;

import org.openqa.selenium.WebDriver;

public class CreateAnAccountPage extends BasePage{

    public CreateAnAccountPage(WebDriver driver) { super(driver); }

    void waitForPageOpened() {
    }

    public void login(String emailAddress) {
        driver.findElement(EMAIL_ADDRESS_FIELD_INPUT).sendKeys(emailAddress);
        driver.findElement(CREATE_AN_ACCOUNT_BUTTON).click();
    }

    public boolean isPageOpened() {
        return driver.findElement(CREATE_AN_ACCOUNT_LABEL).isDisplayed();
    }

    public boolean getLocatorEmailAddressField() {
        driver.findElement(ERROR_LOCATOR_IN_EMPTY_FIELD_EMAIL_ADDRESS).getText();
        return true;
    }

    public String getActualResultWrongEmailAddress() {
     return driver.findElement(ERROR_WRONG_EMAIL_ADDRESS_IN_FIELD).getText();
    }
}
