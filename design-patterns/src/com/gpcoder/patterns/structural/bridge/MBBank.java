package com.gpcoder.patterns.structural.bridge;

public class MBBank extends Bank {

    public MBBank(Account account) {
        super(account);
    }

    @Override
    public void openAccount() {
        System.out.print("Open account at MBBank is a ");
        account.openAccount();
    }
}
