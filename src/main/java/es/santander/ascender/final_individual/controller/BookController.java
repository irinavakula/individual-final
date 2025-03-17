package es.santander.ascender.final_individual.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.santander.ascender.final_individual.models.Book;
import es.santander.ascender.final_individual.services.BookService;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired 
    private BookService bookService;

    @PostMapping
    //@Secured("ADMIN")
    @PreAuthorize("hasRole('ADMIN')")
    public Book create(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Book retrive(@PathVariable ("id") Long id) {
        return bookService.retriveBook(id);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Book update(@PathVariable("id") Long id, @RequestBody Book book) {
        return bookService.updateBook(id, book);
    }
 
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String delete(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
        return "delete";
    }

    @GetMapping
    public List<Book> list() {
        return bookService.retriveAllBooks();
    }

}
