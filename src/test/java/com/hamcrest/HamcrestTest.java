package com.hamcrest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class HamcrestTest {
    @Test
    public void testBasicPairings() throws Exception{
        String text1 = "Baris";
        String text2 = "Baris2";

        assertEquals("Baris",text1);
        //is okumayı kolaylaştırır.is zorunlu değildir.
        assertThat(text1,is(equalTo("Baris")));
        assertThat(text1,is(notNullValue()));
        assertThat(text1, containsString("ris"));
        //or  kontrolu yapar , ,çeriisnde ris veya Bar varmı diye bakılır
        assertThat(text1, anyOf(containsString("ris"), containsString("Bar")));
    }
    @Test
    public void testLists() throws Exception{

        List<String> citys = new ArrayList<String>(Arrays.asList("Istanbul","Ankara", "Izmir"));

        //liste içerisinde İstanbul varmı
        assertThat(citys, hasItem("Istanbul"));

        //liste içinde hem İstanbul hem İzmir varmı diye bakılır.
        assertThat(citys, hasItems("Istanbul", "Izmir"));

        //listemde İstanbul ve İzmir olsun ama Bursa olmasın ;
        // allOf():verilen eşlştirmelerin hepsi doğru olmalı. AND AND
        assertThat(citys,allOf( hasItems("Istanbul", "Ankara"),not(hasItem("Bursa")) ));

        //either or (ya şu olsun yada bu olsun)
        assertThat(citys,either( hasItems("Istanbul", "Ankara")).or(not(hasItem("Bursa"))) );



    }
}
