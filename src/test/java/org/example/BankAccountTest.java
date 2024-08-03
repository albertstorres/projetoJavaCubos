package org.example;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BankAccountTest{
    private PersonalAccount personalAccount;
    private BusinessAccount businessAccount;

    @Before
    public void setup() {
        personalAccount = new PersonalAccount("Anthony Sevy", "Rua 7 de Setembro, 542", 1000, "123.123.123-13");
        businessAccount = new BusinessAccount("Nord Aço", "Rua Cons. Manoel Correa de Melo, 15", 10000, "55.444.333/0001-22");
    }

    @Test
    public void depositAddMoneyAccount() {
        double depositoPf = 1600;
        double valorEsperadoPf = personalAccount.getBalance() + depositoPf;
        double depositoPj = 10000;
        double valorEsperadoPj = businessAccount.getBalance() + depositoPj;
        double delta = 0.01;

        personalAccount.deposit(depositoPf);
        double valorObtidoPf = personalAccount.getBalance();
        businessAccount.deposit(depositoPj);
        double valorObtidoPj = businessAccount.getBalance();

        assertEquals(valorEsperadoPf, valorObtidoPf, delta);
        assertEquals(valorEsperadoPj, valorObtidoPj, delta);
    }

    @Test
    public void withdrawMoneyFromTheAccount() {
        double saquePf = personalAccount.getBalance() - 1;
        double valorEsperadoPf = personalAccount.getBalance() - saquePf;
        double saquePj = businessAccount.getBalance() - 1;
        double valorEsperadoPj = businessAccount.getBalance() - saquePj;
        double delta = 0.01;

        personalAccount.withdraw(saquePf);
        businessAccount.withdraw(saquePj);
        double valorObtidoPf = personalAccount.getBalance();
        double valorObtidoPj = businessAccount.getBalance();

        assertEquals(valorEsperadoPf, valorObtidoPf, delta);
        assertEquals(valorEsperadoPj, valorObtidoPj, delta);
    }

    @Test
    public void withdrawMoneyFromTheAccountInvalid() {
        double saquePf = personalAccount.getBalance() + 1;
        double valorEsperadoPf = personalAccount.getBalance();
        double saquePj = businessAccount.getBalance() + 1;
        double valorEsperadoPj = businessAccount.getBalance();
        double delta = 0.01;

        personalAccount.withdraw(saquePf);
        businessAccount.withdraw(saquePj);
        double valorObtidoPf = personalAccount.getBalance();
        double valorObtidoPj = businessAccount.getBalance();

        assertEquals(valorEsperadoPf, valorObtidoPf, delta);
        assertEquals(valorEsperadoPj, valorObtidoPj, delta);
    }

}