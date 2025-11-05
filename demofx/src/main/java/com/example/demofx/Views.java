package com.example.demofx;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Views extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Stage stage = new Stage();
        stage.setTitle("Views");

        Label elecciones = new Label("Elecciones");

        ListView<String> listView = new ListView<String>();
        listView.getItems().addAll("Psoe", "PP", "Vox");

        listView.setFixedCellSize(30);

        int items = listView.getItems().size();

        double tamañoTotal = items * listView.getFixedCellSize();
        listView.setPrefHeight(tamañoTotal);

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(listView);
        //-----------------------------------------

        TreeItem<String> principal = new TreeItem<String>("Partidos");
        principal.setExpanded(true);
        TreeItem<String> psoe = new TreeItem<String>("Psoe");
        TreeItem<String> vox = new TreeItem<String>("Vox");
        TreeItem<String> pp = new TreeItem<String>("PP");

        principal.getChildren().addAll(psoe, vox, pp);
        psoe.getChildren().addAll(
                new TreeItem<>("Perro Sanchez"),
                new TreeItem<>("Su mujer")
        );
        TreeView<String> treeView = new TreeView<String>(principal);
        treeView.setMaxWidth(150);

        //------------------------------------------
        TableView<Persona> tabla = new TableView<>();

        TableColumn<Persona, String> nombre = new TableColumn<>("Nombre");
        TableColumn<Persona, String> edad = new TableColumn<>("Edad");
        TableColumn<Persona, String> apellido = new TableColumn<>("Apellido");

        tabla.getColumns().addAll(nombre, edad,apellido);
        nombre.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
        edad.setCellValueFactory(new PropertyValueFactory<>("Edad"));
        apellido.setCellValueFactory(new PropertyValueFactory<>("Apellido"));

        tabla.setItems((FXCollections.observableArrayList(
                new Persona("Sergio", "Luna","20"),
                new Persona("Aurora", "Rodriguez","20")
                ))
        );

        tabla.setMaxSize(200, 200);


        //Columnas Padres
        TreeTableColumn<Persona,String> colNombre = new TreeTableColumn<>("Nombre");
        colNombre.setCellValueFactory(param -> param.getValue().getValue().nombreProperty());

        TreeTableColumn<Persona,String> colEdad = new TreeTableColumn<>("Edad");
        colEdad.setCellValueFactory(param -> param.getValue().getValue().edadProperty());

        TreeTableColumn<Persona, String> colApellido = new TreeTableColumn<>("Apellido");
        colApellido.setCellValueFactory(param -> param.getValue().getValue().apellidoProperty());

        //Creacion de los hijos, primero el treeItem para añadir el desplegable y luego los hijos
        Persona persona = new Persona("Desplegable", "");
        TreeItem<Persona> treeItem = new TreeItem<>(persona);

        TreeItem<Persona> sergio = new TreeItem<>(new Persona("Sergio", "Luna","20"));
        TreeItem<Persona> aurora = new TreeItem<>(new Persona("Aurora", "Rodríguez","20"));

        treeItem.getChildren().addAll(sergio, aurora);
        treeItem.setExpanded(true);

        TreeTableView<Persona> tableView = new TreeTableView<>(treeItem);
        tableView.getColumns().addAll(colNombre, colEdad, colApellido);
        treeView.setShowRoot(true);

        tableView.setMaxSize(200,200);

        VBox vBox =  new VBox();
        vBox.getChildren().addAll(tabla, tableView);

        borderPane.setLeft(treeView);
        borderPane.setCenter(vBox);
        Scene scene = new Scene(borderPane, 600, 600);
        stage.setScene(scene);
        stage.show();


    }
}
