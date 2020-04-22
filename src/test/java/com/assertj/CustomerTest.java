package com.assertj;

import org.assertj.core.api.Condition;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomerTest {

    List<String> turkishCitiesList= new ArrayList<String>(Arrays.asList("Istanbul","Ankara","Izmir"));
    List<String> abroadCitiesList= new ArrayList<String>(Arrays.asList("Amsterdam","Paris","Londra"));

    @Test
    public void testStrings() throws Exception{

        String text1 = "Istanbul";
        //her eşleştirmeyi yeni bir satırda yazmaya çalışın daha okunaklı olur.
        assertThat(text1)
                .describedAs("bu bir hata")
                .isEqualTo("Istanbul")
                .startsWith("Ist")
                .endsWith("bul")
                .contains("tan")
                .isNotEmpty()
                .isNotNull()
                .doesNotContain("kader")
                .containsOnlyOnce("tan");
    }
    @Test
    public void testLists() throws Exception{
        List<String> city= new ArrayList<String>(Arrays.asList("Istanbul","Ankara","Izmir"));
        assertThat(city)
                .describedAs("bu bir hata ")
                .contains("Ankara")
                .doesNotContain("Bursa")
                .contains("Istanbul","Ankara","Izmir")
                .doesNotHaveDuplicates()
        ;
        //listemde sadece türk şehirleri olsun
        //kendi metodumuzu ayzıyoruz (turkishCities)
       List<String> citys2 = new ArrayList<String>(Arrays.asList("Istanbul","Ankara", "Izmir"));
        assertThat(citys2)
                .have(turkishCities());

       //listemde sadece yabancı şehirler olsun
        List<String> citys3 = new ArrayList<String>(Arrays.asList("Amsterdam","Paris","Londra"));
        assertThat(citys3)
                .have(abroadCities());

        //listemde 2 türk 3 yabancı şehirler olsun
        List<String> citys4 = new ArrayList<String>(Arrays.asList("Amsterdam","Istanbul","Paris","Izmir","Londra"));
        assertThat(citys4)
                .haveExactly(2, turkishCities())
                .haveExactly(3,abroadCities());


    }

    private Condition<? super String> abroadCities() {
        return new Condition<String>(){
            @Override
            public boolean matches(String value) {
                return abroadCitiesList.contains(value);
            }
        };
    }

    private Condition<? super String> turkishCities() {
        return new Condition<String>(){
            @Override
            public boolean matches(String value) {
                return turkishCitiesList.contains(value);
            }
        };
    }
}
