package com.example.demofx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Ejercicio3 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        Stage stage = new Stage();

        BorderPane root = new BorderPane();

        VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.setMaxHeight(200);
        vbox.setMaxWidth(200);

        HBox hboxHobbies = new HBox();
        hboxHobbies.setSpacing(10);
        hboxHobbies.setMaxHeight(100);
        hboxHobbies.setMaxWidth(100);

        HBox hboxGenero =  new HBox();
        hboxGenero.setSpacing(10);
        hboxGenero.setMaxHeight(100);
        hboxGenero.setMaxWidth(100);

        Label hobbies = new Label("Selecciona tus Hobbies:");

        CheckBox musica = new CheckBox("Musica");
        CheckBox deporte = new CheckBox("Deporte");
        CheckBox lectura = new CheckBox("Lectura");


        Label generos = new Label("Selecciona tu Genero:");

        RadioButton hombre = new RadioButton("Hombre");
        RadioButton mujer = new RadioButton("Mujer");
        RadioButton otro = new RadioButton("Otro");


        Label notificaciones = new Label("Notificaciones:");

        ToggleButton actDesact = new ToggleButton("Activa/Desactivar");

        Label pais = new Label("Selecciona tu Pais:");

        ChoiceBox paises = new ChoiceBox();
        paises.setValue("Paises");
        paises.getItems().add("China");
        paises.getItems().add("Germany");
        paises.getItems().add("Spain");
        paises.getItems().add("Italia");


        Label color = new Label("Selecciona tu Color:");

        ComboBox colores = new ComboBox();
        colores.setValue("Colores");
        colores.getItems().add("Red");
        colores.getItems().add("Blue");
        colores.getItems().add("Green");
        colores.getItems().add("Orange");
        colores.visibleRowCountProperty();
        colores.setEditable(true);

        Label edad = new Label("Edad:");

        Spinner<Integer> edades = new Spinner<>();
        edades.setEditable(true);
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0);
        edades.setValueFactory(valueFactory);

        //Boton cerrar ventana
        Button cerrar = new Button("Cerrar");

        cerrar.setOnAction(e -> {
            stage.close();
        });

        vbox.getChildren().addAll(hobbies, musica,deporte,lectura
        ,generos, hombre, mujer, otro, notificaciones,actDesact,pais, paises,
        color, colores, edad,edades, cerrar);
        root.setCenter(vbox);
        Scene scena = new Scene(root, 400,500);
        stage.setTitle("EJERCICIO 3");
        stage.setScene(scena);
        stage.show();

    }

}
