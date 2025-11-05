package com.example.ejercicio21fxml;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;

public class HelloController {
    public ObservableList<String> tareas = FXCollections.observableArrayList();
    public Button Eliminar;
    public Button añadir;
    public TextField tfTarea;
    public HBox hbox;
    public Label ltarea;
    public ListView LVitems;

    @FXML
    protected void añadir() {

        String tarea = tfTarea.getText();
        tareas.add(tarea);
        LVitems.setItems(tareas);

        tfTarea.setText("");

    }

    @FXML
    protected void Eliminar() {

        String tarea = LVitems.getSelectionModel().getSelectedItem().toString();
        tareas.remove(tarea);
        LVitems.setItems(tareas);

    }
}