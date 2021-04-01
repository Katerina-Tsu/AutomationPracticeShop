package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static constants.CommonConstants.SIGN_IN_URL;

public class HeaderTest extends BaseTest{

    @Test(groups = "Katia. Sign out of my account")
    public void signOutTest() {
        headerPage.openPage(SIGN_IN_URL);
        headerPage.fillInEmailAndClickSignInBtn(REGISTERED_EMAIL_ADDRESS, FIELD_PASSWORD);
        headerPage.waitForMyAccountPageOpened();
        headerPage.signOutBtnOnMyAccPage();
//        Assert.assertTrue(myAccountPage.isSignInHeaderButtonShown());
    }
}
