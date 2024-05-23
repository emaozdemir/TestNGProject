package clarusway.tests;

import clarusway.utilities.TestBase;
import org.testng.annotations.Test;

public class C08_DependsOnTest extends TestBase {

    @Test
    public void googleTest() {
        driver.get("https://google.com");
    }

    @Test(dependsOnMethods = "googleTest")
    public void linkedinTest() {
        driver.get("https://linkedin.com");
    }

    @Test(dependsOnMethods = {"linkedinTest", "googleTest"})
    public void claruswayTest() {
        driver.get("https://clarusway.com");
    }

}
