package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static constants.CommonConstants.SIGN_IN_URL;

public class EditShippingAddressesTest extends BaseTest {

    @Test(groups = "Sasha", description = "Remove the shipping address")
    public void EditShippingAddressesTest() {
        signInPage.openPage(SIGN_IN_URL);
        signInPage.fillInSignInForm(EMAIL_ADDRESS_RIGHT_SIGN_IN_S, PASSWORD);
        createNewAddressPage.clickAddressesButton();
        headerPage.clickOnEditAddressButton();
        createNewAddressPage.inputNewTextInFieldsFormRegNewAddress(FIELD_WITH_REDACTED_NAME_ADDRESS);
        createNewAddressPage.clickSaveButton();
        Assert.assertTrue(createNewAddressPage.isNewAddressNameDisplayed(FIELD_WITH_REDACTED_NAME_ADDRESS_CHECK));
    }
}
