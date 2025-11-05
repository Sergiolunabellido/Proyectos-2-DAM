package com.example.ejercicio2repasojavafx;

import javafx.application.Application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        BorderPane root = new BorderPane();

        //TOP
        MenuBar menuBar = new MenuBar();
        Menu menu = new Menu("Archivo");
        MenuItem menuItemNew = new MenuItem("Nuevo");
        MenuItem menuItemSalir = new MenuItem("Salir");
        MenuItem menuItemSave = new MenuItem("Guardar");
        menu.getItems().addAll(menuItemNew, menuItemSalir, menuItemSave);
        menuBar.getMenus().add(menu);

        menuItemSalir.setOnAction(e -> {
            stage.close();
        });

        root.setTop(menuBar);

        //LEFT
        VBox vBoxLeft = new VBox();
        vBoxLeft.setPadding(new Insets(10, 10, 10, 10));
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        Label labelName = new Label("Nombre:");
        TextField textFieldName = new TextField();
        textFieldName.setPromptText("Introduce tu nombre:");

        Label labelEmail = new Label("Email:");
        TextField textFieldEmail = new TextField();
        textFieldEmail.setPromptText("Introduce tu email:");

        Label labelPassword = new Label("Password:");
        PasswordField textFieldPassword = new PasswordField();
        textFieldPassword.setPromptText("Introduce tu password:");

        Button registrar = new Button("Registrar");
        registrar.setMinSize(200, 20);

        gridPane.add(labelName, 0, 0);
        gridPane.add(textFieldName, 0, 1);
        gridPane.add(labelEmail, 0, 2);
        gridPane.add(textFieldEmail, 0, 3);
        gridPane.add(labelPassword, 0, 4);
        gridPane.add(textFieldPassword, 0, 5);
        gridPane.add(registrar, 0, 6);



        vBoxLeft.getChildren().addAll(gridPane);
        root.setLeft(vBoxLeft);

        //CENTER
        VBox vBoxCenter = new VBox();
        vBoxCenter.setPadding(new Insets(10, 10, 10, 10));
        vBoxCenter.setSpacing(10);

        Label labelUsuario = new Label("Usuario:");

        TableView tableView = new TableView();
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        TableColumn tableColumnName = new TableColumn("Nombre");
        TableColumn tableColumnEmail = new TableColumn("Email");
        TableColumn tableColumnFecha = new TableColumn("Fecha");

        tableColumnName.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
        tableColumnEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
        tableColumnFecha.setCellValueFactory(new PropertyValueFactory<>("Fecha"));
        tableView.getColumns().addAll(tableColumnName, tableColumnEmail, tableColumnFecha);


        registrar.setOnMousePressed(event ->{

            if(textFieldName.getText().equals( "") || textFieldEmail.getText().equals("") || textFieldPassword.getText().equals("")){

                Alert error = new Alert(Alert.AlertType.ERROR);
                error.setTitle("Error");
                error.setHeaderText("Campos vacíos");
                error.setContentText("Por favor, completa todos los campos antes de continuar.");
                error.showAndWait();

            }else {
                tableView.getItems().addAll(new Persona(textFieldName.getText(), textFieldEmail.getText()));
                Alert error = new Alert(Alert.AlertType.CONFIRMATION);
                error.setTitle("Correct");
                error.setHeaderText("Usuario registrado");
                error.setContentText("Los datos se han introducido correctamente.");
                error.showAndWait();
            }
        });

        vBoxCenter.getChildren().addAll(labelUsuario, tableView);
        root.setCenter(vBoxCenter);

        //RIGHT
        VBox vBoxRight = new VBox();
        vBoxRight.setSpacing(20);
        vBoxRight.setPadding(new Insets(10));
        CheckBox newsletter = new CheckBox("Suscribete a la newsletter");

        ToggleGroup radioButtons = new ToggleGroup();
        RadioButton radioButtonGratis = new RadioButton("Gratis");
        RadioButton radioButtonPremium = new RadioButton("Premium");
        RadioButton radioButtonEmpresarial = new RadioButton("Empresarial");
        radioButtonGratis.setToggleGroup(radioButtons);
        radioButtonPremium.setToggleGroup(radioButtons);
        radioButtonEmpresarial.setToggleGroup(radioButtons);

        VBox vboxRight = new VBox();
        vBoxRight.setSpacing(20);
        vboxRight.setSpacing(10);
        vboxRight.getChildren().addAll(radioButtonGratis, radioButtonPremium, radioButtonEmpresarial);

        Spinner spinnerGratis = new Spinner(0,10,0);

        vBoxRight.getChildren().addAll(newsletter,vboxRight,spinnerGratis);

        root.setRight(vBoxRight);

        //BOTTOM


        ToolBar toolBar = new ToolBar();
        toolBar.setPrefHeight(50);
        toolBar.setPadding(new Insets(8));

        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.setPadding(new Insets(10));
        hBox.setAlignment(Pos.CENTER);

        Button actualizar = new Button("Actualizar Tabla");

        actualizar.setOnMousePressed(event ->{

            tableView.setItems(null);

        });

        Button eliminarUsuario = new Button("Eliminar Usuario");

        eliminarUsuario.setOnMousePressed(e -> {

            tableView.getItems().remove(tableView.getSelectionModel().getSelectedIndex());

        });

        Button salir = new Button("Salir");

        salir.setOnMousePressed(event ->{
                stage.close();
        });


        hBox.getChildren().addAll(actualizar,eliminarUsuario,salir);
        toolBar.getItems().add(hBox);
        root.setBottom(toolBar);


        root.setStyle("-fx-background-color: #ecf0f1;");
        Scene scene = new Scene(root, 700, 350);
        stage.setTitle("Ejercicio2Repaso JavaFX");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}