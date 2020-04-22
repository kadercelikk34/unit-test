package com.junit;

import com.unittest.Calculations;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;


import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class EasyParameterTest {
    private Calculations calculations = new Calculations();

    @Test
    @Parameters({"10,2,20", "20,20,400"})
    public void testCalculateSquareMeter(int height, int width, int totalSquareMeter) throws Exception {

        assertEquals(totalSquareMeter, calculations.calculateSquareMeter(height, width));
    }
}
