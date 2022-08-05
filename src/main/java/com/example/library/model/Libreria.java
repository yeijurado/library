/* Model for the resource: Libreria
    Author: Yeison Fernando Jurado G.
    Date: August 01st 2022
    Technology: Spring Boot - Backend Java 
*/ 

package com.example.library.model;

import lombok.Data;

// Add @Data label to Spring generate all getters and Setters automaticaly

public @Data class Libreria {
    private String nombre;
    private String direccion;
    private String telefono;
    private String horario;
}
