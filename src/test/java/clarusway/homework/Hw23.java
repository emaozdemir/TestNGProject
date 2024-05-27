package clarusway.homework;

import clarusway.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.sort;


public class Hw23 extends TestBase {
    /*
       Find the height of the earliest built tower on this page:
       (Listedeki ilk inşa edilmiş kulenin uzunluğunu yazdırınız)
       https://www.techlistic.com/p/demo-selenium-practice.html
       Your code must be dynamic
       Run test with XML file
   */
    @Test
    void test01() {
//        Find the height of the earliest built tower on this page:
//        (Listedeki ilk inşa edilmiş kulenin uzunluğunu yazdırınız)
//        https://www.techlistic.com/p/demo-selenium-practice.html
//        Your code must be dynamic
//        Run test with XML file
        driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");
        WebElement table2 = driver.findElement(By.xpath("//table[@border=\"1\"]"));
        System.out.println(table2.getText());
        List<WebElement> c4 = table2.findElements(By.xpath(".//td[4]"));
       // Your code must be dynamic
        for (int i = 0; i < c4.size(); i++) {
            System.out.println(c4.get(i).getText());
        }

        String s=table2.findElement(By.xpath(".//tr[3]//td[3]")).getText();
        System.out.println("s = " + s);













    }

}
