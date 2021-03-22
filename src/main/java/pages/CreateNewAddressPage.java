package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateNewAddressPage extends BasePage {
    public CreateNewAddressPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@title='Addresses']")
    WebElement addressesButton;

    @FindBy(xpath = "//*[@title='Add an address']")
    WebElement addAnAddressButton;

    @FindBy(xpath = "//*[@id='firstname']")
    WebElement firstNameField;

    @FindBy(xpath = "//*[@id='lastname']")
    WebElement lastNameField;

    @FindBy(xpath = "//*[@id='address1']")
    WebElement newAddressField;

    @FindBy(xpath = "//*[@id='city']")
    WebElement newCityField;

    @FindBy(xpath = "//*[@id='postcode']")
    WebElement newPostcodeField;

    @FindBy(xpath = "//*[@id='phone']")
    WebElement newHomePhoneField;

    @FindBy(xpath = "//*[@id='phone_mobile']")
    WebElement newMobilePhoneField;

    @FindBy(xpath = "//*[@id='alias']")
    WebElement newAddressTitleField;

    @FindBy(xpath = "//*[@id='id_state']//ancestor::*[contains(text(),'Alabama')]")
    WebElement fieldState;

    @FindBy(xpath =  "//*[@id='submitAddress']/span")
    WebElement saveButton;

    private static final String NAME_NEW_ADDRESS_XPATH = "//*[@id='center_column']//ancestor::*[contains(text(),'%s')]";

    @Override
    void waitForPageOpened() {
    }

    public void isAddressesAdded() {
        addressesButton.click();
    }

    public void addAnAddress() {
        addAnAddressButton.click();
    }

    public void inputTextInFieldsFormRegNewAddress(String firstName, String lastName, String newAddress,
                                                    String newCity, String newPostcode,
                                                    String newHomePhone, String newMobilePhone, String addressTitleField) {
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        newAddressField.sendKeys(newAddress);
        newCityField.sendKeys(newCity);
        fieldState.click();
        newPostcodeField.sendKeys(newPostcode);
        newHomePhoneField.sendKeys(newHomePhone);
        newMobilePhoneField.sendKeys(newMobilePhone);
        newAddressTitleField.sendKeys(addressTitleField);

    }

    public void isSaveButton() {
        saveButton.click();
    }
    public boolean isNameNewAddress(String headerText) {
        return driver.findElement(By.xpath(String.format(NAME_NEW_ADDRESS_XPATH, headerText))).isDisplayed();
    }
}
