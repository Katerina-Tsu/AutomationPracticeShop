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

    @FindBy(xpath =  "//*[@id='submitAddress']/span")
    WebElement saveButton;

    @FindBy(xpath = "//*[@id='center_column']/div/div/ol/li")
    WebElement incorrectFieldText;

    private static final String NEW_ADDRESS_NAME_XPATH = "//*[@id='center_column']//ancestor::*[contains(text(),'%s')]";

    private static final String STATE_FIELD_XPATH = "//*[@id='id_state']//ancestor::*[contains(text(),'%s')]";

    @Override
    void waitForPageOpened() {
    }

    public void AddressesAdded() {
        addressesButton.click();
    }

    public void clickOnAddAnAddressButton() {
        addAnAddressButton.click();
    }

    public void inputTextInFieldsFormRegNewAddress(String firstName, String lastName, String newAddress,
                                                    String newCity, String newPostcode,
                                                    String newHomePhone, String newMobilePhone, String addressTitleField, String stateName) {
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        newAddressField.sendKeys(newAddress);
        newCityField.sendKeys(newCity);
        driver.findElement(By.xpath(String.format(STATE_FIELD_XPATH,stateName))).click();
        newPostcodeField.sendKeys(newPostcode);
        newHomePhoneField.sendKeys(newHomePhone);
        newMobilePhoneField.sendKeys(newMobilePhone);
        newAddressTitleField.sendKeys(addressTitleField);
    }

    public void inputTextInFieldsFormRegNewAddressIncorrect(String firstName, String lastName,
                                                   String newCity, String newPostcode,
                                                   String newHomePhone, String newMobilePhone, String addressTitleField, String stateName) {
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        newCityField.sendKeys(newCity);
        driver.findElement(By.xpath(String.format(STATE_FIELD_XPATH,stateName))).click();
        newPostcodeField.sendKeys(newPostcode);
        newHomePhoneField.sendKeys(newHomePhone);
        newMobilePhoneField.sendKeys(newMobilePhone);
        newAddressTitleField.sendKeys(addressTitleField);
    }

    public void clickSaveButton() {
        saveButton.click();
    }
    public boolean isNewAddressNameDisplayed(String headerText) {
        return driver.findElement(By.xpath(String.format(NEW_ADDRESS_NAME_XPATH, headerText))).isDisplayed();
    }

    public String getSearchTextIncorrectDataField() {
        return incorrectFieldText.getText();
    }

    public void inputNewTextInFieldsFormRegNewAddress(String newAddress) {
        newAddressTitleField.sendKeys(newAddress);
    }
}
