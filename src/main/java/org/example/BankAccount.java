package org.example;

import java.util.ArrayList;
import java.util.List;

public abstract class BankAccount {
    private String costumerName;
    private String billingAddress;
    private double balance;
    private List <String> transactions;

    public BankAccount(String billingAddress, String costumerName, double initialBalance) {
        this.billingAddress = billingAddress;
        this.costumerName = costumerName;
        this.balance = initialBalance;
        this.transactions = new ArrayList<>();
        this.transactions.add("Saldo inicial: " + initialBalance);
    }

}
