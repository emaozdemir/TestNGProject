package clarusway.homework;

import clarusway.utilities.ExtentReportUtils;
import clarusway.utilities.TestBase;
import com.github.javafaker.Faker;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import static clarusway.utilities.JavascriptUtils.clickElementByJS;


public class Hw28 extends TestBase {
    /*
Go to https://automationexercise.com/
Create an account and delete it.
Create HTML report for each step with screenshots
https:automationexercise.com adresine gidin.
 Bir hesap oluşturun ve silin. Her adım için ekran görüntüleriyle HTML raporu oluşturun
 */

    @Test
    void createAndDeleteAccount() throws InterruptedException {
        ExtentReportUtils.createTestReport("Create Account Test", "Happy Path");
        driver.get("https://automationexercise.com/");
        driver.findElement(By.xpath("//a[@href='/login']")).click();
        ExtentReportUtils.passAndCaptureScreenshot("User is on the homepage");
        driver.findElement(By.xpath("//input[@data-qa='signup-name']")).sendKeys(Faker.instance().name().username() + Keys.ENTER);
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys(Faker.instance().internet().emailAddress() + Keys.ENTER);
        ExtentReportUtils.passAndCaptureScreenshot("User is on the signup/login page");
        // driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();

        //2.kısım
        driver.findElement(By.xpath("//input[@id='id_gender2']")).click();

        //driver.findElement(By.xpath("//input[@data-qa='name']")).sendKeys("semas" + Keys.ENTER);
        driver.findElement(By.xpath("//input[@data-qa='password']")).sendKeys(Faker.instance().internet().password() + Keys.ENTER);

        Select select = new Select(driver.findElement(By.xpath("//select[@data-qa='days']")));
        select.selectByIndex(4);
        Select select1 = new Select(driver.findElement(By.xpath("//select[@data-qa='months']")));
        select1.selectByIndex(4);
        Select select2 = new Select(driver.findElement(By.xpath("//select[@data-qa='years']")));
        select2.selectByValue("1990");

        driver.findElement(By.xpath("(//input[@value='1'])[1]")).click();
        driver.findElement(By.xpath("(//input[@value='1'])[2]")).click();
        driver.findElement(By.xpath("//input[@data-qa='first_name']")).sendKeys("sem" + Keys.ENTER);
        driver.findElement(By.xpath("//input[@data-qa='last_name']")).sendKeys("ozd" + Keys.ENTER);
        driver.findElement(By.xpath("//input[@data-qa='company']")).sendKeys("clarusw" + Keys.ENTER);
        driver.findElement(By.xpath("//input[@data-qa='address']")).sendKeys("sevilla" + Keys.ENTER);
        driver.findElement(By.xpath("//input[@data-qa='address2']")).sendKeys("spain" + Keys.ENTER);

        Select select3 = new Select(driver.findElement(By.xpath("//select[@data-qa='country']")));
        select3.selectByVisibleText("Canada");

        driver.findElement(By.xpath("//input[@data-qa='state']")).sendKeys(Faker.instance().address().state() + Keys.ENTER);
        driver.findElement(By.xpath("//input[@data-qa='city']")).sendKeys(Faker.instance().address().city() + Keys.ENTER);
        driver.findElement(By.xpath("//input[@data-qa='zipcode']")).sendKeys(Faker.instance().address().zipCode() + Keys.ENTER);
        driver.findElement(By.xpath("//input[@data-qa='mobile_number']")).sendKeys(Faker.instance().phoneNumber().cellPhone() + Keys.ENTER);
        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();
//        WebElement createButton = driver.findElement(By.xpath("//button[@data-qa='create-account']"));
//        clickElementByJS(createButton);
        ExtentReportUtils.passAndCaptureScreenshot("User created account in successfully");
        driver.findElement(By.linkText("Continue")).click();

        driver.findElement(By.xpath("//a[@href='/delete_account']")).click();
        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();

        ExtentReportUtils.passAndCaptureScreenshot("Account deleted!!!");
      //  ExtentReportUtils.createTestReport("Account has deleted","Create and delete task");

        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();

        ExtentReportUtils.flush();

    }



}