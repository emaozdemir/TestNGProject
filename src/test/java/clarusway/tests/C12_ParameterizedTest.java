package clarusway.tests;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class C12_ParameterizedTest {

    @Test
    @Parameters("name")
//XML dosyasında belirtilen name parametresine girilen değer test classında kullanılır. Testin XML ile çalıştırılması gerekir.
    void parameterizedTest(@Optional("Mary") String name) {
        System.out.println(name);
    }

    @Test
    @Parameters({"name", "lastname", "age"})
//@Optional olarak belirtilen değerler, paramtere atanmadığı durumlarda default değer olarak kullanılır.
    void parameterizedTest(@Optional("Terry") String name, @Optional("Doe") String lastname, @Optional("25") String age) {
        System.out.println(name + " " + lastname + " " + age);
    }


}
