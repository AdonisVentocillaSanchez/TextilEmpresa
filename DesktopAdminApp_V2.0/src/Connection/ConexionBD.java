package Connection;

import Bean.UsuarioBean;
import java.sql.*;
import javax.swing.JOptionPane;

public class ConexionBD {
    
    public static Connection getConexion(UsuarioBean admin){
        Connection cx = null;
        
        int port = admin.getPort();
        String server = admin.getServer();
        String sid = admin.getSid();
        String usu = admin.getUser();
        String pas = admin.getPassword();
        
               
        String conn = "jdbc:oracle:thin:@"+server+":"+port+":"+sid;
        
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
    
}
