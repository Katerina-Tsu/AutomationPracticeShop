package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.*;
import test_data.TestConstants;
import utils.TestListener;

import java.util.concurrent.TimeUnit;

@Log4j2
@Listeners(TestListener.class)
public class BaseTest implements TestConstants {
    WebDriver driver;
    SignInPage signInPage;
    CreateAnAccountPage createAnAccountPage;
    MainProductsPage mainProductsPage;
    MyAccountPage myAccountPage;
    ProductDetailsPage productDetailsPage;
    ProductDetailsModal productDetailsModal;
    YourShoppingCartSummaryPage yourShoppingCartSummaryPage;
    YourShoppingCartSignInPage yourShoppingCartSignInPage;
    YourShoppingCartAddressPage yourShoppingCartAddressPage;
    YourShoppingCartShippingPage yourShoppingCartShippingPage;
    YourShoppingCartPaymentPage yourShoppingCartPaymentPage;
    OrderConfirmationPaymentPage orderConfirmationPaymentPage;
    HeaderPage headerPage;
    CreateNewAddressPage createNewAddressPage;
    ProductSearchPage productSearchPage;
    CartPage cartPage;

    @BeforeMethod
    public void initTest() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        initPage();
    }

    @AfterMethod(alwaysRun = true)
    public void endTest() {
            driver.quit();
    }

    public void initPage() {
        signInPage = new SignInPage(driver);
        createAnAccountPage = new CreateAnAccountPage(driver);
        mainProductsPage = new MainProductsPage(driver);
        myAccountPage = new MyAccountPage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
        productDetailsModal = new ProductDetailsModal(driver);
        yourShoppingCartSummaryPage = new YourShoppingCartSummaryPage(driver);
        yourShoppingCartSignInPage = new YourShoppingCartSignInPage(driver);
        yourShoppingCartAddressPage = new YourShoppingCartAddressPage(driver);
        yourShoppingCartShippingPage = new YourShoppingCartShippingPage(driver);
        yourShoppingCartPaymentPage = new YourShoppingCartPaymentPage(driver);
        orderConfirmationPaymentPage = new OrderConfirmationPaymentPage(driver);
        headerPage = new HeaderPage(driver);
        productSearchPage = new ProductSearchPage(driver);
        createNewAddressPage = new CreateNewAddressPage(driver);
        cartPage = new CartPage(driver);
    }
}