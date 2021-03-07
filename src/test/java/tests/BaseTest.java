package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.CreateAnAccountPageFactory;
import pages.LoginPage;
import test_data.TestConstants;

import java.util.concurrent.TimeUnit;

public class BaseTest implements TestConstants {
    WebDriver driver;
    LoginPage loginPage;
    CreateAnAccountPageFactory createAnAccountPageFactory;

    @BeforeMethod
    public void initTest() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        loginPage = new LoginPage(driver);
        createAnAccountPageFactory = new CreateAnAccountPageFactory(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void endTest() { driver.quit();}
}
