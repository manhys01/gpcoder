package com.gpcoder.patterns.aop;

import java.lang.reflect.Method;

public class AfterHandlerImpl extends AfterHandler {

    @Override
    public void handleAfter(Object proxy, Method method, Object[] args) {
        System.out.println("Handle after\n");
    }

}
