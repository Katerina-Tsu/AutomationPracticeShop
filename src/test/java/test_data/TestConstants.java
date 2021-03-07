package test_data;


public interface TestConstants {
    String EMAIL_ADDRESS = "a.ivanov.customer@mail.ru";
    String EMPTY_EMAIL_ADDRESS = "";
    String PASSWORD = "rfvtgb123yhn";
    String WRONG_EMAIL_ADDRESS = "ivanov";
    String EXPECTED_RESULT_WRONG_EMAIL_ADDRESS = "Invalid email address.";
    String EMPTY_FIELD_FIRST_NAME = "";
    String EXPECTED_RESULT_EMPTY_FIELD_FIRSTNAME = "firstname";
    String LONG_PASSWORD = "123456789123456789123456789123456";
    String EXPECTED_RESULT_NOT_LONG_PASSWORD = "passwd is too long. Maximum length: 32";
}
