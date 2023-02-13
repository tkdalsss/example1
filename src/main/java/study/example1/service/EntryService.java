package study.example1.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.example1.domain.Account;
import study.example1.domain.Entry;
import study.example1.repository.AccountRepository;
import study.example1.repository.EntryRepository;

@Service
@RequiredArgsConstructor
public class EntryService {

    private final EntryRepository entryRepository;
    private final AccountRepository accountRepository;

    @Transactional
    public void entry(Long accountId, int balance){
        Account account = accountRepository.findById(accountId).get();
        Entry entry = Entry.createEntry(account, balance);
        entryRepository.save(entry);
    }
}
