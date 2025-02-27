package org.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class BankAccountTest{
    private PersonalAccount personalAccount;
    private BusinessAccount businessAccount;

    @Mock
    private PrintStream mockPrintStream;

    @Before
    public void setup() {
        System.setOut(mockPrintStream);

        personalAccount = new PersonalAccount("Anthony Sevy", "Rua 7 de Setembro, 542", 1000, "abc123", "123.123.123-13");
        businessAccount = new BusinessAccount("Nord Aço", "Rua Cons. Manoel Correa de Melo, 15", 10000, "abc1234", "55.444.333/0001-22");
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
    public void depositAddMoneyAccountInvalid() {
        double depositoPf = -1;
        double valorEsperadoPf = personalAccount.getBalance();
        double depositoPj = -1;
        double valorEsperadoPj = businessAccount.getBalance();
        double delta = 0.01;

        personalAccount.deposit(depositoPf);
        businessAccount.deposit(depositoPj);
        double valorObtidoPf = personalAccount.getBalance();
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

    @Test
    public void testPrintStatement() {
        personalAccount.printStatement();
        businessAccount.printStatement();

        verify(mockPrintStream).println("Extrato de: Anthony Sevy");
        verify(mockPrintStream).println("Extrato de: Nord Aço");
    }

}