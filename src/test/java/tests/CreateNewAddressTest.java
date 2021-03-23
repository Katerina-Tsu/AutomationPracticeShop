package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static constants.CommonConstants.SIGN_IN_URL;

public class CreateNewAddressTest extends BaseTest {

    @Test(groups = "Sasha", description = "In My Account. Add a new address shipping")
    public void createNewAddressTest() {
        signInPage.openPage(SIGN_IN_URL);
        signInPage.fillInSignInForm(EMAIL_ADDRESS_RIGHT_SIGN_IN_S, PASSWORD);
        createNewAddressPage.AddressesAdded();
        createNewAddressPage.clickOnAddAnAddressButton();
        createNewAddressPage.inputTextInFieldsFormRegNewAddress(FIELD_NEW_YOUR_FIRSTNAME,
                FIELD_NEW_YOUR_LASTNAME,
                FIELD_NEW_ADDRESS,
                FIELD_NEW_NAME_CITY,
                FIELD_NEW_ZIPCODE,
                FIELD_NEW_HOME_PHONE,
                FIELD_NEW_MOB_PHONE,
                FIELD_NEW_NAME_ADDRESS,
                "Alabama"
        );
        createNewAddressPage.clickSaveButton();
        Assert.assertTrue(createNewAddressPage.isNewAddressNameDisplayed(FIELD_NEW_NAME_ADDRESS));
    }
}