package org.example;

public class PersonalAccount extends BankAccount{
    private String cpf;

    public PersonalAccount(String costumerName, String billingAddress, double initialBalance, String password, String cpf) {
        super(costumerName, billingAddress, initialBalance, password);
        this.cpf = cpf;
    }

    @Override
    public String getAccountDetails() {
        return "Personal Account: [CPF: " + this.cpf + "]";
    }
}
