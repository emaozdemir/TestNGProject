package clarusway.tests;

import clarusway.utilities.JavascriptUtils;
import clarusway.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class C29_ReusableMethods extends TestBase {

    @Test
    void reusableMethodsTest() {

        driver.get("https://practicetestautomation.com/practice-test-login/");

        WebElement username = driver.findElement(By.id("username"));

        JavascriptUtils.flash(username, "green");

        username.sendKeys("student");

        WebElement password = driver.findElement(By.id("password"));

        JavascriptUtils.flash(password, "green");

        password.sendKeys("Password123");

        WebElement submit = driver.findElement(By.id("submit"));

        JavascriptUtils.flash(submit, "green");

        submit.click();

        WebElement logout = driver.findElement(By.linkText("Log out"));

        JavascriptUtils.flash(logout, "green");

        assert logout.isDisplayed();

    }

}
