package com.gpcoder.junit.util;

import org.junit.Assert;
import org.junit.Test;

public class TimeoutTest1 {

    @Test(timeout = 3000L)
    public void test_normal_task() {
        int expected = 1;
        int actual = TaskUtil.doNormalTask();
        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 3000L)
    public void test_heavy_task() {
        int expected = 1;
        int actual = TaskUtil.doHeavyTask();
        Assert.assertEquals(expected, actual);
    }

}
