// 
// Decompiled by Procyon v0.5.36
// 

package Controlador;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.IOException;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import javax.swing.JColorChooser;
import java.awt.Color;
import javafx.collections.FXCollections;
import javafx.util.Callback;
import javafx.scene.control.cell.PropertyValueFactory;
import java.util.List;
import java.awt.Component;
import javax.swing.JOptionPane;
import java.math.RoundingMode;
import java.math.BigDecimal;
import javafx.event.ActionEvent;
import javafx.scene.input.InputMethodEvent;
import java.util.ResourceBundle;
import java.net.URL;
import javafx.collections.ListChangeListener;
import javax.swing.JMenu;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;
import Producto.Producto;
import javafx.scene.control.TableView;
import javafx.fxml.Initializable;

public class InterfazControlador implements Initializable
{
    @FXML
    private TableView<Producto> table;
    @FXML
    private TextField txtpreciofinal;
    @FXML
    private Button btnCalcular;
    @FXML
    private TextField txtPrecio;
    @FXML
    private TextField txtProductos;
    @FXML
    private TextField txtNombre;
    @FXML
    private Button btnNuevo;
    private Button btnModificar;
    @FXML
    private Button btnEliminar;
    @FXML
    private TableColumn colPrecio;
    @FXML
    private TableColumn colProductos;
    @FXML
    private TableColumn colNombre;
    ObservableList<Producto> productos;
    private int posiciontabla;
    @FXML
    private Button btnGuardar;
    public static String idioma;
    static double precio;
    @FXML
    private MenuItem btnColores;
    @FXML
    private Menu btnLogin;
    @FXML
    private MenuItem btnRegistro;
    @FXML
    private MenuItem btnIniciarSesion;
    @FXML
    private Menu btnDivisas;
    @FXML
    private MenuItem btnTipodemoneda;
    @FXML
    private MenuItem btnColorTabla;
    @FXML
    private SplitPane frame;
    @FXML
    private MenuItem btnGuardarColores;
    @FXML
    private MenuItem btnMenuIdioma;
    @FXML
    private Menu btnOpcionesMenu;
    @FXML
    private Button btnActualizar;
    @FXML
    private Label lblPrecio;
    @FXML
    private Label lblProductos;
    @FXML
    private Label lblNombre;
    public static String colorTabla;
    public static String colorF;
    public static String moneda;
    public static double preciofinal;
    @FXML
    private MenuItem btnConversordemoneda;
    @FXML
    private MenuItem btnAyuda;
    JMenu ayuda;
    @FXML
    private MenuItem btnAgradecimientos;
    @FXML
    private Menu MenuAyuda;
    private final ListChangeListener<Producto> selectorTablaProductos;
    
