package com.example.ejercicios4actions;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;


import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        Pane root = new Pane();



        Line line = new Line();
        root.setOnMousePressed(event -> {
        if (event.getButton() == MouseButton.PRIMARY) {

            line.setStroke(Color.RED);


        }
        if (event.getButton() == MouseButton.SECONDARY) {
            line.setStroke(Color.PINK);

        }
        if (event.getButton() == MouseButton.MIDDLE) {
            line.setStroke(Color.GREEN);

        }
            line.setStartX(event.getX());
            line.setStartY(event.getY());

        });


        Text text = new Text();
        root.setOnMouseMoved(event -> {
            text.setX(event.getX());
            text.setY(event.getY());
            text.setText("Estoy en la posicion " + text.getX() + ", " + text.getY());

        });


        Button btnOpciones = new Button("Ejercicios");

        MenuItem ejercicio1 = new MenuItem("Ejercicio1");
        MenuItem ejercicio2 = new MenuItem("Ejercicio2");
        MenuItem ejercicio3 = new MenuItem("Ejercicio3");

        ContextMenu cntMenu = new ContextMenu();
        cntMenu.getItems().addAll(ejercicio1, ejercicio2, ejercicio3);
        btnOpciones.setContextMenu(cntMenu);

        Stage stage1 = new Stage();

        ejercicio1.setOnAction(e -> {

            ejercicio1 ejercicio = new ejercicio1();
            ejercicio.start(stage1);

        });

        ejercicio2.setOnAction(e -> {

            ejercicio2 ejercicio = new ejercicio2();
            ejercicio.start(stage1);

        });

        ejercicio3.setOnAction(e -> {

            ejercicio3 ejercicio = new ejercicio3();
            ejercicio.start(stage1);

        });



        root.getChildren().addAll(line, text, btnOpciones);

        Scene scene = new Scene(root, 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}