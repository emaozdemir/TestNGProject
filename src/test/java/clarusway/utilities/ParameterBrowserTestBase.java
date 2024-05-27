package clarusway.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class ParameterBrowserTestBase {

    protected static WebDriver driver;

    @BeforeMethod
    @Parameters("browser")//her defa elle browserı değiştirmemek için methodumuza parametre olarak ekledik
    public void setUp(@Optional("chrome")String browser){
        //@Optional("chrome") : browser parametresi belirtilmezse default olarak chrome kullanılır
        if(driver == null) {
            switch (browser) {
                case "chrome":
                    driver = new ChromeDriver();
                    break;

                case "firefox":
                    driver = new FirefoxDriver();
                    break;

                case "edge":
                    driver = new EdgeDriver();
                    break;
            }
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
