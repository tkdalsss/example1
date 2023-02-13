package study.example1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.example1.domain.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
