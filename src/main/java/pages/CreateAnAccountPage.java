package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAnAccountPage extends HeaderPage {

    @FindBy(xpath = "//*[contains(text(),'Your personal information')]")
    WebElement yourPersonalInfoLabel;

    @FindBy(xpath = "//*[@id='customer_firstname']")
    WebElement yourFirstNameField;

    @FindBy(xpath = "//*[@id='submitAccount']")
    WebElement registrationButton;

    @FindBy(xpath = "//*[@id='center_column']//ancestor::*[contains(text(),'firstname')]")
    WebElement emptyFirstnameFieldErrorText;

    @FindBy(xpath = "//*[@id='passwd']")
    WebElement passwordField;

    @FindBy(xpath = "//*[@class='alert alert-danger']//ancestor::*[contains(text(),'The Zip/Postal')]")
    WebElement longZipcodeErrorText;

    @FindBy(xpath = "//*[@id='customer_lastname']")
    WebElement yourLastnameField;

    @FindBy(xpath = "//*[@id='email']")
    WebElement emailField;

    @FindBy(xpath = "//*[@id='firstname']")
    WebElement companyFirstNameField;

    @FindBy(xpath = "//*[@id='lastname']")
    WebElement companyLastNameField;

    @FindBy(xpath = "//*[@id='address1']")
    WebElement yourAddressField;

    @FindBy(xpath = "//*[@id='city']")
    WebElement cityField;

    String stateField = "//*[@id='id_state']//ancestor::*[contains(text(),'%s')]";

    @FindBy(xpath = "//*[@id='postcode']")
    WebElement zipCodeField;

    String countryField = "//*[@id='id_country']//ancestor::*[contains(text(),'%s')]";

    @FindBy(xpath = "//*[@id='phone_mobile']")
    WebElement mobPhoneField;

    @FindBy(xpath = "//*[@id='alias']")
    WebElement assignAddressField;

    @FindBy(xpath = "//*[@id='alias']")
    WebElement textInFieldAssignAnAddress;

    public CreateAnAccountPage(WebDriver driver) {
        super(driver);
    }

    @Step("Inputting first name and click register '{firstName}'.")
    public void inputTextInFormFirstNameAndClickRegister(String firstName) {
        yourFirstNameField.sendKeys(firstName);
        registrationButton.click();
    }

    public String getEmptyFirstnameText() {
        return emptyFirstnameFieldErrorText.getText();
    }

    @Step("Inputting short zipcode and click register '{zipCode}'.")
    public void inputShortPswrdInField(String zipCode) {
        zipCodeField.sendKeys(zipCode);
        registrationButton.click();
    }

    public void clickRegisterButton() {
        registrationButton.click();
    }

    public String getShortPswrdInField() {
        return longZipcodeErrorText.getText();
    }

    @Step("Inputting data in fields for creating an account")
    public void inputTextInRequiredFieldsFormAndReg(String yourFirstName, String yourLastName, String password,
                                                    String firstNameCompany, String lastNameCompany,
                                                    String addressCompany, String city, String zipCode,
                                                    String phoneNumber, String assignCompanyName) {
        yourFirstNameField.sendKeys(yourFirstName);
        yourLastnameField.sendKeys(yourLastName);
        emailField.click();
        passwordField.sendKeys(password);
        companyFirstNameField.clear();
        companyFirstNameField.sendKeys(firstNameCompany);
        companyLastNameField.clear();
        companyLastNameField.sendKeys(lastNameCompany);
        yourAddressField.sendKeys(addressCompany);
        cityField.sendKeys(city);
        zipCodeField.sendKeys(zipCode);
        mobPhoneField.sendKeys(phoneNumber);
        textInFieldAssignAnAddress.clear();
        assignAddressField.sendKeys(assignCompanyName);
    }

    @Step("Choosing state name '{state}'.")
    public void chooseState(String state) {
        driver.findElement(By.xpath(String.format(stateField, state))).click();
    }

    @Step("Choosing country name '{country}'.")
    public void chooseCountry(String country) {
        driver.findElement(By.xpath(String.format(countryField, country))).click();
    }
}