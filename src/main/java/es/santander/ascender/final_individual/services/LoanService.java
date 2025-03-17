package es.santander.ascender.final_individual.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.santander.ascender.final_individual.models.Book;
import es.santander.ascender.final_individual.models.Loan;
import es.santander.ascender.final_individual.repositories.BookRepository;
import es.santander.ascender.final_individual.repositories.LoanRepository;

@Service
public class LoanService {

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private BookRepository bookRepository;

    public Loan createLoan(Long book_id, String borrowerName) {
        Book book = bookRepository.findById(book_id).orElseThrow(() -> new RuntimeException("Book not found"));
        Loan issuedLoan = loanRepository.findFirstByBookIdOrderByIssuanceDesc(book.getId()).orElse(null);

        if (issuedLoan != null && issuedLoan.getRefund() == null) {
            throw new RuntimeException("Book is still in loan.");
        }
        Loan loan = new Loan();
        loan.setBook(book);
        loan.setBorrowerName(borrowerName);
        LocalDateTime now = LocalDateTime.now();
        loan.setIssuance(now);
        return loanRepository.save(loan);
    }
    public Loan saveLoan(Loan loan) {
        return loanRepository.save(loan);
    }

    public List<Loan> retriveAllLoan() {
        return loanRepository.findAll(); 
    }

    public Loan retrieveLoan(Long id) {
        return loanRepository.findById(id).orElseThrow(() -> new RuntimeException("Loan not found")); 
    }

    public Loan refundLoan(Long loanId) {
        Loan loan = loanRepository.findById(loanId).orElseThrow(() -> new RuntimeException("Loan not found"));
        if (loan.getRefund() != null) {
            throw new RuntimeException("Loan has been already refunded.");
        }
        LocalDateTime today = LocalDateTime.now();
        loan.setRefund(today);
        return loanRepository.save(loan);
    }
    

}
