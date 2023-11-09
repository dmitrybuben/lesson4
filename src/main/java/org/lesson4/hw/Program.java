package org.lesson4.hw;

import java.util.Scanner;

/**
 * 1. Создать программу управления банковским счетом(Account).
 * Программа должна позволять пользователю вводить начальный баланс счета, сумму депозита и сумму снятия средств.
 * При этом она должна обрабатывать следующие исключительные ситуации:
 * Попытка создать счет с отрицательным начальным балансом должна вызывать исключение IllegalArgumentException
 * с соответствующим сообщением.
 * Попытка внести депозит с отрицательной суммой должна вызывать исключение IllegalArgumentException
 * с соответствующим сообщением.
 * Попытка снять средства, сумма которых превышает текущий баланс, должна вызывать исключение InsufficientFundsException
 * с сообщением о недостаточных средствах и текущим балансом.
 * Продемонстрируйте работу вашего приложения:
 * Программа должна обрабатывать все исключения с помощью конструкции try-catch,
 * выводя соответствующие сообщения об ошибках.
 */

public class Program {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            manageAccount();
        } catch (IllegalArgumentException e) {
            System.out.println("Check the amount you have entered");
        } catch (InsufficientFundsException e) {
            System.out.println("Not enough funds");
        }
    }

    public static void manageAccount() throws InsufficientFundsException, IllegalArgumentException {
        createAccount();
        depositAccount();
        withdrawAmount();
    }

    public static int createAccount() throws IllegalArgumentException {
        int initialBalanceAmount;
        do {
            System.out.println("Enter initial account amount: ");
            initialBalanceAmount = Integer.parseInt(scanner.nextLine());
            if (initialBalanceAmount < 0) {
                throw new IllegalArgumentException();
            }
            System.out.println("Account created with the balance: " + initialBalanceAmount);
        }
        while (!isInitialBalanceAmountValid(initialBalanceAmount));
        //scanner.close();
        return initialBalanceAmount;
    }

    public static boolean isInitialBalanceAmountValid(int initialBalanceAmount) {
        return initialBalanceAmount >= 0;
    }

    public static int depositAccount() throws IllegalArgumentException {
        int depositBalanceAmount = 0;
        System.out.println("Enter deposit amount: ");
        try {
            depositBalanceAmount = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Check if amount is a number");
        }
        //scanner.close();
        if (depositBalanceAmount < 0) {
            throw new IllegalArgumentException();
        }
        System.out.println("Deposit amount " + depositBalanceAmount + " is accepted");
        return depositBalanceAmount;
    }

    public static void withdrawAmount() throws InsufficientFundsException {
        int amountToWithdraw = 0;
        System.out.println("Enter amount to withdraw: ");
        try {
            amountToWithdraw = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Check if amount is a number");
        }
        if ((createAccount() + depositAccount()) < amountToWithdraw) {
            throw new InsufficientFundsException();
        }
        scanner.close();
    }
}
