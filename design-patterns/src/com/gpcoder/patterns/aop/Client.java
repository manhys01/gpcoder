package com.gpcoder.patterns.aop;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Client {

    public static void main(String[] args) {
        List<AbstractHandler> handlers = new ArrayList<>();
        handlers.add(new BeforeHandlerImpl());
        handlers.add(new AfterHandlerImpl());
        ProductService proxy = ProxyFactory.getProxy(new ProductServiceImpl(), handlers);
        Product iPhone = new Product(1L, "iPhone", new BigDecimal(300));
        proxy.add(iPhone);
        proxy.size();
        proxy.remove(iPhone);
        proxy.size();
    }

}
