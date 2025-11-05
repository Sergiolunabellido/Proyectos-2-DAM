package com.example.demofx;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Tabla extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Stage stage = new Stage();

        BorderPane root = new BorderPane();

        VBox vbox = new VBox();

        vbox.setMaxSize(200,200);
        vbox.setSpacing(20);


        Label labelNombre = new Label("Nombre");
        TextField textFieldName = new TextField();
        Label apellido1 = new Label("Apellido");
        TextField textFieldApellido = new TextField();
        Label edad1 = new Label("Edad");
        TextField textFieldEdad = new TextField();




        //Creacion de memnu.
        MenuBar menuBar = new MenuBar();

        Menu archivo = new Menu("Archivo");
        Menu editar = new Menu("Editar");
        Menu ayuda = new Menu("Ayuda");
        menuBar.getMenus().addAll(archivo,editar,ayuda);

        //Cracion de los items del menu
        MenuItem guardar = new MenuItem("Nuevo");
        MenuItem eliminar = new MenuItem("Abrir");
        MenuItem Cerrar = new MenuItem("Cerrar");
        archivo.getItems().addAll(guardar,Cerrar,eliminar);

        Cerrar.setOnAction(e -> {

          stage.close();

        });

        //Items de editar
        MenuItem copiar = new MenuItem("Copiar");
        MenuItem pegar = new MenuItem("Pegar");
        editar.getItems().addAll(copiar,pegar);

        //Creacion de la tabla

        TableView<Persona> table = new TableView();
        table.setMaxSize(300,300);

        TableColumn<Persona, String> nombre = new TableColumn("Nombre");
        nombre.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());

        TableColumn<Persona, String> edad = new TableColumn("Edad");
        edad.setCellValueFactory(cellData -> cellData.getValue().edadProperty());

        TableColumn<Persona, String> apellido = new TableColumn("Apellido");
        apellido.setCellValueFactory(cellData -> cellData.getValue().apellidoProperty());


        table.getColumns().addAll(nombre,apellido,edad);

        Button agregar = new Button("Agregar");

        //Creamos la lista donde se guardan las personas, para despues guardarlas en la tabla.
        ObservableList<Persona> lista = FXCollections.observableArrayList();
        table.setItems(lista);

        agregar.setOnAction(e -> {

            //Creamos una nueva persona con los datos introducidos por los textFields
                   Persona personitas = new Persona(
                           textFieldName.getText().trim(),
                           textFieldApellido.getText().trim(),
                           textFieldEdad.getText().trim());


                   //Añadimos los datos de la nueva persona a la tabla
                   table.getItems().add(personitas);

                   //Limpiamos los textFields para poder escribir una nueva persona
                   textFieldName.clear();
                   textFieldApellido.clear();
                   textFieldEdad.clear();


        });


        vbox.getChildren().addAll(labelNombre,textFieldName,apellido1, textFieldApellido, edad1, textFieldEdad, agregar);
        root.setTop(menuBar);
        root.setLeft(vbox);
        root.setCenter(table);
        Scene scena = new Scene(root, 500, 300);
        stage.setScene(scena);
        stage.setTitle("Tabla");
        stage.show();



    }
}
