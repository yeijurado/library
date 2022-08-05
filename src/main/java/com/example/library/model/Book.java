/*  Model for the resource: book
    Author: Yeison Fernando Jurado G.
    Date: August 01st 2022
    Technology: Spring Boot - Backend Java 
*/ 

package com.example.library.model;

import lombok.Data;
import lombok.NoArgsConstructor;

// label @NoArgsConstructor to create a non parameter constructor
@NoArgsConstructor
public @Data class Book {
    private String bookId;
    private String title;
    private String description;
    private String author;
    private Double price;
    private int qty;
    
    // Constructor with all the atributes of the class Book
    public Book(String bookId, String title, String description, String author, Double price, int qty) {
        this.bookId = bookId;
        this.title = title;
        this.description = description;
        this.author = author;
        this.price = price;
        this.qty = qty;
    }


    
    
}
