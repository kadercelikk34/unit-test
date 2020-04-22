package com.junit;

import org.junit.*;

public class LifeCycleTest {
    //BeforeClass ve AfterClass  Class metodları olduğu için static metodlardır.Static yapmazsak hata alırız
    @BeforeClass
    public static void beforeCls(){
        System.out.println("Every test class Before");
    }

    @AfterClass
    public static void afterCls(){
        System.out.println("Every test class After");
    }

    @Before
    public void tearDown(){
        System.out.println("Metod Before");
    }

    @After
    public void setUp(){
        System.out.println("Metod After");
    }

    @Test
    public void testHelloWorld1(){
        System.out.println("Test Hello World1");
    }

    @Test
    public void testHelloWorld2(){
        System.out.println("Test Hello World2");

    }

}
