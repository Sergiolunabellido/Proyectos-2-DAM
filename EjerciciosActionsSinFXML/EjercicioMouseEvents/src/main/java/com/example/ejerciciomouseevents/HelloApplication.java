package com.example.ejerciciomouseevents;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {


        Pane root = new Pane();
        Scene scene = new Scene(root, 320, 240);

        root.setOnMouseClicked((event) -> {

            System.out.println("Posicion X " +event.getX() + " Y " +event.getY()
            + "Button " + event.getButton()
            );

        });

        Circle circle = new Circle(50);
        circle.setCenterX(100);
        circle.setCenterY(100);
        circle.setFill(Color.GREEN);

        circle.setOnMouseEntered((event) -> {

            circle.setFill(Color.BLUE);
            circle.setRadius(70);
            circle.setCenterX(120);
            circle.setCenterY(120);

        });

        circle.setOnMouseExited((event) -> {

           circle.setFill(Color.GREEN);
            circle.setRadius(50);
            circle.setCenterX(100);
            circle.setCenterY(100);


        });

        circle.setOnMouseDragged((event) -> {

            circle.setCenterX(event.getX());
            circle.setCenterY(event.getY());

        });

        Rectangle rectangle = new Rectangle(50, 50, 50, 50);

        scene.setOnKeyPressed((event) -> {

           event.getCode();

           if (event.getCode() == KeyCode.LEFT) {
               rectangle.setX(rectangle.getX()-10);
           }else if (event.getCode() == KeyCode.RIGHT) {
               rectangle.setX(rectangle.getX()+10);
           }else if (event.getCode() == KeyCode.UP) {
               rectangle.setY(rectangle.getY()-10);
           }else if (event.getCode() == KeyCode.DOWN) {
               rectangle.setY(rectangle.getY()+10);
           }


        });
        Line line = new Line();
        root.setOnMousePressed((event) -> {


           line.setStartX(event.getX());
           line.setStartY(event.getY());



        });

        root.setOnMouseDragged((event) -> {


            line.setEndX(event.getX());
            line.setEndY(event.getY());


        });


        root.getChildren().add(line);
        root.getChildren().addAll(circle, rectangle);


        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}