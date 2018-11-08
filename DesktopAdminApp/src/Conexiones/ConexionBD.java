package Conexiones;


import java.sql.*;
import javax.swing.JOptionPane;

public class ConexionBD {
    
    public static Connection getConexion(String user, String pass){
        Connection cx = null;
        
        String usu = user;
        String pas = pass;
        
               
        String conn = "jdbc:oracle:thin:@localhost:1521:XE";
        
        try {
            
            Class.forName("oracle.jdbc.OracleDriver");
            cx = DriverManager.getConnection(conn,usu,pas);
            System.out.println("Se conecto a Oracle");
            
            
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Falla durante el proceso: "+e.getMessage(), "Error durante la conexion", JOptionPane.ERROR_MESSAGE);
            System.out.println("Lo que estás ingresando es esto: "+usu+":"+pas);
        }
        
        return cx;
    }
    
    

    public static void main(String[]args){
        
        ConexionBD bd = new ConexionBD();
        bd.getConexion("", "");
        
    }
    
}
