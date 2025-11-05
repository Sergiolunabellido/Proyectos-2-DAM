package com.example.demofx;

import javafx.beans.property.SimpleStringProperty;

public class Persona {
    private SimpleStringProperty nombre;
    private SimpleStringProperty apellido;
    private SimpleStringProperty edad;

    public Persona(String nombre, String apellido, String edad) {
        this.nombre = new SimpleStringProperty(nombre);
        this.apellido = new SimpleStringProperty(apellido);
        this.edad = new SimpleStringProperty(edad);
    }

    public Persona(String nombre, String edad) {
        this.nombre = new SimpleStringProperty(nombre);
        this.edad = new SimpleStringProperty(edad);
    }


    public String getNombre() {
        return nombre.get();
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }



    public String getEdad() {
        return edad.get();
    }

    public SimpleStringProperty edadProperty() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad.set(edad);
    }

    public String getApellido() {
        return apellido.get();
    }

    public SimpleStringProperty apellidoProperty() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido.set(apellido);
    }

    public SimpleStringProperty nombreProperty(){
        return nombre;
    }




}
