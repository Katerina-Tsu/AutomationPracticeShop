package tests;

import org.testng.annotations.DataProvider;

public class TestDataProviders {

    @DataProvider(name = "Input data for the 'create an account' page.")
    public static Object[][] inputForAllRequiredFields() {
        return new Object[][]{
                {"e.chrcsck5@mail.ru", "Evgenii", "Che", "12345", "Evgenii", "Chernikha", "32th Blue Str.", "Minsk", "Arizona", "22335", "United State", "375259874565", "MSI Company"},
                {"o.dzrbnhn5@mail.ru","Oleg", "Dzi", "25333", "Oleg", "Dziraben", "16th Red Str.", "Fanipol", "Arizona", "22365", "United State", "375259874365", "HP Inc."},
                {"s.guor5@mail.ru", "Sasha", "Gur", "124533", "Sasha", "Gursky", "8th Grey Str.", "Borovlyany", "Arizona","22095", "United State", "375259457561", "UV Robotic Inc."},
        };
    }
}

