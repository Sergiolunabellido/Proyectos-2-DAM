package com.example.pruebainicial;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.scene.paint.Color.*;
import static javafx.scene.paint.Color.WHITE;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Stage stage1 = new Stage();

        VBox root = new VBox();
        root.setSpacing(20);
        root.setAlignment(Pos.CENTER);

        Label saludo = new Label();

        TextField nombre = new TextField();
        nombre.setStyle("-fx-border-color: black");
        nombre.setOnAction(e -> {

            saludo.setText("Bienvenido " + nombre.getText());

        });

        Button boton = new Button("Saludar");
        boton.setOnAction(e -> {

            saludo.setText("Hola " + nombre.getText());

        });

        boton.setTextFill(WHITE);
        boton.setStyle("-fx-background-color: green");
        boton.hoverProperty().addListener(e -> {

            if (boton.isHover()) {
                boton.setStyle("-fx-background-color: yellow");
            }else boton.setStyle("-fx-background-color: green");

        });



        root.getChildren().addAll(saludo,nombre, boton);
        Scene scene = new Scene(root, 320, 240);


        stage1.setTitle("Hello!");
        stage1.setScene(scene);
        stage1.show();
    }

    public static void main(String[] args) {
        launch();
    }
}