/* Services for the resource: book 
    Author: Yeison Fernando Jurado G.
    Date: August 03rd 2022
    Technology: Spring Boot - Backend Java 
*/ 

package com.example.library.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.library.model.Book;
import com.example.library.repository.BookRepository;

@Service
public class BookService {
    /*This service has to interact with repository, so 
      we have to create a variable BookRepository type
    */  
    private final BookRepository bookRepository;

    // Create the constructor, once the object is created it has all dependencies ready
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // methods to use by Controller layer

    // method to return all books from repository
    public List<Book> getAll() {
        return bookRepository.getAll();
    }

    // method to return one book from repository
    public Book get(String bookId) {
        return bookRepository.get(bookId);
    }

    // method to return a list of books searching by author
    public List<Book> findByAuthor(String authorId) {
        return bookRepository.findByAuthor(authorId);
    }

    // method to return a list of books searching by title
    public List<Book> findByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    /*  method to create a book, the method asignes null to bookId and let 
        responsability to save method in repository layer to apply business logic
    */  
    public Book addBook(Book book) {
        book.setBookId(null);
        return bookRepository.save(book);
    }

    // method to update a book, it recieves bookId and object book separately
    public Book updateBook(String bookId, Book book) {
        Book bookR = bookRepository.get(bookId);
        if (bookR == null) {
            return null;
        } 
        book.setBookId(bookId);
        return bookRepository.save(book);
    }

    // method to delete a book
    public Book deleteBook(String bookId) {
        return bookRepository.delete(bookId);
    }


    
}
