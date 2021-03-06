package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class EditShippingAddressesTest extends BaseTest {

    @Test(groups = "Sasha", description = "Remove the shipping address")
    public void EditShippingAddressesTest() {
        signInPage.openSignInPage();
        signInPage.fillInSignInForm(EMAIL_ADDRESS_RIGHT_SIGN_IN_S, PASSWORD);
        createNewAddressPage.clickAddressesButton();
        headerPage.clickUpdateButton();
        createNewAddressPage.inputNewTextInFieldsFormRegNewAddress(FIELD_WITH_REDACTED_NAME_ADDRESS);
        createNewAddressPage.clickSaveButton();
        Assert.assertTrue(createNewAddressPage.isNewAddressNameDisplayed(FIELD_WITH_REDACTED_NAME_ADDRESS_CHECK));
    }
}
