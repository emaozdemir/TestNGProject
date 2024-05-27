package clarusway.tests;

import clarusway.utilities.DataProviderUtils;
import clarusway.utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class C17_DataProviderExcel extends TestBase {

    @Test(dataProvider = "usernamePasswordFaker", dataProviderClass = DataProviderUtils.class)
    void parameterizedTest(String username, String password, String comment) throws InterruptedException {

//Go to https://testpages.eviltester.com/styled/basic-html-form-test.html
        driver.get("https://testpages.eviltester.com/styled/basic-html-form-test.html");

//Enter username
        driver.findElement(By.name("username")).sendKeys(username);
        Thread.sleep(2000);

//Enter password
        driver.findElement(By.name("password")).sendKeys(password);
        Thread.sleep(2000);

//Enter comment
        driver.findElement(By.name("comments")).clear();
        driver.findElement(By.name("comments")).sendKeys(comment);
        Thread.sleep(2000);

//Click submit
        driver.findElement(By.xpath("//input[@value='submit']")).click();

//Verify username
        String usernameText = driver.findElement(By.id("_valueusername")).getText();
        assertEquals(username, usernameText);

    }

}
