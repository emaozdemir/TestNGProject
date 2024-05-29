package clarusway.tests;


import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//Listeners ve test classını bağlamanın İKİNCİ YOLU XMLLEDİR.
//3.yol noteste ekran görüntüsü olarak bulunmakta .

public class C26_ListenersTestXML {
    @Test
    public void test01() {
        System.out.println("BLOCKER");
    }

    @Test
    public void test02() throws Exception {
        System.out.println("CRITICAL");
        throw new Exception();
    }

    @Test
    public void test03() {
        System.out.println("NORMAL");
        throw  new SkipException("Skipped");
    }

    @Test
    public void test04() {
        System.out.println("MINOR");
        assert false;
    }

    @Test
    public void test05() {
        System.out.println("TRIVIAL");
    }
}
