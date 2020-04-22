package com.junit;

import com.unittest.Calculations;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
@RunWith(Parameterized.class)
public class ParameterTest {

    private Calculations calculations=new Calculations();

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {10,2,20},
                {20,2,40},
                {1,3,3},
                {1,55,55},
                {4,9,36}});
    }

    private int height;
    private int width;
    private int totalSquareMeter;

    public ParameterTest(int height, int width, int totalSquareMeter) {
        this.height = height;
        this.width = width;
        this.totalSquareMeter = totalSquareMeter;
    }

    @Test
    public void testCalculateSquareMeter() throws Exception {

        assertEquals(totalSquareMeter,calculations.calculateSquareMeter(height,width));
    }
}