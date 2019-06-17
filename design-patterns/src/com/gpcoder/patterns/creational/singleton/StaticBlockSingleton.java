package com.gpcoder.patterns.creational.singleton;

/**
 * Cách làm tương tự như Eager initialization chỉ khác phần static block cung cấp thêm lựa chọn cho việc
 * handle exception hay các xử lý khác.
 */
public class StaticBlockSingleton {

    private static final StaticBlockSingleton INSTANCE;

    private StaticBlockSingleton() {
    }

    static {
        try {
            INSTANCE = new StaticBlockSingleton();
        } catch (Exception e){
            throw new RuntimeException("Exception occured in creating singleton instance");
        }
    }

    public static StaticBlockSingleton getInstance() {
        return INSTANCE;
    }
}
