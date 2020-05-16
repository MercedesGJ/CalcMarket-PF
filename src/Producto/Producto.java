/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Producto;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Producto
{
    public SimpleDoubleProperty precio;
    public SimpleIntegerProperty nump;
    public SimpleStringProperty nombre;
    
    public Producto() {
        this.precio = new SimpleDoubleProperty();
        this.nump = new SimpleIntegerProperty();
        this.nombre = new SimpleStringProperty();
    }
    
    public double getPrecio() {
        return this.precio.get();
    }
    
    public int getNump() {
        return this.nump.get();
    }
    
    public String getNombre() {
        return this.nombre.get();
    }
}