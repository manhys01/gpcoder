package com.gpcoder.junit.util;

import java.util.concurrent.TimeUnit;

public class TaskUtil {

    public static int doNormalTask(){
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 1;
    }

    public static int doHeavyTask(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 1;
    }

}
