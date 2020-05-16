// 
// Decompiled by Procyon v0.5.36
// 

package Controlador;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import java.util.ResourceBundle;
import java.net.URL;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.fxml.Initializable;

public class InterfazRegistroController implements Initializable
{
    public static String Usuario;
    public static String Pass;
    @FXML
    private Button btnRegistrarse;
    @FXML
    private Button btnCancelar;
    @FXML
    private PasswordField txtpass;
    @FXML
    private TextField txtusu;
    @FXML
    private DialogPane frame;
    
    public void initialize(final URL url, final ResourceBundle rb) {
        final String idioma = InterfazControlador.idioma;
        switch (idioma) {
            case "ESP": {
                this.btnRegistrarse.setText("Registrarse");
                this.btnCancelar.setText("Cancelar");
                break;
            }
            case "ING": {
                this.btnRegistrarse.setText("Sing in");
                this.btnCancelar.setText("Cancel");
                break;
            }
            case "CAT": {
                this.btnRegistrarse.setText("Registrar-se");
                this.btnCancelar.setText("Cancel·lar");
                break;
            }
            case "JAP": {
                this.btnRegistrarse.setText("\u30b5\u30a4\u30f3\u30a2\u30c3\u30d7");
                this.btnCancelar.setText("\u30ad\u30e3\u30f3\u30bb\u30eb\u3059\u308b");
                break;
            }
            case "FRA": {
                this.btnRegistrarse.setText("S'inscrire");
                this.btnCancelar.setText("Annuler");
                break;
            }
            case "RUS": {
                this.btnRegistrarse.setText("\u0417\u0430\u0440\u0435\u0433\u0438\u0441\u0442\u0440\u0438\u0440\u043e\u0432\u0430\u0442\u044c\u0441\u044f");
                this.btnCancelar.setText("\u043e\u0442\u043c\u0435\u043d\u0438\u0442\u044c");
                break;
            }
        }
    }
    
    @FXML
    private void Registrarse(final ActionEvent event) throws SQLException {
        this.Regis();
    }
    
    public void Regis() throws SQLException {
        InterfazRegistroController.Usuario = this.txtusu.getText();
        InterfazRegistroController.Pass = this.txtpass.getText();
        Controlador.Registrarse(InterfazRegistroController.Usuario, InterfazRegistroController.Pass);
        final Stage stage = (Stage)this.btnRegistrarse.getScene().getWindow();
        stage.close();
    }
    
    @FXML
    private void Cancelar(final ActionEvent event) {
        final Stage stage = (Stage)this.btnCancelar.getScene().getWindow();
        stage.close();
    }
    
    @FXML
    private void Enter(final KeyEvent event) throws SQLException {
        if (event.getCode() == KeyCode.ENTER) {
            this.Regis();
        }
        if (event.getCode() == KeyCode.ESCAPE) {
            final Stage stage = (Stage)this.btnCancelar.getScene().getWindow();
            stage.close();
        }
    }
}
