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

    @JsonIgnore
    @JoinColumn(name = "account_id")
    private Long fromId;

    @JsonIgnore
    @JoinColumn(name = "account_id")
    private Long toId;

    private int balance;

    private LocalDateTime created_at;

    public static Transfer createTransfer(Long fromId, Long toId, int balance) {
        Transfer transfer = new Transfer();

        transfer.setFromId(fromId);
        transfer.setToId(toId);
        transfer.setBalance(balance);
        transfer.setCreated_at(LocalDateTime.now());

        return transfer;
    }
}
