package clarusway.homework;

import clarusway.utilities.TestBase;
import org.testng.annotations.Test;

public class Hw22 extends TestBase {
       /*
	Create tests that depend on each other
	Create beforeClass and set up settings.
	By creating interdependent tests;
	First go to Facebook.
	Then go to Google depending on Facebook,
	Then go to Clarusway depending on Google
	Close the driver.

*/

    //Create tests that depend on each other
    @Test
    void facebookGo() throws Exception {
        driver.get("http://www.facebook.com");

    }

    @Test(dependsOnMethods = "facebookGo")
    void googleGo() {
        driver.get("http://www.google.com");
    }

    @Test(dependsOnMethods = {"googleGo","facebookGo"})
    void claruswayGo() {
        driver.get("http://www.clarusway.com");
    }

    //Create beforeClass and set up settings.
    //extends yaptım


}

