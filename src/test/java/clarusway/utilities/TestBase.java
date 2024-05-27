package clarusway.utilities;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public abstract class TestBase {//Classı abstract yaparak bu classtan obje oluşturulmasını engelliyoruz.

    protected WebDriver driver;


    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//Web elementin yüklenip bulunması için 10 saniyeye kadar bekler. NoSuchElementException atar.
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }



    //Bu method web element olarak girilen web table'ın belirtilen satırının belirtilen sütunun String olarak döner.
    public String getTableCell(WebElement element, int row, int column) {

        return element.findElement(By.xpath(".//tr[" + row + "]/td[" + column + "]")).getText();

    }



    //Bu method arguman olarak girilen By objesinin görünür olmasını 10 saniye bekler ve locate ederek o elementi döner.
    // Bulamaz ve zaman dolarsa TimeOutException atar.
    public WebElement waitAndLocate(By by){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        return  wait.until(ExpectedConditions.visibilityOfElementLocated(by));

    }


}
