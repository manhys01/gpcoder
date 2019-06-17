package com.gpcoder.patterns.creational.builder.food;

public class Client {

    public static void main(String[] args) {
        Order order = new FastFoodOrderBuilder()
                .orderType(OrderType.ON_SITE)
                .orderBread(BreadType.BEEF)
                .orderSauce(SauceType.SOY_SAUCE)
                .build();
        System.out.println(order);
    }

}

