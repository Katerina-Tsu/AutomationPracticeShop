package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static constants.CommonConstants.SIGN_IN_URL;

public class CartTest extends BaseTest{
    @Test(groups = "Sasha", description = "Adding an item to the cart")
    public void productCartTest() {
        signInPage.openSignInPage();
        signInPage.fillInSignInForm(EMAIL_ADDRESS_RIGHT_SIGN_IN_S, PASSWORD);
        headerPage.clickMenuHeaderLink("Women");
        cartPage.clickOnProduct("Blouse");
        cartPage.clickOnAddToCartButton();
        cartPage.clickAddToCart();
        Assert.assertTrue(cartPage.isProductDescriptionDisplayed("Blouse"));
    }
}
