package tests;

import junit.framework.Assert;
import org.testng.annotations.Test;

import static constants.CommonConstants.SIGN_IN_URL;

public class HeaderTest extends BaseTest{

    @Test(groups = "Katia", description = "Sign out of my account")
    public void signOutTest() {
        signInPage.openPage(SIGN_IN_URL);
        signInPage.fillInEmailAndClickSignInBtn(REGISTERED_EMAIL_ADDRESS, FIELD_PASSWORD);
        headerPage.waitForMyAccountPageOpened();
        headerPage.clickSignOutBtnOnMyAccPage();
        Assert.assertTrue(myAccountPage.isSignInHeaderButtonShown());
    }
}