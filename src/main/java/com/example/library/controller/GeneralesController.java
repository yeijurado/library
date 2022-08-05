/* General information about the business library
    Author: Yeison Fernando Jurado G.
    Date: July 30th 2022
    Technology: Spring Boot - Backend Java 
*/ 

package com.example.library.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.model.Libreria;

@RestController
@RequestMapping({"generales"})
public class GeneralesController {

    private Libreria libreria;

    // create the object libreria with all the info
    public GeneralesController() {
        libreria = new Libreria();
        libreria.setNombre("Librería Medellín");
        libreria.setDireccion("Cra 50 #50-50 Centro de Medellín");
        libreria.setTelefono("300 8510608");
        libreria.setHorario("Lunes a Sábado 10am - 9pm");
    }

    // Method to return the object info in JSON format
    @GetMapping("/")
    public Libreria info() {
        return libreria;
    }

    // Method to return libreria´s nombre
    @GetMapping("/nombre")
    public String nombre() {
        return libreria.getNombre();
    }

    // Method to return libreria´s dirección
    @GetMapping("/direccion")
    public String direccion() {
        return libreria.getDireccion();
    }

    // Method to return libreria´s teléfono
    @GetMapping("/telefono")
    public String telefono() {
        return libreria.getTelefono();
    }

    // Method to return libreria´s horario
    @GetMapping("/horario")
    public String horario() {
        return libreria.getHorario();
    }

}
