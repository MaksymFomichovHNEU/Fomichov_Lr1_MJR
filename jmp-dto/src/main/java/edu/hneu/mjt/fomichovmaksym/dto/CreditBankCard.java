package edu.hneu.mjt.fomichovmaksym.dto;

public class CreditBankCard extends BankCard {
    private double creditLimit;
    private double currentBalance;

    public CreditBankCard(String number, User user, double creditLimit, double currentBalance) {
        super(number, user);
        this.creditLimit = creditLimit;
        this.currentBalance = currentBalance;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public void makePurchase(double amount) {
        if (amount <= currentBalance + creditLimit) {
            currentBalance -= amount;
            System.out.println("Purchase of $" + amount + " made successfully.");
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    public void makePayment(double amount) {
        if (amount >= 0) {
            currentBalance += amount;
            System.out.println("Payment of $" + amount + " applied to the balance.");
        } else {
            System.out.println("Invalid payment amount.");
        }
    }

    @Override
    public String toString() {
        return "number: " + getNumber() + " user: " + getUser() + " creditLimit: " + creditLimit;
    }

}
