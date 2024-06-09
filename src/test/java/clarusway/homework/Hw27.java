package clarusway.homework;

import clarusway.utilities.DataProviderUtils;
import clarusway.utilities.ExcelUtils;
import clarusway.utilities.ParameterBrowserTestBase;
import clarusway.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;


public class Hw27 extends ParameterBrowserTestBase {
    /*
   Go to https://testpages.eviltester.com/styled/apps/notes/simplenotes.html
   Add 10 notes using data provider with excel
   Run it with 3 different browsers using XML file
   Run it parallel with 3 threads
   https:testpages.eviltester.comstyledappsnotessimplenotes.html adresine gidin Excel ile veri sağlayıcıyı
   kullanarak 10 not ekleyin XML dosyasını kullanarak 3 farklı tarayıcıyla çalıştırın
   3 iş parçacığıyla paralel çalıştırın
    */
    // DataProvider metodu
    @DataProvider
    public String[][] titleNotes() {
        ExcelUtils excelUtils = new ExcelUtils("resources/username_password.xlsx", "Sheet2");
        return excelUtils.getDataArrayWithoutFirstRow();
    }

    @Test(dataProvider = "titleNotes")
    public void dataProviderHW(String title, String note) throws InterruptedException {
        // Belirtilen URL'ye git
        driver.get("https://testpages.eviltester.com/styled/apps/notes/simplenotes.html");

        // Başlık gir
        driver.findElement(By.id("note-title-input")).sendKeys(title);

        // Not gir
        driver.findElement(By.id("note-details-input")).sendKeys(note);

        // Ekle düğmesine tıkla
        driver.findElement(By.id("add-note")).click();

        // Kısa bir süre bekle (Thread.sleep yerine WebDriverWait kullanılması önerilir)
        Thread.sleep(500);
    }
}