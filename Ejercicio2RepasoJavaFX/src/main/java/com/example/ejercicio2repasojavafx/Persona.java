package com.example.ejercicio2repasojavafx;

import java.time.LocalDate;

public class Persona {

    String nombre;
    String email;
    LocalDate fecha;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Persona(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
        this.fecha = LocalDate.now();
    }

    public Persona() {}
}
