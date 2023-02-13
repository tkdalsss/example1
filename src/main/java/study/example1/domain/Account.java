package study.example1.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Table(name = "accounts")
@Entity
@Data
public class Account {

    @Id @GeneratedValue
    @Column(name = "account_id")
    private Long id;

    private String owner;

    private int balance;

    @Enumerated(EnumType.STRING)
    private Currency currency;

    private LocalDateTime created_at;

    public static Account createAccount(String name, int balance, Currency currency) {
        Account account = new Account();

        account.setOwner(name);
        account.setBalance(balance);
        account.setCurrency(currency);
        account.setCreated_at(LocalDateTime.now());

        return account;
    }

}
