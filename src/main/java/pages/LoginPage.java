package pages;

import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) { super(driver); }

    void waitForPageOpened() {
    }

    /**
     * Login to the site
     * @param emailAddress
     */
    public void login(String emailAddress) {
        driver.findElement(EMAIL_ADDRESS_FIELD_INPUT).sendKeys(emailAddress);
        driver.findElement(CREATE_AN_ACCOUNT_BUTTON).click();
    }

    public void openPage(String url) {
        super.openPage(SIGN_IN);
    }
}