package org.example;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BankAccountTest{
    private PersonalAccount personalAccount;

    @Before
    public void setup() {
        personalAccount = new PersonalAccount("Anthony Sevy", "Rua 7 de Setembro, 542", 1000, "123.123.123-13");
    }

    @Test
    public void depositAddMoneyAccount() {
        double deposito = 1600;
        double valorEsperado = personalAccount.getBalance() + deposito;
        double delta = 0.01;

        personalAccount.deposit(deposito);
        double valorObtido = personalAccount.getBalance();

        assertEquals(valorEsperado, valorObtido, delta);
    }
}