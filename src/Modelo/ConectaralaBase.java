/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;

public class ConectaralaBase
{
    static Connection conexion;
    
    public static Connection conectar() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
            ConectaralaBase.conexion = DriverManager.getConnection("jdbc:sqlite:CalcMarket.db");
        }
        catch (ClassNotFoundException ex) {
            System.out.println("Error al registrar el driver de MySQL: " + ex);
        }
        return ConectaralaBase.conexion;
    }
    
    public static void desconectar() throws SQLException {
        ConectaralaBase.conexion.close();
    }
    
    static {
        ConectaralaBase.conexion = null;
    }
}

