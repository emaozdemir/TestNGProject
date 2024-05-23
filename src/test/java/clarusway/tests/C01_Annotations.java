package clarusway.tests;

import org.testng.annotations.*;

public class C01_Annotations {
/*
    @BeforeSuite-@AfterSuite : Bu projedeki tüm testlerden önce/sonra çalışır.Sadece bir kere çalışır.
    @BeforeTest-@AfterTest :Tüm test methodlarından önce/sonra çalışır.Sadece bir kere çalışır.
    @BeforeClass-@AfterClass : Bir test sınıfındaki tüm test yöntemlerinden önce/sonra çalışır.Sadece bir kere çalışır.
    @BeforeGroups-@AfterGroups :Herhangi belirli test grubundan önce/sonra çalışır.Sadece bir kere çalışır.
    @BeforeMethod-@AfterMethod :Her test methodundan önce/sonra çalışır
 */

 /*
    Create a class.
    Create 3 test methods.
    Use TestNG annotations that can be used in the class.
    Interpret output in console.
 */

    @BeforeSuite
    public void beforeSuit() {
        System.out.println("@BeforeSuite");
    }

    @AfterSuite
    public void afterSuit() {
        System.out.println("@AfterSuite");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("@BeforeTest");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("@AfterTest");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("@BeforeClass");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("@AfterClass");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("@BeforeMethod");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("@AfterMethod");
    }


    @Test
    public void test01() {
        System.out.println("Test 01");
    }

    @Test
    public void test02() {
        System.out.println("Test 02");
    }

    @Test
    public void test03() {
        System.out.println("Test 03");
    }

    /*
@BeforeSuite
@BeforeTest
@BeforeClass
@BeforeMethod
@Test
@AfterMethod
@AfterClass
@AfterTest
@AfterSuite
     */


}