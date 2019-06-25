package com.gpcoder.junit.util;

import org.junit.*;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JUnitLifeCycleTest {

    @BeforeClass
    public static void beforeClass() {
        System.out.println("@BeforeClass: Khởi tạo dữ liệu cho các phương thức được đánh dấu là @Test");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("@AfterClass: Dọn dẹp bộ nhớ sau khi đã chạy hết tất cả phương thức được đánh dấu là @Test");
    }

    @Before
    public void beforeTest(){
        System.out.println("@Before: Khởi tạo dữ liệu cho một phương thức được đánh dấu là @Test");
    }

    @After
    public void afterTest(){
        System.out.println("@After: Dọn dẹp bộ nhớ sau khi thực thi phương thức được đánh dấu là @Test");
    }

    @Test
    public void test_method_11(){
        System.out.println("@Test: method 1");
    }

    @Test
    public void test_method_2(){
        System.out.println("@Test: method_2");
    }

    @Ignore
    @Test
    public void test_ignore_method(){
        System.out.println("@Test: this method will be skipped");
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_throw_exception_method(){
        System.out.println("Throw IllegalArgumentException");
        throw new IllegalArgumentException();
    }

}
