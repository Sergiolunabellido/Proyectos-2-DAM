package com.example.demofx;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Formulario extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Stage stage = new Stage();
        stage.setTitle("Formulario");

        BorderPane root = new BorderPane();

        //Creamos el menu
        MenuBar menuBar = new MenuBar();


        //Creamos los items del menu
        Menu archivo = new Menu("Archivo");
        Menu editar = new Menu("Editar");

        //Creamos items para los menus
        //Menu archivo
        MenuItem abrir = new MenuItem("Abrir");
        MenuItem nuevo = new MenuItem("Nuevo");
        MenuItem salir = new MenuItem("Salir");


        salir.setOnAction(e -> {
            stage.close();
        });
        //Menu editar
        MenuItem copiar = new MenuItem("Copiar");
        MenuItem cortar = new MenuItem("Cortar");
        MenuItem pegar = new MenuItem("Pegar");

        archivo.getItems().addAll(abrir, nuevo, salir);
        editar.getItems().addAll(copiar, cortar, pegar);

        ToolBar toolBar = new ToolBar();
        Button btnRojo = new Button("Rojo");
        Button btnAmarillo = new Button("Amarillo");

        toolBar.getItems().addAll(btnRojo, btnAmarillo);

        menuBar.getMenus().addAll(archivo, editar);
        //Empezamos con el cuerpo de la ventana(vbox,hbox...)
        VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.setMaxSize(300,300);
        vbox.setAlignment(Pos.CENTER);

        //Creamos hbox para cada apartado de la ventana
        //Creacion de hboxNombre

        //Elementos hboxNombre
        Label nombreLabel = new Label("Nombre:");
        TextField nombreTextField = new TextField();


        //Creacion hboxContraseña

        //Creacion de elementos contraseña
        Label contraLabel = new Label("Contraseña:");
        PasswordField contraTextField = new PasswordField();

        //Creacion de hboxGenero

        //Generacion elementos hboxGenero
        Label generoLabel = new Label("Genero:");
        RadioButton masculino = new RadioButton("Maculino");
        RadioButton femenino = new RadioButton("Femenino");


        //Creacion de checkbox
        CheckBox newsletter = new CheckBox("Suscribete al newsletter");


        //Creamos el hboxPais

        //Creamos label y choiceBox para elegir pais
        Label paisLabel = new Label("Pais:");

        ChoiceBox<String> pais = new ChoiceBox<>();
        pais.setMaxSize(100,100);
        pais.setValue("Paises");
        pais.getItems().add("España");
        pais.getItems().add("Germany");
        pais.getItems().add("China");



        //Creamos el hboxEdad

        //Creamos los elementos del hbox
        Label edadLabel = new Label("Edad:");
        Spinner<Integer> edadSpinner = new Spinner<>();
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0);
        edadSpinner.setValueFactory(valueFactory);
        edadSpinner.setEditable(true);

        //Creamos el hboxFecha

        //Creamos los elementos del hbox
        Label fechaLabel = new Label("Fecha:");
        DatePicker fechaPicker = new DatePicker();

        //Creamos un boton para enviar
        Button enviar = new Button("Enviar");
        enviar.setOnAction(e -> {

            if(masculino.isSelected()){
                System.out.println("Se ha enviado el Formulario con los datos: \n" +
                        "Nombre: " + nombreTextField.getText().trim() + " Contraseña: "
                        + contraTextField.getText().trim() + " Genero:  masculino"
                        + " Pais: " + pais.getValue() + " Edad: " + edadSpinner.getValue()
                        + " Fecha: " + fechaPicker.getValue());

            }else {

                System.out.println("Se ha enviado el Formulario con los datos: \n" +
                        "Nombre: " + nombreTextField.getText().trim() + " Contraseña: "
                        + contraTextField.getText().trim() + " Genero:  femenino"
                        + " Pais: " + pais.getValue() + " Edad: " + edadSpinner.getValue()
                        + " Fecha: " + fechaPicker.getValue().toString());

            }

        });

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(15);
        grid.setVgap(15);

        //Añadir nombre
        grid.add(nombreLabel, 0, 0);
        grid.add(nombreTextField, 1, 0);
        //Añadir contraseña
        grid.add(contraLabel, 0, 1);
        grid.add(contraTextField, 1, 1);
        //Añadir genero
        grid.add(generoLabel, 0, 2);
        grid.add(masculino, 1, 2);
        grid.add(femenino, 2, 2);
        //Añadir newsletter
        grid.add(newsletter, 1, 3);
        //Añadir pais
        grid.add(paisLabel, 0, 4);
        grid.add(pais, 1, 4);
        //Añadir edad
        grid.add(edadLabel, 0, 5);
        grid.add(edadSpinner, 1, 5);
        //Añadir fecha
        grid.add(fechaLabel, 0, 6);
        grid.add(fechaPicker, 1, 6);
        //Añadir boton
        grid.add(enviar, 1, 7);



        vbox.getChildren().addAll(menuBar, toolBar);

        root.setTop(vbox);
        root.setCenter(grid);
        Scene scene = new Scene(root, 500, 500);
        vbox.setMaxWidth(scene.getWidth());
        stage.setScene(scene);
        stage.show();















    }
}
