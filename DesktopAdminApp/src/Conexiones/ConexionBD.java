package Conexiones;


import java.sql.*;
import javax.swing.JOptionPane;

public class ConexionBD {
    
    

    public static Connection getConexion(String user, String pass){
        Connection cx = null;
        
        String usu = user;
        String pas = pass;
        
        if (usu.isEmpty() & pas.isEmpty()) {
            usu = "";
            pas = "";
        }
        
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
    
    public static ResultSet Consulta(String usesave,String passave,String consulta){
        ResultSet respuesta = null;
        
        
        Statement declara = null;
        
        try {
            Connection con = getConexion(usesave,passave);
            declara = con.createStatement();
            respuesta = declara.executeQuery(consulta);
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al ejecutar la sentencia: \n" + consulta + "\n Error: \n" + e.getMessage(), "Error en la ejecución",  JOptionPane.ERROR_MESSAGE);
        }
        
        return respuesta;
    }
    public boolean Logear(String user,String password)
    {
        try{
        getConexion(user, password);
            System.out.println("Conecto correctamente");
            return true;
        
        }catch(Exception e){
            System.out.println("No conecto el logear por Aparcana");
        }
        
        return false;
    }
    
    public static void main(String[]args){
        
        ConexionBD bd = new ConexionBD();
        bd.getConexion("VALENCIA", "vale");
        
    }
    
}
