package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static constants.CommonConstants.SIGN_IN_URL;

public class SignInTests extends BaseTest {

    @Test(groups = "Katia")
    public void createAnAccountTest() {
        signInPage.openPage(SIGN_IN_URL);
        signInPage.fillInEmailAndClickCreateAccountBtn(EMAIL_ADDRESS);
        Assert.assertTrue(signInPage.isPageOpened());
    }

    @Test(groups = "Katia")
    public void emptyEmailFieldTest() {
        signInPage.openPage(SIGN_IN_URL);
        signInPage.fillInEmailAndClickCreateAccountBtn(EMPTY_EMAIL_ADDRESS);
        Assert.assertEquals(signInPage.getEmailAddressText(), EXPECTED_RESULT_WRONG_EMAIL_ADDRESS);
    }

    @Test(groups = "Katia")
    public void wrongEmailFieldTest() {
        signInPage.openPage(SIGN_IN_URL);
        signInPage.fillInEmailAndClickCreateAccountBtn(WRONG_EMAIL_ADDRESS_MESSAGE);
        Assert.assertEquals(signInPage.getEmailAddressText(), EXPECTED_RESULT_WRONG_EMAIL_ADDRESS);
    }
}
