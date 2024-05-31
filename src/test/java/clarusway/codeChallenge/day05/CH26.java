package clarusway.codeChallenge.day05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CH26 {


    /*
     https://bonigarcia.dev/selenium-webdriver-java/navigation1.html adresine gidin
     1.sayfadaki body nin "Lorem ipsum" icerdigini
     2.sayfadaki body nin "Ut enim" icerdigini
     3.sayfadaki body nin "Excepteur sint" icerdigini dogrulayin

     NOT: Her sayfa icin ayri test methodu kullaniniz
          extent kullanma.......
     */

    WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
    }

    @Test(priority = 1)
    public void test01() {

        //     https://bonigarcia.dev/selenium-webdriver-java/navigation1.html adresine gidin
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/navigation1.html");

        //     1.sayfadaki body nin "Lorem ipsum" icerdigini
        assertBodyContains("Lorem ipsum");

    }

    @Test(priority = 3)
    public void test02() {

        // 2.sayfadaki body nin "Ut enim" icerdigini
        driver.findElement(By.linkText("2")).click();
        assertBodyContains("Ut enim");

    }

    @Test(priority = 2)
    public void test03() {
        // 3.sayfadaki body nin "Excepteur sint" icerdigini dogrulayin

        driver.findElement(By.linkText("3")).click();
        assertBodyContains("Excepteur sint");
    }


    public void assertBodyContains(String text) {
        String bodyText = driver.findElement(By.xpath("//p[@class='lead']")).getText();
        Assert.assertTrue(bodyText.contains(text));
    }

}
