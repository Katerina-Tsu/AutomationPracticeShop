package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class WishlistTest extends BaseTest{
    @Test(groups = "Sasha", description = "Addition Wishlist")
    public void WishlistTest() {
        signInPage.openSignInPage();
        signInPage.fillInSignInForm(EMAIL_ADDRESS_RIGHT_SIGN_IN_S, PASSWORD);
        headerPage.clickOnMyWishlist();
        headerPage.inputTextInFieldsNewWishlist(FIELD_NEW_WISHLIST);
        headerPage.clickWishlistButton();
        Assert.assertTrue(headerPage.isNewWishlistNameDisplayed(FIELD_NEW_WISHLIST));
    }
}