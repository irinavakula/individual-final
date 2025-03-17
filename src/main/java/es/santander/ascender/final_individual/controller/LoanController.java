package es.santander.ascender.final_individual.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.santander.ascender.final_individual.models.Loan;
import es.santander.ascender.final_individual.services.LoanService;

class CreateLoanDTO {

    public String borrower_name;

    public Long book_id;
    
}


@RestController
@RequestMapping("/api/loan")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @PostMapping
     @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public Loan create(@RequestBody CreateLoanDTO loanDTO) {
        return loanService.createLoan(loanDTO.book_id, loanDTO.borrower_name);
    }

    @PostMapping("/{id}/refund")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public Loan refund(Long id) {
        return loanService.refundLoan(id);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public Loan retrive(@PathVariable("id") Long id) {
        return loanService.retrieveLoan(id);
    }

    @GetMapping
    public List<Loan> list() {
        return loanService.retriveAllLoan(); 
    }



}
