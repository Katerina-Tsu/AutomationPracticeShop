package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderPage extends BasePage{
    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@title='Women'][1]")
    WebElement womenCategoryButton;

    @FindBy(xpath = "//*[@id='header']//ancestor::*[contains(text(), 'Sign out')]")
    WebElement signOutButton ;

    @FindBy(xpath = "(//*[@title='T-shirts'])[2]")
    WebElement tshirtsCategoryButton;

    @FindBy(xpath = "(//*[@id='center_column']//ancestor::*[contains(text(),'Update')])[2]")
    WebElement updateButton;

    @FindBy(xpath = "//*[@title='My wishlists']")
    WebElement editWishlistButton;

    @FindBy(xpath = "//*[@name='submitWishlist']")
    WebElement saveWishlistButton;

    @FindBy(xpath = "//*[@id='name']")
    WebElement wishlistField;

    private static final String NEW_WISHLIST_NAME_XPATH = "//*[@id='block-history']//ancestor::*[contains(text(),'%s')]";

    void waitForPageOpened() {
    }

    public void clickSignOutProfile() {
        signOutButton.click();
    }

    public void clickOnWomenCategoryButton() {
        womenCategoryButton.click();
    }

    public void clickOnTshirtsCategoryButton() {tshirtsCategoryButton.click();}

    public void clickOnMyWishlist() {editWishlistButton.click();}

    public void inputTextInFieldsNewWishlist(String wishlist) {
        wishlistField.sendKeys(wishlist);
    }

    public void clickWishlistButton() {saveWishlistButton.click();}

    public void clickUpdateButton() {updateButton.click();}

    public boolean isNewWishlistNameDisplayed(String headerText) {
        return driver.findElement(By.xpath(String.format(NEW_WISHLIST_NAME_XPATH, headerText))).isDisplayed();
    }

}
