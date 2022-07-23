package configuration.utilities;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

    @DataProvider(name = "LogInInformation")
    public static Object[][] logInData(){
        return new Object[][]{
                {"OoompaLoompa","awwNoIDidItAgain"},
                {"OhSnap","lifeManJustLife"},
                {"HereWeGoAgain","INeedMotivation"},
        };
    }

    //@DataProvider(name = "RegistrationDataFromExcel")
    @DataProvider(name = "TDD_RegistrationDataFromExcel")
    public static Object[][] getRegistrationDataFromExcel() {
        return ReadExcelDataDrivenApproach.getRegistrationTestData("AccountInfo");
    }

}
