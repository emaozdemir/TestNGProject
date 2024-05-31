package clarusway.codeChallenge.day05;


import clarusway.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.invoke.MethodHandles.lookup;
import static java.util.logging.Logger.getLogger;

import java.util.logging.Logger;


public class CH21 extends TestBase {

    /*
    1. https://bonigarcia.dev/selenium-webdriver-java/web-form.html adresine gidin.
    2. Slider'in başlangıç değerini kaydet
    3. Slider'i 5 birim sağa hareket ettirin.
    4. Slider'in son değerini kaydedin.
    5. endValue-initValue==5 oldugunu dogrulayin
    */

    static final Logger log = getLogger(String.valueOf(lookup().lookupClass()));

    @Test
    public void test() throws InterruptedException {

        //    1. https://bonigarcia.dev/selenium-webdriver-java/web-form.html adresine gidin.
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
        log.info("user go to url");

        //    2. Slider'in başlangıç değerini kaydet
        WebElement slider = driver.findElement(By.xpath("//input[@name='my-range']"));
        String ilkValue = slider.getAttribute("value");
        log.info(" ilk slider value degeri: " + ilkValue);

        //    3. Slider'i 5 birim sağa hareket ettirin.
        Thread.sleep(3000);

        for (int i = 0; i < 5; i++) {
            slider.sendKeys(Keys.ARROW_RIGHT);
        }
        log.info("slider 5 birim saga hareket ettirildi");

        //    4. Slider'in son değerini kaydedin.
        String sonValue = slider.getAttribute("value");
        log.info(" son slider value degeri: " + sonValue);

        //    5. endValue-initValue==5 oldugunu dogrulayin
        Assert.assertEquals(Integer.parseInt(sonValue) - Integer.parseInt(ilkValue), 5);
        log.info("Slider Testi Bitti");

    }

}
