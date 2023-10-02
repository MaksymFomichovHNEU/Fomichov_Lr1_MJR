// ServiceImpl.java
package edu.hneu.mjt.fomichovmaksym.service.impl;

import edu.hneu.mjt.fomichovmaksym.dto.BankCard;
import edu.hneu.mjt.fomichovmaksym.dto.Subscription;
import edu.hneu.mjt.fomichovmaksym.dto.User;
import edu.hneu.mjt.fomichovmaksym.service.Service;


import java.time.LocalDate;
import java.util.*;

public class ServiceImpl implements Service {

    private Map<String, Subscription> subscriptionMap = new HashMap<>();
    private Map<String, BankCard> bankCardMap = new HashMap<>();
    private Map<User, List<BankCard>> userBankCardsMap = new HashMap<>();
    @Override
    public void subscribe(BankCard bankCard) {
        var cardNumber = bankCard.getNumber();
        bankCardMap.put(cardNumber, bankCard);
        var subscription = new Subscription(bankCard, LocalDate.now());
        subscriptionMap.put(cardNumber, subscription);
        var user = bankCard.getUser();
        userBankCardsMap.computeIfAbsent(user, arr -> new ArrayList<>()).add(bankCard);
    }

    @Override
    public Optional<Subscription> getSubscriptionByBankCardNumber(String bankCardNumber) {
        return Optional.ofNullable(subscriptionMap.get(bankCardNumber));
    }

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(userBankCardsMap.keySet());
    }
}
