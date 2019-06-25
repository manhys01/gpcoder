package com.gpcoder.patterns.aop;

import java.lang.reflect.InvocationHandler;

public abstract class AbstractHandler implements InvocationHandler {

    protected Object targetObject;

    public Object getTargetObject() {
        return targetObject;
    }

    public void setTargetObject(Object targetObject) {
        this.targetObject = targetObject;
    }

}
