// 
// Decompiled by Procyon v0.5.36
// 

package Controlador;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import java.awt.Component;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import java.util.ResourceBundle;
import java.net.URL;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.fxml.Initializable;

public class InterfazIniciarSesionController implements Initializable
{
    public static String Usuario;
    public static String Pass;
    @FXML
    private TextField txtUsu;
    @FXML
    private PasswordField txtpass;
    @FXML
    private Button btnIniciarSesion;
    @FXML
    private Button btnCancelar;
    @FXML
    private TitledPane frame;
    @FXML
    private Label lblIncorrecto;
    public String idioma;
    @FXML
    private Label lblIniciarSesion;
    @FXML
    private Label lblUsuario;
    @FXML
    private Label lblContrase\u00f1a;
    public static int ID;
    
    public void initialize(final URL url, final ResourceBundle rb) {
        this.idioma = InterfazControlador.idioma;
        final String idioma = this.idioma;
        switch (idioma) {
            case "ESP": {
                this.lblContrase\u00f1a.setText("Contrase\u00f1a");
                this.lblIniciarSesion.setText("Iniciar sesi\u00f3n");
                this.lblUsuario.setText("Usuario");
                this.btnIniciarSesion.setText("Iniciar sesi\u00f3n");
                this.btnCancelar.setText("Cancelar");
                break;
            }
            case "ING": {
                this.lblContrase\u00f1a.setText("Password");
                this.lblIniciarSesion.setText("Log in");
                this.lblUsuario.setText("User");
                this.btnIniciarSesion.setText("Log in");
                this.btnCancelar.setText("Cancel");
                break;
            }
            case "CAT": {
                this.lblContrase\u00f1a.setText("Contrasenya");
                this.lblIniciarSesion.setText("Inici de sessi\u00f3");
                this.lblUsuario.setText("Usuari");
                this.btnIniciarSesion.setText("Inici de sessi\u00f3");
                this.btnCancelar.setText("Cancel·lar");
                break;
            }
            case "JAP": {
                this.lblContrase\u00f1a.setText("\u30d1\u30b9\u30ef\u30fc\u30c9");
                this.lblIniciarSesion.setText("\u30ed\u30b0\u30a4\u30f3");
                this.lblUsuario.setText("\u30e6\u30fc\u30b6\u30fc");
                this.btnIniciarSesion.setText("\u30ed\u30b0\u30a4\u30f3");
                this.btnCancelar.setText("\u30ad\u30e3\u30f3\u30bb\u30eb\u3059\u308b");
                break;
            }
            case "FRA": {
                this.btnIniciarSesion.setText("Commencer la session");
                this.btnCancelar.setText("Annuler");
                this.lblIniciarSesion.setText("Commencer la session");
                this.lblContrase\u00f1a.setText("mot de passe");
                this.lblUsuario.setText("utilisateur");
                break;
            }
            case "RUS": {
                this.btnIniciarSesion.setText("\u0432\u043e\u0439\u0442\u0438 \u0432 \u0441\u0438\u0441\u0442\u0435\u043c\u0443");
                this.btnCancelar.setText("\u043e\u0442\u043c\u0435\u043d\u0438\u0442\u044c");
                this.lblIniciarSesion.setText("\u0432\u043e\u0439\u0442\u0438 \u0432 \u0441\u0438\u0441\u0442\u0435\u043c\u0443");
                this.lblContrase\u00f1a.setText("\u043f\u0430\u0440\u043e\u043b\u044c");
                this.lblUsuario.setText("\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u0442\u0435\u043b\u044c");
                break;
            }
        }
    }
    
    @FXML
    private void IniciarSesion(final ActionEvent event) throws SQLException {
        this.IniSe();
    }
    
    public void IniSe() throws SQLException {
        InterfazIniciarSesionController.Usuario = this.txtUsu.getText();
        InterfazIniciarSesionController.Pass = this.txtpass.getText();
        final boolean a = Controlador.IniciarSesion(InterfazIniciarSesionController.Usuario, InterfazIniciarSesionController.Pass);
        this.lblIncorrecto.setText("");
        if (a) {
            this.lblIncorrecto.setText(" ");
            final String idioma = this.idioma;
            switch (idioma) {
                case "ESP": {
                    JOptionPane.showMessageDialog(null, "Inicio de sesi\u00f3n correcto");
                    break;
                }
                case "ING": {
                    JOptionPane.showMessageDialog(null, "Correct log in");
                    break;
                }
                case "CAT": {
                    JOptionPane.showMessageDialog(null, "Inici de sessi\u00f3 correcte");
                    break;
                }
                case "JAP": {
                    JOptionPane.showMessageDialog(null, "\u6b63\u3057\u3044\u30ed\u30b0\u30a4\u30f3");
                    break;
                }
            }
            InterfazIniciarSesionController.ID = Controlador.SacarID(InterfazIniciarSesionController.Usuario, InterfazIniciarSesionController.Pass);
            final Stage stage = (Stage)this.btnIniciarSesion.getScene().getWindow();
            stage.close();
        }
        else {
            final String idioma2 = this.idioma;
            switch (idioma2) {
                case "ESP": {
                    this.lblIncorrecto.setText("Contrase\u00f1a o usuario incorrecto");
                    break;
                }
                case "ING": {
                    this.lblIncorrecto.setText("Password or user wrong");
                    break;
                }
                case "CAT": {
                    this.lblIncorrecto.setText("Contrasenya o usuari incorrecte");
                    break;
                }
                case "JAP": {
                    this.lblIncorrecto.setText("\u9593\u9055\u3063\u305f\u30d1\u30b9\u30ef\u30fc\u30c9\u307e\u305f\u306f\u30e6\u30fc\u30b6\u30fc\u540d");
                    break;
                }
            }
        }
    }
    
    @FXML
    private void Cancelar(final ActionEvent event) {
        final Stage stage = (Stage)this.btnCancelar.getScene().getWindow();
        stage.close();
    }
    
    @FXML
    private void Enter(final KeyEvent event) throws SQLException {
        if (event.getCode() == KeyCode.ENTER) {
            this.IniSe();
        }
        if (event.getCode() == KeyCode.ESCAPE) {
            final Stage stage = (Stage)this.btnCancelar.getScene().getWindow();
            stage.close();
        }
    }
    
    @FXML
    private void Escape(final KeyEvent event) throws SQLException {
        if (event.getCode() == KeyCode.ENTER) {
            this.IniSe();
        }
        if (event.getCode() == KeyCode.ESCAPE) {
            final Stage stage = (Stage)this.btnCancelar.getScene().getWindow();
            stage.close();
        }
    }
    
    @FXML
    private void EnterUsu(final KeyEvent event) throws SQLException {
        if (event.getCode() == KeyCode.ENTER) {
            this.IniSe();
        }
        if (event.getCode() == KeyCode.ESCAPE) {
            final Stage stage = (Stage)this.btnCancelar.getScene().getWindow();
            stage.close();
        }
    }
    
    @FXML
    private void Entertxt(final KeyEvent event) throws SQLException {
        if (event.getCode() == KeyCode.ENTER) {
            this.IniSe();
        }
        if (event.getCode() == KeyCode.ESCAPE) {
            final Stage stage = (Stage)this.btnCancelar.getScene().getWindow();
            stage.close();
        }
    }
}
