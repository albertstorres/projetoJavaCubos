package org.example;

public class PersonalAccount extends BankAccount{
    private String cpf;

    public PersonalAccount(String costumerName, String billingAddress, double initialBalance, String cpf) {
        super(costumerName, billingAddress, initialBalance);
        this.cpf = cpf;
    }
}
