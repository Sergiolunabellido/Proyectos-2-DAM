package com.example.ejerciciorepasojavafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import net.synedra.validatorfx.Check;

import java.io.IOException;
import java.time.LocalDate;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        BorderPane root = new BorderPane();

        //TOP
        HBox hBoxTop = new HBox();
        hBoxTop.setSpacing(20);

        StackPane SPheader = new StackPane();
        SPheader.setAlignment(Pos.CENTER);
        SPheader.setStyle("-fx-background-color: white;-fx-border-color: lightgrey;-fx-border-style: solid; -fx-border-radius: 3");
        SPheader.setMinWidth(300);
        SPheader.setMaxHeight(50);
        Label labelHeader = new Label("Header");
        labelHeader.setTextFill(Color.BLACK);
        SPheader.getChildren().add(labelHeader);

        StackPane SPdate= new StackPane();
        SPdate.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
        SPdate.setMaxWidth(160);
        DatePicker datePicker = new DatePicker(LocalDate.now());
        datePicker.setFocusTraversable(false);


        SPdate.getChildren().add(datePicker);

        hBoxTop.getChildren().addAll(SPheader,SPdate);
        hBoxTop.setPadding(new Insets(10,10,10,10));
        hBoxTop.setAlignment(Pos.CENTER_LEFT);
        root.setTop(hBoxTop);

        //CENTER
        VBox VboxCenter = new VBox();
        GridPane gridPane = new GridPane();

        Label labeluser = new Label("User");
        Label labelpass = new Label("Password");

        TextField textFielduser = new TextField();
        textFielduser.setPromptText("Introduce your username");

        PasswordField password = new PasswordField();
        password.setPromptText("Introduce your password");

        TextArea textArea = new TextArea();
        textArea.setEditable(false);
        textArea.setText("Welcome to the formulary");
        textArea.setPrefColumnCount(15);
        textArea.setPrefRowCount(3);

        Button button = new Button("Submit");
        button.setPrefWidth(250);
        button.setStyle("-fx-background-color: white;");

        Label state = new Label("State:");
        Label statecont = new Label();

        gridPane.add(labeluser,0,0);
        gridPane.add(textFielduser,1,0);
        gridPane.add(labelpass,0,1);
        gridPane.add(password,1,1);
        gridPane.add(textArea,1,2);
        gridPane.add(button,1,3);
        gridPane.add(state,0,4);
        gridPane.add(statecont,1,4);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        VboxCenter.getChildren().add(gridPane);
        VboxCenter.setPadding(new Insets(10,10,10,10));
        VboxCenter.setStyle("-fx-border-style: solid; -fx-border-width: 0.2; -fx-border-radius: 3");
        VboxCenter.setMinWidth(300);
        VboxCenter.setMaxWidth(300);
        VboxCenter.setMinHeight(220);
        VboxCenter.setMaxHeight(230);
        root.setCenter(VboxCenter);

        //RIGHT

        VBox vBox = new VBox();
        vBox.setPadding(new Insets(10,10,10,10));
        vBox.setSpacing(10);

        CheckBox checkbox = new CheckBox("Aceptar Terminos");

        RadioButton opcionA =  new RadioButton("Opción A");
        RadioButton opcionB =  new RadioButton("Opción B");

        Label labelChoice =  new Label("ChoiceBox:");

        ChoiceBox choiceBox = new ChoiceBox();
        choiceBox.setValue("Elige");
        choiceBox.getItems().addAll("Rojo","Verde");

        Label labelCombo =  new Label("ComBoBox:");

        ComboBox comboBox = new ComboBox();
        comboBox.setPromptText("Elige");
        comboBox.getItems().addAll("Rojo","Verde");


        vBox.getChildren().addAll(checkbox,opcionA,opcionB,labelChoice,choiceBox,labelCombo,comboBox);
        vBox.setMinWidth(160);
        vBox.setMaxWidth(160);
        vBox.setMinHeight(230);
        vBox.setMaxHeight(230);

        vBox.setStyle("-fx-border-style: solid; -fx-border-width: 0.2; -fx-border-radius: 3");

        root.setRight(vBox);

        //BOTTOM
        HBox hBox = new HBox();
        hBox.setSpacing(20);
        hBox.setPadding(new Insets(10,10,10,10));
        hBox.setAlignment(Pos.TOP_RIGHT);

        Label label = new Label("Spinner:");

        Spinner<Integer> spinner = new Spinner<>(0,10,0);
        spinner.setEditable(true);
        spinner.setMaxWidth(50);
        spinner.setMaxHeight(50);


        hBox.getChildren().addAll(label,spinner);
        root.setBottom(hBox);

        BorderPane.setMargin(vBox, new Insets(5,20,10,10));
        BorderPane.setMargin(VboxCenter, new Insets(0,10,10,10));
        BorderPane.setMargin(hBox, new Insets(-10,10,20,0));
        Scene scene = new Scene(root, 500, 330);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}