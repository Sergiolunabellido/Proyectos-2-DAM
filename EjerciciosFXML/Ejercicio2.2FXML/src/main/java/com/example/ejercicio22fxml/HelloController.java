package com.example.ejercicio22fxml;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;

public class HelloController {

    public Button Eliminar;
    public Button añadir;
    public TextField tfTarea;
    public HBox hbox;
    public Label ltarea;
    public TableView<Contacto> TVitems;

    public TextField tfTelefono;
    public TableColumn NombreTabla;
    public TableColumn TeléfonoTabla;
    Contacto contacto;
    @FXML
    protected void añadir() {

        String tarea = tfTarea.getText();
        String telefono = tfTelefono.getText();

        TVitems.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        NombreTabla.setCellValueFactory(new PropertyValueFactory<Contacto, String>("nombre"));
        TeléfonoTabla.setCellValueFactory(new PropertyValueFactory<Contacto, String>("telefono"));

        TVitems.getItems().add(new Contacto(tarea, telefono));

        tfTarea.setText("");
        tfTelefono.setText("");

    }

    @FXML
    public void initialize() {
        TVitems.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }

    @FXML
    protected void Eliminar() {

        TVitems.getItems().remove(TVitems.getSelectionModel().getSelectedIndex());

    }
}