package clarusway.tests;

import org.testng.annotations.Test;

public class C02_Priority {
/*
        - Test annotationlara öncelik verilmesine yardımcı olurken, varsayılan öncelik 0 ile başlar ve testler artan sırada yürütülür.
        - Test annotationda herhangi bir priority attribute yoksa priority sıfır kabul edilir.
        - TestNG (default) olarak @Test annotationları alfabetik sıraya göre execute eder.
*/

    @Test(priority = 5)
    public void test01() {
        System.out.println("Test 01");
    }

    @Test
    public void test02() {
        System.out.println("Test 02");
    }

    @Test(priority = 1)
    public void test03() {
        System.out.println("Test 03");
    }

    @Test(priority = -2)//-2 diğerlerinden daha küçük olduğu için ilk çalışır
    public void test04() {
        System.out.println("Test 04");
    }

    @Test(priority = 3)
    public void test05() {
        System.out.println("Test 05");
    }


}
