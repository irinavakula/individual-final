package es.santander.ascender.final_individual.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.santander.ascender.final_individual.models.Book;
import es.santander.ascender.final_individual.repositories.BookRepository;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public Book retriveBook(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public List<Book> retriveAllBooks() {
        return bookRepository.findAll();
    }

    public Book updateBook(Long id, Book book) {
        if (bookRepository.existsById(id)) {
            book.setId(id);
            return this.saveBook(book);
        }
        throw new RuntimeException("Couldn't find building with id " + id);
    }

}
