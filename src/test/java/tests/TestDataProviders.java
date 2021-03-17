package tests;

import org.testng.annotations.DataProvider;

public class TestDataProviders {

    @DataProvider(name = "Input data for the 'create an account' page.")
    public static Object[][] inputForAllRequiredFields() {
        return new Object[][]{
                {"e.chernika@mail.ru", "Evgenii", "Che", "12345", "Evgenii", "Chernika", "32th Blue Str.", "Minsk", "22335", "375259874565", "MSI Company"},
                {"o.dzeraben@mail.ru","Oleg", "Dze", "25333", "Oleg", "Dzeraben", "16th Red Str.", "Fanipol", "22365", "375259874365", "HP Inc."},
                {"s.guru@mail.ru", "Sasha", "Guru", "124533", "Sasha", "Gurski", "8th Grey Str.", "Borovlyany", "22095", "375259457561", "UV Robotic Inc."},
        };
    }
}
