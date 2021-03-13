package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static constants.CommonConstants.AUTOMATION_PRACTICE_SHOP_URL;
import static constants.CommonConstants.SIGN_IN_URL;

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

//    @Test(groups = "Katia. Payment.steps 04.Shipping -  tick a “ I agree to terms.. ”. Pay by bank wire. Button “I confirm my order”.")
//    public void makeEntirePaymentCycle() {
//        yourShoppingCartPage.openPage(SIGN_IN_URL);
//        yourShoppingCartPage.fillInEmailAndClickSignInBtn(EMAIL_ADDRESS, FIELD_PASSWORD);
//    }

    @Test(groups = "Katia. Checking product removal from the cart.")
    public void deletingProductFromCart() {
        yourShoppingCartPage.openPage(AUTOMATION_PRACTICE_SHOP_URL);
        yourShoppingCartPage.findProductNameOnMainPage("Blouse");
        yourShoppingCartPage.clickAddToCartButton();
    }
}