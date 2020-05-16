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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.fxml.Initializable;

public class InterfazConversiondeMonedaController implements Initializable
{
    @FXML
    private Button btnConvertir;
    @FXML
    private TextField txtprecioactual;
    @FXML
    private TextField txtConversionMoneda;
    @FXML
    private ComboBox<String> jcomboMonedaDeseada;
    @FXML
    private Label lblMonedaActual;
    @FXML
    private Label lblMonedaConvertida;
    ObservableList<String> monedas;
    String monedaSel;
    @FXML
    private Label lblmonedaActual;
    @FXML
    private Button btnCerrar;
    
    public InterfazConversiondeMonedaController() {
        this.monedas = FXCollections.observableArrayList();
    }
    
    public void initialize(final URL url, final ResourceBundle rb) {
        this.lblMonedaActual.setText(InterfazControlador.moneda);
        this.monedas.addAll(new String[] { "\u20ac", "$", "¥", "£" });
        this.jcomboMonedaDeseada.setItems((ObservableList)this.monedas);
        this.txtprecioactual.setText(String.valueOf(InterfazControlador.preciofinal));
        final String idioma = InterfazControlador.idioma;
        switch (idioma) {
            case "ESP": {
                this.btnConvertir.setText("Convertir");
                this.btnCerrar.setText("Cancelar");
                this.lblMonedaConvertida.setText("Selecciona moneda");
                break;
            }
            case "ING": {
                this.btnConvertir.setText("Convert into");
                this.btnCerrar.setText("Cancel");
                this.lblMonedaConvertida.setText("Select currency");
                break;
            }
            case "CAT": {
                this.btnConvertir.setText("Converteix");
                this.btnCerrar.setText("Cancel·lar");
                this.lblMonedaConvertida.setText("Selecciona moneda");
                break;
            }
            case "JAP": {
                this.btnConvertir.setText("\u5909\u63db");
                this.btnCerrar.setText("\u30ad\u30e3\u30f3\u30bb\u30eb\u3059\u308b");
                this.lblMonedaConvertida.setText("\u901a\u8ca8\u3092\u9078\u629e");
                break;
            }
            case "FRA": {
                this.btnConvertir.setText("Convertir");
                this.btnCerrar.setText("Annuler");
                this.lblMonedaConvertida.setText("s\u00e9lectionner la devise");
                break;
            }
            case "RUS": {
                this.btnConvertir.setText("\u043d\u043e\u0432\u043e\u043e\u0431\u0440\u0430\u0449\u0435\u043d\u043d\u044b\u0439");
                this.btnCerrar.setText("\u043e\u0442\u043c\u0435\u043d\u0438\u0442\u044c");
                this.lblMonedaConvertida.setText("\u0432\u044b\u0431\u0435\u0440\u0438\u0442\u0435 \u0432\u0430\u043b\u044e\u0442\u0443");
                break;
            }
        }
    }
    
    @FXML
    private void Convertir(final ActionEvent event) throws SQLException {
        this.Conver();
    }
    
    public void Conver() throws SQLException {
        final double a = Double.parseDouble(this.txtprecioactual.getText());
        double b = 0.0;
        final String moneda = InterfazControlador.moneda;
        switch (moneda) {
            case "\u20ac": {
                b = Controlador.ConvertirEuro(((String)this.jcomboMonedaDeseada.getValue()).trim());
                break;
            }
            case "$": {
                b = Controlador.ConvertirDolar(((String)this.jcomboMonedaDeseada.getValue()).trim());
                break;
            }
            case "¥": {
                b = Controlador.ConvertirYen(((String)this.jcomboMonedaDeseada.getValue()).trim());
                break;
            }
            case "£": {
                b = Controlador.ConvertirLibra(((String)this.jcomboMonedaDeseada.getValue()).trim());
                break;
            }
        }
        final double resu = a * b;
        this.txtConversionMoneda.setText(String.valueOf(resu));
    }
    
    @FXML
    private void Cerrar(final ActionEvent event) {
        final Stage stage = (Stage)this.btnCerrar.getScene().getWindow();
        stage.close();
    }
    
    @FXML
    private void Enter(final KeyEvent event) throws SQLException {
        if (event.getCode() == KeyCode.ENTER) {
            this.Conver();
        }
        if (event.getCode() == KeyCode.ESCAPE) {
            final Stage stage = (Stage)this.btnCerrar.getScene().getWindow();
            stage.close();
        }
    }
}
