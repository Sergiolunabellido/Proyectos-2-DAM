package com.example.demofx;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.awt.*;

import static java.awt.Transparency.BITMASK;

public class BackGrounds extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Stage stage = new Stage();

        BorderPane root = new BorderPane();
        root.setMaxSize(primaryStage.getWidth(), primaryStage.getHeight());


        //--------------------------
        StackPane paneTop = new StackPane();
        Button btnTop = new Button();
        btnTop.setText("Top");
        paneTop.getChildren().add(btnTop);
        paneTop.setStyle("-fx-background-color: lightblue;");

        //---------------------------
        StackPane paneBottom = new StackPane();
        Button btnBottom = new Button();
        btnBottom.setText("Bottom");
        paneBottom.getChildren().add(btnBottom);
        paneBottom.setStyle("-fx-background-color: lightgreen;");
        //---------------------------
        StackPane paneLeft = new StackPane();
        Button btnLeft = new Button();
        btnLeft.setText("Left");
        paneLeft.getChildren().add(btnLeft);
        paneLeft.setStyle("-fx-background-color: red;");
        //---------------------------

        StackPane paneRight = new StackPane();
        Button btnRight = new Button();
        btnRight.setText("Right");
        paneRight.getChildren().add(btnRight);
        paneRight.setStyle("-fx-background-color: lightyellow;");
        //---------------------------

        Button btnCenter = new Button();
        btnCenter.setText("Center");


        root.setTop(paneTop);
        root.setCenter(btnCenter);
        root.setLeft(paneLeft);
        root.setRight(paneRight);
        root.setBottom(paneBottom);

        //------------------------

        BorderPane.setAlignment(btnTop, Pos.CENTER);
        BorderPane.setAlignment(btnCenter, Pos.CENTER);
        BorderPane.setAlignment(btnBottom, Pos.CENTER);
        BorderPane.setAlignment(btnLeft, Pos.CENTER);
        BorderPane.setAlignment(btnRight, Pos.CENTER);
        //----------------------------------------------



        Scene scene = new Scene(root, 500, 450);
        paneTop.setMaxWidth(scene.getWidth());
        stage.setTitle("BackGrounds");
        stage.setScene(scene);
        stage.show();

    }
}
