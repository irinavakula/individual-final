package es.santander.ascender.final_individual.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import es.santander.ascender.final_individual.models.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
