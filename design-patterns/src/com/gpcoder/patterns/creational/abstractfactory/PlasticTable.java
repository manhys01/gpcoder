package com.gpcoder.patterns.creational.abstractfactory;

public class PlasticTable implements Table {
    @Override
    public void create() {
        System.out.println("Create plastic table");
    }
}
