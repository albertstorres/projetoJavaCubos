package org.example;

public class BusinessAccount extends BankAccount{

    private String cnpj;

    public BusinessAccount(String costumerName, String billingAddress, double initialBalance, String cnpj) {
        super(costumerName, billingAddress, initialBalance);
        this.cnpj = cnpj;
    }

    @Override
    public String getAccountDetails() {
        return "Business Account [CNPJ: " + this.cnpj + " ]";
    }
}
