package Connection;

import Bean.UsuarioBean;
import java.sql.*;
import javax.swing.JOptionPane;
import Bean.ConexionBean;

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
            JOptionPane.showMessageDialog(null, "Bienvenido a DatabaseManagment to Alpaca SAC", "Conexión exitosa", JOptionPane.INFORMATION_MESSAGE);
            ConexionBean.Conexion(admin);            
            
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Falla durante el proceso: "+e.getMessage(), "Error durante la conexion", JOptionPane.ERROR_MESSAGE);
        }
        
        return cx;
        
    }

    public static Connection getConex() {
        Connection cxn = null;
        
        ConexionBean conex = new ConexionBean();
        
        int port = conex.getPort();
        String server = conex.getServer();
        String sid = conex.getSid();
        String usu = conex.getUser();
        String pas = conex.getPassword();
                     
        String conn = "jdbc:oracle:thin:@"+server+":"+port+":"+sid;
        
        try {
            
            Class.forName("oracle.jdbc.OracleDriver");
            cxn = DriverManager.getConnection(conn,usu,pas);       
            
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Falla durante el proceso: "+e.getMessage(), "Error durante la conexion", JOptionPane.ERROR_MESSAGE);
        }
        
        return cxn;
    }
    
}
