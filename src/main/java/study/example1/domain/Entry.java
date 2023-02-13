package study.example1.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Table(name = "entries")
@Entity
@Data
public class Entry {

    @Id @GeneratedValue
    @Column(name = "entry_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;

    private int balance;

    private LocalDateTime created_at;

    public static Entry createEntry(Account account, int balance) {
        Entry entry = new Entry();

        entry.setAccount(account);
        entry.setBalance(balance);
        entry.setCreated_at(LocalDateTime.now());

        return entry;
    }
}
