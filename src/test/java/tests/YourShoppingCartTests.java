package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static constants.CommonConstants.AUTOMATION_PRACTICE_SHOP_URL;
import static constants.CommonConstants.SIGN_IN_URL;

public class YourShoppingCartTests extends BaseTest{

    @Test(groups = "Katia", description = "Add multiple products to cart.", priority = 1)
    public void findMultipleProductsToCart() {
        yourShoppingCartPage.openPage(AUTOMATION_PRACTICE_SHOP_URL);
        yourShoppingCartPage.findProductNameOnMainPage("Blouse");
        yourShoppingCartPage.increaseQuantityProducts();
        yourShoppingCartPage.goToMyCartPageProducts();
        yourShoppingCartPage.waitOpeningPageMyCartPageProducts();
        Assert.assertEquals(yourShoppingCartPage.getQuantityProductsOnMyCartPageOfProducts("Blouse"), EXPECTED_RESULT_QUANTITY_PRODUCTS);
        Assert.assertEquals(yourShoppingCartPage.getTotalPriceSomeItemsProduct("Blouse"), EXPECTED_RESULT_TOTAL_PRICE_SOME_ITEMS);
    }

    @Test(groups = "Katia", description = "Payment. Tick a “ I agree to terms.. ”. Pay by bank wire. Button “I confirm my order”", priority = 2)
    public void makeEntirePaymentCycle() {
        yourShoppingCartPage.openPage(SIGN_IN_URL);
        yourShoppingCartPage.fillInEmailAndClickSignInBtn(REGISTERED_EMAIL_ADDRESS, FIELD_PASSWORD);
        yourShoppingCartPage.waitForMyAccountPageOpened();
        yourShoppingCartPage.clickMenuHeaderLink("Women");
        yourShoppingCartPage.clickProductName("Printed Chiffon Dress");
        yourShoppingCartPage.clickAddToCartButton();
        yourShoppingCartPage.goToMyCartPageProducts();
        yourShoppingCartPage.goToNextPage();
        yourShoppingCartPage.goToNextPage();
        yourShoppingCartPage.checkedTabShipping();
        yourShoppingCartPage.clickBankWireBtn();
        yourShoppingCartPage.paymentBtn();
        Assert.assertTrue(yourShoppingCartPage.findOrderIsCompletePage());
    }

    @Test(groups = "Katia", description = "Checking product removal from the cart.", priority = 3)
    public void deletingProductFromCart() {
        yourShoppingCartPage.openPage(AUTOMATION_PRACTICE_SHOP_URL);
        yourShoppingCartPage.findProductNameOnMainPage("Blouse");
        yourShoppingCartPage.clickAddToCartButton();
        yourShoppingCartPage.goToMyCartPageProducts();
        yourShoppingCartPage.clickTrashButton("Blouse");
        yourShoppingCartPage.waitOpeningPageMyCartPageProducts();
        Assert.assertEquals(yourShoppingCartPage.getShoppingCartIsEmptyHeaderText(), EXPECTED_RESULT_EMPTY_SHPCART_HEADER_TEXT);
        Assert.assertEquals(yourShoppingCartPage.getShoppingCartIsEmptyText(), EXPECTED_RESULT_EMPTY_SHPCART_TEXT);
    }
}