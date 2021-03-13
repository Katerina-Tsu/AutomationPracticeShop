package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static constants.CommonConstants.AUTOMATION_PRACTICE_SHOP_URL;

public class MainProductsTests extends BaseTest{

//    @Test(groups = "Katia. Click 'Add to cart' button on the main page. HAVE A PROBLEM WITH SEARCHING THIS BUTTON")
//    public void addOneProductTest() {
//        mainProductsPage.openPage(AUTOMATION_PRACTICE_SHOP_URL);
////        mainProductsPage.waitForPageOpened();
//        mainProductsPage.addProductToCartOnMainPage("Blouse");
//        Assert.assertTrue(mainProductsPage.isTickProductAddedToCartPageOpened());
//    }

    @Test(groups = "Katia. Add one product. Click 'Add to cart' button from main page on the cart page.")
    public void addOneProductCartTest() {
        mainProductsPage.openPage(AUTOMATION_PRACTICE_SHOP_URL);
        mainProductsPage.findProductNameOnMainPage("Blouse");
        mainProductsPage.clickAddToCartButton();
        mainProductsPage.waitForPageOpened();
        Assert.assertTrue(mainProductsPage.isTickProductAddedToCartPageOpened());
    }
}
