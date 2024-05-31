package clarusway.codeChallenge.day05;


import clarusway.utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CH25 extends TestBase {


    /*
     https://bonigarcia.dev/selenium-webdriver-java/login-form.html adresine gidin
     "user", "user" icin "Login succesful"
     "bad-user", "bad-password" icin "Invalid credentials"
     sonuclarini DataProvider kullanarak login işlemini gerçekleştirin
     */


    @Test(dataProvider = "loginData")
    public void test(String userName, String password, String expectedText) {

        //https://bonigarcia.dev/selenium-webdriver-java/login-form.html adresine gidin
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/login-form.html");


        // sonuclarini DataProvider kullanarak login işlemini gerçekleştirin
        driver.findElement(By.id("username")).sendKeys(userName);
        driver.findElement(By.id("password")).sendKeys(password);

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // 1. YOL:
        String bodyText = driver.findElement(By.tagName("body")).getText();
        Assert.assertTrue(bodyText.contains(expectedText));

        // 2. YOL
        String actualText = driver.findElement(By.xpath("//div[contains(@class,'alert')]")).getText();
        System.out.println(actualText);

        Assert.assertEquals(actualText, expectedText);
    }

    @DataProvider(name = "loginData")
    public Object[][] loginData() {

        return new Object[][]{
                {"user", "user", "Login successful"},
                {"bad-user", "bad-password", "Invalid credentials"}
        };
    }

}
