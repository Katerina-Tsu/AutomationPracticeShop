package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SignInTests extends BaseTest {

    @Test(groups = "Katia", description = "When inputted right email. After that, We went to Create an account page.", priority = 1)
    public void createAnAccountTest() {
        signInPage.openSignInPage();
        signInPage.fillInEmailAndClickCreateAccountBtn(NOT_REGISTERED_EMAIL_ADDRESS);
        Assert.assertTrue(signInPage.isPageOpened());
    }

    @Test(groups = "Katia", description = "When field email is empty.", priority = 3)
    public void emptyEmailFieldTest() {
        signInPage.openSignInPage();
        signInPage.fillInEmailAndClickCreateAccountBtn(EMPTY_EMAIL_ADDRESS);
        Assert.assertEquals(signInPage.getEmailAddressText(), WRONG_EMAIL_ADDRESS_MESSAGE);
    }

    @Test(groups = "Katia", description = "When inputted wrong email.", priority = 2)
    public void wrongEmailFieldTest() {
        signInPage.openSignInPage();
        signInPage.fillInEmailAndClickCreateAccountBtn(WRONG_EMAIL_ADDRESS);
        Assert.assertEquals(signInPage.getEmailAddressText(), WRONG_EMAIL_ADDRESS_MESSAGE);
    }

    @Test(groups = "Sasha", description = "Checked error text when input wrong email address")
    public void wrongEmailFieldSignInTest() {
        signInPage.openPage(SIGN_IN_URL);
        signInPage.fillInSignInForm(EMAIL_ADDRESS_WRONG_S, PASSWORD);
        Assert.assertEquals(signInPage.getErrorTextSignIn(), WRONG_EMAIL_ADDRESS_MESSAGE_SIGN_IN);
    }

    @Test(groups = "Sasha", description = "Checked when sign in is over")
    public void rightDataSignInTest() {
        signInPage.openPage(SIGN_IN_URL);
        signInPage.fillInSignInForm(EMAIL_ADDRESS_RIGHT_SIGN_IN_S, PASSWORD);
        Assert.assertTrue(signInPage.isHeaderLabelDisplayed("Anton Ivanov"));
    }

    @Test(groups = "Sasha", description = "Checked when sign out is over")
    public void signInSignOutTest() {
        signInPage.openPage(SIGN_IN_URL);
        signInPage.fillInSignInForm(EMAIL_ADDRESS_RIGHT_SIGN_IN_S, PASSWORD);
        headerPage.clickSignOutBtn();
        Assert.assertTrue(signInPage.isSignInButtonDisplayed ());
    }

}