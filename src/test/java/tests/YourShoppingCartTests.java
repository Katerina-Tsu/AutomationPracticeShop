package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static constants.CommonConstants.AUTOMATION_PRACTICE_SHOP_URL;
import static constants.CommonConstants.SIGN_IN_URL;

public class YourShoppingCartTests extends BaseTest{

    @Test(groups = "Katia", description = "Add multiple products to cart.", priority = 1)
    public void findMultipleProductsToCart() {
        headerPage.openPage(AUTOMATION_PRACTICE_SHOP_URL);
        mainProductsPage.findProductNameOnPage("Blouse");
        yourShoppingCartPage.increaseProductsQuantity();
        yourShoppingCartPage.clickProceedToCheckoutButton();
        yourShoppingCartPage.waitForMyCartPageIsOpened();
        Assert.assertEquals(yourShoppingCartPage.getProductsQuantityOnMyCartPage("Blouse"), "2");
        Assert.assertEquals(yourShoppingCartPage.getTotalPriceProducts("Blouse"), "$54.00");
    }

    @Test(groups = "Katia",
            description = "Payment. Tick a 'I agree to terms'. Pay by bank wire. Button 'I confirm my order'",
            priority = 2)
    public void makeEntirePaymentCycle() {
        signInPage.openPage(SIGN_IN_URL);
        signInPage.fillInEmailAndClickSignInBtn(REGISTERED_EMAIL_ADDRESS, FIELD_PASSWORD);
        myAccountPage.waitForMyAccountPageOpened();
        headerPage.clickMenuHeaderLink("Women");
        headerPage.clickProductName("Printed Chiffon Dress");
        yourShoppingCartPage.clickAddToCartButton();
        yourShoppingCartPage.clickProceedToCheckoutButton();
        yourShoppingCartPage.goToNextPageProceedToCheckoutButton();
        yourShoppingCartPage.goToNextPageProceedToCheckoutButton();
        yourShoppingCartPage.checkedTabShipping();
        yourShoppingCartPage.clickBankWireBtn();
        yourShoppingCartPage.clickPaymentBtn();
        Assert.assertTrue(yourShoppingCartPage.isOrderIsCompleteTextDisplayed());
    }

    @Test(groups = "Katia", description = "Checking product removal from the cart.", priority = 3)
    public void deletingProductFromCart() {
        headerPage.openPage(AUTOMATION_PRACTICE_SHOP_URL);
        mainProductsPage.findProductNameOnPage("Blouse");
        yourShoppingCartPage.clickAddToCartButton();
        yourShoppingCartPage.clickProceedToCheckoutButton();
        yourShoppingCartPage.clickTrashButton("Blouse");
        yourShoppingCartPage.waitForMyCartPageIsOpened();
        Assert.assertEquals(yourShoppingCartPage.getShoppingCartIsEmptyHeaderText(), EXPECTED_RESULT_EMPTY_SHPCART_HEADER_TEXT);
        Assert.assertEquals(yourShoppingCartPage.getShoppingCartIsEmptyText(), EXPECTED_RESULT_EMPTY_SHPCART_TEXT);
    }
}