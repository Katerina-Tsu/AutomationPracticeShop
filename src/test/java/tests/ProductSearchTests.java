package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static constants.CommonConstants.SIGN_IN_URL;

public class ProductSearchTests extends BaseTest{
    @Test(groups = "Sasha", description = "Сheck when the product is found on the site")
    public void wrongEmailFieldSignInTest() {
        signInPage.openPage(SIGN_IN_URL);
        signInPage.fillInSignInForm(EMAIL_ADDRESS_RIGHT_SIGN_IN_S, PASSWORD);
        productSearchPage.inputInSearchField(DRESS_ITEM);
        Assert.assertTrue(productSearchPage.getSearchText(CORRECT_ITEMS_FOUND_RESULT));
    }
}
