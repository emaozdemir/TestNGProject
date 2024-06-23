package clarusway.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class C21_ParallelTestWithParameters {

    @Test(threadPoolSize = 3, invocationCount = 15)
    void test01() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
        assert driver.getTitle().contains("Google");
        driver.quit();
    }

}