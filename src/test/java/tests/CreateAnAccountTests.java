package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static constants.CommonConstants.SIGN_IN_URL;

public class CreateAnAccountTests extends BaseTest {

    @Test(groups = "Katia. Empty email address verification.")
    public void firstnameFieldIsEmptyTest() {
        createAnAccountPage.openPage(SIGN_IN_URL);
        createAnAccountPage.fillInEmailAndClickCreateAccountBtn(EMAIL_ADDRESS);
        createAnAccountPage.inputTextInFormFirstNameAndClickRegistr(EMPTY_FIELD_FIRST_NAME);
        Assert.assertEquals(createAnAccountPage.getEmptyFirstnameText(), EXPECTED_RESULT_EMPTY_FIELD_FIRSTNAME);
    }

    @Test(groups = "Katia. Input short-zipcode verification.")
    public void inputLongPasswordTest() {
        createAnAccountPage.openPage(SIGN_IN_URL);
        createAnAccountPage.fillInEmailAndClickCreateAccountBtn(EMAIL_ADDRESS);
        createAnAccountPage.inputShortPswrdInField(SHORT_ZIPCODE);
        Assert.assertEquals(createAnAccountPage.getShortPswrdInField(), EXPECTED_RESULT_NOT_LONG_PASSWORD);
    }

    @Test(groups = "Katia. Create an account.The required form fields are filled. Registration is complete.")
    public void allRequiredFieldsAreFilled() {
        createAnAccountPage.openPage(SIGN_IN_URL);
        createAnAccountPage.fillInEmailAndClickCreateAccountBtn(EMAIL_ADDRESS);
        createAnAccountPage.inputTextInRequiredFieldsFormAndReg(FIELD_YOUR_FIRSTNAME,
                FIELD_YOUR_LASTNAME,
                FIELD_PASSWORD,
                FIELD_YOUR_FIRSTNAME_COMPANY,
                FIELD_YOUR_LASTNAME_COMPANY,
                FIELD_ADDRESS_COMPANY,
                FIELD_NAME_CITY,
                FIELD_ZIPCODE,
                FIELD_MOB_PHONE,
                FIELD_COMPANY_ASSIGN_NAME
        );
        Assert.assertTrue(createAnAccountPage.isMainStorePageOpened());
    }
}
