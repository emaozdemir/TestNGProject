package clarusway.codeChallenge.day05;


import clarusway.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CH23 extends TestBase {


    /*
     https://bonigarcia.dev/selenium-webdriver-java/shadow-dom.html adresine gidin
     body nin ve p taglı elementin "Hello Shadow DOM" icerdigini dogrulayin

     Kaynak: https://medium.com/@burak19956/selenium-webdriver-kullanarak-shadow-dom-larda-web-element-nas%C4%B1l-bulunur-b98aa90590d6
    */

    @Test
    public void test() {

        // https://bonigarcia.dev/selenium-webdriver-java/shadow-dom.html adresine gidin
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/shadow-dom.html");

        //     body nin ve p taglı elementin "Hello Shadow DOM" icerdigini dogrulayin
        WebElement content = driver.findElement(By.xpath("//div[@id='content']"));

        SearchContext shadow = content.getShadowRoot();

        WebElement title = shadow.findElement(By.cssSelector("p"));

        Assert.assertEquals(title.getText(), "Hello Shadow DOM");

    }
}
 