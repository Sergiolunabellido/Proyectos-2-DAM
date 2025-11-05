package com.example.ejercicio3interfaces;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        AtomicInteger contadorAcertadas= new AtomicInteger();
        AtomicInteger contadorIntentos = new AtomicInteger();
        AtomicInteger respuesta = new AtomicInteger();

        /*
        * Inicio de VBox Primer Layout
        * */
        VBox root = new VBox(10);
        Scene scene = new Scene(root, 350, 240);

        Label pregunta = new Label("Que hace un pez cuando choca contra una pared?");

        RadioButton r1 = new RadioButton("Nada");

        RadioButton r2 = new RadioButton("Corre");

        RadioButton r3 = new RadioButton("Salta");


        Label error = new Label();
        error.setTextFill(Color.RED);

        Button botonResponder = new Button("Responder");
        botonResponder.setOnAction(e -> {

            if (r1.isSelected() && r2.isSelected() && r3.isSelected()) {
                error.setText("Ecuchame pisha no have rehpondeh un cuehtionario? Holo una rehpuehta!!");
            } else if (r1.isSelected() && r2.isSelected() || r1.isSelected() && r3.isSelected()
            || r2.isSelected() && r3.isSelected()) {
                error.setText("Ecuchame pisha no habe rehpondeh un cuehtionario? Holo una rehpuehta!!");
            }else{
                if (r1.isSelected() || r2.isSelected() || r3.isSelected()) {
                    int seleccion = r1.isSelected() ? 0 : r2.isSelected() ? 1 : 2;

                    if (seleccion == respuesta.get()) {
                        contadorAcertadas.getAndIncrement();
                    }
                    contadorIntentos.getAndIncrement();
                }
            }

            if (contadorIntentos.get() == 1) {

                pregunta.setText("Que hace una abeja en el gimnasio?");
                r1.setText("Miel");
                r2.setText("Zumba");
                r3.setText("Baila");

                r1.setSelected(false);
                r2.setSelected(false);
                r3.setSelected(false);

                error.setText("");
                respuesta.set(1);
            }

            if (contadorIntentos.get() == 2) {

                pregunta.setText("Pregunta tres");
                r1.setText("Respuesta 1");
                r2.setText("Respuesta 2");
                r3.setText("Respuesta 3");

                r1.setSelected(false);
                r2.setSelected(false);
                r3.setSelected(false);

                error.setText("");
                respuesta.set(0);
            }


            if (contadorIntentos.get() == 3) {

                pregunta.setText("!Test finalizado¡"+" Puntución: " + contadorAcertadas.get() + "/" + contadorIntentos.get());

                r1.setVisible(false);
                r2.setVisible(false);
                r3.setVisible(false);
                botonResponder.setDisable(true);
                botonResponder.setOpacity(0.5);



            }

        });


        Button deNuevo = new Button("Volver a empezar");
        deNuevo.setOnAction(e -> {

            pregunta.setText("Que hace un pez cuando choca contra una pared?");

            r1.setText("Nada");
            r1.setVisible(true);
            r1.setSelected(false);

            r2.setText("Corre");
            r2.setVisible(true);
            r2.setSelected(false);

            r3.setText("Salta");
            r3.setVisible(true);
            r3.setSelected(false);

            contadorAcertadas.set(0);
            contadorIntentos.set(0);
            respuesta.set(0);
            error.setText("");
            botonResponder.setMaxWidth(100);
            botonResponder.setMinWidth(100);
            botonResponder.setDisable(false);
            botonResponder.setOpacity(1);


        });

        HBox botones = new HBox(10);
        botones.getChildren().addAll(botonResponder, deNuevo);
        root.getChildren().addAll(pregunta,r1,r2,r3,error,botones);

        /*
         * Finalizacion de VBox Primer Layout
         * */

        stage.setTitle("Cuestionario!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}