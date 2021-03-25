package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderPage extends BasePage{
    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='block_top_menu']/ul/li[1]/a")
    WebElement womenCategoryButton;

    @FindBy(xpath = "//*[@id='header']//ancestor::*[contains(text(), 'Sign out')]")
    WebElement signOutButton ;

    @FindBy(xpath = "//*[@id='block_top_menu']/ul/li[3]/a")
    WebElement tshirtsCategoryButton;

    @FindBy (xpath = "//*[@id='center_column']/div[1]/div/div[2]/ul/li[9]/a[1]/span")
    WebElement editAddressButton;

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

    public void clickOnTshirtdCategoryButton() {tshirtsCategoryButton.click();}

    public void clickOnEditAddressButton() {editAddressButton.click();}

    public void clickOnMyWishlist() {editWishlistButton.click();}

    public void inputTextInFieldsNewWishlist(String wishlist) {
        wishlistField.sendKeys(wishlist);
    }

    public void clickWishlistButton() {saveWishlistButton.click();}

    public boolean isNewWishlistNameDisplayed(String headerText) {
        return driver.findElement(By.xpath(String.format(NEW_WISHLIST_NAME_XPATH, headerText))).isDisplayed();
    }

}
