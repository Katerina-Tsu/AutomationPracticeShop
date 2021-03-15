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
        Assert.assertEquals(signInPage.getEmailAddressText(), WRONG_EMAIL_ADDRESS_MESSAGE);
    }

    @Test(groups = "Katia")
    public void wrongEmailFieldTest() {
        signInPage.openPage(SIGN_IN_URL);
        signInPage.fillInEmailAndClickCreateAccountBtn(WRONG_EMAIL_ADDRESS);
        Assert.assertEquals(signInPage.getEmailAddressText(), WRONG_EMAIL_ADDRESS_MESSAGE);
    }

    @Test(groups = "Sasha. Checked error text when input wrong email address")
    public void wrongEmailFieldSignInTest() {
        signInPage.openPage(SIGN_IN_URL);
        signInPage.fillInSignInAndBtn(EMAIL_ADDRESS_WRONG_S, PASSWORD);
        Assert.assertEquals(signInPage.getErrorTextSignIn(), WRONG_EMAIL_ADDRESS_MESSAGE_SIGN_IN);
    }

    @Test(groups = "Sasha. Checked when sign in is over")
    public void rightDataSignInTest() {
        signInPage.openPage(SIGN_IN_URL);
        signInPage.fillInSignInAndBtn(EMAIL_ADDRESS_RIGHT_SIGN_IN_S, PASSWORD);
        Assert.assertTrue(signInPage.isMainPageOpened());
    }

    @Test(groups = "Sasha. Checked when sign out is over")
    public void signImSignOutTest() {
        signOutPage.openPage(SIGN_IN_URL);
        signOutPage.fillInSignInAndBtn(EMAIL_ADDRESS_RIGHT_SIGN_IN_S, PASSWORD);
        Assert.assertTrue(signOutPage.isMainPageClose());
    }

}
