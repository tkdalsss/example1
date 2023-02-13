package study.example1.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.example1.domain.Account;
import study.example1.domain.Transfer;
import study.example1.repository.AccountRepository;
import study.example1.repository.TransferRepository;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TransferService {

    private final TransferRepository transferRepository;
    private final AccountRepository accountRepository;

    @Transactional
    public void transfer(Long fromId, Long toId, int balance) {
        Account from_account = accountRepository.findById(fromId).get();
        Account to_account = accountRepository.findById(toId).get();

        log.info("before Transfer : from account = {}, to account = {}", from_account.getBalance(), to_account.getBalance());
        int minus = from_account.getBalance() - balance;
        int plus = to_account.getBalance() + balance;

        log.info("after Transfer : from account = {}, to account = {}", minus, plus);
        from_account.setBalance(minus);
        to_account.setBalance(plus);

        // transfer create & save
        Transfer transfer = Transfer.createTransfer(fromId, toId, balance);
        transferRepository.save(transfer);
    }

    public List<Transfer> getList() {
        return transferRepository.findAll();
    }
}
