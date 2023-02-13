package study.example1.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Table(name = "transfers")
@Entity
@Data
public class Transfer {

    @Id @GeneratedValue
    @Column(name = "transfer_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "from_account_id")
    private Account fromAccount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "to_account_id")
    private Account toAccount;

    private int balance;

    private LocalDateTime created_at;

    public static Transfer createTransfer(Account fromAccount, Account toAccount, int balance) {
        Transfer transfer = new Transfer();
        transfer.setFromAccount(fromAccount);
        transfer.setToAccount(toAccount);
        transfer.setBalance(balance);
        transfer.setCreated_at(LocalDateTime.now());
        return transfer;
    }
}
