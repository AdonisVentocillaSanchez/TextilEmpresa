package Connection;

import Bean.UsuarioBean;
import java.sql.*;
import javax.swing.JOptionPane;
import Bean.ConexionBean;

public class ConexionBD {
    
    public static Connection cx = null;
    public static ConexionBean conex = new ConexionBean();
    
    public static Connection getConexion(UsuarioBean admin){
                
        int port = admin.getPort();
        String server = admin.getServer();
        String sid = admin.getSid();
        String usu = admin.getUser();
        String pas = admin.getPassword();
                     
        String conn = "jdbc:oracle:thin:@"+server+":"+port+":"+sid;
        
        try {
            
            Class.forName("oracle.jdbc.OracleDriver");
            cx = DriverManager.getConnection(conn,usu,pas);
            System.out.println("coneccion");
            JOptionPane.showMessageDialog(null, "Bienvenido a DatabaseManagment to Alpaca SAC", "Conexión exitosa", JOptionPane.INFORMATION_MESSAGE);
            ConexionBean.Conexion(admin);
            
            
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Falla durante el proceso: "+e.getMessage(), "Error durante la conexion", JOptionPane.ERROR_MESSAGE);
        }
        
        return cx;
        
    }

    public static Connection getConex() {
                
        int port = conex.getPort();
        String server = conex.getServer();
        String sid = conex.getSid();
        String usu = conex.getUser();
        String pas = conex.getPassword();
                     
        String conn = "jdbc:oracle:thin:@"+server+":"+port+":"+sid;
        
        try {
            
            Class.forName("oracle.jdbc.OracleDriver");
            cx = DriverManager.getConnection(conn,usu,pas);       
            
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Falla durante el proceso: \n"+e.getMessage(), "Error durante la conexion", JOptionPane.ERROR_MESSAGE);
        }
        
        return cx;
    }
    
    public static void CloseConexion(Connection conexion, Statement sentencia, ResultSet resultado, PreparedStatement ps){
        try {
            conexion.close();
            sentencia.close();
            resultado.close();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falla durante el proceso: \n"+ex.getMessage(), "Error al cerrar las conexiones", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
