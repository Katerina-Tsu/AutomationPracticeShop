package tests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer {
    private String emailAddress;
    private String yourFirstName;
    private String yourLastName;
    private String password;
    private String firstNameCompany;
    private String lastNameCompany;
    private String addressCompany;
    private String city;
    private String state;
    private String zipCode;
    private String country;
    private String phoneNumber;
    private String assignCompanyName;

}