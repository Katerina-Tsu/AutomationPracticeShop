package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import static constants.CommonConstants.SIGN_IN;

public class CreateAnAccountTests extends BaseTest{

    @Test
    public void createAnAccountTest() {
        createAnAccountPage.openPage(SIGN_IN);
        createAnAccountPage.login(EMAIL_ADDRESS);
        Assert.assertTrue(createAnAccountPage.isPageOpened());
    }

    @Test
    public void emptyEmailFieldTest() {
        createAnAccountPage.openPage(SIGN_IN);
        createAnAccountPage.login(EMPTY_EMAIL_ADDRESS);
        createAnAccountPage.getLocatorEmailAddressField();
        Assert.assertEquals(createAnAccountPage.getLocatorEmailAddressField(), expectedResultEmptyFieldEmailAddress);
    }

    @Test
    public void wrongEmailFieldTest() {
        createAnAccountPage.openPage(SIGN_IN);
        createAnAccountPage.login(WRONG_EMAIL_ADDRESS);
        Assert.assertEquals(createAnAccountPage.getActualResultWrongEmailAddress(), EXPECTED_RESULT_WRONG_EMAIL_ADDRESS);
    }
}
