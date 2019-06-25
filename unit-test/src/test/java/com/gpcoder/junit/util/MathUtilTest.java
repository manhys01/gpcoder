package com.gpcoder.junit.util;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MathUtilTest {

    @Test(expected = UnsupportedOperationException.class)
    public void test_MathUtilConstructor_throwException() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<MathUtil> mathUtilClass = MathUtil.class;
        Constructor<MathUtil> constructor = mathUtilClass.getDeclaredConstructor();
        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void divide_SixDividedByThree_ReturnTwo(){
        final int expected = 2;
        final int actual = MathUtil.divide(6, 3);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void divide_SixDividedByTwo_ReturnThree(){
        final int expected = 3;
        final int actual = MathUtil.divide(6, 2);
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void divide_OneDividedByZero_ThrowsIllegalArgumentException() {
        MathUtil.divide(1, 0);
    }

    @Test
    public void add_SixAddedByTwo_ReturnEight() {
        final int expected = 8;

        final int actual = MathUtil.add(6, 2);

        Assert.assertEquals(expected, actual);
    }

}
