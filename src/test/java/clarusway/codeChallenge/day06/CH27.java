package clarusway.codeChallenge.day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CH27 {
    /*
https://bonigarcia.dev/selenium-webdriver-java/ adresine gidin
farkli Browserlar icin,
Title'ın "Selenium WebDriver" icerdigini dogrulayin
USERNAME:user
PASSWORD:user
*/

    WebDriver driver;

    @DataProvider(name = "browsers")
    public static Object[][] data() {

        return new Object[][]{
                {"chrome"},
                {"edge"},
                {"firefox"}
        };
    }


    @Test(dataProvider = "browsers")
    public void test(String browserName) {

        driver = WebDriverManager.getInstance(browserName).create();
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");

        String actualTitle = driver.getTitle();

        Assert.assertTrue(actualTitle.contains("Selenium WebDriver"));

    }


}
