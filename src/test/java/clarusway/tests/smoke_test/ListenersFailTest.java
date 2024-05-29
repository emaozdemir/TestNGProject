package clarusway.tests.smoke_test;

import clarusway.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ListenersFailTest extends TestBase {


    @Test
    public void positiveLoginTest(){

        driver.get("https://thinking-tester-contact-list.herokuapp.com/");

        driver.findElement(By.id("email")).sendKeys("xyz@hotmail.com");

        driver.findElement(By.id("password")).sendKeys("Clarusway.123");

        driver.findElement(By.id("submit")).click();

        WebElement addContact = driver.findElement(By.id("add-contact"));

        assert addContact.isDisplayed();

    }

}