package com.example.ejercicio2;

import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;


public class HelloController {
    public TableColumn columnaNombre;
    public TableColumn columnaTelefono;
    public TableView lvitems;
    public Button Eliminar;
    public Button añadir;
    public TextField tfTarea;
    public HBox hbox;
    public Label ltarea;
    public TextField tfTelefono;
    @FXML
    protected void añadir() {

        String tarea = tfTarea.getText();
        String telefono = tfTelefono.getText();


        columnaNombre.setCellValueFactory(tareaProperty -> new SimpleObjectProperty<>(tarea));
        columnaTelefono.setCellValueFactory(tareaProperty -> new SimpleObjectProperty<>(telefono));
        tfTarea.setText("");
        tfTelefono.setText("");

    }

//    @FXML
//    protected void Eliminar() {
//
//        String tarea = lvitems.getSelectionModel().getSelectedItem();
//        columnaNombre.re;
//        lvitems.setItems(items);
//
//    }
}