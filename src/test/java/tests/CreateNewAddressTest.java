package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static constants.CommonConstants.SIGN_IN_URL;

public class CreateNewAddressTest extends BaseTest {

    @Test(groups = "Sasha", description = "In My Account. Add a new address shipping")
    public void createNewAddressTest(String firstName, String lastName, String newAddress,
                                     String newCity, String newPostcode,
                                     String newHomePhone, String newMobilePhone, String addressTitleField) {
        signInPage.openPage(SIGN_IN_URL);
        signInPage.fillInSignInForm(EMAIL_ADDRESS_RIGHT_SIGN_IN_S, PASSWORD);
        createNewAddressPage.isAddressesAdded();
        createNewAddressPage.inputTextInFieldsFormRegNewAddress(firstName,
                lastName,
                newAddress,
                newCity,
                newPostcode,
                newHomePhone,
                newMobilePhone,
                addressTitleField
        );
        createNewAddressPage.chooseState(state);
        createNewAddressPage.clickSaveButton();
        Assert.assertTrue(createAnAccountPage.isMainStorePageOpened());
    }
}