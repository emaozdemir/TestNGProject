package clarusway.homework;

import clarusway.utilities.DataProviderUtils;
import clarusway.utilities.ExcelUtils;
import clarusway.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;


public class Hw24 extends TestBase {
    //Write the sum of numbers in columns 'number1' and 'number2' into the 'sum' column using a loop.
    //'Sayı1' ve 'Sayı2' sütunlarındaki sayıların toplamını bir döngü kullanarak 'toplam' sütununa yazın.

    @Test()
    public void toplam(){
        String excelPath = "resources/Addition.xlsx";
        String sheetName = "Numbers"; // Replace with your actual sheet name
        ExcelUtils excelUtils = new ExcelUtils(excelPath, sheetName);
        // Get the column names
        List<String> columns = excelUtils.getColumnsNames();

        // Assuming columns are named 'number1' and 'number2', adjust if necessary
        int number1ColIndex = columns.indexOf("Number 1");
        int number2ColIndex = columns.indexOf("Number 2");
        int sumColIndex = columns.indexOf("sum");

        // Iterate through the rows and calculate the sum
        for (int i = 1; i < excelUtils.rowCount(); i++) {
            // Read the values from 'number1' and 'number2' columns
            String number1Str = excelUtils.getCellData(i, number1ColIndex);
            String number2Str = excelUtils.getCellData(i, number2ColIndex);

            // Convert the values to integers, handling possible non-numeric cells
            try {
                int number1 = Integer.parseInt(number1Str);
                int number2 = Integer.parseInt(number2Str);

                // Calculate the sum
                int sum = number1 + number2;

                // Write the sum into the 'sum' column
                excelUtils.setCellData(String.valueOf(sum),i, sumColIndex);
            } catch (NumberFormatException e) {
                // Handle the case where cell values are not numbers
                System.err.println("Non-numeric data in row " + i + ": " + e.getMessage());
            }
        }
    }

    }

