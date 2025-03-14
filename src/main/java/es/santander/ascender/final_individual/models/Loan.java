package es.santander.ascender.final_individual.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class Loan {
    @Column(name = "issuance")
    private LocalDate issuance;

    @Column(name = "refund")
    private LocalDate refund;

     @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    public Book book;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    public User user;

}
