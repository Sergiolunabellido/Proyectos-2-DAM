package com.example.demofx;

import com.almasb.fxgl.ui.Position;
import com.almasb.fxgl.ui.ProgressBar;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ParteFinalTema extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Stage stage = new Stage();

        BorderPane root = new BorderPane();

        ProgressBar progressBar = new ProgressBar();
        progressBar.setMaxValue(1000);
        progressBar.setMinValue(0);
        progressBar.setCurrentValue(100);
        progressBar.setLabelVisible(true);
        progressBar.setLabelPosition(Position.RIGHT);
        progressBar.setFill(Color.RED);

        Button avanceBarra = new Button("Avancar");
        avanceBarra.setMaxSize(200, 200);

        avanceBarra.setOnAction(E ->{

            progressBar.setCurrentValue(progressBar.getCurrentValue() + 10);

                });

        HBox hb = new HBox();
        hb.getChildren().addAll(avanceBarra,progressBar);

        root.setBottom(hb);
        Scene scene = new Scene(root,800,600);
        stage.setScene(scene);
        stage.show();

    }
}
