package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static constants.CommonConstants.AUTOMATION_PRACTICE_SHOP_URL;

public class YourShoppingCartTests extends BaseTest{

    @Test(groups = "Katia. Add multiple products to cart.")
    public void findMultipleProductsToCart() {
        yourShoppingCartPage.openPage(AUTOMATION_PRACTICE_SHOP_URL);
        yourShoppingCartPage.findProductNameOnMainPage("Blouse");
        yourShoppingCartPage.increaseQuantityProducts();
        yourShoppingCartPage.goToMyCartPageProducts();
        yourShoppingCartPage.waitOpeningPageMyCartPageProducts();
        Assert.assertEquals(yourShoppingCartPage.getQuantityProductsOnMyCartPageOfProducts("Blouse"), EXPECTED_RESULT_QUANTITY_PRODUCTS);
        Assert.assertEquals(yourShoppingCartPage.getTotalPriceSomeItemsProduct("Blouse"), EXPECTED_RESULT_TOTAL_PRICE_SOME_ITEMS);
    }
}