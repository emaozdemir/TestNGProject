package clarusway.homework;

import clarusway.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.sort;
import static org.testng.AssertJUnit.assertEquals;


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



        System.out.println("idx = " + minIndex);

        //En düşük yılın indeksindeki yüksekliği alalım:
        String heightOfFirstBuiltTower = driver.findElements(By.xpath("(//tbody)[2]//td[3]")).get(minIndex).getText();
        System.out.println("heightOfFirstBuiltTower = " + heightOfFirstBuiltTower);

        assertEquals("509m", heightOfFirstBuiltTower);














    }

}

/*
    @Test
    public void towerHeight() {

        driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");

        //Yapılış yıllarını bir list içine alalım:
        List<WebElement> years = driver.findElements(By.xpath("(//tbody)[2]//td[4]"));

        //Minimum yılı hesplayalım:
        int minYear = Integer.parseInt(years.getFirst().getText());

        for (WebElement w : years) {

            if (Integer.parseInt(w.getText()) < minYear) {
                minYear = Integer.parseInt(w.getText());
            }

        }

        System.out.println("minYear = " + minYear);

        int idx = 0;

        for (WebElement w : years) {

            if (Integer.parseInt(w.getText()) == minYear) {
                break;
            }

            idx++;
        }

        System.out.println("idx = " + idx);

        //En düşük yılın indeksindeki yüksekliği alalım:
        String heightOfFirstBuiltTower = driver.findElements(By.xpath("(//tbody)[2]//td[3]")).get(idx).getText();
        System.out.println("heightOfFirstBuiltTower = " + heightOfFirstBuiltTower);

        assertEquals("509m", heightOfFirstBuiltTower);


    }

}
 */