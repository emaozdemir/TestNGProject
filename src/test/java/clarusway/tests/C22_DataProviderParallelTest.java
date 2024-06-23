package clarusway.tests;

import clarusway.utilities.DataProviderUtils;
import clarusway.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class C22_DataProviderParallelTest {
    /*
    XML dosyası ile çalıştırırsak belirttiğimiz thread count sayısı çalışır.
    Test class'ından çalıştırırsak Data provider içinde bulunan element sayısı kadar thread count çalışır.
     */

    @Test(dataProvider = "fakerParallel", dataProviderClass = DataProviderUtils.class)
    void parameterizedTest(String username, String password, String comment) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

//Go to https://testpages.eviltester.com/styled/basic-html-form-test.html
        driver.get("https://testpages.eviltester.com/styled/basic-html-form-test.html");

//Enter username
        driver.findElement(By.name("username")).sendKeys(username);
        Thread.sleep(500);

//Enter password
        driver.findElement(By.name("password")).sendKeys(password);
        Thread.sleep(500);

//Enter comment
        driver.findElement(By.name("comments")).clear();
        driver.findElement(By.name("comments")).sendKeys(comment);
        Thread.sleep(500);

//Click submit
        driver.findElement(By.xpath("//input[@value='submit']")).click();

//Verify username
        String usernameText = driver.findElement(By.id("_valueusername")).getText();
        assertEquals(username, usernameText);

        driver.quit();

    }


}