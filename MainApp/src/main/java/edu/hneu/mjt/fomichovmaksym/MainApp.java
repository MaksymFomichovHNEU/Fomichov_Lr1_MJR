package edu.hneu.mjt.fomichovmaksym;

import edu.hneu.mjt.fomichovmaksym.bank.Bank;
import edu.hneu.mjt.fomichovmaksym.bank.impl.BankImpl;
import edu.hneu.mjt.fomichovmaksym.dto.BankCardType;
import edu.hneu.mjt.fomichovmaksym.dto.User;
import edu.hneu.mjt.fomichovmaksym.service.Service;
import edu.hneu.mjt.fomichovmaksym.dto.BankCard;
import edu.hneu.mjt.fomichovmaksym.dto.Subscription;
import edu.hneu.mjt.fomichovmaksym.service.impl.ServiceImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class MainApp {
    public static void main(String[] args) {

        Bank bank = new BankImpl();
        Service service = new ServiceImpl();

        User user1 = new User();
        user1.setName("Ihor");
        user1.setSurname("Liman");
        user1.setBirthday(LocalDate.of(2002, 1, 14));

        User user2 = new User();
        user2.setName("Artur");
        user2.setSurname("Kurasov");
        user2.setBirthday(LocalDate.of(2000, 7, 15));

        BankCard debitCard = bank.createBankCard(user1, BankCardType.DEBIT);
        BankCard creditCard = bank.createBankCard(user2, BankCardType.CREDIT);

        service.subscribe(debitCard);
        service.subscribe(creditCard);

        String bankCardNumber = debitCard.getNumber();
        Optional<Subscription> subscription = service.getSubscriptionByBankCardNumber(bankCardNumber);

        if (subscription.isPresent()) {
            System.out.println("Subscription found for bank card: " + subscription.get().getBankcard());
        }
        else {
            System.out.println("Subscription not found for bank card: " + bankCardNumber);
        }

        String bankCardNumber2 = creditCard.getNumber();
        Optional<Subscription> subscription2 = service.getSubscriptionByBankCardNumber(bankCardNumber2);

        if (subscription.isPresent()) {
            System.out.println("Subscription found for bank card: " + subscription2.get().getBankcard());
        }
        else {
            System.out.println("Subscription not found for bank card: " + bankCardNumber2);
        }

        List<User> users = service.getAllUsers();
        System.out.println("All users:");
        for (User u : users) {
            System.out.println(u);
        }
    }
}