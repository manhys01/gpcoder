package com.gpcoder.junit.util;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ExceptionTest3 {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void shouldTestExceptionMessage() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Cannot divide by zero (0)");
        MathUtil.divide(1, 0);
    }

}
