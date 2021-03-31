package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductSearchPage extends BasePage {
    public ProductSearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='search_query_top']")
    WebElement searchField;

    @FindBy(xpath = "//*[@id='searchbox']/button")
    WebElement searchActivation;

    private static final String SEARCH_CORRECT_RESULT_XPATH = "//*[@class='heading-counter']//ancestor::*[contains(text(),'%s')]";

    @FindBy(xpath = "//*[@class='heading-counter']")
    WebElement searchCorrectResultTshirts;

    @Override
    void waitForPageOpened() {
    }

    public void inputInSearchField (String search){
        searchField.sendKeys(search);
        searchActivation.click();
    }

    public boolean isSearchResultDisplayed(String headerText) {
        return driver.findElement(By.xpath(String.format(SEARCH_CORRECT_RESULT_XPATH, headerText))).isDisplayed();
    }

    public String getSearchTextTshirts() {
        return searchCorrectResultTshirts.getText();
    }
}
