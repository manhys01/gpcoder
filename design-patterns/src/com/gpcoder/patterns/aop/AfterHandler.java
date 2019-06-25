package com.gpcoder.patterns.aop;

import java.lang.reflect.Method;

public abstract class AfterHandler extends AbstractHandler {

    public abstract void handleAfter(Object proxy, Method method, Object[] args);

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = method.invoke(targetObject, args);
        handleAfter(proxy, method, args);
        return result;
    }

}