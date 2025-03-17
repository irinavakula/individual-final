package es.santander.ascender.final_individual.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "loans")
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "issuance")
    private LocalDateTime issuance;

    @Column(name = "refund")
    private LocalDateTime refund;

    @Column(name = "borrowerName")
    private String borrowerName;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    public Book book;

    @ManyToOne

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getIssuance() {
        return issuance;
    }

    public void setIssuance(LocalDateTime issuance) {
        this.issuance = issuance;
    }

    public LocalDateTime getRefund() {
        return refund;
    }

    public void setRefund(LocalDateTime refund) {
        this.refund = refund;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    /*@ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    public User user;*/

}
