package clarusway.codeChallenge.day05;

import clarusway.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CH24 extends TestBase {

    /*
     //https://www.way2automation.com/angularjs-protractor/webtables/
     //tüm E-mail leri yazdırın
     //Tüm E-maillerin "@" işareti içerdiğini doğrulayin
     */

    @Test
    public void test() {

        //https://www.way2automation.com/angularjs-protractor/webtables/
        driver.get("https://www.way2automation.com/angularjs-protractor/webtables/");

        //tüm E-mail leri yazdırın
        //Tüm E-maillerin "@" işareti içerdiğini doğrulayin
        List<WebElement> emails = driver.findElements(By.xpath("//table//tbody//tr//td[7]"));

        for (int i = 0; i < emails.size(); i++) {
            System.out.println(emails.get(i).getText());
            Assert.assertTrue(emails.get(i).getText().contains("@"));
        }

    }
}
