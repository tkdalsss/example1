package study.example1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.example1.domain.Transfer;

public interface TransferRepository extends JpaRepository<Transfer, Long> {
}
