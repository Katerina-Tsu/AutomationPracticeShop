package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import static constants.CommonConstants.SIGN_IN;

public class LoginTests extends BaseTest{

    @Test
    public void printEmailAddressTest() {
        loginPage.openPage(SIGN_IN);
        loginPage.login(EMAIL_ADDRESS);
    }

    @Test
    public void emptyFieldEmailAddress(){
        loginPage.openPage(SIGN_IN);
        loginPage.login(EMPTY_EMAIL_ADDRESS);

    }

}
