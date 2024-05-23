package clarusway.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.AssertJUnit.*;

public class C09_Assertions {

    //Not: Hard Assert daha çok tercih edilir. Çünkü fail durumunda hemen müdehale etmek gerekir.

    //Hard Assertion -> Ilk fail olan assertion'da çalışma durur
    @Test
    void hardAssertionTest(){

        assertTrue(1<2);//Burada oluşacak bir fail diğer assertionların çalışmayacağı anlamına gelir.

        assertEquals(1, 1);

        assertFalse(1>2);

    }

    //Soft Assertion -> Fail durumunda çalışma durmaz son kısımdaki assertAll() methoduna kadar çalışır.
    @Test
    void softAssertionTest(){
        //Soft assertion adımları:
        //1. Adım: SoftAssert objesi oluştur:
        SoftAssert softAssert = new SoftAssert();

        //2. Adım: Assert yap:
        softAssert.assertEquals(12,1);
        softAssert.assertEquals("XHello","Hello");
        softAssert.assertTrue(1>2);
        softAssert.assertTrue(1<2);

        //3. Adım: assertAll() methodunu kullan
        softAssert.assertAll();
        System.out.println("Bu print fail varsa çalışmaz. Çünkü execution asserAll() methodunda durur.");

    }

}
