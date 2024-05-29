package clarusway.tests.smoke_test;

import clarusway.utilities.ExtentReportUtils;
import clarusway.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class NegativeLoginTest extends TestBase {
    @Test
    public void negativeLoginTest() throws InterruptedException {

        ExtentReportUtils.createTestReport("Negative Test","Wrong email");

        ExtentReportUtils.info("user goes to homepage");

        driver.get("https://thinking-tester-contact-list.herokuapp.com/");
        ExtentReportUtils.pass("user is on the homepage");

        driver.findElement(By.id("email")).sendKeys("clarusway1@hotmail.com");
        ExtentReportUtils.passAndCaptureScreenshot("user entered email");
        driver.findElement(By.id("password")).sendKeys("Clarusway.123");
        ExtentReportUtils.passAndCaptureScreenshot("user entered password");
        driver.findElement(By.id("submit")).click();
        ExtentReportUtils.pass("user clicked on submit");
        Thread.sleep(200);//yerine implicity yapabiliriz

        WebElement negatifMessage = driver.findElement(By.id("error"));
        assertTrue(negatifMessage.isDisplayed());
        ExtentReportUtils.passAndCaptureScreenshot("user gets error message");
       // assert negatifMessage.isDisplayed();
        ExtentReportUtils.flush();
    }
}
