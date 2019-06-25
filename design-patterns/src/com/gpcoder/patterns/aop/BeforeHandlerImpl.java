package com.gpcoder.patterns.aop;

import java.lang.reflect.Method;

public class BeforeHandlerImpl extends BeforeHandler {

    @Override
    public void handleBefore(Object proxy, Method method, Object[] args) {
        System.out.println("Handle before");
    }

}
