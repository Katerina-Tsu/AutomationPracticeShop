package test_data;

import org.openqa.selenium.By;

public interface TestConstants {
    String EMAIL_ADDRESS = "a.ivanov.customer@mail.ru";
    String EMPTY_EMAIL_ADDRESS = "";
    String PASSWORD = "rfvtgb123yhn";
    String expectedResultEmptyFieldEmailAddress = "form-group form-error";
    String WRONG_EMAIL_ADDRESS = "ivanov";
    String EXPECTED_RESULT_WRONG_EMAIL_ADDRESS = "Invalid email address.";
}
