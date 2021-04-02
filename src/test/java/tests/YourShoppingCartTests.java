package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class YourShoppingCartTests extends HeaderTest{

    @Test(groups = "Katia", description = "Add multiple products to cart.", priority = 1)
    public void findMultipleProductsToCart() {
        headerPage.openHeaderPage();
        mainProductsPage.findProductNameOnPage("Blouse");
        productDetailsPage.increaseProductsQuantity();
        productDetailsModal.clickProceedToCheckoutButton();
        yourShoppingCartSummaryPage.waitForMyCartPageIsOpened();
        Assert.assertEquals(yourShoppingCartSummaryPage.getProductsQuantityOnMyCartPage("Blouse"), "2");
        Assert.assertEquals(yourShoppingCartSummaryPage.getTotalPriceProducts("Blouse"), "$54.00");
    }

    @Test(groups = "Katia",
            description = "Payment. Tick a 'I agree to terms'. Pay by bank wire. Button 'I confirm my order'",
            priority = 2)
    public void makeEntirePaymentCycle() {
        signInPage.openSignInPage();
        signInPage.fillInSignInForm(REGISTERED_EMAIL_ADDRESS, FIELD_PASSWORD);
        myAccountPage.waitForMyAccountPageOpened();
        headerPage.clickMenuHeaderLink("Women");
        mainProductsPage.clickProductName("Printed Chiffon Dress");
        productDetailsPage.clickAddToCartInProductDetailButton();
        productDetailsModal.clickProceedToCheckoutButton();
        yourShoppingCartSummaryPage.clickProceedToCheckoutYSCSummaryButton();
        yourShoppingCartAddressPage.clickProceedToCheckoutYSCSignInButton();
        yourShoppingCartShippingPage.checkedTabShipping();
        yourShoppingCartPaymentPage.clickBankWireBtn();
        yourShoppingCartPaymentPage.clickPaymentBtn();
        Assert.assertTrue(orderConfirmationPaymentPage.isOrderIsCompleteTextDisplayed());
    }

    @Test(groups = "Katia", description = "Checking product removal from the cart.", priority = 3)
    public void deletingProductFromCart() {
        headerPage.openHeaderPage();
        mainProductsPage.findProductNameOnPage("Blouse");
        productDetailsPage.clickAddToCartInProductDetailButton();
        productDetailsModal.clickProceedToCheckoutButton();
        yourShoppingCartSummaryPage.clickTrashButton("Blouse");
        yourShoppingCartSummaryPage.waitForMyCartPageIsOpened();
        Assert.assertEquals(headerPage.getShoppingCartIsEmptyHeaderText(), EXPECTED_RESULT_EMPTY_SHPCART_HEADER_TEXT);
        Assert.assertEquals(yourShoppingCartSummaryPage.getShoppingCartIsEmptyText(), EXPECTED_RESULT_EMPTY_SHPCART_TEXT);
    }
}