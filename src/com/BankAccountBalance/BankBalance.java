package com.BankAccountBalance;

public class BankBalance {
    private double balance;

 BankBalance(double initialBalance) {
        this.balance = initialBalance;
	}

	public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds!");
        }
    }
}
