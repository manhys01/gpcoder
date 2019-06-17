package com.gpcoder.patterns.creational.factorymethod;

public class BankFactory {

    private BankFactory() {
    }

    public static final Bank getBank(BankType bankType) {
        switch (bankType) {
            case VIETINBANK:
                return new VietinBank();
            case VIETCOMBANK:
                return new VietcomBank();
            case MBBANK:
                return new MBBank();
            default:
                throw new IllegalArgumentException("This bank type is unsupported");
        }
    }

}
