package clarusway.tests;

import clarusway.utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class C10_HardAndSoftAssertion extends TestBase {
/*
    Test Case1: Positive Login Test
    Open page https://practicetestautomation.com/practice-test-login/
    Type username student into Username field
    Type password Password123 into Password field
    Click Submit button.
    Verify new page URL contains practicetestautomation.com/logged-in-successfully/
    Verify new page contains expected text ('Congratulations' or 'successfully logged in')
    Verify button Log out is displayed on the new page.
*/
    @Test
    public void test01() {
        driver.get("https://practicetestautomation.com/practice-test-login/");
//    Type username student into Username field
driver.findElement(By.id("username")).sendKeys("student");
//    Type password Password123 into Password field
        driver.findElement(By.id("password")).sendKeys("Password123");
//    Click Submit button.
        driver.findElement(By.id("submit")).click();
//    Verify new page URL contains practicetestautomation.com/logged-in-successfully/
        String url= driver.getCurrentUrl();
        assertTrue(url.contains("practicetestautomation.com/logged-in-successfully/"));

//    Verify new page contains expected text ('Congratulations' or 'successfully logged in')
        String text= driver.findElement(By.tagName("strong")).getText();
        assertTrue(text.contains("Congratulations") || text.contains("successfully logged in"));
//    Verify button Log out is displayed on the new page.
        assertTrue(driver.findElement(By.linkText("Log out")).isDisplayed());

    }



}