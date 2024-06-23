package clarusway.tests;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class C19_ParallelTest {

    @Test
   // @Severity(SeverityLevel.CRITICAL)
    void test01() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
        assert driver.getTitle().contains("Google");
        driver.quit();
    }

    @Test
    void test02() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://linkedin.com");
        assert driver.getTitle().contains("LinkedIn");
        driver.quit();
    }

    @Test
    void test03() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://clarusway.com");
        assert driver.getTitle().contains("Bootcamp");
        driver.quit();
    }

    @Test
    void test04() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://facebook.com");
        assert driver.getTitle().contains("Facebook");
        driver.quit();
    }

    @Test
    void test05() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://instagram.com");
        assert driver.getTitle().contains("Instagram");
        driver.quit();
    }

}