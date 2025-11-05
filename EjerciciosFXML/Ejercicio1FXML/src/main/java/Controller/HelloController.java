package Controller;

import com.example.ejercicio1fxml.HelloApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    public Button botonRegistroCompleto;
    @FXML
    private Button botonRegistrarse;
    @FXML
    private Button botonInicioSesion;
    @FXML
    private TextField textFieldUsuario;
    @FXML
    private Label contraseña;
    @FXML
    private TextField textFieldContraseña;
    @FXML
    private Label usuario;

    @FXML
    protected void registro(){

            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("formulario-registro.fxml"));
            Scene scene = null;
            try {
                scene = new Scene(fxmlLoader.load(), 350, 450);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            stage.setTitle("Formulario de registro");
            stage.setScene(scene);

            FormularioRegistro controller = fxmlLoader.getController();
            controller.setStage(stage);

            stage.show();


    }

    @FXML
    protected void registroCompleto(){

        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("formulario-completo.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 600, 430);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.setTitle("Formulario de registro completo");
        stage.setScene(scene);

        stage.show();


    }
}