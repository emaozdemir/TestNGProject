package clarusway.tests;

import clarusway.utilities.DataProviderUtils;
import clarusway.utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class C17_DataProviderExcel extends TestBase {

    @Test(dataProvider = "excelData", dataProviderClass = DataProviderUtils.class)
    public void excelTest01(String firstname, String password, String comment){

        System.out.println("firstname = " + firstname);
        System.out.println("password = " + password);
        System.out.println("comment = " + comment);
        System.out.println("------------");

    }

    @Test(dataProvider = "excelData", dataProviderClass = DataProviderUtils.class)
    public void excelTest02(String username, String password, String comment) throws InterruptedException {
//Go to https://testpages.eviltester.com/styled/basic-html-form-test.html
        driver.get("https://testpages.eviltester.com/styled/basic-html-form-test.html");

//Enter username
        driver.findElement(By.name("username")).sendKeys(username);
        Thread.sleep(1000);

//Enter password
        driver.findElement(By.name("password")).sendKeys(password);
        Thread.sleep(1000);

//Enter comment
        driver.findElement(By.name("comments")).clear();
        driver.findElement(By.name("comments")).sendKeys(comment);
        Thread.sleep(1000);

//Click submit
        driver.findElement(By.xpath("//input[@value='submit']")).click();

//Verify username
        String usernameText = driver.findElement(By.id("_valueusername")).getText();
        assertEquals(username, usernameText);

    }


    @Test(dataProvider = "registerData", dataProviderClass = DataProviderUtils.class)
    public void registerTest(String firstName, String lastName, String email, String password ){

        driver.get("https://thinking-tester-contact-list.herokuapp.com/");

        driver.findElement(By.id("signup")).click();

        driver.findElement(By.id("firstName")).sendKeys(firstName);
        driver.findElement(By.id("lastName")).sendKeys(lastName);
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(password);

    }




}
