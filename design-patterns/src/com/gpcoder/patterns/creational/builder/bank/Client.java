package com.gpcoder.patterns.creational.builder.bank;

public class Client {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount.BankAccountBuilder("manh", "0123123")
                .withAddress("Co Nhue")
                .wantNewsletter(true)
                .withEmail("manhnd.695@gmail.com")
                .build();
        System.out.println(bankAccount);
    }
}
