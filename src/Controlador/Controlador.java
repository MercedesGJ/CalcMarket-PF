/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.SQLException;
import Modelo.Codigo;

public class Controlador
{
    public static boolean IniciarSesion(final String usu, final String pass) throws SQLException {
        final boolean a = Codigo.IniciarSesion(usu, pass);
        return a;
    }
    
    public static void Registrarse(final String usu, final String pass) throws SQLException {
        Codigo.Registrarse(usu, pass);
    }
    
    public static void GuardarPar(final String colorF, final String colorFT, final String idioma, final String moneda, final int ID) throws SQLException {
        Codigo.GuardarParam(colorF, colorFT, idioma, moneda, ID);
    }
    
    public static int SacarID(final String usu, final String password) throws SQLException {
        final int id = Codigo.SacarID(usu, password);
        return id;
    }
    
    public static String SacarColor(final int id) throws SQLException {
        final String colorF = Codigo.SacarColorF(id);
        return colorF;
    }
    
    public static String SacarTabla(final int id) throws SQLException {
        final String colorFT = Codigo.SacarColorTabla(id);
        return colorFT;
    }
    
    public static String Sacaridioma(final int id) throws SQLException {
        final String idioma = Codigo.SacarIdioma(id);
        return idioma;
    }
    
    public static String Sacarmondeda(final int id) throws SQLException {
        final String moneda = Codigo.SacarMoneda(id);
        return moneda;
    }
    
    public static double ConvertirEuro(final String moneda) throws SQLException {
        final double divisa = Codigo.ConvertirEuro(moneda);
        return divisa;
    }
    
    public static double ConvertirDolar(final String moneda) throws SQLException {
        final double divisa = Codigo.ConvertirDolar(moneda);
        return divisa;
    }
    
    public static double ConvertirYen(final String moneda) throws SQLException {
        final double divisa = Codigo.ConvertirYen(moneda);
        return divisa;
    }
    
    public static double ConvertirLibra(final String moneda) throws SQLException {
        final double divisa = Codigo.ConvertirLibra(moneda);
        return divisa;
    }
}
