package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public abstract class BankAccount {
    private String costumerName;
    private String billingAddress;
    private double balance;
    private List <String> transactions;

    public BankAccount(String costumerName, String billingAddress, double initialBalance) {
        this.costumerName = costumerName;
        this.billingAddress = billingAddress;
        this.balance = initialBalance;
        this.transactions = new ArrayList<>();
        this.transactions.add("Saldo inicial: " + initialBalance);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactions.add("Depósito: R$" + amount);
        } else {
            transactions.add("Falha na tentativa de depósito: R$ " + amount);
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactions.add("Saque: R$ " + "- " + amount);
        } else {
            transactions.add("Falha na tentativa de saque: R$ " + amount);
        }
    }

    public void printStatement() {
        System.out.println("Extrato de: " + costumerName);
        for (String transaction : transactions) {
            System.out.println(transaction);
        }
        System.out.println("---------------------");
        System.out.println("Saldo atual: R$ " + balance);
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

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public abstract String getAccountDetails();
}
