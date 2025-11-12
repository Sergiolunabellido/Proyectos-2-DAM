package com.example.ejercicio3_4;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.paint.Color;

public class HelloController {
    public ComboBox Colores;
    public Button Limpiar;
    public Canvas Dibujo;
    GraphicsContext gc;

    @FXML
    public void initialize() {


        Colores.getItems().addAll("Azul", "Rojo", "Verde");
        Colores.setValue("Colores");
        gc = Dibujo.getGraphicsContext2D();

        gc.setLineWidth(3);

        Dibujo.setOnMousePressed(e -> {
            gc.beginPath();
            gc.moveTo(e.getX(), e.getY());
            gc.stroke();
        });

        Dibujo.setOnMouseDragged(e -> {
          gc.lineTo(e.getX(), e.getY());
          gc.stroke();
        });
        Dibujo.setStyle("-fx-border-color: Black; -fx-border-width: 2; -fx-padding: 10;");

    }

    public void CambiarColor(){

        if(Colores.getValue()== "Azul"){
            gc.setStroke(Color.BLUE);
        }else if(Colores.getValue()=="Rojo"){
            gc.setStroke(Color.RED);
        }else if(Colores.getValue()=="Verde"){
            gc.setStroke(Color.GREEN);
        }

    }


    public void limpiar(){

        Colores.setValue("Colores");
        gc.clearRect(0,0,Dibujo.getWidth(),Dibujo.getHeight());

    }
   }