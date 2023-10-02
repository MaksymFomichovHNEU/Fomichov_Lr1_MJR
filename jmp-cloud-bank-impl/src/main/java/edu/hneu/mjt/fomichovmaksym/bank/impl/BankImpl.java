package edu.hneu.mjt.fomichovmaksym.bank.impl;

import edu.hneu.mjt.fomichovmaksym.dto.*;
import edu.hneu.mjt.fomichovmaksym.bank.Bank;

public class BankImpl implements Bank {
    @Override
    public BankCard createBankCard(User user, BankCardType cardType) {
        switch (cardType) {
            case DEBIT:
                return new DebitBankCard("4444 4444 4444 4444",user,1000.0);
            case CREDIT:
                return new CreditBankCard("5555 5555 5555 5555",user,5000.0,2000.0);
        }
        return null;
    }
}