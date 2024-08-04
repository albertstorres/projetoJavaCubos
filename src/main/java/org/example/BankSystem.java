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

    public void createAccount() {
        System.out.println("Criando uma nova conta: ");
        System.out.println("Digite o nome do cliente: ");
        String name = scanner.nextLine(); //nextLine() serve para limpar o buffer e para ler tudo antes do ENTER (/n);

        System.out.println("Digiete o endereço de cobrança: ");
        String address = scanner.nextLine();

        System.out.println("Digite o saldo inicial: ");
        double balance = scanner.nextDouble();
        scanner.nextLine(); //Limpando o lixo.
        System.out.println("Digite a senha: ");
        String password = scanner.nextLine();

        System.out.println("________________________");
        System.out.println("1. Pessoa Física");
        System.out.println("2. Pessoa Jurídica");
        System.out.println("________________________");
        System.out.println("Digite o tipo da conta: ");
        int accountType = scanner.nextInt();
        scanner.nextLine();

        if (accountType == 1) {
            System.out.println("Digite o CPF: ");
            String cpf = scanner.nextLine();
            PersonalAccount personalAccount = new PersonalAccount(name, address, balance, password, cpf);
            accounts.put(cpf, personalAccount);
            System.out.println("Conta pessoal criada com sucesso.");
        } else if (accountType == 2) {
            System.out.println("Digite o CNPJ: ");
            String cnpj = scanner.nextLine();
            BusinessAccount businessAccount = new BusinessAccount(name, address, balance, password, cnpj);
            accounts.put(cnpj, businessAccount);
            System.out.println("Conta jurídica criada com sucesso.");
        } else {
            do {
                System.out.println("Opção inválida!");
                System.out.println("________________________");
                System.out.println("1. Pessoa Física");
                System.out.println("2. Pessoa Jurídica");
                System.out.println("________________________");
                System.out.println("Digite novamente o tipo da conta: ");
                accountType = scanner.nextInt();
                scanner.nextLine();
            }while(accountType != 1 || accountType != 2);
        }

    }
    public void login (String identifier, String password) {
        if (accounts.containsKey(identifier)) {
            BankAccount bankAccount = accounts.get(identifier); // Salvando a conta encontrada;
            boolean passwordMatch = bankAccount.verifyPassword(password);

            if (passwordMatch) {
                System.out.println("Usuário logado com sucesso. Bem vindo(a)" + bankAccount.getCostumerName());

            }
        } else {
            System.out.println("Conta não encontrada.");
        }
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
                case 1 :
                    System.out.println("Digite o CPF ou CNPJ: ");
                    String identifier = scanner.nextLine();
                    System.out.println("Digite sua senha: ");
                    String password = scanner.nextLine();
                    bankSystem.login(identifier, password);
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }while(option != 0);
    }
}