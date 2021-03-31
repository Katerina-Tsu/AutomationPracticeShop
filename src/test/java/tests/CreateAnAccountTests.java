package tests;

import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.Test;

@Log4j2
public class CreateAnAccountTests extends BaseTest {

    @Test(groups = "Katia", description = "Empty email address verification.", priority = 3)
    public void firstnameFieldIsEmptyTest() {
        signInPage.openSignInPage();
        signInPage.fillInEmailAndClickCreateAccountBtn(NOT_REGISTERED_EMAIL_ADDRESS);
        createAnAccountPage.inputTextInFormFirstNameAndClickRegister(EMPTY_FIELD_FIRST_NAME);
        Assert.assertEquals(createAnAccountPage.getEmptyFirstnameText(), EXPECTED_RESULT_EMPTY_FIELD_FIRSTNAME);
    }

    @Test(groups = "Katia", description = "Input short-zipcode verification.", priority = 3)
    public void inputLongPasswordTest() {
        signInPage.openSignInPage();
        signInPage.fillInEmailAndClickCreateAccountBtn(NOT_REGISTERED_EMAIL_ADDRESS);
        createAnAccountPage.inputShortPswrdInField(SHORT_ZIPCODE);
        Assert.assertEquals(createAnAccountPage.getShortPswrdInField(), EXPECTED_RESULT_NOT_LONG_PASSWORD);
    }

    @Test(groups = "Katia", description = "Create an account.The required form fields are filled. Registration is complete.",
            priority = 1, dataProvider = "Input data for the 'create an account' page.", dataProviderClass = TestDataProviders.class)
    public void createAnAccountTest(String emailAddress, String yourFirstName, String yourLastName, String password,
                                    String firstNameCompany, String lastNameCompany, String addressCompany,
                                    String city, String state, String zipCode, String country, String phoneNumber, String assignCompanyName) {
        signInPage.openSignInPage();
        signInPage.fillInEmailAndClickCreateAccountBtn(emailAddress);
        createAnAccountPage.inputTextInRequiredFieldsFormAndReg(yourFirstName,
                yourLastName,
                password,
                firstNameCompany,
                lastNameCompany,
                addressCompany,
                city,
                zipCode,
                phoneNumber,
                assignCompanyName
        );
        createAnAccountPage.chooseState(state);
        createAnAccountPage.chooseCountry(country);
        createAnAccountPage.clickRegisterButton();
        Assert.assertTrue(myAccountPage.isMyAccountPagePageOpened());
    }
}