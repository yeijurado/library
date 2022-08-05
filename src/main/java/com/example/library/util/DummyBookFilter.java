package com.example.library.util;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.library.model.Book;
import com.example.library.service.BookService;

@Component
public class DummyBookFilter {
    private final BookService bookService;

    public DummyBookFilter(BookService bookService) {
        this.bookService = bookService;
    }

    @PostConstruct
    public void init() {
        bookService.addBook(new Book(null, "Invest like a Bank", "Want to retire early with real estate but don’t know where to start?", "Beaux Blast", 25.88, 5));
        try {Thread.sleep(100);} catch (InterruptedException e) {}
        bookService.addBook(new Book(null, "Las Llaves del Exito", "Expone los 17 principios del triunfo personal", "Napoleon Hill", 23.50, 8));
        try {Thread.sleep(100);} catch (InterruptedException e) {}
        bookService.addBook(new Book(null, "Las Ocho Columnas de la Prosperidad", "Nuestros sueños y pensamientos determinan el tipo de persona en la que nos convertimos", "James Allen", 15.30, 2));
        try {Thread.sleep(100);} catch (InterruptedException e) {}
        bookService.addBook(new Book(null, "Yo Soy la Mágica Presencia", "Es la hora en que la humanidad de esta tierra debe dar más reconocimiento a la actividad de los Grandes Maestros Ascendidos", "Saint Germain", 25.99, 7));
        try {Thread.sleep(100);} catch (InterruptedException e) {}
        bookService.addBook(new Book(null, "Misterios Develados", "Relato sobre el inicio de la Nueva Era de Acuario", "Saint Germain", 20.50, 4));
        try {Thread.sleep(100);} catch (InterruptedException e) {}
        bookService.addBook(new Book(null, "Piense y Hágase Rico", "La riqueza y la realización personal están al alcance de todos", "Napoleon Hill", 15.50, 13));
        try {Thread.sleep(100);} catch (InterruptedException e) {}
        bookService.addBook(new Book(null, "Hacia mi Mágica Presencia", "Camino y etapas para la ascención de Daniel Raigborn con la ayuda de los Grandes Maestros Ascendidos", "Saint Germain", 20.99, 5));
    } 
}
