package com.gpcoder.junit.util;

import org.junit.Assert;
import org.junit.Test;

public class ExceptionTest2 {

    @Test
    public void testDividedByZero(){
        try {
            MathUtil.divide(1,0);
            Assert.fail("Not throw an exception");
        } catch (Exception e){
            Assert.assertTrue(e instanceof IllegalArgumentException);
            Assert.assertEquals("Cannot divide by zero (0)", e.getMessage());
        }
    }

}
