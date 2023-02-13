package study.example1.controller;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import study.example1.domain.Currency;

@Data
public class AccountForm {

    @NotEmpty(message = "예금주 이름은 필수입니다.")
    private String owner;

    @Positive(message = "잔고는 0이상의 양수이어야 합니다.")
    private int balance;
    private Currency currency;
}
