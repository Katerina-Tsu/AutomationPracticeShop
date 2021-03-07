package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import static constants.CommonConstants.SIGN_IN;

public class CreateAnAccountTests extends BaseTest{

    @Test
    public void createAnAccountTest() {
        createAnAccountPageFactory.openPage(SIGN_IN);
        createAnAccountPageFactory.login(EMAIL_ADDRESS);
        Assert.assertTrue(createAnAccountPageFactory.isPageOpened());
    }

    @Test
    public void emptyEmailFieldTest() {
        createAnAccountPageFactory.openPage(SIGN_IN);
        createAnAccountPageFactory.login(EMPTY_EMAIL_ADDRESS);
        createAnAccountPageFactory.getLocatorEmailAddressField();
        Assert.assertEquals(createAnAccountPageFactory.getLocatorEmailAddressField(), expectedResultEmptyFieldEmailAddress);
    }

    @Test
    public void wrongEmailFieldTest() {
        createAnAccountPageFactory.openPage(SIGN_IN);
        createAnAccountPageFactory.login(WRONG_EMAIL_ADDRESS);
        Assert.assertEquals(createAnAccountPageFactory.getActualResultWrongEmailAddress(), EXPECTED_RESULT_WRONG_EMAIL_ADDRESS);
    }
}
