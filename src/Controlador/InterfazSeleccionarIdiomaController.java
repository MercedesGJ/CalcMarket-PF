// 
// Decompiled by Procyon v0.5.36
// 

package Controlador;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.util.ResourceBundle;
import java.net.URL;
import javafx.collections.FXCollections;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.fxml.Initializable;

public class InterfazSeleccionarIdiomaController implements Initializable
{
    @FXML
    private ComboBox<String> cmbIdioma;
    @FXML
    private Button btnAceptar;
    @FXML
    private Button btnCancelar;
    ObservableList<String> idiomas;
    String IdiomaSel;
    @FXML
    private TitledPane frame;
    @FXML
    private Label lblSeleccionarIdioma;
    
    public InterfazSeleccionarIdiomaController() {
        this.idiomas = FXCollections.observableArrayList();
    }
    
    public void initialize(final URL url, final ResourceBundle rb) {
        this.idiomas.addAll(new String[] { "ESP", "ING", "CAT", "JAP", "FRA", "RUS" });
        this.cmbIdioma.setItems((ObservableList)this.idiomas);
        final String idioma2;
        final String idioma = idioma2 = InterfazControlador.idioma;
        switch (idioma2) {
            case "ESP": {
                this.btnAceptar.setText("Aceptar");
                this.btnCancelar.setText("Cancelar");
                this.lblSeleccionarIdioma.setText("Selecciona Idioma");
                break;
            }
            case "ING": {
                this.btnAceptar.setText("Ok");
                this.btnCancelar.setText("Cancel");
                this.lblSeleccionarIdioma.setText("Select language");
                break;
            }
            case "CAT": {
                this.btnAceptar.setText("Acceptar");
                this.btnCancelar.setText("Cancel·lar");
                this.lblSeleccionarIdioma.setText("Selecciona Idioma");
                break;
            }
            case "JAP": {
                this.btnAceptar.setText("\u53d7\u3051\u5165\u308c\u308b");
                this.btnCancelar.setText("\u30ad\u30e3\u30f3\u30bb\u30eb\u3059\u308b");
                this.lblSeleccionarIdioma.setText("\u8a00\u8a9e\u3092\u9078\u629e\u3057\u3066\u304f\u3060\u3055\u3044");
                break;
            }
            case "FRA": {
                this.btnAceptar.setText("Accepter");
                this.btnCancelar.setText("Annuler");
                this.lblSeleccionarIdioma.setText("Choisissez la langue");
                break;
            }
            case "RUS": {
                this.btnAceptar.setText("\u043f\u0440\u0438\u043d\u0438\u043c\u0430\u0442\u044c");
                this.btnCancelar.setText("\u043e\u0442\u043c\u0435\u043d\u0438\u0442\u044c");
                this.lblSeleccionarIdioma.setText("\u0412\u044b\u0431\u0435\u0440\u0438\u0442\u0435 \u044f\u0437\u044b\u043a");
                break;
            }
        }
    }
    
    @FXML
    private void AceptarIdioma(final ActionEvent event) {
        this.Aceptar();
    }
    
    @FXML
    private void Cancelar(final ActionEvent event) {
        final Stage stage = (Stage)this.btnCancelar.getScene().getWindow();
        stage.close();
    }
    
    public void Aceptar() {
        InterfazControlador.idioma = (String)this.cmbIdioma.getValue();
        final Stage stage = (Stage)this.btnAceptar.getScene().getWindow();
        stage.close();
    }
    
    @FXML
    private void Enter(final KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            this.Aceptar();
        }
        if (event.getCode() == KeyCode.ESCAPE) {
            final Stage stage = (Stage)this.btnCancelar.getScene().getWindow();
            stage.close();
        }
    }
}
