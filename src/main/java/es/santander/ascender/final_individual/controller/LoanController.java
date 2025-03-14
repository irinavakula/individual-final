package es.santander.ascender.final_individual.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.santander.ascender.final_individual.models.Loan;

@RestController
@RequestMapping("/api/loan")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @PostMapping
    public Loan create(@RequestBody Loan loan) {
        return loanService.saveLoan(loan);
    }

    /*@GetMapping("/{id}")
    public Loan retrive(@PathVariable("id") Long id) {
        return loanService.retriveLoan(id);
    } */

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        loanService.deletLoan(id);
        return "delete";
    }
}
