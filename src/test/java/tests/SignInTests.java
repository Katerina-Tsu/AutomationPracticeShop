package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static constants.CommonConstants.SIGN_IN;

public class SignInTests extends BaseTest {

    @Test
    public void createAnAccountTest() {
        signInPage.openPage(SIGN_IN);
        signInPage.login(EMAIL_ADDRESS);
        Assert.assertTrue(signInPage.isPageOpened());
    }

    @Test
    public void emptyEmailFieldTest() {
        signInPage.openPage(SIGN_IN);
        signInPage.login(EMPTY_EMAIL_ADDRESS);
        Assert.assertEquals(signInPage.getEmailAddressText(), EXPECTED_RESULT_WRONG_EMAIL_ADDRESS);
    }

    @Test
    public void wrongEmailFieldTest() {
        signInPage.openPage(SIGN_IN);
        signInPage.login(WRONG_EMAIL_ADDRESS);
        Assert.assertEquals(signInPage.getEmailAddressText(), EXPECTED_RESULT_WRONG_EMAIL_ADDRESS);
    }

//    @Test
//    public void allFieldsAreEmptyTest() {
//        signInPage.openPage(SIGN_IN);
//        signInPage.login(EMAIL_ADDRESS);
//      //  signInPage.
//        Assert.assertEquals(signInPage.getEmailAddressText(), EXPECTED_RESULT_WRONG_EMAIL_ADDRESS);
//    }
}
