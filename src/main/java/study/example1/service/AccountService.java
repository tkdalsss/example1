package study.example1.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.example1.domain.Account;
import study.example1.repository.AccountRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    @Transactional
    public Account createAccount(Account account) {
        accountRepository.save(account);
        return account;
    }

    public List<Account> getList() {
        return accountRepository.findAll();
    }
}
