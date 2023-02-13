package study.example1.controller;

import lombok.Data;

@Data
public class TransferForm {
    private Long fromId;
    private Long toId;
    private int balance;
}
