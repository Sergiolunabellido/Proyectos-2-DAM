package com.example.ejerciciosactions;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;



import java.io.IOException;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        BorderPane root = new BorderPane();

        Button mostrarMensaje = new Button("Mensaje");
        mostrarMensaje.setStyle("-fx-border-radius: 50; -fx-background-color: pink");
        mostrarMensaje.setOnMouseClicked(event -> {

            System.out.println("mensaje");

        });

        Button cambiarColor = new Button("Cambiar color");

        cambiarColor.setStyle("-fx-border-radius: 50;  -fx-background-color: PINK");
        cambiarColor.setOnMouseClicked(event -> {

            Random random = new Random();
            int r = random.nextInt(256);
            int g = random.nextInt(256);
            int b = random.nextInt(256);
            root.setStyle("-fx-background-color: rgb(" + r + "," + g + "," + b + ")");

        });
        Label label = new Label();
        label.setText("Contador: 0");
        AtomicInteger contador= new AtomicInteger();


        Button pulsar = new Button("Sumar");
        pulsar.setOnMouseClicked(event -> {

            contador.getAndIncrement();
            label.setText("Contador: " + contador.get());

        });

        Label texto = new Label();
        texto.setText("Texto a cambiar");

        javafx.scene.control.CheckBox checkbox = new javafx.scene.control.CheckBox("Activar modo bestia");
        checkbox.setOnAction(event -> {

            if (checkbox.isSelected()) {
                texto.setText("Texto cambiado");
            }else texto.setText("Texto a cambiar");


        });


        HBox hBox2 = new HBox(10);
        hBox2.getChildren().addAll( checkbox, texto);


        HBox hbox = new HBox();
        hbox.setSpacing(10);
        hbox.getChildren().addAll(label,pulsar);


        HBox botones = new HBox();
        botones.getChildren().addAll(mostrarMensaje, cambiarColor );

        root.setCenter(botones);
        root.setTop(hBox2);
        root.setBottom(hbox);
        Scene scene = new Scene(root, 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}