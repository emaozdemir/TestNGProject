package clarusway.utilities;

import com.github.javafaker.Faker;
import org.testng.annotations.DataProvider;

import java.util.Arrays;

public class DataProviderUtils {

    @DataProvider
    public String[][] usernamePassword() {

        String[][] arr = {
                {"john_doe", "John.123"},
                {"mary_star", "Mary.123"},
                {"tom_steel", "Tom.123"},
                {"hans_zimmer", "Hans.123"}
        };

        return arr;
    }

    @DataProvider//Bu method faker'dan aldığı datayı iki boyutlu array olarak döner ve data provider ile test classında kullanılır.
    public String[][] usernamePasswordFaker() {

        Faker faker = new Faker();

        String[][] arr = {

                {faker.name().firstName(), faker.internet().password(), faker.lorem().paragraph()},
                {faker.name().firstName(), faker.internet().password(), faker.lorem().paragraph()},
                {faker.name().firstName(), faker.internet().password(), faker.lorem().paragraph()},
                {faker.name().firstName(), faker.internet().password(), faker.lorem().paragraph()},
                {faker.name().firstName(), faker.internet().password(), faker.lorem().paragraph()}

        };

        return arr;
    }

    @DataProvider//Bu method excel datasını 2 boyutlu array'e çevirir ve  data provider ile test classında kullanılır.
    public String[][] excelData() {

        ExcelUtils excelUtils = new ExcelUtils("resources/username_password.xlsx", "Sheet1");

        return excelUtils.getDataArrayWithoutFirstRow();
    }

    @DataProvider
    public String[][] registerData() {

        ExcelUtils excelUtils = new ExcelUtils("resources/username_password.xlsx", "Sheet3");

        return excelUtils.getDataArrayWithoutFirstRow();
    }

}
