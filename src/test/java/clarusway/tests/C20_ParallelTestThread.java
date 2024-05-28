package clarusway.tests;

import org.testng.annotations.Test;

public class C20_ParallelTestThread {

    @Test
    void test01() {
        System.out.println("Thread ID: " + Thread.currentThread().threadId());
        System.out.println("Test 01");
    }

    @Test
    void test02() {
        System.out.println("Thread ID: " + Thread.currentThread().threadId());
        System.out.println("Test 02");
    }

    @Test
    void test03() {
        System.out.println("Thread ID: " + Thread.currentThread().threadId());
        System.out.println("Test 03");
    }

    @Test
    void test04() {
        System.out.println("Thread ID: " + Thread.currentThread().threadId());
        System.out.println("Test 04");
    }

    @Test
    void test05() {
        System.out.println("Thread ID: " + Thread.currentThread().threadId());
        System.out.println("Test 03");
    }


}