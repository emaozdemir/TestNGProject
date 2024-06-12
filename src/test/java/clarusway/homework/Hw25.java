package clarusway.homework;

import clarusway.utilities.ExcelUtils;
import clarusway.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Hw25 extends TestBase {
    //Place the winners of the World Cup and the European Cup in two separate maps with their years.
    //Dünya Kupası ve Avrupa Kupasını kazananları yıllarıyla birlikte iki ayrı haritaya yerleştirin.
    @Test()
    public void test01() {
        String excelPath = "resources/CupWinners.xlsx";
        String sheetName = "WorldCup";
        ExcelUtils excelUtils = new ExcelUtils(excelPath, sheetName);
        Map<Integer, String> worldCupWinners = new HashMap<>();
        List<Map<String, String>> worldCupData = excelUtils.getDataList();

        // Dünya Kupası verilerini Map'e yerleştir
        for (Map<String, String> data : worldCupData) {
            int year = Integer.parseInt(data.get("Year"));
            String winner = data.get("Winner");
            worldCupWinners.put(year, winner);
        }

        // Test amaçlı Map'i yazdır (İsteğe bağlı)
        System.out.println("World Cup Winners: " + worldCupWinners);
    }

    @Test
    public void testEuropeanCupWinners() {
        // Excel dosyasının yolu ve sayfa adı
        String excelPath = "resources/CupWinners.xlsx";
        String sheetName = "EuropeanCup";

        // Avrupa Kupası kazananlarını saklayacak bir Map oluştur
        ExcelUtils excelUtils = new ExcelUtils(excelPath, sheetName);
        Map<Integer, String> europeanCupWinners = new HashMap<>();
        List<Map<String, String>> europeanCupData = excelUtils.getDataList();

        // Avrupa Kupası verilerini Map'e yerleştir
        for (Map<String, String> data : europeanCupData) {
            int year = Integer.parseInt(data.get("Year"));
            String winner = data.get("Winner");
            europeanCupWinners.put(year, winner);
        }

        // Test amaçlı Map'i yazdır (İsteğe bağlı)
        System.out.println("European Cup Winners: " + europeanCupWinners);
    }
}

/*
yasin hoca
public class P03_CupWinners {
    //Place the winners of the World Cup and the European Cup in two separate maps with their years.
    @Test
    public void cupWinnersTest() throws IOException {

        FileInputStream fileInputStream = new FileInputStream("resources/CupWinners.xlsx");

        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet worldCup = workbook.getSheet("WorldCup");
        Map<String, String> worldCupMap = new TreeMap<>();

        for (int i = 1; i <= worldCup.getLastRowNum(); i++) {
            String year = worldCup.getRow(i).getCell(0).toString().substring(0, 4);
            String country = worldCup.getRow(i).getCell(1).toString();

            worldCupMap.put(year, country);

        }

        System.out.println(worldCupMap);

        System.out.println("=====================");

        Sheet europeanCup = workbook.getSheet("EuropeanCup");
        Map<String, String> europeanCupMap = new TreeMap<>();

        for (int i = 1; i <= europeanCup.getLastRowNum(); i++) {
            String year = europeanCup.getRow(i).getCell(0).toString().substring(0, 4);
            String country = europeanCup.getRow(i).getCell(1).toString();

            europeanCupMap.put(year, country);

        }

        System.out.println(europeanCupMap);

    }
}
 */