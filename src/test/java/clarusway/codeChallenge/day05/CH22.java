package clarusway.codeChallenge.day05;


import clarusway.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CH22 extends TestBase {

     /*
    "https://bonigarcia.dev/selenium-webdriver-java/web-form.html" sayfasina gidin
    tempfiles.tmp şeklinde bir dosya oluşturun
    File Input altındaki Dosya Seç kısmına ekleyin
    Submit butonuna tıklayın
    Form submitted
    Received! yazısını doğrulayın
    */

    // NOT: tag'i input type="file" olanlarda dosya yolunu sendKeys() yapip, bu sekildede dosyayi gonderebiliyoruz. Degilse robot class kullanilabilir.

    @Test
    public void test() throws IOException {

        //    "https://bonigarcia.dev/selenium-webdriver-java/web-form.html" sayfasina gidin
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");

        //    tempfiles.tmp şeklinde bir dosya oluşturun
        Path tempFile = Files.createTempFile("tempfiles", ".tmp");
        String path = tempFile.toAbsolutePath().toString();

        // System.out.println("path = " + path);

        //    File Input altındaki Dosya Seç kısmına ekleyin
        WebElement input = driver.findElement(By.xpath("//input[@type='file']"));
        input.sendKeys(path);

        //    Submit butonuna tıklayın
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();

        //    Form submitted
        //    Received! yazısını doğrulayın
        String actualText = driver.findElement(By.xpath("//p[@class=\"lead\"]")).getText();
        String expectedText = "Received!";

        Assert.assertEquals(actualText, expectedText);


    }
}
