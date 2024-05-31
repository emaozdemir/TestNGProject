package clarusway.homework;

import clarusway.utilities.DataProviderUtils;
import clarusway.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;


public class Hw27 extends TestBase {
 /*
Go to https://testpages.eviltester.com/styled/apps/notes/simplenotes.html
Add 10 notes using data provider with excel
Run it with 3 different browsers using XML file
Run it parallel with 3 threads
https:testpages.eviltester.comstyledappsnotessimplenotes.html adresine gidin Excel ile veri sağlayıcıyı
kullanarak 10 not ekleyin XML dosyasını kullanarak 3 farklı tarayıcıyla çalıştırın
3 iş parçacığıyla paralel çalıştırın
 */

    @Test(dataProvider = "usernamePassword",dataProviderClass = DataProviderUtils.class )
    void parameterizedTest(String username, String password) {

//Go to https://testpages.eviltester.com/styled/basic-html-form-test.html
        driver.get("https://testpages.eviltester.com/styled/basic-html-form-test.html");

//Enter username
        driver.findElement(By.name("username")).sendKeys(username);

//Enter password
        driver.findElement(By.name("password")).sendKeys(password);

//Click submit
        driver.findElement(By.xpath("//input[@value='submit']")).click();

//Verify username
        String usernameText = driver.findElement(By.id("_valueusername")).getText();
        assertEquals(username, usernameText);

    }
}
