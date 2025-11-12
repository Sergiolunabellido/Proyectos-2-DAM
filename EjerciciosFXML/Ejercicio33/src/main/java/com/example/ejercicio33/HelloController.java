package com.example.ejercicio33;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.shape.Rectangle;

public class HelloController {

    @FXML public Rectangle rectangulo;
    @FXML public Slider SliderRojo;
    @FXML public Slider SliderVerde;
    @FXML public Slider SliderAzul;
    public Label textoRGB;

    @FXML
    public void initialize() {

        //HACEMOS QUE EL PROGRAMA ESTE ESCUCHANDO A LOS SLIDER PARA QUE CUANDO CAMBIEN DE VALOR SE ACTUALICE EL COLOR AL NUEVO VALOR DADO
        SliderRojo.valueProperty().addListener((observable, oldValue, newValue) -> actualizarColorRectangulo());
        SliderVerde.valueProperty().addListener((observable, oldValue, newValue) -> actualizarColorRectangulo());
        SliderAzul.valueProperty().addListener((observable, oldValue, newValue) -> actualizarColorRectangulo());



        //LLAMAMOS AL METODO DE CAMBIAR COLOR DEL RECTANGULO
        actualizarColorRectangulo();

    }

    public void actualizarColorRectangulo() {

        //GUARDAMOS EN VARIABLES LOS VALORES DE CADA SLIDER QUE INDICARAN UN COLOR U OTRO
        int red = (int) SliderRojo.getValue();
        int green = (int) SliderVerde.getValue();
        int blue = (int) SliderAzul.getValue();

        //CREAMOS UNA CADENA QUE INDICARA EL RGB CON LOS VALORES DE LOS SLIDERS USANDO EL %D PARA QUE VAYA COGIENDO
        //EL VALOR DE CADA VARIABLE INDICADA EN ORDEN.
        String color = String.format("rgb(%d,%d,%d)", red , green , blue);

        //INDICAMOS EL COLOR QUE TENDRA NUESTRO RECTANGULO QUE SERA IGUAL AL COLOR GENERADO ANTERIORMENTE
        rectangulo.setStyle("-fx-fill: " + color + ";");
        //CADA VEZ QUE SE LLAME AL METODO SE LE ASIGNARA EL TEXTO AL TEXTORGB DE DEBAJO DEL RECTANGULO PARA INDICAR
        //LOS VALORES ACTUALES DEL COLOR MOSTRADO.
        textoRGB.setText(color);
    }
}