/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import java.util.ResourceBundle;
import java.net.URL;
import javafx.scene.control.TitledPane;
import javafx.fxml.FXML;
import javafx.scene.web.WebView;
import javafx.fxml.Initializable;

public class InterfazAgradecimientosController implements Initializable
{
    @FXML
    private WebView webAgradecimientos;
    public String Agradecimientos;
    @FXML
    private TitledPane frame;
    
    public InterfazAgradecimientosController() {
        this.Agradecimientos = "<html>\n<head>\n\t<title>Agradecimientos</title>\n</head>\n<body>\n\t<h1>Esta pesta\u00f1a es para agradecer a todas las personas que me han ayudado.</h1>\n\t<ul>\n\t<li>Sofia P.G</li>\n\t<li>Profesores.</li>\n\t<li>Familia</li>\n\t<li>Sylvi</li>\n\t<li>Sara</li>\n\t<li>Anna</li>\n\t<li>Adri</li>\n\t</ul>\n</body>\n</html>";
    }
    
    public void initialize(final URL url, final ResourceBundle rb) {
        this.webAgradecimientos.getEngine().loadContent(this.Agradecimientos);
    }
    
    @FXML
    private void Salir(final KeyEvent event) {
        if (event.getCode() == KeyCode.ESCAPE) {
            final Node source = (Node)event.getSource();
            final Stage stage = (Stage)source.getScene().getWindow();
            stage.close();
        }
    }
}
