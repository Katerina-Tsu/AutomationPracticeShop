package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static constants.CommonConstants.SIGN_IN;

public class SignInTests extends BaseTest {

    @Test(groups = "Katia. When inputted right email. After that, We went to Create an account page.")
    public void createAnAccountTest() {
        signInPage.openPage(SIGN_IN);
        signInPage.fillInEmailAndClickCreateAccountBtn(EMAIL_ADDRESS);
        Assert.assertTrue(signInPage.isPageOpened());
    }

    @Test(groups = "Katia. When field email is empty.")
    public void emptyEmailFieldTest() {
        signInPage.openPage(SIGN_IN);
        signInPage.fillInEmailAndClickCreateAccountBtn(EMPTY_EMAIL_ADDRESS);
        Assert.assertEquals(signInPage.getEmailAddressText(), EXPECTED_RESULT_WRONG_EMAIL_ADDRESS);
    }

    @Test(groups = "Katia. When inputted wrong email.")
    public void wrongEmailFieldTest() {
        signInPage.openPage(SIGN_IN);
        signInPage.fillInEmailAndClickCreateAccountBtn(WRONG_EMAIL_ADDRESS_MESSAGE);
        Assert.assertEquals(signInPage.getEmailAddressText(), EXPECTED_RESULT_WRONG_EMAIL_ADDRESS);
    }
}
