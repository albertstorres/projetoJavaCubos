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

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactions.add("Depósito: R$" + amount);
        }
    }

    public String getCostumerName() {
        return costumerName;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public double getBalance() {
        return balance;
    }

    public List<String> getTransactions() {
        return transactions;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }
}
