package edu.hneu.mjt.fomichovmaksym.dto;

public class DebitBankCard extends BankCard {
    private double accountBalance;

    public DebitBankCard(String number, User user, double accountBalance) {
        super(number, user);
        this.accountBalance = accountBalance;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public void withdraw(double amount) {
        if (amount <= accountBalance) {
            accountBalance -= amount;
            System.out.println("Withdrawal of $" + amount + " made successfully.");
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    public void deposit(double amount) {
        if (amount >= 0) {
            accountBalance += amount;
            System.out.println("Deposit of $" + amount + " completed.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    @Override
    public String toString() {
        return "number: " + getNumber() + " user: " + getUser();
    }
}
