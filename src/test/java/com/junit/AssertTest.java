package com.junit;

import org.junit.Test;

import static org.junit.Assert.*;

public class AssertTest {

    @Test
    public void testAssertions() throws Exception{
        Dummy d1 = new Dummy(5);
        Dummy d2 = new Dummy(5);

        //Dummy class içerisinde equals ile kontrol ediliyor iksinde aynı nesnemi diye
        //assertEquals(d1,d2);
        //İki nesnenin aynı olup olmadığını equals bakmaksızın kontrol eder. Dummy d2 = d1 yaparsak  iki nesnede aynı olur.

        //assertSame(d1,d2);
        //Kendi hata mesajımızı da yazabliriz
        //assertSame("d1 in d2 ye eşit olması gerekli",d1,d2);

        //Verilen nesnenin null olup olmadığını test eder.
        assertNull(d1);

        //Tam tersi null olmadığını test eder.
        assertNotNull(d1);

        //Doğru olup olmadığını kontrol eder ,içerisinde istediğinizi yazabilirsiniz.
        assertTrue(d1.getId() == 5);
        assertTrue(d1.equals(d2));


        //assertTrue nun tam tersidir.
        assertFalse(d1.equals(d2));

        //verilen iki array nesnesinin eşit olup olmadığını kontrol eder.
        String[] arr1 = new String[]{"1","2"};
        String[] arr2 = new String[]{"1","2"};
        assertArrayEquals(arr1, arr2);




    }
    private static class Dummy{
        private int id;

        public int getId() {
            return id;
        }

        public Dummy(int id) {
            this.id = id;
        }

        /*@Override
        public boolean equals(Object obj) {
            return  this.id == ((Dummy) obj).getId();
        }*/
    }

}
