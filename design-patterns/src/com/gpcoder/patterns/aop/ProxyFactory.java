package com.gpcoder.patterns.aop;

import java.lang.reflect.Proxy;
import java.util.List;

public class ProxyFactory {

    private ProxyFactory() {
        throw new UnsupportedOperationException();
    }

    @SuppressWarnings("unchecked")
    public static <T> T getProxy(T targetObject, List<AbstractHandler> handlers) {
        if (handlers != null && !handlers.isEmpty()) {
            T proxyObject = targetObject;
            for (AbstractHandler handler : handlers) {
                handler.setTargetObject(proxyObject);
                proxyObject = (T) Proxy.newProxyInstance(targetObject.getClass().getClassLoader(), targetObject.getClass().getInterfaces(), handler);
            }
            return proxyObject;
        }
        return targetObject;
    }

}
