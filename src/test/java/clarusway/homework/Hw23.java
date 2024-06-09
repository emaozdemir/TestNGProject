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
        driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");
      List<WebElement> builtDate = driver.findElements(By.xpath("//table[@class='tsc_table_s13']//tr//td[4]"));

       // Your code must be dynamic
        int minValue=Integer.MAX_VALUE;
        int minIndex=-1;
        for (int i = 0; i < builtDate.size(); i++) {
           // System.out.println(builtDate.get(i).getText());
            int value=Integer.parseInt(builtDate.get(i).getText());
            if(value<minValue){
                minValue=value;
                minIndex=i;
            }
        }


        List<WebElement> builtHeight =driver.findElements(By.xpath("//table[@class='tsc_table_s13']//tr//th[1]"));//yuksekliği istiyor ?
        System.out.println(builtHeight.get(minIndex+2).getText());














    }

}
