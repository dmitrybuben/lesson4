package org.lesson4.hwVariant2;

public class BankAccountApp {
    public static void main(String[] args) {
        try {
            // Создаем счет с начальным балансом
            Account account = new Account(1000);

            // Вносим депозит
            account.deposit(500);

            // Пытаемся снять средства больше, чем есть на счете
            account.withdraw(2000);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (InsufficientFundsException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
