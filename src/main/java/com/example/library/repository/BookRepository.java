/* Interface to handle book repository
    Author: Yeison Fernando Jurado G.
    Date: August 02nd 2022
    Technology: Spring Boot - Backend Java 
*/ 

package com.example.library.repository;

import java.util.List;

import com.example.library.model.Book;

// The service is going to implement this interface

public interface BookRepository {
    public List<Book> getAll();
    public Book get(String bookId);
    public List<Book> findByAuthor(String author);
    public List<Book> findByTitle(String title);
    public Book save(Book book);
    public Book delete(String bookId);
}
