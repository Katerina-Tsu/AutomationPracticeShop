package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static constants.CommonConstants.SIGN_IN_URL;

public class SignInTests extends BaseTest {

    @Test(groups = "Katia. When inputted right email. After that, We went to Create an account page.")
    public void createAnAccountTest() {
        signInPage.openPage(SIGN_IN_URL);
        signInPage.fillInEmailAndClickCreateAccountBtn(EMAIL_ADDRESS);
        Assert.assertTrue(signInPage.isPageOpened());
    }

    @Test(groups = "Katia. When field email is empty.")
    public void emptyEmailFieldTest() {
        signInPage.openPage(SIGN_IN_URL);
        signInPage.fillInEmailAndClickCreateAccountBtn(EMPTY_EMAIL_ADDRESS);
        Assert.assertEquals(signInPage.getEmailAddressText(), WRONG_EMAIL_ADDRESS_MESSAGE);
    }

    @Test(groups = "Katia. When inputted wrong email.")
    public void wrongEmailFieldTest() {
        signInPage.openPage(SIGN_IN_URL);
        signInPage.fillInEmailAndClickCreateAccountBtn(WRONG_EMAIL_ADDRESS);
        Assert.assertEquals(signInPage.getEmailAddressText(), WRONG_EMAIL_ADDRESS_MESSAGE);
    }
}
