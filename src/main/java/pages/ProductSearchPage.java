package pages;

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

    @FindBy(xpath = "//*[@class='heading-counter']//ancestor::*[contains(text(),'7 results have been found.')]")
    WebElement searchCorrectResult;

    @Override
    void waitForPageOpened() {
    }

    public void inputInSearchField (String search){
        searchField.sendKeys(search);
        searchActivation.click();
    }

    public String getCorrectTextSearch() {
        return searchCorrectResult.getText();
    }
}