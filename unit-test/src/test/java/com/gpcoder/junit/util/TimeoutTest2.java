package com.gpcoder.junit.util;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class TimeoutTest2 {

    @Rule
    public Timeout globalTimeOut = Timeout.seconds(3);

    @Test
    public void test_normal_task() {
        int expected = 1;
        int actual = TaskUtil.doNormalTask();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test_heavy_task() {
        int expected = 1;
        int actual = TaskUtil.doHeavyTask();
        Assert.assertEquals(expected, actual);
    }


}
