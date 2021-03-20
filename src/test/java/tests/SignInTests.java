package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static constants.CommonConstants.SIGN_IN_URL;

public class SignInTests extends BaseTest {

    @Test(groups = "Katia", description = "When inputted right email. After that, We went to Create an account page.", priority = 1)
    public void createAnAccountTest() {
        signInPage.openPage(SIGN_IN_URL);
        signInPage.fillInEmailAndClickCreateAccountBtn(NOT_REGISTERED_EMAIL_ADDRESS);
        Assert.assertTrue(signInPage.isPageOpened());
    }

    @Test(groups = "Katia", description = "When field email is empty.", priority = 3)
    public void emptyEmailFieldTest() {
        signInPage.openPage(SIGN_IN_URL);
        signInPage.fillInEmailAndClickCreateAccountBtn(EMPTY_EMAIL_ADDRESS);
        Assert.assertEquals(signInPage.getEmailAddressText(), WRONG_EMAIL_ADDRESS_MESSAGE);
    }

    @Test(groups = "Katia", description = "When inputted wrong email.", priority = 2)
    public void wrongEmailFieldTest() {
        signInPage.openPage(SIGN_IN_URL);
        signInPage.fillInEmailAndClickCreateAccountBtn(WRONG_EMAIL_ADDRESS);
        Assert.assertEquals(signInPage.getEmailAddressText(), WRONG_EMAIL_ADDRESS_MESSAGE);
    }
}