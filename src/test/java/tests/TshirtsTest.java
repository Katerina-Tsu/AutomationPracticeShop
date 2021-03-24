package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static constants.CommonConstants.SIGN_IN_URL;

public class TshirtsTest extends BaseTest{
    @Test(groups = "Sasha", description = "Check when the t-shirts is found on the site")
    public void tshirtsProductTest() {
        signInPage.openPage(SIGN_IN_URL);
        signInPage.fillInSignInForm(EMAIL_ADDRESS_RIGHT_SIGN_IN_S, PASSWORD);
        headerPage.clickOnTshirtdCategoryButton();
        Assert.assertEquals(productSearchPage.getSearchTextTshirts(), CORRECT_ITEMS_FOUND_RESALT_TSHIRTS);
    }
}