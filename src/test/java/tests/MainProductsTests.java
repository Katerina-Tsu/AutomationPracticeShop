package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static constants.CommonConstants.AUTOMATION_PRACTICE_SHOP_URL;

public class MainProductsTests extends BaseTest{

    @Test(groups = "Katia. Add one product. Click 'Add to cart' button from main page on the cart page.")
    public void addOneProductCartTest() {
        mainProductsPage.openPage(AUTOMATION_PRACTICE_SHOP_URL);
        mainProductsPage.findProductNameOnMainPage("Blouse");
        mainProductsPage.clickAddToCartButton();
        mainProductsPage.waitForPageOpened();
        Assert.assertTrue(mainProductsPage.isTickProductAddedToCartPageOpened());
    }
}
