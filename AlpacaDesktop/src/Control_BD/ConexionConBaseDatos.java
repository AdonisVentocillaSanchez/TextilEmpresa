
package Control_BD;

import java.sql.*;
import javax.swing.JOptionPane;

public class ConexionConBaseDatos {
         
    public static Connection conexion = null;
    
    public static Connection getConexion() {
        String usu = "Aparcana";
        String pas = "aparcana";

        String conn = "jdbc:oracle:thin:@localhost:1521:xe";
        try {
            
            Class.forName("oracle.jdbc.OracleDriver");
            conexion = DriverManager.getConnection(conn, usu, pas);
            System.out.println("coneccion");
            JOptionPane.showMessageDialog(null, "Bienvenido a DatabaseManagment to Alpaca SAC", "Conexión exitosa", JOptionPane.INFORMATION_MESSAGE);
                        
       } catch (ClassNotFoundException | SQLException e) {
           System.out.println("error de conexion");
           JOptionPane.showMessageDialog(null, "error de conexion "+e);
       }

        return conexion;
    }//cierra metodo obtenerConexion
    
  
}//fin class
