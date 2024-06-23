package clarusway.homework;

import clarusway.utilities.DataProviderUtils;
import clarusway.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;


public class Hw26 extends TestBase {
    //Create 5 users by using Data Provider on https://thinking-tester-contact-list.herokuapp.com/addUser
    //https:thinking-tester-contact-list.herokuapp.comaddUser adresindeki Veri Sağlayıcıyı kullanarak 5 kullanıcı oluşturun
    @Test(dataProvider = "usernamePasswordFaker2", dataProviderClass = DataProviderUtils.class)
    void test01(String firstName, String lastName, String email,String password) throws InterruptedException {

//Go to https://thinking-tester-contact-list.herokuapp.com/addUser
        driver.get("https://thinking-tester-contact-list.herokuapp.com/addUser");


        driver.findElement(By.id("firstName")).sendKeys(firstName);
        Thread.sleep(2000);


        driver.findElement(By.id("lastName")).sendKeys(lastName);
        Thread.sleep(2000);


        driver.findElement(By.id("email")).sendKeys(email);
        Thread.sleep(2000);
        driver.findElement(By.id("password")).sendKeys(password);
        Thread.sleep(2000);


        driver.findElement(By.id("submit")).click();

        String logout = driver.findElement(By.id("logout")).getText();
        Thread.sleep(2000);
//        assertEquals("Logout", logout);

    }
}
