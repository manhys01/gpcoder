package com.gpcoder.junit.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class AssertTest {

    @Test
    public void testAssertEquals() {
        assertEquals("failure - string are not equal", "text", "text");
    }

    @Test
    public void testAssertArrayEquals() {
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {1, 2, 3};
        assertArrayEquals("failure - two arrays not same", arr1, arr2);
    }

    @Test
    public void testAssertTrue() {
        assertTrue("failure - should be true", true);
    }


    @Test
    public void testAssertFalse() {
        assertFalse("failure - should be false", false);
    }

    @Test
    public void testAssertNull() {
        assertNull("failure - should be null", null);
    }

    @Test
    public void testAssertNotNull() {
        assertNotNull("failure - should not be null", new Object());
    }

    @Test
    public void testAssertSame() {
        int a = 10;
        int b = a;
        int c = a;
        assertSame("failure - should be same", b, c);
    }

    @Test
    public void testAssertNotSame() {
        Object a = new Object();
        Object b = new Object();
        assertNotSame("Should not be same Object", a, b);
    }

    @Test
    public void testFail(){
        fail("Make fail a test");
    }

}
