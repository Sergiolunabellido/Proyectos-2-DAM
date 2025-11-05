package com.example.demofx;

import com.almasb.fxgl.ui.ProgressBar;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.w3c.dom.Text;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.setMaxWidth(300);
        vbox.setMaxHeight(300);
        //vbox.setAlignment(Pos.CENTER);

        HBox hbox = new HBox();
        hbox.setSpacing(10);
        hbox.setMaxWidth(400);
        hbox.setMaxHeight(400);

        //Nombre
        Label labelNombre = new Label("Usuario:");

        TextField textFieldName = new TextField();
        textFieldName.setPromptText("Escriba su nombre de usuario");

        //Contraseña
        Label labelPass = new Label("Contraseña:");

        PasswordField textFieldPass = new PasswordField();
        textFieldPass.setPromptText("Escriba su contraseña");


        //Direccion
        Label labelDirec = new Label("Direccion:");

        TextField textFieldDirec = new TextField();
        textFieldDirec.setMinHeight(50);
        textFieldDirec.setMaxHeight(50);

        textFieldDirec.setPromptText("Escriba su direccion");

        //Comentario
        Label labelComent = new Label("Comentario:");

        TextField textFieldComent = new TextField();

        textFieldComent.setMinHeight(70);
        textFieldComent.setMaxHeight(70);
        textFieldComent.setPromptText("Escriba su comentario");




        //Crear boton opciones para otras ventanas
        Button btnOpciones = new Button("Ejercicios");

        MenuItem ejercicio = new MenuItem("Ejercicio3");
        MenuItem formulario1 = new MenuItem("Formulario");
        MenuItem tabla1 = new MenuItem("Tabla");
        MenuItem BackGrounds = new MenuItem("BackGrounds");
        MenuItem Views = new MenuItem("Views");
        MenuItem ContenidoFinal = new MenuItem("ContenidoFinal");
        MenuItem cancel = new MenuItem("Cancelar");

        ContextMenu cntMenu = new ContextMenu();
        cntMenu.getItems().addAll(ejercicio, formulario1, tabla1, BackGrounds,Views,ContenidoFinal,cancel);
        btnOpciones.setContextMenu(cntMenu);

        Stage stage1 = new Stage();

        ejercicio.setOnAction(e -> {
            System.out.println("Bienvenido "+textFieldName.getText());

            Ejercicio3 ejercicio3 = new Ejercicio3();
            try {

                ejercicio3.start(stage1);
            }catch (IOException e1) {
                e1.printStackTrace();
            }
        });

        formulario1.setOnAction(e -> {

            Formulario formulario = new Formulario();
            formulario.start(stage1);
        });

        tabla1.setOnAction(e -> {
            Tabla tabla = new Tabla();

            tabla.start(stage1);
        });

        BackGrounds.setOnAction(e -> {

           BackGrounds backGrounds = new BackGrounds();
           backGrounds.start(stage1);

        });


        cancel.setOnAction(e -> {

            System.out.println("Ejercicio Cancelado");
            stage.close();

        });

        Views.setOnAction(e -> {

            Views views = new Views();
            views.start(stage1);

        });


        ContenidoFinal.setOnAction(e -> {

            ParteFinalTema pft = new ParteFinalTema();
            pft.start(stage1);

        });


        Button btnEnviar = new Button("Enviar");
        btnEnviar.setOnAction(e -> {

            System.out.println("Se ha enviado el Formulario con los datos: \n" +
                    "Nombre: " +textFieldName.getText().trim() + " Contraseña: "
                    + textFieldPass.getText().trim() +  " Direccion: " + textFieldDirec.getText() + " Comentario: " + textFieldComent.getText()
                    );

        });



        //Añadimos los elementos y panel al panel grande

        hbox.getChildren().addAll(btnEnviar,btnOpciones);


        vbox.getChildren().addAll(labelNombre,textFieldName,labelPass,textFieldPass,labelDirec,textFieldDirec
                ,labelComent,textFieldComent,hbox);
        BorderPane root = new BorderPane(vbox);


        //Añadimos el panel grande a la escena y damos tamaño y titulo.
        Scene scene = new Scene(root, 380, 380);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}