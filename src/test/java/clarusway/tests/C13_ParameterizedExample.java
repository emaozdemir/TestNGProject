package clarusway.tests;

import clarusway.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class C13_ParameterizedExample extends TestBase {

    /*
    Go to https://testpages.eviltester.com/styled/basic-html-form-test.html
    Enter username
    Enter password
    Enter comment
    Click submit
    Verify username
     */

    @Test
    @Parameters({"username", "password", "comment"})
    void parameterizedTest(String username, String password, String comment) {

//Go to https://testpages.eviltester.com/styled/basic-html-form-test.html
        driver.get("https://testpages.eviltester.com/styled/basic-html-form-test.html");

//Enter username
        driver.findElement(By.name("username")).sendKeys(username);

//Enter password
        driver.findElement(By.name("password")).sendKeys(password);

//Enter comment
        WebElement commentInput = driver.findElement(By.name("comments"));
        commentInput.clear();
        commentInput.sendKeys(comment);

//Click submit
        driver.findElement(By.xpath("//input[@value='submit']")).click();

//Verify username
        String usernameText = driver.findElement(By.id("_valueusername")).getText();
        assertEquals(username, usernameText);

    }

}
