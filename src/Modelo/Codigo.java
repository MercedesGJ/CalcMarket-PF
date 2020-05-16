/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class Codigo
{
    public static boolean IniciarSesion(final String usu, final String password) throws SQLException {
        ConectaralaBase.conectar();
        boolean inis = false;
        final PreparedStatement ps = ConectaralaBase.conexion.prepareStatement("SELECT usuario,password FROM Usuarios WHERE usuario = ? AND password = ?");
        ps.setString(1, usu);
        ps.setString(2, password);
        final ResultSet res = ps.executeQuery();
        while (res.next()) {
            inis = (res != null);
        }
        return inis;
    }
    
    public static void Registrarse(final String usu, final String password) throws SQLException {
        ConectaralaBase.conectar();
        final PreparedStatement ps = ConectaralaBase.conexion.prepareStatement("INSERT INTO Usuarios(usuario,password) VALUES(?,?)");
        ps.setString(1, usu);
        ps.setString(2, password);
        ps.execute();
    }
    
    public static void GuardarParam(final String colorF, final String colorFT, final String idioma, final String moneda, final int ID) throws SQLException {
        ConectaralaBase.conectar();
        final PreparedStatement ps = ConectaralaBase.conexion.prepareStatement("UPDATE Usuarios SET cFondo = ?, cFondoTabla = ?, idioma = ?, moneda = ? WHERE ID = ?");
        ps.setString(1, colorF);
        ps.setString(2, colorFT);
        ps.setString(3, idioma);
        ps.setString(4, moneda);
        ps.setInt(5, ID);
        ps.execute();
    }
    
    public static int SacarID(final String usu, final String password) throws SQLException {
        ConectaralaBase.conectar();
        int ID = 0;
        final PreparedStatement ps = ConectaralaBase.conexion.prepareStatement("SELECT ID FROM Usuarios WHERE usuario = ? AND password = ?");
        ps.setString(1, usu);
        ps.setString(2, password);
        final ResultSet p = ps.executeQuery();
        while (p.next()) {
            ID = p.getInt(1);
        }
        return ID;
    }
    
    public static String SacarColorF(final int id) throws SQLException {
        String colorF = "";
        final PreparedStatement ps = ConectaralaBase.conexion.prepareStatement("SELECT cFondo FROM Usuarios WHERE ID = ?");
        ps.setInt(1, id);
        final ResultSet p = ps.executeQuery();
        while (p.next()) {
            colorF = p.getString(1);
        }
        return colorF;
    }
    
    public static String SacarColorTabla(final int id) throws SQLException {
        String colorFT = "";
        final PreparedStatement ps = ConectaralaBase.conexion.prepareStatement("SELECT cFondoTabla FROM Usuarios WHERE ID = ?");
        ps.setInt(1, id);
        final ResultSet p = ps.executeQuery();
        while (p.next()) {
            colorFT = p.getString(1);
        }
        return colorFT;
    }
    
    public static String SacarIdioma(final int id) throws SQLException {
        String idioma = "";
        final PreparedStatement ps = ConectaralaBase.conexion.prepareStatement("SELECT idioma FROM Usuarios WHERE ID = ?");
        ps.setInt(1, id);
        final ResultSet p = ps.executeQuery();
        while (p.next()) {
            idioma = p.getString(1);
        }
        return idioma;
    }
    
    public static String SacarMoneda(final int id) throws SQLException {
        String moneda = "";
        final PreparedStatement ps = ConectaralaBase.conexion.prepareStatement("SELECT moneda FROM Usuarios WHERE ID = ?");
        ps.setInt(1, id);
        final ResultSet p = ps.executeQuery();
        while (p.next()) {
            moneda = p.getString(1);
        }
        return moneda;
    }
    
    public static Double ConvertirEuro(final String moneda) throws SQLException {
        ConectaralaBase.conectar();
        double divisa = 0.0;
        final PreparedStatement ps = ConectaralaBase.conexion.prepareStatement("SELECT Euros FROM Divisas WHERE moneda = ?");
        ps.setString(1, moneda);
        final ResultSet p = ps.executeQuery();
        while (p.next()) {
            divisa = p.getDouble(1);
        }
        return divisa;
    }
    
    public static Double ConvertirDolar(final String moneda) throws SQLException {
        ConectaralaBase.conectar();
        double divisa = 0.0;
        final PreparedStatement ps = ConectaralaBase.conexion.prepareStatement("SELECT Dolar FROM Divisas WHERE moneda = ?");
        ps.setString(1, moneda);
        final ResultSet p = ps.executeQuery();
        while (p.next()) {
            divisa = p.getDouble(1);
        }
        return divisa;
    }
    
    public static Double ConvertirYen(final String moneda) throws SQLException {
        ConectaralaBase.conectar();
        double divisa = 0.0;
        final PreparedStatement ps = ConectaralaBase.conexion.prepareStatement("SELECT Yen FROM Divisas WHERE moneda = ?");
        ps.setString(1, moneda);
        final ResultSet p = ps.executeQuery();
        while (p.next()) {
            divisa = p.getDouble(1);
        }
        return divisa;
    }
    
    public static Double ConvertirLibra(final String moneda) throws SQLException {
        ConectaralaBase.conectar();
        double divisa = 0.0;
        final PreparedStatement ps = ConectaralaBase.conexion.prepareStatement("SELECT Libra FROM Divisas WHERE moneda = ?");
        ps.setString(1, moneda);
        final ResultSet p = ps.executeQuery();
        while (p.next()) {
            divisa = p.getDouble(1);
        }
        return divisa;
    }
}