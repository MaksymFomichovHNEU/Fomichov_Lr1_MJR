package edu.hneu.mjt.fomichovmaksym.bank;

import edu.hneu.mjt.fomichovmaksym.dto.BankCard;
import edu.hneu.mjt.fomichovmaksym.dto.BankCardType;
import edu.hneu.mjt.fomichovmaksym.dto.User;

public interface Bank {
    BankCard createBankCard(User user, BankCardType cardType);
}
