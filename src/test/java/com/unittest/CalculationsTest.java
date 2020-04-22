package com.unittest;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculationsTest {

    @Test
    public void testAdd() {

        //GIVEN (Ön hazırık)
        Calculations calculations = new Calculations();
        int number1 = 5;
        int number2 = 19;

        //WHEN (metodu çalıştır)
        int sum = calculations.add(number1, number2);

        //THEN (sonucu kontrol et)
        assertEquals(24, sum);

        //Her test metodu içerisinde bir seneryo test edilebilir.
        //int sub = calculations.subtract(number1, number2);
        // Assert.assertEquals(-14, sub);
    }

    /* Eger metod içerisindeki Assert.assertEquals satırlarından biri  hata verirse
    diğer leri test edilmez bu nedenle  hepsini ayrı test metodlarına aldık.
    Aynı metod için farklı seneryolar  farklı test metodlarında test edilmelisir*/
    @Test
    public void testSubtract1() {

        Calculations calculations = new Calculations();
        assertEquals(15, calculations.subtract(15, 0));
        //Assert.assertEquals(-15, calculations.subtract(0, 15));
        //Assert.assertEquals(20, calculations.subtract(50, 30));
    }

    @Test
    public void testSubtract2() {

        Calculations calculations = new Calculations();
        assertEquals(-15, calculations.subtract(0, 15));
    }

    @Test
    public void testSubtract3() {

        Calculations calculations = new Calculations();
       assertEquals(20, calculations.subtract(50, 30));
    }
}
