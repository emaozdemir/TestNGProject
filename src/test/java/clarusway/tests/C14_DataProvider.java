package clarusway.tests;

import clarusway.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class C14_DataProvider extends TestBase {

    @Test(dataProvider = "usernamePassword")
    void dataProviderTest(String username, String password) {

        System.out.println("username = " + username);
        System.out.println("password = " + password);

    }

    @DataProvider
    public String[][] usernamePassword() {

        String[][] arr = {
                {"john_doe", "John.123"},
                {"mary_star", "Mary.123"},
                {"mehmet_kan", "Mehmet.123"}
        };

        return arr;
    }


    @Test(dataProvider = "usernamePassword")
    void parameterizedTest(String username, String password) {

//Go to https://testpages.eviltester.com/styled/basic-html-form-test.html
        driver.get("https://testpages.eviltester.com/styled/basic-html-form-test.html");

//Enter username
        driver.findElement(By.name("username")).sendKeys(username);

//Enter password
        driver.findElement(By.name("password")).sendKeys(password);

//Click submit
        driver.findElement(By.xpath("//input[@value='submit']")).click();

//Verify username
        String usernameText = driver.findElement(By.id("_valueusername")).getText();
        assertEquals(username, usernameText);

    }

}
