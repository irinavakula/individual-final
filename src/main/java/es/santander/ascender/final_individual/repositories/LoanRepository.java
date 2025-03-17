package es.santander.ascender.final_individual.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import es.santander.ascender.final_individual.models.Loan;
import java.util.Optional;

public interface LoanRepository extends JpaRepository<Loan, Long> {
    Optional<Loan> findFirstByBookIdOrderByIssuanceDesc(Long bookId);
}
