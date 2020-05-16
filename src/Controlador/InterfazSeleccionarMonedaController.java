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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.fxml.FXML;
import javafx.scene.control.TitledPane;
import javafx.fxml.Initializable;

public class InterfazSeleccionarMonedaController implements Initializable
{
    @FXML
    private TitledPane frame;
    @FXML
    private Button btnAceptar;
    @FXML
    private Button btnCancelar;
    ObservableList<String> monedas;
    @FXML
    private Label lblSeleccionarMoneda;
    @FXML
    private ComboBox<String> cmbMoneda;
    
    public InterfazSeleccionarMonedaController() {
        this.monedas = FXCollections.observableArrayList();
    }
    
    public void initialize(final URL url, final ResourceBundle rb) {
        this.monedas.addAll(new String[] { "\u20ac", "$", "¥", "£" });
        this.cmbMoneda.setItems((ObservableList)this.monedas);
        final String idioma = InterfazControlador.idioma;
        switch (idioma) {
            case "ESP": {
                this.btnAceptar.setText("Aceptar");
                this.btnCancelar.setText("Cancelar");
                this.lblSeleccionarMoneda.setText("Selecciona moneda");
                break;
            }
            case "ING": {
                this.btnAceptar.setText("Ok");
                this.btnCancelar.setText("Cancel");
                this.lblSeleccionarMoneda.setText("Select currency");
                break;
            }
            case "CAT": {
                this.btnAceptar.setText("Acceptar");
                this.btnCancelar.setText("Cancel·lar");
                this.lblSeleccionarMoneda.setText("Selecciona moneda");
                break;
            }
            case "JAP": {
                this.btnAceptar.setText("\u53d7\u3051\u5165\u308c\u308b");
                this.btnCancelar.setText("\u30ad\u30e3\u30f3\u30bb\u30eb\u3059\u308b");
                this.lblSeleccionarMoneda.setText("\u901a\u8ca8\u3092\u9078\u629e");
                break;
            }
            case "FRA": {
                this.btnAceptar.setText("Accepter");
                this.btnCancelar.setText("Annuler");
                this.lblSeleccionarMoneda.setText("s\u00e9lectionner la devise");
                break;
            }
            case "RUS": {
                this.btnAceptar.setText("\u043f\u0440\u0438\u043d\u0438\u043c\u0430\u0442\u044c");
                this.btnCancelar.setText("\u043e\u0442\u043c\u0435\u043d\u0438\u0442\u044c");
                this.lblSeleccionarMoneda.setText("\u0432\u044b\u0431\u0435\u0440\u0438\u0442\u0435 \u0432\u0430\u043b\u044e\u0442\u0443");
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
        InterfazControlador.moneda = (String)this.cmbMoneda.getValue();
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
