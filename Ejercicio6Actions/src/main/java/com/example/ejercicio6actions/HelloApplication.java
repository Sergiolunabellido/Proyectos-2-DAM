package com.example.ejercicio6actions;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class HelloApplication extends Application {

    String operador= "";
    double num1 = 0;
    boolean nuevaOperacion = true;

    @Override
    public void start(Stage stage) throws IOException {

        //PANELES
        BorderPane root = new BorderPane();

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        //BOTONES
        Button boton0 = new Button("0");
        Button boton1 = new Button("1");
        Button boton2 = new Button("2");
        Button boton3 = new Button("3");
        Button boton4 = new Button("4");
        Button boton5 = new Button("5");
        Button boton6 = new Button("6");
        Button boton7 = new Button("7");
        Button boton8 = new Button("8");
        Button boton9 = new Button("9");
        Button boton10 = new Button("/");
        Button boton11 = new Button("*");
        Button boton12 = new Button("+");
        Button boton13 = new Button("-");
        Button boton14 = new Button("=");
        Button boton15 = new Button("C");


        //AGREGAR A GRID
        grid.add(boton7, 0,0);
        grid.add(boton8, 1,0);
        grid.add(boton9, 2,0);
        grid.add(boton10, 3,0);
        grid.add(boton4, 0,1);
        grid.add(boton5, 1,1);
        grid.add(boton6, 2,1);
        grid.add(boton11, 3,1);
        grid.add(boton1, 0,2);
        grid.add(boton2, 1,2);
        grid.add(boton3, 2,2);
        grid.add(boton13, 3,2);
        grid.add(boton0,0,3);
        grid.add(boton15,1,3);
        grid.add(boton14,2,3);
        grid.add(boton12, 3,3);

        //TEXTFIELD
        TextField textField = new TextField();
        textField.setPromptText("Enter your name");
        textField.setMinSize(235, 30);
        textField.setMaxSize(235, 30);

        //DAMOS TAMAÑO A TODOS LOS BOTONES Y EN LA ACCION DEL BOTON DECIMOS QUE SI ES DIGITO QUE LO ESCRIBA EN EL
        //TEXTFIEL

        for (Node node : grid.getChildren()) {
            Button boton = (Button) node;
            boton.setMinWidth(50);
            boton.setMinHeight(50);

            boton.setOnMousePressed(event -> {

                //FUNCIONES BOTONES
                String valor = boton.getText();
                switch(valor) {

                    case "+": case "-": case "*": case "/":
                        operador = valor;
                        num1 = Double.parseDouble(textField.getText());
                        textField.clear();
                        break;
                    case "=":
                        if(!operador.isEmpty()){

                            double num2 = Double.parseDouble(textField.getText());
                            double resultado = 0;

                            switch(operador) {
                                case"+": resultado = num1 + num2;break;
                                case "-": resultado = num1 - num2;break;
                                case "*": resultado = num1 * num2;break;
                                case "/":
                                    if (num2 != 0)resultado = num1 / num2;
                                    else {
                                        textField.setText("Error");
                                        operador = "";
                                        return;
                                    }
                                    break;
                            }
                            textField.setText(String.valueOf(resultado));
                            operador = "";
                            nuevaOperacion = true;
                        }
                        break;

                    case"C":
                        textField.clear();
                        num1 = 0;
                        operador = "";
                        nuevaOperacion = true;
                        break;

                    default:
                        if(nuevaOperacion){
                            textField.setText(valor);
                            nuevaOperacion = false;
                        }else{
                            textField.setText(textField.getText() + valor);
                        }

                }


            });

        }



        root.setTop(textField);
        root.setCenter(grid);
        BorderPane.setMargin(textField, new Insets(60,80,0,80));
        BorderPane.setMargin(grid, new Insets(20,80,20,80));
        Scene scene = new Scene(root, 400, 400);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}