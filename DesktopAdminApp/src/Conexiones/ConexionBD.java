package Conexiones;

import java.sql.*;
import javax.swing.JOptionPane;

public class ConexionBD {
    
    public static Connection getConexion(String user, String pass){
        Connection cx = null;
        
        String usu = user;
        String pas = pass;
        
        if (usu.isEmpty() & pas.isEmpty()) {
            usu = "APARCANA";
            pas = "aparcana";
        }
        
        String conn = "jdbc:oracle:thin:@197.168.1.8:1521:XE";
        
        try {
            
            Class.forName("oracle.jdbc.OracleDriver");
            cx = DriverManager.getConnection(conn,usu,pas);
            System.out.println("Se conecto a Oracle");
            
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Falla durante el proceso: "+e.getMessage(), "Error durante la conexion", JOptionPane.ERROR_MESSAGE);
        }
        
        return cx;
    }
    
    public static ResultSet Consulta(String consulta){
        ResultSet respuesta = null;
        
        Connection con = getConexion("", "");
        Statement declara = null;
        
        try {
            
            declara = con.createStatement();
            respuesta = declara.executeQuery(consulta);
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al ejecutar la sentencia: \n" + consulta + "\n Error: \n" + e.getMessage(), "Error en la ejecución",  JOptionPane.ERROR_MESSAGE);
        }
        
        return respuesta;
    }
    
    public static void main(String[]args){
        
        ConexionBD bd = new ConexionBD();
        bd.getConexion("APARCANA", "aparcana");
        
    }
    
}
