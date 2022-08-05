/* Controller for the resource: book
    Author: Yeison Fernando Jurado G.
    Date: August 04th 2022
    Technology: Spring Boot - Backend Java 
*/ 

package com.example.library.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.model.Book;
import com.example.library.service.BookService;

@RestController
@RequestMapping({"book"})
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // method to return all books and filtered books 
    @GetMapping("")
    public List<Book> getAll(@RequestParam(required = false) String authorId, String title) {
        if (authorId == null && title == null) {
            return this.bookService.getAll();
        } else if (authorId != null) {
            return this.bookService.findByAuthor(authorId);
        } else {
            return this.bookService.findByTitle(title);
        }
    }

    // method to return one book
    @GetMapping("/{bookId}")
    public Book get(@PathVariable String bookId) {
        return this.bookService.get(bookId);
    }
    
    // method to create a book
    @PostMapping("")
    public Book addBook(@RequestBody Book book) {
        return this.bookService.addBook(book);
    }

    // method to update a book
    @PutMapping("/{bookId}")
    public Book updateBook(@PathVariable String bookId, @RequestBody Book book) {
        Book ret = this.bookService.updateBook(bookId, book);
        return ret;
    }
    
    // method to delete a book
    @DeleteMapping("/{bookId}")
    public Book deleteBook(@PathVariable String bookId) {
        return this.bookService.deleteBook(bookId);
    }
}
