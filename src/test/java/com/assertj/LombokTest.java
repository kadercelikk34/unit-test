package com.assertj;

import com.unittest.assertj.Gift;
import org.junit.Test;

public class LombokTest {
    @Test
    public void testLombok()throws Exception {
        //Gift gift = new Gift("kader");
        Gift gift = Gift.builder().name("kader").build();
        System.out.println(gift.toString());
    }
}
