package tests;

import junit.framework.Assert;
import org.testng.annotations.Test;

import static constants.CommonConstants.SIGN_IN_URL;

public class MyAccountTests extends BaseTest{

    @Test(groups = "Katia. Sign out of my account")
    public void signOutTest() {
        myAccountPage.openPage(SIGN_IN_URL);
        myAccountPage.fillInEmailAndClickCreateAccountBtn(EMAIL_ADDRESS);
        myAccountPage.inptTextInRequiredFieldsFormAndReg(FIELD_YOUR_FIRSTNAME,
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
        myAccountPage.signOutBtnOnMyAccPage();
        Assert.assertTrue(myAccountPage.isMainStorePageOpened());
    }
}
