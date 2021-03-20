package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static constants.CommonConstants.AUTOMATION_PRACTICE_SHOP_URL;

public class MainProductsTests extends BaseTest{

    @Test(groups = "Katia", description = "Add one product. Click 'Add to cart' button from main page on the cart page.")
    public void addOneProductCartTest() {
        headerPage.openPage(AUTOMATION_PRACTICE_SHOP_URL);
        mainProductsPage.findProductNameOnPage("Blouse");
        mainProductsPage.clickAddToCartButton();
        mainProductsPage.waitForPageOpened();
        Assert.assertTrue(mainProductsPage.isTickProductAddedToCartPageOpened());
    }
}