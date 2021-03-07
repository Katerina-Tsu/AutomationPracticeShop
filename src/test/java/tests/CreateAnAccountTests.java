package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static constants.CommonConstants.SIGN_IN;

public class CreateAnAccountTests extends BaseTest{

    @Test
    public void firstnameFieldIsEmptyTest() {
        createAnAccountPage.openPage(SIGN_IN);
        createAnAccountPage.login(EMAIL_ADDRESS);
        createAnAccountPage.inputTextInFormFirstName(EMPTY_FIELD_FIRST_NAME);
        Assert.assertEquals(createAnAccountPage.getEmptyFirstnameText(), EXPECTED_RESULT_EMPTY_FIELD_FIRSTNAME);
    }

    @Test
    public void longPasswordTest() {
        createAnAccountPage.openPage(SIGN_IN);
        createAnAccountPage.login(EMAIL_ADDRESS);
        createAnAccountPage.inputLongPasswordInField(LONG_PASSWORD);
        Assert.assertEquals(createAnAccountPage.inputLongPasswordInField(), EXPECTED_RESULT_NOT_LONG_PASSWORD);
    }

}
