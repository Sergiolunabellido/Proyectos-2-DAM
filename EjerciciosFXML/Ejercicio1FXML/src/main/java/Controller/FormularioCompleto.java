package Controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class FormularioCompleto {
    @FXML
    private Label LBLNombre;

    @FXML
    private TextField TextFieldNombre;

    @FXML
    private Label LBLContraseña;

    @FXML
    private PasswordField TextFieldContraseña;

    @FXML
    private Label LBLFecha;

    @FXML
    private DatePicker Fecha;

    @FXML
    private Label LBLPais;

    @FXML
    private ComboBox ComboBoxPais;

    @FXML
    private Label LBLGenero;

    @FXML
    private Label LBLIntereses;

    @FXML
    private Label LBLComentarios;

    @FXML
    private TextField TextFieldComentario;

    @FXML
    private RadioButton RBmasculino;

    @FXML
    private RadioButton RBFemenino;

    @FXML
    private CheckBox Musica;

    @FXML
    private CheckBox Deporte;

    @FXML
    private CheckBox Lectura;

    @FXML
    private Button enviar;

    @FXML
    private Button limpiar;

    @FXML
    private VBox VboxResultados;

    @FXML
    private Label NombreUsuario;

    @FXML
    private Label PaisUsuario;

    @FXML
    private Label GeneroUsuario;

    @FXML
    private Label InteresesUsuario;

    @FXML
    private Label FechaUsuario;

    @FXML
    protected void mostrarResultado(){
        NombreUsuario.setText("Nombre: "+TextFieldNombre.getText());
        PaisUsuario.setText("Pais: "+ComboBoxPais.getValue().toString());
        if (RBmasculino.isSelected()) {
            GeneroUsuario.setText("Genero: Masculino");
        }else if (RBFemenino.isSelected()) {
            GeneroUsuario.setText("Genero: Femenino");
        }else  {
            GeneroUsuario.setText("Genero: No tienes genero");
        }

        if (Musica.isSelected() && !Deporte.isSelected() && !Lectura.isSelected()) {
            InteresesUsuario.setText("Interes: Música");
        } else if (!Musica.isSelected() && Deporte.isSelected() && !Lectura.isSelected()) {
            InteresesUsuario.setText("Interes: Deporte");
        } else if (!Musica.isSelected() && !Deporte.isSelected() && Lectura.isSelected()) {
            InteresesUsuario.setText("Interes: Lectura");
        } else if (Musica.isSelected() && Deporte.isSelected() && !Lectura.isSelected()) {
            InteresesUsuario.setText("Interes: Música Deporte");
        } else if (Musica.isSelected() && !Deporte.isSelected() && Lectura.isSelected()) {
            InteresesUsuario.setText("Interes: Música Lectura");
        } else if (!Musica.isSelected() && Deporte.isSelected() && Lectura.isSelected()) {
            InteresesUsuario.setText("Interes: Deporte Lectura");
        } else if (Musica.isSelected() && Deporte.isSelected() && Lectura.isSelected()) {
            InteresesUsuario.setText("Interes: Música Deporte Lectura");
        } else {
            InteresesUsuario.setText("Interes: Sin intereses seleccionados");
        }

        FechaUsuario.setText("Fecha: "+Fecha.getValue().toString());

    };

    @FXML
    protected void limpiar(){

        TextFieldComentario.setText("");
        TextFieldContraseña.setText("");
        TextFieldNombre.setText("");
        Fecha.setValue(null);
        ComboBoxPais.setValue(null);
        RBmasculino.setSelected(false);
        RBFemenino.setSelected(false);
        Musica.setSelected(false);
        Deporte.setSelected(false);
        Lectura.setSelected(false);
        VboxResultados.setVisible(false);
    }
}
