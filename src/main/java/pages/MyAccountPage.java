package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MyAccountPage extends HeaderPage {
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//*[@id='customer_firstname']")
    WebElement fieldYourFirstName;

    @FindBy(xpath = "//*[@id='submitAccount']")
    WebElement registrationButton;

    @FindBy(xpath = "//*[@id='passwd']")
    WebElement fieldPassword;

    @FindBy(xpath = "//*[@id='customer_lastname']")
    WebElement fieldYourLastname;

    @FindBy(xpath = "//*[@id='email']")
    WebElement fieildEmail;

    @FindBy(xpath = "//*[@id='firstname']")
    WebElement fieldCompanyFirstname;

    @FindBy(xpath = "//*[@id='lastname']")
    WebElement fieldCompanyLastname;

    @FindBy(xpath = "//*[@id='address1']")
    WebElement fieldYourAddress;

    @FindBy(xpath = "//*[@id='city']")
    WebElement fieldCity;

    @FindBy(xpath = "//*[@id='id_state']//ancestor::*[contains(text(),'Arizona')]")
    WebElement fieldState;

    @FindBy(xpath = "//*[@id='postcode']")
    WebElement fieldZipCode;

    @FindBy(xpath = "//*[@id='id_country']//ancestor::*[contains(text(),'United State')]")
    WebElement fieldCountry;

    @FindBy(xpath = "//*[@id='phone_mobile']")
    WebElement fieldMobPhone;

    @FindBy(xpath = "//*[@id='alias']")
    WebElement fieldAssignAddress;

    @FindBy(xpath = "//*[@id='alias']")
    WebElement textInFieldAssignAnAddress;

    @FindBy(xpath = "//*[@id='center_column']//ancestor::*[contains(text(),'My account')]")
    WebElement myAccountPageLabel;

    @FindBy(xpath = "//*[@id='header']//ancestor::*[contains(text(),'Sign out')]")
    WebElement signOutBtn;

    @FindBy(xpath = "//*[@id='htmlcontent_top']")
    WebElement mainStorePageLabel;

    public void waitForPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated((By) myAccountPageLabel));
    }

    public void fillInEmailAndClickCreateAccountBtn(String emailAddress) {
        //TODO: Implement method????
    }

    public void inptTextInRequiredFieldsFormAndReg(String firstName, String lastname, String pswrd, String frstnameCompany, String lstnameCompany, String yourAddress, String city, String zipCode, String mobPhone, String assNameAddress) {
        fieldYourFirstName.sendKeys(firstName);
        fieldYourLastname.sendKeys(lastname);
        fieildEmail.click();
        fieldPassword.sendKeys(pswrd);
        fieldCompanyFirstname.sendKeys(frstnameCompany);
        fieldCompanyLastname.sendKeys(lstnameCompany);
        fieldYourAddress.sendKeys(yourAddress);
        fieldCity.sendKeys(city);
        fieldState.click();
        fieldZipCode.sendKeys(zipCode);
        fieldCountry.getText();
        fieldMobPhone.sendKeys(mobPhone);
        textInFieldAssignAnAddress.clear();
        fieldAssignAddress.sendKeys(assNameAddress);
        registrationButton.click();
    }

    public void signOutBtnOnMyAccPage() {
        signOutBtn.click();
    }

    public boolean isMainStorePageOpened() {
        return mainStorePageLabel.isDisplayed();
    }
}
