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

    String stateField = "//*[@id='id_state']//ancestor::*[contains(text(),'%s')]";

    String countryField = "//*[@id='id_country']//ancestor::*[contains(text(),'%s')]";

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
        newPostcodeField.sendKeys(newPostcode);
        newHomePhoneField.sendKeys(newHomePhone);
        newMobilePhoneField.sendKeys(newMobilePhone);
        newAddressTitleField.sendKeys(addressTitleField);

    }

    public void chooseState(String state) {
        driver.findElement(By.xpath(String.format(stateField, state))).click();
    }

}
