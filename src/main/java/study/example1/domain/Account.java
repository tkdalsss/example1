package study.example1.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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

    @JsonIgnore
    @OneToMany(mappedBy = "account")
    private List<Entry> entries = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "fromAccount")
    private Collection<Transfer> from;

    @JsonIgnore
    @OneToMany(mappedBy = "toAccount")
    private Collection<Transfer> to;

    public static Account createAccount(String name, int balance, Currency currency) {
        Account account = new Account();

        account.setOwner(name);
        account.setBalance(balance);
        account.setCurrency(currency);
        account.setCreated_at(LocalDateTime.now());

        return account;
    }

}
