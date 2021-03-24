package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static constants.CommonConstants.SIGN_IN_URL;

public class CartTest extends BaseTest{
    @Test(groups = "Sasha", description = "Checked when sign out is over")
    public void productCartTest() {
        signInPage.openPage(SIGN_IN_URL);
        signInPage.fillInSignInForm(EMAIL_ADDRESS_RIGHT_SIGN_IN_S, PASSWORD);
        headerPage.clickOnWomenCategoryButton();
        cartPage.clickOnProduct("Blouse");
        cartPage.iframeAdToCart();
        cartPage.clickAddToCart();
        Assert.assertTrue(cartPage.isProductDescription("Blouse"));
    }
}
