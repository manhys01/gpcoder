package com.gpcoder.patterns.creational.builder.bank;

public class BankAccount {

    private final String name; // Required
    private final String account; // Required
    private final String address;
    private final String email;
    private final boolean newsletter;
    private final boolean mobileBanking;

    private BankAccount(String name, String account, String address, String email, boolean newsletter, boolean mobileBanking) {
        this.name = name;
        this.account = account;
        this.address = address;
        this.email = email;
        this.newsletter = newsletter;
        this.mobileBanking = mobileBanking;
    }

    public static class BankAccountBuilder {

        private String name; // Required
        private String accountNumber; // Required
        private String address;
        private String email;
        private boolean newsletter;
        private boolean mobileBanking;

        public BankAccountBuilder(String name, String accountNumber) {
            this.name = name;
            this.accountNumber = accountNumber;
        }

        public BankAccountBuilder withAddress(String address) {
            this.address = address;
            return this;
        }

        public BankAccountBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public BankAccountBuilder wantNewsletter(boolean newsletter) {
            this.newsletter = newsletter;
            return this;
        }

        public BankAccountBuilder wantMobileBanking(boolean mobileBanking) {
            this.mobileBanking = mobileBanking;
            return this;
        }

        public BankAccount build() {
            BankAccount bankAccount = new BankAccount(
                    this.name, this.accountNumber,
                    this.address, this.email,
                    this.newsletter, this.mobileBanking);

            validateUserObject(bankAccount);

            return bankAccount;
        }

        private void validateUserObject(BankAccount bankAccount) {
            // Do some basic validations to check
            if (this.newsletter && email == null) {
                throw new IllegalArgumentException("Email can't be null when client want to receive the new letter");
            }
        }

    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "name='" + name + '\'' +
                ", account='" + account + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", newsletter=" + newsletter +
                ", mobileBanking=" + mobileBanking +
                '}';
    }
}
