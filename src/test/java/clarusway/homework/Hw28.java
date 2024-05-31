package clarusway.homework;

import clarusway.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;


public class Hw28 extends TestBase {
    /*
Go to https://automationexercise.com/
Create an account and delete it.
Create HTML report for each step with screenshots
https:automationexercise.com adresine gidin.
 Bir hesap oluşturun ve silin. Her adım için ekran görüntüleriyle HTML raporu oluşturun
 */
    @Test
    void test01() throws InterruptedException {
        driver.get("https://automationexercise.com/");
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("sema@gmail.com");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@data-qa='login-password']")).sendKeys("sema123");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();

    }

}
