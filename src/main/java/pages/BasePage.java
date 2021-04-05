package pages;

import constants.CommonConstants;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

@Log4j2
public class BasePage implements CommonConstants {
    WebDriver driver;
    WebDriverWait wait;

    BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
        log.debug("Implicit Timeout = 20");
        PageFactory.initElements(driver, this);
    }

    public void openPage(String url) {
        log.info("Open url" + url);
        driver.get(url);
    }
}