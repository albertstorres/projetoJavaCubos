package org.example;

import java.util.HashMap;
import java.util.Scanner;

public class BankSystem {
    private HashMap<String, BankAccount> accounts;
    private Scanner scanner;

    public BankSystem(HashMap<String, BankAccount> acounts, Scanner scanner){
        this.accounts = acounts;
        this.scanner = scanner;
    }

    public static void main(String[] args) {
        HashMap<String, BankAccount> accounts = new HashMap<String, BankAccount>();
        Scanner scanner = new Scanner(System.in);

        BankSystem bankSystem = new BankSystem(accounts, scanner);

        int option;
        do {
            System.out.println("Seja bem vindo ao CubosBank!");
            System.out.println("-----------------------------");
            System.out.println("1. Login");
            System.out.println("2. Criar conta");
            System.out.println("3. Deletar conta");
            System.out.println("0. Sair");
            System.out.println("-----------------------------");
            System.out.println("Digite a opção desejada: ");
            option = scanner.nextInt();
            scanner.nextLine(); //Limpando o lixo do scanner.

            switch (option) {
                case 0 :
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }while(option != 0);
    }
}