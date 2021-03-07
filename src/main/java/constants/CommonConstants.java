package constants;

import org.openqa.selenium.By;

public interface CommonConstants {
    String AUTOMATION_PRACTICE_SHOP_URL = "http://automationpractice.com/index.php";
    String SIGN_IN ="http://automationpractice.com/index.php?controller=authentication&back=my-account";
    By EMAIL_ADDRESS_FIELD_INPUT = By.xpath("//*[@id=\"email_create\"]");
    By CREATE_AN_ACCOUNT_BUTTON = By.xpath("//*[@id=\"SubmitCreate\"]");
    By CREATE_AN_ACCOUNT_LABEL = By.xpath("//*[contains(text(),'Create an account')]");
    By ERROR_LOCATOR_IN_EMPTY_FIELD_EMAIL_ADDRESS = By.xpath("//*[@class=\"form-group form-error\"]");
    By ERROR_WRONG_EMAIL_ADDRESS_IN_FIELD = By.xpath("//*[@id=\"create_account_error\"]//ancestor::*[contains(text(),'Invalid email address.')]");
}
