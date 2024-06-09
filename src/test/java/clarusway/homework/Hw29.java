package clarusway.homework;

import clarusway.utilities.TestBase;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class Hw29 extends TestBase {
    /*
Go to https://testpages.eviltester.com/styled/dynamic-buttons-simple.html
Click buttons to see message 'All Buttons Clicked!
Use Allure reports and listeners
https:testpages.eviltester.comstyleddynamic-buttons-simple.html adresine gidin 'Tüm Düğmeler Tıklandı!'
mesajını görmek için düğmelere tıklayın! Allure raporlarını ve dinleyicilerini kullanma
 */
  //@Listeners(ListenersUtils.class)//Listeners ve test classını bağlamanın birinci yolu. ama ben 2.yolla yaptım xml le.
    @Test
    public void test01() throws InterruptedException {
        driver.get("https://testpages.eviltester.com/styled/dynamic-buttons-simple.html");

        String[] buttonIds = {"button00", "button01", "button02", "button03"};

        for (String id : buttonIds) {
            driver.findElement(By.id(id)).click();
        }


        String message = driver.findElement(By.id("buttonmessage")).getText();
        Assert.assertTrue(message.contains("All Buttons Clicked"));
    }
    @Test
    public void test02() {//calistiramadım
        driver.get("https://testpages.eviltester.com/styled/dynamic-buttons-simple.html");


        driver.findElement(By.id("button00")).click();


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> buttons = driver.findElements(By.xpath("//div[@id='buttons']/button"));
        for (WebElement button : buttons) {
            wait.until(ExpectedConditions.elementToBeClickable(button)).click();
        }

        WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buttonmessage")));
        String message = messageElement.getText();
        Assert.assertTrue(message.contains("All Buttons Clicked!"));
    }
}
