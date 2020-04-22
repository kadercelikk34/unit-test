package com.junit;

import org.junit.Ignore;
import org.junit.Test;

public class IgnoreTest {
    @Test
    public void testHello1() throws Exception{
        System.out.println("Hello1");

    }
    @Test
    @Ignore("Bu metod daha sonra kullanılacak")
    public void testHello2() throws Exception{
        System.out.println("Hello2");

    }
}
