package clarusway.tests.smoke_test;

import clarusway.utilities.ExtentReportUtils;
import clarusway.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class PositiveLoginTest extends TestBase {


    @Test
    public void positiveLoginTest(){

        ExtentReportUtils.createTestReport("Postive Test", "Happy Path");

        driver.get("https://thinking-tester-contact-list.herokuapp.com/");
        ExtentReportUtils.passAndCaptureScreenshot("User is on the homepage");

        driver.findElement(By.id("email")).sendKeys("clarusway@hotmail.com");
        ExtentReportUtils.passAndCaptureScreenshot("User entered email");

        driver.findElement(By.id("password")).sendKeys("Clarusway.123");
        ExtentReportUtils.passAndCaptureScreenshot("User entered password");

        driver.findElement(By.id("submit")).click();
        ExtentReportUtils.passAndCaptureScreenshot("User clickec on submit");

        WebElement addContact = driver.findElement(By.id("add-contact"));
        assert addContact.isDisplayed();

        ExtentReportUtils.passAndCaptureScreenshot("User signed in successfully");
        //ExtentReportUtils.flush();

    }
}