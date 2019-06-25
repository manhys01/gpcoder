package com.gpcoder.junit.util;

import org.junit.Test;

public class ExceptionTest1 {

    @Test(expected = IllegalArgumentException.class)
    public void testDividedByZero() {
        MathUtil.divide(1, 0);
    }
}
