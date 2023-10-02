// Service.java
package edu.hneu.mjt.fomichovmaksym.service;

import edu.hneu.mjt.fomichovmaksym.dto.BankCard;
import edu.hneu.mjt.fomichovmaksym.dto.Subscription;
import edu.hneu.mjt.fomichovmaksym.dto.User;

import java.util.List;
import java.util.Optional;

public interface Service {
    void subscribe(BankCard bankCard);
    Optional<Subscription> getSubscriptionByBankCardNumber(String bankCardNumber);
    List<User> getAllUsers();
}
