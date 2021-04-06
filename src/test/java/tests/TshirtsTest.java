package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TshirtsTest extends BaseTest{
    @Test(groups = "Sasha", description = "Check when the t-shirts is found on the site")
    public void tshirtsProductTest() {
        signInPage.openSignInPage();
        signInPage.fillInSignInForm(EMAIL_ADDRESS_RIGHT_SIGN_IN_S, PASSWORD);
        headerPage.clickMenuHeaderLink("T-shirts");
        Assert.assertEquals(productSearchPage.getSearchTextTshirts(), CORRECT_ITEMS_FOUND_RESULT_CLOTHES);
    }
}