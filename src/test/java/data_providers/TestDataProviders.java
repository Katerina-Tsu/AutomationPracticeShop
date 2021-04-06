package data_providers;

import org.testng.annotations.DataProvider;

public class TestDataProviders {

    @DataProvider(name = "Input data for the 'create an account' page.")
    public static Object[][] inputForAllRequiredFields() {
        return new Object[][]{
                {"e.chrcsck7@mail.ru", "Evgenii", "Che", "12345", "Evgenii", "Chernikha", "32th Blue Str.", "Minsk", "Arizona", "22335", "United State", "375259874565", "MSI Company"},
                {"o.dzrbnhn7@mail.ru","Oleg", "Dzi", "25333", "Oleg", "Dziraben", "16th Red Str.", "Fanipol", "Arizona", "22365", "United State", "375259874365", "HP Inc."},
                {"s.guor7@mail.ru", "Sasha", "Gur", "124533", "Sasha", "Gursky", "8th Grey Str.", "Borovlyany", "Arizona","22095", "United State", "375259457561", "UV Robotic Inc."},
        };
    }
}