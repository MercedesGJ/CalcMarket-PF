// 
// Decompiled by Procyon v0.5.36
// 

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

public class InterfazAyudaController implements Initializable
{
    @FXML
    private WebView wbAyuda;
    public String PaginaPrincipal;
    @FXML
    private TitledPane frame;
    
    public InterfazAyudaController() {
        this.PaginaPrincipal = "<html>\n<head>\n\t<title>Ayuda CalcMarket</title>\n</head>\n<body>\n\t<h1>¿C\u00f3mo usar CalckMarket?</h1>\n\t<p><i>Esta es una aplicaci\u00f3n que te permite tener una gesti\u00f3n de gastos.</i></p>\n\t<p>En la parte derecha tienes una zona para ingresar datos: El precio, el n\u00famero de productos que tienes y si quieres darle un nombre. M\u00e1s abajo tienes tres botones: Nuevo, Guardar y Eliminar.</p>\n\t<ul><li>Nuevo: Sirve para poner donde se ingresan los datos en blanco.</li>\n\t<li>Guardar: Sirve para guardar en la tabla los datos que tengas en cada dato.</li>\n\t<li>Eliminar: Sirve para eliminar de la tabla el registro seleccionado.</li>\n\t</ul>\n\t<p>\n\tUna vez ingreses los productos le das a calcular y abajo te saldr\u00e1 el precio total.\n\tEn el men\u00fa de arriba tienes una barra con varias opciones:\n\t</p>\n\t<ul><li>Opciones : Permite modificar los colores y el idioma de la aplicaci\u00f3n.</li>\n\t<li>Login: Sirve para guardar tus preferencias, iniciar sesi\u00f3n y registrarse. El registro ser\u00e1 en local as\u00ed que si cambias de dispositivo es posible que pierdas los datos.</li>\n\t<li>Divisas: Sirve para seleccionar el tipo de moneda y hacer una conversi\u00f3n entre ellas.</li></ul>\n\nEnglish\n<head> \n <title> Help CalcMarket </title> \n</head> \n<body> \n<h1> How to use CalckMarket? </h1> \n<p> <i> This is an application that allows you to have expense management. </i> </p> \n<p> On the right side you have an area to enter data: The price, the number of products you have and if you want to give it a name. Below you have three buttons: New, Save and Delete. </p> \n <ul> <li> New: Used to put where blank data is entered. </li> \n<li> Save: It is used to save the data you have in each data in the table. </li> \n<li> Delete: It is used to delete the selected record from the table. </li> \n</ul> \n<p> \nOnce you enter the products you click on it and the total price will appear below. \nIn the menu above you have a bar with various options: \n</p> \n<ul> <li> Options: Allows to change the colors and the language of the application. </li> \n<li> Login: It is used to save your preferences, log in and register. The registration will be local, so if you change devices you may lose your data. </li> \n<li> Currencies: It is used to select the type of currency and make a conversion between them. </li> </ul> \n</body> \n</html>";
    }
    
    public void initialize(final URL url, final ResourceBundle rb) {
        this.wbAyuda.getEngine().loadContent(this.PaginaPrincipal);
    }
    
    @FXML
    private void Salir(final KeyEvent event) throws Exception, Throwable {
        if (event.getCode() == KeyCode.ESCAPE) {
            final Node source = (Node)event.getSource();
            final Stage stage = (Stage)source.getScene().getWindow();
            stage.close();
        }
    }
}
