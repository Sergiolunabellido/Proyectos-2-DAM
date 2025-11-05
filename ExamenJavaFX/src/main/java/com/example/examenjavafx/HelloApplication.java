package com.example.examenjavafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
//NOMBRE DE ALUMNO: SERGIO LUNA BELLIDO
//FECHA: 04/11/2025
//PROFESORA: SILVIA
//ASIGNATURA: DESARROLLO DE INTERFACES
public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        //LAYOUT PRINCIPAL
        BorderPane root = new BorderPane();
        //GRIDPANE PARA ODERNAR LOS ELEMENTOS EN LA INTERFAZ.
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        //LABELS OPERANDOS
        Label operando1 = new Label("Operando 1");
        Label operando2 = new Label("Operando 2");

        //TEXTFIELDS OPERANDOS
        TextField textField1 = new TextField();
        textField1.setPromptText("Introduce un valor ");
        TextField textField2 = new TextField();
        textField2.setPromptText("Introduce un valor ");

        //BOTON OPERAR
        Button operar = new Button("Operar");

        //HBOX PARA COLOCAR LOS RADIOBUTTON
        HBox hBoxSumaYMulti = new HBox(10);
        HBox hBoxRestaYDivi = new HBox(10);


        //RADIOBUTTONS OPERACIONES POSIBLES
        RadioButton radioSuma = new RadioButton("Suma");
        RadioButton radioMultiplicacion = new RadioButton("Multiplicacion");
        RadioButton radioResta = new RadioButton("Resta");
        RadioButton radioDivision = new RadioButton("Division");

        hBoxSumaYMulti.getChildren().addAll(radioSuma, radioMultiplicacion);
        hBoxRestaYDivi.getChildren().addAll(radioResta, radioDivision);


        //LABEL Y TEXTFIELD RESULTADO DE LA OPERACIÓN
        Label resultado = new Label("Resultado");
        TextField textField3 = new TextField();
        textField3.setPromptText("Resultado");
        textField3.setEditable(false);

        //POSICIONES DENTRO DEL GRID
        gridPane.add(operando1,0,0);
        gridPane.add(operando2,0,1);
        gridPane.add(textField1,1,0);
        gridPane.add(textField2,1,1);
        gridPane.add(operar,1,2);
        gridPane.add(hBoxSumaYMulti,1,3);
        gridPane.add(hBoxRestaYDivi,1,4);
        gridPane.add(resultado, 0, 5);
        gridPane.add(textField3,1,5);



        //ACCIONES AL PRESIONAR EL BOTON.
        operar.setOnMousePressed(event -> {

            //CREAMOS UN IF QUE COMPRUEBE TODAS LA TIPO DE CONBINACIONES DE DOBLE OPERANDO O MAS QUE PUEDAN SELECCIONARSE
            //A LA VEZ Y LANZA UN ERROR DICIENDOLE AL USUARIO QUE SOLO PUEDE SELECCIONAR UNA OPCION NO MAS DE UNA
            if ((radioSuma.isSelected() && radioMultiplicacion.isSelected()
                    && radioResta.isSelected() && radioDivision.isSelected()//EN ESTAS DOS LINEAS INDICAMOS QUE TODOS LOS CAMPOS SEAN SELECCIONADOS (ERROR)

                    || radioSuma.isSelected() && radioMultiplicacion.isSelected())//EN ESTA SI SUMA Y MULTIPLICACION ESTAN SELECCIONADAS A LA VEZ(ERROR)

                    || radioResta.isSelected() && radioDivision.isSelected()//EN ESTA SI RESTA Y DIVISION ESTAN SELECCIONADAS A LA VEZ(ERROR)

                    || radioSuma.isSelected() && radioResta.isSelected()//EN ESTA SI SUMA Y RESTA ESTAN SELECCIONADAS A LA VEZ(ERROR)

                    || radioMultiplicacion.isSelected() && radioDivision.isSelected()//EN ESTA SI MULTIPLICACION Y DIVISION ESTAN SELECCIONADAS A LA VEZ(ERROR)

                    || radioMultiplicacion.isSelected() && radioResta.isSelected()//EN ESTA SI RESTA Y MULTIPLICACION ESTAN SELECCIONADAS A LA VEZ(ERROR)

                    ||  radioSuma.isSelected() && radioDivision.isSelected()) {//EN ESTA SI SUMA Y DIVISION ESTAN SELECCIONADAS A LA VEZ(ERROR)

                //CREAMOS UN ALERT QUE INDICARA EL ERROR COMETIDO POR EL USUARIO AL SELECCIONAR LA OPERACION
                Alert error = new Alert(Alert.AlertType.ERROR);
                error.setTitle("Error");
                error.setHeaderText("Error al seleccionar una operaion");
                error.setContentText("Tienes que elegir una operacion nada mas");
                error.show();
            }else{

                //CREAMOS UN IF QUE COMPRUEBE SI RADIODIVISION ES SELECCIONADO Y EL OPERANDO1 O OPERANDO2 SON IGUAL A 0 O NO CONTIENEN NADA QUE SALTE EL ERROR( ERRORRRR)
                if (radioDivision.isSelected() && textField1.getText().equals("0") ||radioDivision.isSelected() && textField2.getText().equals("0")
                ||radioDivision.isSelected() && textField1.getText().equals("") ||radioDivision.isSelected() && textField2.getText().equals("")){

                    //CREAMOS LA ALERTA CON EL ERROR EN CONCRETO
                        Alert error = new Alert(Alert.AlertType.ERROR);
                        error.setTitle("Error");
                        error.setHeaderText("Error al indicar los valores");
                        error.setContentText("Ninguno de los dos valores pueden ser 0 o  no contener nada");
                        error.show();

                }


                //CREAMOS UN IF PARA COMRPOBAR QUE SI NINGUN DE LOS RADIOS ESTA SELECCIONADO DE UN ERROR.
                //YA QUE SI O SI UNO TIENE QUE SELECCIONAR
                if(!radioSuma.isSelected() && !radioMultiplicacion.isSelected() && !radioResta.isSelected() && !radioDivision.isSelected()){

                    //CREAMOS LA ALERTA CON EL ERROR EN CONCRETO
                    Alert error = new Alert(Alert.AlertType.ERROR);
                    error.setTitle("Error");
                    error.setHeaderText("Error al indicar la accion");
                    error.setContentText("No se ha indicado ninguna operacion por favor seleccione una de las posibles.");
                    error.show();

                }




                if(radioDivision.isSelected()){//INDICAMOS QUE SI SOLO ESTA SELECCIONADO DIVISION SIN NINGUN CASO ANTERIOR PUES QUE REALICE LA DIVISION Y LA MUESTRE EN EL TEXTFIELD DEL RESULTADO

                    int division = Integer.parseInt(textField1.getText() ) / Integer.parseInt(textField2.getText()) ;

                    textField3.setText(String.valueOf(division));


                }else if (radioSuma.isSelected()){//INDICAMOS SI ESTA SELECCIONADO SUMA QUE REALICE LA SUMA Y LA MUESTRE EN EL TEXTFIELD DEL RESULTADO
                    int suma = Integer.parseInt(textField1.getText() ) + Integer.parseInt(textField2.getText()) ;

                    textField3.setText(String.valueOf(suma));

                }else if (radioResta.isSelected()){//INDICAMOS SI ESTA SELECCIONADO RESTA QUE REALICE LA RESTA Y LA MUESTRE EN EL TEXTFIELD DEL RESULTADO
                    int resta = Integer.parseInt(textField1.getText() ) - Integer.parseInt(textField2.getText()) ;

                    textField3.setText(String.valueOf(resta));
                }else if (radioMultiplicacion.isSelected()){//INDICAMOS SI ESTA SELECCIONADO MULTIPLICACION QUE REALICE LA MULTIPLICACION Y LA MUESTRE EN EL TEXTFIELD DEL RESULTADO
                    int multiplicacion = Integer.parseInt(textField1.getText() ) * Integer.parseInt(textField2.getText()) ;

                    textField3.setText(String.valueOf(multiplicacion));
                }


            }

        });



        root.setCenter(gridPane);
        BorderPane.setMargin(gridPane, new Insets(30,0,0,55));
        Scene scene = new Scene(root, 350, 260);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}