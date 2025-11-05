package com.example.ejercicios4actions;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class ejercicio1 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Pane root = new Pane();

        Circle circulo = new Circle();
        circulo.setRadius(20);
        circulo.setCenterX(50);
        circulo.setCenterY(50);
        circulo.setStrokeWidth(50);
        circulo.setFill(Color.PINK);

        circulo.setOnMouseClicked(event -> {

            if (event.getClickCount() == 2){

                circulo.setFill(Color.RED);

            }
            if (event.getClickCount() != 2){
                circulo.setFill(Color.PINK);
                event.getClickCount();
            }

        });

        root.getChildren().add(circulo);

        Scene scene = new Scene(root, 320, 240);
        primaryStage.setTitle("Ejercicio1");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
