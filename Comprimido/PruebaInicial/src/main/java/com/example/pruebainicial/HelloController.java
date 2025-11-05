package com.example.pruebainicial;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    private TextField nombreUsuario;

    @FXML
    protected void setNombreUsuario() {
        welcomeText.setText("Holaaaa " + nombreUsuario.getText());
    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Holaaaa " + nombreUsuario.getText());
    }
}