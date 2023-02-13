package study.example1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.example1.domain.Entry;

public interface EntryRepository extends JpaRepository<Entry, Long> {
}
