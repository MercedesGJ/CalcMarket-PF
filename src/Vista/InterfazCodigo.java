/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import javafx.scene.image.Image;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.application.Application;

public class InterfazCodigo extends Application
{
    public void start(final Stage primaryStage) throws Exception {
        final Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("Interfaz.fxml"));
        final Scene scene = new Scene(root);
        primaryStage.setTitle("CalcMarket");
        primaryStage.getIcons().add(new Image(this.getClass().getResource("iconoapp.png").toURI().toString()));
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(final String[] args) {
        launch(args);
    }
}