    public InterfazControlador() {
        this.selectorTablaProductos = (ListChangeListener<Producto>)new ListChangeListener<Producto>() {
            public void onChanged(final ListChangeListener.Change<? extends Producto> c) {
                InterfazControlador.this.ponerProductoSeleccionado();
            }
        };
    }
    //Inicializa y le da un modelo :O
    public void initialize(final URL url, final ResourceBundle rb) {
        this.inicializarTablaProducto();
        final ObservableList<Producto> tlProducto = (ObservableList<Producto>)this.table.getSelectionModel().getSelectedItems();
        tlProducto.addListener((ListChangeListener)this.selectorTablaProductos);
    }
    //No hace nada, creo que me equivoqué al ponerlo, no, no, quería que al añadir un producto se calculara automáticamente, pero ahora tengo miedo de quitarlo por si me da error XD
    @FXML
    private void ModificarTabla(final InputMethodEvent event) {
    }
    //Método para calcular el precio, por suerte aquí puedo coger la columna específica y le doy un formato para que no salga a 0,00000000000001 :D
    @FXML
    private void Calcular(final ActionEvent event) {
        InterfazControlador.precio = 0.0;
        for (int i = 0; i < this.productos.size(); ++i) {
            final double a = (double)this.colPrecio.getCellData(i);
            final int b = (int)this.colProductos.getCellData(i);
            InterfazControlador.precio += a * b;
        }
        this.txtpreciofinal.setText(String.format("%.2f", InterfazControlador.precio) + InterfazControlador.moneda);
        BigDecimal bd = new BigDecimal(InterfazControlador.precio);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        InterfazControlador.preciofinal = bd.doubleValue();
    }
    //Método para poner los textfield en blanco :P
    @FXML
    private void nuevo(final ActionEvent event) {
        this.txtNombre.setText("");
        this.txtPrecio.setText("");
        this.txtProductos.setText("");
        this.btnEliminar.setDisable(true);
    }
    //Este método esta creado, pero decidí descartarlo, prefiero 3 botones es más simple.
    private void modificar(final ActionEvent event) {
        final Producto producto = new Producto();
        producto.nombre.set(this.txtNombre.getText());
        producto.nump.set(Integer.parseInt(this.txtProductos.getText()));
        producto.precio.set(Double.parseDouble(this.txtPrecio.getText()));
        this.productos.add(this.posiciontabla,producto);
    }
    //Método eliminar, simplemente lo elimina de la tabla.
    @FXML
    private void eliminar(final ActionEvent event) {
        this.productos.remove(this.posiciontabla);
    }
    //Método guardar, del botón de la parte derecha, lo sé, muchos if, pero por suerte solo lo hice una vez y copie y pegué en el else >.<
    @FXML
    private void guardar(final ActionEvent event) {
        String a = this.txtPrecio.getText();
        if (a.contains("a") || a.contains("b") || a.contains("c") || a.contains("d") || a.contains("e") || a.contains("f") || a.contains("g") || a.contains("h") || a.contains("i") || a.contains("j") || a.contains("k") || a.contains("l") || a.contains("m") || a.contains("n") || a.contains("\u00f1") || a.contains("o") || a.contains("p") || a.contains("q") || a.contains("r") || a.contains("s") || a.contains("t") || a.contains("u") || a.contains("v") || a.contains("y") || a.contains("z")) {
            JOptionPane.showMessageDialog(null, "Error en el precio, solo n\u00fameros");
        }
        else {
            a = this.txtProductos.getText();
            if (a.contains("a") || a.contains("b") || a.contains("c") || a.contains("d") || a.contains("e") || a.contains("f") || a.contains("g") || a.contains("h") || a.contains("i") || a.contains("j") || a.contains("k") || a.contains("l") || a.contains("m") || a.contains("n") || a.contains("\u00f1") || a.contains("o") || a.contains("p") || a.contains("q") || a.contains("r") || a.contains("s") || a.contains("t") || a.contains("u") || a.contains("v") || a.contains("y") || a.contains("z")) {
                JOptionPane.showMessageDialog(null, "Error en el n\u00famero de productos, solo n\u00fameros");
            }
            else {
                final Producto producto = new Producto();
                producto.nombre.set(this.txtNombre.getText());
                producto.nump.set(Integer.parseInt(this.txtProductos.getText()));
                producto.precio.set(Double.parseDouble(this.txtPrecio.getText()));
                this.productos.add(producto);
                this.btnEliminar.setDisable(false);
            }
        }
    }
    //Te permite seleccionar un producto de la tabla.
    public Producto getTablaProductosSeleccionados() {
        
        if (this.table != null) {
            final List<Producto> tabla = (List<Producto>)this.table.getSelectionModel().getSelectedItems();
            if (tabla.size() == 1) {
                final Producto competicionSeleccionada = tabla.get(0);
                return competicionSeleccionada;
            }
        }
        return null;
    }
    //Para sacar el producto seleccionado en la parte de la derecha en los textos de nombre, precio y número de productos.
    private void ponerProductoSeleccionado() {
        final Producto producto = this.getTablaProductosSeleccionados();
        this.posiciontabla = this.productos.indexOf((Object)producto);
        if (producto != null) {
            this.txtNombre.setText(producto.getNombre());
            this.txtPrecio.setText(String.valueOf(producto.getPrecio()));
            this.txtProductos.setText(String.valueOf(producto.getNump()));
        }
    }
    //Inicializo la tabla de los productos y le digo que tiene 3 columnas: nombre, precio y nump.
    private void inicializarTablaProducto() {
        this.colNombre.setCellValueFactory((Callback)new PropertyValueFactory("nombre"));
        this.colPrecio.setCellValueFactory((Callback)new PropertyValueFactory("precio"));
        this.colProductos.setCellValueFactory((Callback)new PropertyValueFactory("nump"));
        this.productos = FXCollections.observableArrayList();
        this.table.setItems((ObservableList)this.productos);
    }
    //Selecciona el color de fondo ( Espero que la gente no se ponga colores chillones hacen daño a la vista >.<)
    @FXML
    private void SeleccionarColorFondo(final ActionEvent event) {
        final Color color = JColorChooser.showDialog(null, "Elige un color", Color.BLACK);
        final String hexColor = InterfazControlador.colorF = String.format("#%06X", 0xFFFFFF & color.getRGB());
        this.frame.setStyle("-fx-background-color:" + hexColor);
    }
    //Cambia el color de la tabla (Solo se verá si no hay ningún elemento).
    @FXML
    private void ColorTabla(final ActionEvent event) {
        final Color color = JColorChooser.showDialog(null, "Elige un color", Color.BLACK);
        final String hexColor = InterfazControlador.colorTabla = String.format("#%06X", 0xFFFFFF & color.getRGB());
        this.table.setStyle("-fx-background-color:" + hexColor);
    }
    //Llama a la ventana de Registrarse
    @FXML
    private void Registrarse(final ActionEvent event) throws IOException {
        final FXMLLoader loader = new FXMLLoader();
        final FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/Vista/InterfazRegistro.fxml"));
        final Parent root = (Parent)fxmlLoader.load();
        final Stage stage = new Stage();
        stage.setTitle("Registrarse");
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }
    //Llama a la ventana de iniciar sesión
    @FXML
    private void IniciarSesion(final ActionEvent event) throws IOException {
        final FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/Vista/InterfazIniciarSesion.fxml"));
        final Parent root = (Parent)fxmlLoader.load();
        final Stage stage = new Stage();
        stage.setTitle("Iniciar Sesi\u00f3n");
        stage.setScene(new Scene(root));
        stage.showAndWait();
        try {
            final String colorF = Controlador.SacarColor(InterfazIniciarSesionController.ID);
            this.frame.setStyle("-fx-background-color:" + colorF);
            final String colorT = Controlador.SacarTabla(InterfazIniciarSesionController.ID);
            this.table.setStyle("-fx-background-color:" + colorT);
            final String idio = InterfazControlador.idioma = Controlador.Sacaridioma(InterfazIniciarSesionController.ID);
            final String mone = InterfazControlador.moneda = Controlador.Sacarmondeda(InterfazIniciarSesionController.ID);
            this.Idiomas();
        }
        catch (SQLException ex) {
            Logger.getLogger(InterfazControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //El método de llamar a la ventana de seleccionar idioma, le digo que espere y cuando cierre la ventana pone el idioma.
    @FXML
    private void SeleccionarIdioma(final ActionEvent event) throws IOException {
        final FXMLLoader loader = new FXMLLoader();
        final FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/Vista/InterfazSeleccionarIdioma.fxml"));
        final Parent root = (Parent)fxmlLoader.load();
        final Stage stage = new Stage();
        stage.setTitle("Selecciona un idioma");
        stage.setScene(new Scene(root));
        stage.showAndWait();
        this.Idiomas();
    }
    //Aqui se actualiza para ponerlo al idioma correspondiente
    @FXML
    private void ActualizarTodo(final ActionEvent event) {
        this.Idiomas();
    }
    //El método de idiomas de la interfaz principal...
    public void Idiomas() {
        final String idioma = InterfazControlador.idioma;
        switch (idioma) {
            case "ESP": {
                this.lblNombre.setText("Nombre");
                this.lblPrecio.setText("Precio");
                this.lblProductos.setText("Nº Productos");
                this.btnCalcular.setText("Calcular");
                this.btnActualizar.setText("Actualizar");
                this.btnColores.setText("Colores");
                this.btnColorTabla.setText("Color de la tabla");
                this.btnDivisas.setText("Divisas");
                this.btnEliminar.setText("Eliminar");
                this.btnGuardar.setText("Guardar");
                this.btnGuardarColores.setText("Guardar par\u00e1metros");
                this.btnIniciarSesion.setText("Iniciar sesi\u00f3n");
                this.btnLogin.setText("Sesi\u00f3n");
                this.btnMenuIdioma.setText("Idioma");
                this.btnNuevo.setText("Nuevo");
                this.btnOpcionesMenu.setText("Opciones");
                this.btnRegistro.setText("Registrarse");
                this.btnTipodemoneda.setText("Moneda");
                this.colNombre.setText("Nombre");
                this.colPrecio.setText("Precio");
                this.colProductos.setText("Nº Productos");
                this.btnConversordemoneda.setText("Conversor de moneda");
                this.btnAyuda.setText("Ayuda");
                this.btnAgradecimientos.setText("Agradecimientos");
                this.MenuAyuda.setText("Ayuda");
                break;
            }
            case "ING": {
                this.lblNombre.setText("Name");
                this.lblPrecio.setText("Price");
                this.lblProductos.setText("Stock");
                this.btnCalcular.setText("Calc");
                this.btnActualizar.setText("Update");
                this.btnColores.setText("Color");
                this.btnColorTabla.setText("Color of table");
                this.btnDivisas.setText("Type of money");
                this.btnEliminar.setText("Delete");
                this.btnGuardar.setText("Save");
                this.btnGuardarColores.setText("Save options");
                this.btnIniciarSesion.setText("Log in");
                this.btnLogin.setText("Log in");
                this.btnMenuIdioma.setText("Language");
                this.btnNuevo.setText("New");
                this.btnOpcionesMenu.setText("Options");
                this.btnRegistro.setText("Sing in");
                this.btnTipodemoneda.setText("Money");
                this.btnConversordemoneda.setText("Currency converter");
                this.btnAyuda.setText("Help");
                this.btnAgradecimientos.setText("Acknowledgment");
                this.MenuAyuda.setText("Help");
                this.colNombre.setText("Name");
                this.colPrecio.setText("Price");
                this.colProductos.setText("Stock");
                break;
            }
            case "CAT": {
                this.lblNombre.setText("Nom");
                this.lblPrecio.setText("Preu");
                this.lblProductos.setText("Nº Productes");
                this.btnCalcular.setText("Calcular");
                this.btnActualizar.setText("Actualitzar");
                this.btnColores.setText("Colors");
                this.btnColorTabla.setText("Color de la taula");
                this.btnDivisas.setText("Divises");
                this.btnEliminar.setText("Eliminar");
                this.btnGuardar.setText("Guardar");
                this.btnGuardarColores.setText("Guardar par\u00e0metres");
                this.btnIniciarSesion.setText("Iniciar sessi\u00f3");
                this.btnLogin.setText("Sessi\u00f3");
                this.btnMenuIdioma.setText("Idioma");
                this.btnNuevo.setText("Nou");
                this.btnOpcionesMenu.setText("Opcions");
                this.btnRegistro.setText("Registrar-se");
                this.btnTipodemoneda.setText("Moneda");
                this.btnConversordemoneda.setText("Convertidor de moneda");
                this.btnAyuda.setText("Ajuda");
                this.btnAgradecimientos.setText("Agradeciments");
                this.MenuAyuda.setText("Ajuda");
                this.colNombre.setText("Nom");
                this.colPrecio.setText("Preu");
                this.colProductos.setText("Nº Productes");
                break;
            }
            case "JAP": {
                this.lblNombre.setText("\u304a\u540d\u524d");
                this.lblPrecio.setText("\u4fa1\u683c");
                this.lblProductos.setText("\u88fd\u54c1\u6570");
                this.btnCalcular.setText("\u8a08\u7b97\u3059\u308b");
                this.btnActualizar.setText("\u30ea\u30d5\u30ec\u30c3\u30b7\u30e5");
                this.btnColores.setText("\u8272");
                this.btnColorTabla.setText("\u30c6\u30fc\u30d6\u30eb\u30ab\u30e9\u30fc");
                this.btnDivisas.setText("\u901a\u8ca8");
                this.btnEliminar.setText("\u524a\u9664\u3059\u308b");
                this.btnGuardar.setText("\u4fdd\u5b58\u3059\u308b");
                this.btnGuardarColores.setText("\u30d1\u30e9\u30e1\u30fc\u30bf\u3092\u4fdd\u5b58");
                this.btnIniciarSesion.setText("\u30ed\u30b0\u30a4\u30f3");
                this.btnLogin.setText("\u30bb\u30c3\u30b7\u30e7\u30f3");
                this.btnMenuIdioma.setText("\u8a00\u8a9e");
                this.btnNuevo.setText("\u65b0\u3057\u3044");
                this.btnOpcionesMenu.setText("\u30aa\u30d7\u30b7\u30e7\u30f3");
                this.btnRegistro.setText("\u30b5\u30a4\u30f3\u30a2\u30c3\u30d7");
                this.btnTipodemoneda.setText("\u901a\u8ca8");
                this.btnConversordemoneda.setText("\u901a\u8ca8\u30b3\u30f3\u30d0\u30fc\u30bf\u30fc");
                this.btnAyuda.setText("\u52a9\u3051\u3066");
                this.btnAgradecimientos.setText("\u8b1d\u8f9e");
                this.MenuAyuda.setText("\u52a9\u3051\u3066");
                this.colNombre.setText("\u304a\u540d\u524d");
                this.colPrecio.setText("\u4fa1\u683c");
                this.colProductos.setText("\u88fd\u54c1\u6570");
                break;
            }
            case "FRA": {
                this.lblNombre.setText("Nom");
                this.lblPrecio.setText("Prix");
                this.lblProductos.setText("Nº Produits");
                this.btnCalcular.setText("Calculer");
                this.btnActualizar.setText("Mettre \u00e0 jour");
                this.btnColores.setText("Couleurs");
                this.btnColorTabla.setText("Couleur du tableau");
                this.btnDivisas.setText("Devises");
                this.btnEliminar.setText("Effacer");
                this.btnGuardar.setText("Sauvegarder");
                this.btnGuardarColores.setText("Enregistrer les param\u00e8tres");
                this.btnIniciarSesion.setText("Se connecter");
                this.btnLogin.setText("Acc\u00e8der");
                this.btnMenuIdioma.setText("Langue");
                this.btnNuevo.setText("Nouveau");
                this.btnOpcionesMenu.setText("Options");
                this.btnRegistro.setText("S'inscrire");
                this.btnTipodemoneda.setText("Type de devise");
                this.btnConversordemoneda.setText("Convertisseur de devises");
                this.btnAyuda.setText("Aide");
                this.btnAgradecimientos.setText("Remerciements");
                this.MenuAyuda.setText("Aide");
                this.colNombre.setText("Nom");
                this.colPrecio.setText("Prix");
                this.colProductos.setText("Nº Produits");
                break;
            }
            case "RUS": {
                this.lblNombre.setText("\u0438\u043c\u044f");
                this.lblPrecio.setText("\u0446\u0435\u043d\u0430");
                this.lblProductos.setText("\u041a\u043e\u043b\u0438\u0447\u0435\u0441\u0442\u0432\u043e \u043f\u0440\u043e\u0434\u0443\u043a\u0442\u043e\u0432");
                this.btnCalcular.setText("\u0432\u044b\u0441\u0447\u0438\u0442\u044b\u0432\u0430\u0435\u0442");
                this.btnActualizar.setText("\u043e\u0431\u043d\u043e\u0432\u043b\u0435\u043d\u0438\u0435");
                this.btnColores.setText("\u0446\u0432\u0435\u0442\u0430");
                this.btnColorTabla.setText("\u0426\u0432\u0435\u0442 \u0441\u0442\u043e\u043b\u0430");
                this.btnDivisas.setText("\u0438\u043d\u043e\u0441\u0442\u0440\u0430\u043d\u043d\u0430\u044f \u0432\u0430\u043b\u044e\u0442\u0430");
                this.btnEliminar.setText("\u0443\u0434\u0430\u043b\u0438\u0442\u044c");
                this.btnGuardar.setText("\u0441\u043e\u0445\u0440\u0430\u043d\u0438\u0442\u044c");
                this.btnGuardarColores.setText("\u0421\u043e\u0445\u0440\u0430\u043d\u0438\u0442\u044c \u043f\u0430\u0440\u0430\u043c\u0435\u0442\u0440\u044b");
                this.btnIniciarSesion.setText("\u0412\u043e\u0439\u0442\u0438 \u0432 \u0441\u0438\u0441\u0442\u0435\u043c\u0443");
                this.btnLogin.setText("\u0441\u0435\u0441\u0441\u0438\u044f");
                this.btnMenuIdioma.setText("\u044f\u0437\u044b\u043a");
                this.btnNuevo.setText("\u043d\u043e\u0432\u044b\u0439");
                this.btnOpcionesMenu.setText("\u043e\u043f\u0446\u0438\u0438");
                this.btnRegistro.setText("\u0417\u0430\u0440\u0435\u0433\u0438\u0441\u0442\u0440\u0438\u0440\u043e\u0432\u0430\u0442\u044c\u0441\u044f");
                this.btnTipodemoneda.setText("\u0432\u0430\u043b\u044e\u0442\u0430");
                this.btnConversordemoneda.setText("\u041a\u043e\u043d\u0432\u0435\u0440\u0442\u0435\u0440 \u0432\u0430\u043b\u044e\u0442");
                this.btnAyuda.setText("\u043f\u043e\u043c\u043e\u0449\u044c");
                this.btnAgradecimientos.setText("\u041f\u043e\u0434\u0442\u0432\u0435\u0440\u0436\u0434\u0435\u043d\u0438\u044f");
                this.MenuAyuda.setText("\u043f\u043e\u043c\u043e\u0449\u044c");
                this.colNombre.setText("\u0438\u043c\u044f");
                this.colPrecio.setText("\u0446\u0435\u043d\u0430");
                this.colProductos.setText("\u041a\u043e\u043b\u0438\u0447\u0435\u0441\u0442\u0432\u043e \u043f\u0440\u043e\u0434\u0443\u043a\u0442\u043e\u0432");
                break;
            }
        }
    }
    //Guarda los parámetros en la base de datos
    @FXML
    private void GuardarParametros(final ActionEvent event) throws SQLException {
        Controlador.GuardarPar(InterfazControlador.colorF, InterfazControlador.colorTabla, InterfazControlador.idioma, InterfazControlador.moneda, InterfazIniciarSesionController.ID);
        JOptionPane.showMessageDialog(null, "Se ha guardado correctamente");
    }
    //Ventana de seleccionar moneda.
    @FXML
    private void SelecMoneda(final ActionEvent event) throws IOException {
        final FXMLLoader loader = new FXMLLoader();
        final FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/Vista/InterfazSeleccionarMoneda.fxml"));
        final Parent root = (Parent)fxmlLoader.load();
        final Stage stage = new Stage();
        stage.setTitle("Selecciona un idioma");
        stage.setScene(new Scene(root));
        stage.show();
    }
    //Ventana de conversión de moneda
    @FXML
    private void Conversiondemoneda(final ActionEvent event) throws IOException {
        final FXMLLoader loader = new FXMLLoader();
        final FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/Vista/InterfazConversiondeMoneda.fxml"));
        final Parent root = (Parent)fxmlLoader.load();
        final Stage stage = new Stage();
        stage.setTitle("Selecciona un idioma");
        stage.setScene(new Scene(root));
        stage.show();
    }
    //Ventana ayuda
    @FXML
    private void SacarAyuda(final ActionEvent event) throws IOException {
        final FXMLLoader loader = new FXMLLoader();
        final FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/Vista/InterfazAyuda.fxml"));
        final Parent root = (Parent)fxmlLoader.load();
        final Stage stage = new Stage();
        stage.setTitle("Ayuda");
        stage.setScene(new Scene(root));
        stage.show();
    }
    //Ventana agradecimientos 
    @FXML
    private void SacarAgradecimientos(final ActionEvent event) throws IOException {
        final FXMLLoader loader = new FXMLLoader();
        final FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/Vista/InterfazAgradecimientos.fxml"));
        final Parent root = (Parent)fxmlLoader.load();
        final Stage stage = new Stage();
        stage.setTitle("Agradecimientos");
        stage.setScene(new Scene(root));
        stage.show();
    }
    //Esto es los valores por defecto, aunque creo que se ha cambiado por el instalador (Pero no voy a modificarlo, tengo miedo de que se rompa xD)
    static {
        InterfazControlador.idioma = "ESP";
        InterfazControlador.moneda = "\u20ac";
        InterfazControlador.preciofinal = 0.0;
    }
}
