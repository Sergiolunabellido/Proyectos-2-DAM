package com.example.ejercicio7actions;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        BorderPane root = new BorderPane();

        TableView<Personas> tabla = new TableView<>();
        tabla.setMaxSize(500,300);
        tabla.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        TableColumn<Personas,String> nombre = new TableColumn<>("Nombre");
        TableColumn<Personas,String> apellido = new TableColumn<>("Apellido");
        TableColumn<Personas,String> edad = new TableColumn<>("Edad");
        nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        apellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        edad.setCellValueFactory(new PropertyValueFactory<>("edad"));
        tabla.getColumns().addAll(nombre,apellido,edad);

        VBox vBox = new VBox(10);
        vBox.setPadding(new Insets(10,10,10,10));

        TextField Nombre = new TextField("Nombre");
        TextField apellido1 = new TextField("Apellido");
        TextField edad1 = new TextField("Edad");

        Button boton = new Button("Añadir");
        boton.setOnAction(e -> {

            tabla.getItems().add(new Personas(Nombre.getText(), apellido1.getText(), edad1.getText()));

        });



        vBox.getChildren().addAll(tabla,Nombre,apellido1,edad1,boton);
        root.setCenter(vBox);
        BorderPane.setMargin(vBox, new Insets(20,20,20,20));
        VBox.setMargin(boton, new Insets(0,0,0,200));
        Scene scene = new Scene(root, 500, 500);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}