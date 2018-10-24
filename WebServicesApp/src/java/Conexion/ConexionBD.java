
package Conexion;

import java.sql.*;

public class ConexionBD {
    
    private Connection conexion;
    
    public Connection getConexion(){
        return conexion;
    }
    
    public void setConexion(Connection conexion){
        this.conexion = conexion;
    }
    
    public void Conectar(){
        try {
            String user = "Aparcana";
            String pass = "aparcana";
            Class.forName("oracle.jdbc.OracleDriver");
            String conn = "jdbc:oracle:thin:@197.168.10.8:1521:XE";
            setConexion(DriverManager.getConnection(conn, user, pass));
            System.out.println("Conectado a Oracle");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error : " + e.toString());
        }
    }
    
//    Para verificar si se ha conectado la base de datos
    public static void main(String[] args) {
        
        
        
        ConexionBD bd = new ConexionBD();
        bd.Conectar();


    
    }
    
//    public static ResultSet Consulta(String consulta) {
//        Connection con = getConexion();
//        Statement declara;
//        try {
//            declara = con.createStatement();
//            ResultSet respuesta = declara.executeQuery(consulta);
//            return respuesta;
//        } catch (SQLException e) {
//            System.out.println("Error : " + e.toString());
//        }
//        
//        return null;
//    }
    
}
