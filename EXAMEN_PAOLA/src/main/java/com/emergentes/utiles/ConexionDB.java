package com.emergentes.utiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class ConexionDB {
    
    //Parametros para la conexion a la base de datos
    static public String url = "jdbc:mysql://localhost:3306/bd_internet";
    static public String usuario = "root";
    static public String password = "";
    
    protected Connection conn = null;
    
    public ConexionDB() {
        try {
            //My sql ver. 5.7 "com.mysql.jdbc.Driver"
            //My sql ver. 8.0 "com.mysql.jc.jdbc.Driver"
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, usuario, password);
            if (conn != null) {
                System.out.println("Conexion OK " + conn);
            }
        } catch (SQLException ex) {
            System.out.println("Error al conectar" + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Error en Driver" + ex.getMessage());
        }
    }
    
    public Connection conectar() {
        return conn;
    }
    
    public void desconectar() {
        System.out.println("Cerrando la BD " + conn);
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
