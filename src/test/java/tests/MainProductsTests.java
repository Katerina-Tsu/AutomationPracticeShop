package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MainProductsTests extends BaseTest{

    @Test(groups = "Katia", description = "Add one product. Click 'Add to cart' button from main page on the cart page.")
    public void addOneProductCartTest() {
        headerPage.openHeaderPage();
        mainProductsPage.findProductNameOnPage("Blouse");
        productDetailsPage.clickAddToCartInProductDetailButton();
        productDetailsModal.waitForPageOpened();
        Assert.assertTrue(productDetailsModal.isTickProductAddedToCartPageOpened());
    }
}