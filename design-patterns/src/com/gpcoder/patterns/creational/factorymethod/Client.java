package com.gpcoder.patterns.creational.factorymethod;

public class Client {
    public static void main(String[] args) {
        Bank bank = BankFactory.getBank(BankType.VIETCOMBANK);
        String bankName = bank.getBankName();
        System.out.println(bankName);
    }
}
