package clarusway.tests;

import clarusway.utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.AssertJUnit.assertEquals;
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
        String url = driver.getCurrentUrl();
        assertTrue(url.contains("practicetestautomation.com/logged-in-successfully/"));

//    Verify new page contains expected text ('Congratulations' or 'successfully logged in')
        String text = driver.findElement(By.tagName("strong")).getText();
        assertTrue(text.contains("Congratulations ") || text.contains("successfully logged in "));
      //  assertEquals("Congratulations student. You successfully logged in!", text);
//    Verify button Log out is displayed on the new page.
        assertTrue(driver.findElement(By.linkText("Log out")).isDisplayed());

    }

    @Test
    public void test02Softla() {
        driver.get("https://practicetestautomation.com/practice-test-login/");
//    Type username student into Username field
        driver.findElement(By.id("username")).sendKeys("student");
//    Type password Password123 into Password field
        driver.findElement(By.id("password")).sendKeys("Password123");
//    Click Submit button.
        driver.findElement(By.id("submit")).click();
//    Verify new page URL contains practicetestautomation.com/logged-in-successfully/
        String url = driver.getCurrentUrl();

        //soft assertion için 1.adım
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(url.contains("Xpracticetestautomation.com/logged-in-successfully/"));

//    Verify new page contains expected text ('Congratulations' or 'successfully logged in')
        String text = driver.findElement(By.tagName("strong")).getText();
        softAssert.assertTrue(text.contains("XCongratulations") || text.contains("Xsuccessfully logged in"));

//    Verify button Log out is displayed on the new page.
        softAssert.assertTrue(!driver.findElement(By.linkText("Log out")).isDisplayed());
//son adim YAPTIĞIMIZ her yere hata bıraktık kalsın diye bu all sayesinde kalanı goreceğiz
        softAssert.assertAll();

    }


}