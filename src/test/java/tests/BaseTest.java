package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.CreateAnAccountPage;
import pages.MainProductsPage;
import pages.MyAccountPage;
import pages.SignInPage;
import test_data.TestConstants;

import java.util.concurrent.TimeUnit;

public class BaseTest implements TestConstants {
    WebDriver driver;
    SignInPage signInPage;
    CreateAnAccountPage createAnAccountPage;
    MyAccountPage myAccountPage;
    MainProductsPage mainProductsPage;

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
        myAccountPage = new MyAccountPage(driver);
        mainProductsPage = new MainProductsPage(driver);
    }
}
