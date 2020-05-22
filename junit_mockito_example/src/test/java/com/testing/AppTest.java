package com.testing;


import org.junit.jupiter.api.*;

public class AppTest {

    @BeforeAll
    static void setup() {
        System.out.println("@BeforeAll executed");
    }

    @BeforeEach
    void setUpThis() {
        System.out.println("@BeforeEach executed");
    }

    @Test
    void testCalOne() {
        System.out.println("======TEST ONE EXECUTED=======");
        Assertions.assertEquals(4,Calculator.add(2,2));
    }

    @Disabled
    @Test
    void testCalTwo() {
        System.out.println("======TEST Two EXECUTED=======");
        Assertions.assertEquals(6,Calculator.add(2,4));
    }

    @AfterEach
    void tearDownThis() {

        System.out.println("@AfterEach executed");
    }

    @AfterAll
    static void tear() {
        System.out.println("@AfterAll executed");
    }
}
