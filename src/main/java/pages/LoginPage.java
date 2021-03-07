package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) { super(driver); }

    @FindBy(xpath = "//*[@id=\"email_create\"]")
    WebElement emailAddressFieldInput;

    @FindBy(xpath = "//*[@id=\"SubmitCreate\"]")
    WebElement createAnAccountButton;

    void waitForPageOpened() {
    }

    public void login(String emailAddress) {
        emailAddressFieldInput.sendKeys(emailAddress);
        createAnAccountButton.click();
    }

    public void openPage(String url) {
        super.openPage(SIGN_IN);
    }
}