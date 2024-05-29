package clarusway.tests;


import clarusway.utilities.ListenersUtils;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(ListenersUtils.class)//Listeners ve test classını bağlamanın birinci yolu.
public class C25_ListenersTest {

    @Test
    public void test01() {
        System.out.println("test01");
    }

    @Test
    public void test02() throws Exception {
        System.out.println("test02");
        throw new Exception();
    }

    @Test
    public void test03() {
        System.out.println("test03");
        throw new SkipException("Skipped");
    }

    @Test
    public void test04() {
        System.out.println("test04");
        assert false;
    }

    @Test
    public void test05() {
        System.out.println("test05");
    }


}