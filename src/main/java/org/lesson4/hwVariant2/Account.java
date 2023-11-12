package org.lesson4.hwVariant2;

public class Account {
    private double balance;

    public Account(double initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Начальный баланс не может быть отрицательным");
        }
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Сумма депозита не может быть отрицательной");
        }
        this.balance += amount;
        System.out.println("Депозит успешно внесен. Текущий баланс: " + this.balance);
    }

    public void withdraw(double amount) throws org.lesson4.hwVariant2.InsufficientFundsException {
        if (amount < 0) {
            throw new IllegalArgumentException("Сумма снятия не может быть отрицательной");
        }
        if (amount > this.balance) {
            throw new org.lesson4.hwVariant2.InsufficientFundsException("Недостаточно средств. Текущий баланс: " + this.balance);
        }
        this.balance -= amount;
        System.out.println("Средства успешно сняты. Текущий баланс: " + this.balance);
    }
}
