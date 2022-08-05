/* Class to handle book repository
    Author: Yeison Fernando Jurado G.
    Date: August 02nd 2022
    Technology: Spring Boot - Backend Java 
*/ 

package com.example.library.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.example.library.model.Book;

// with the label @Repository Spring knows where to find the repository to use in the App.

@Repository
public class MemoryBookRepository implements BookRepository {

    // create a Hash Map to manage, efficiently, the books in memory
    private Map<String, Book> booksMap;

    public MemoryBookRepository() {
        booksMap = new HashMap<>();
    }

    // method to return all the books from repository
    @Override
    public List<Book> getAll() {
        List<Book> books = new ArrayList<>();
        books.addAll(booksMap.values());
        return books;
    }

    // method to return one book from repository
    @Override
    public Book get(String bookId) {
        return booksMap.get(bookId);
    }

    // method to return a list of books searching by author from repository
    @Override
    public List<Book> findByAuthor(String author) {
        // using streams
        return booksMap.values().stream()
          .filter(book -> book.getAuthor().toLowerCase()
          .indexOf(author.toLowerCase()) >= 0).collect(Collectors.toList());
    }

    // method to return a list of books searching by title from repository
    @Override
    public List<Book> findByTitle(String title) {
        // using streams
        return booksMap.values().stream()
          .filter(book -> book.getTitle().toLowerCase()
          .indexOf(title.toLowerCase()) >= 0).collect(Collectors.toList());
    }

    /* method to save or update one book in repository
       --> if bookId doesn´t exists, then insert the record
       --> if bookId exists, then update the record
    */
    @Override
    public Book save(Book book) {
        if (book.getBookId() == null) {
            book.setBookId(String.valueOf(System.currentTimeMillis()));
        }
        booksMap.put(book.getBookId(), book);
        return book;
    }

    // method to delete a books by id from repository
    @Override
    public Book delete(String bookId) {
        return booksMap.remove(bookId);
    }
    
}
