
package Conexion;

import java.sql.*;

public class ConexionBD {
    
    public static Connection getConexion(String user, String pass){
        String usu = user;
        String pas = pass;
        if(usu.isEmpty() & pas.isEmpty()){
            usu="Ventocilla";
            pas="ella";
        }
        String conn = "jdbc:oracle:thin:@197.168.2.7:1521:XE";
        Connection cx=null;
        try {
           Class.forName("oracle.jdbc.OracleDriver");
           cx=DriverManager.getConnection(conn,usu,pas);
            System.out.println("SE CONECTO");
        } catch (Exception e) {
            System.out.println("NO SE CONECTO");
        }
        return cx;
    }
    
    public static ResultSet Consulta(String consulta) {
        Connection con = getConexion("","");
        ResultSet respuesta = null;
        Statement declara;
        try {
            declara = con.createStatement();
            respuesta = declara.executeQuery(consulta);
            
        } catch (SQLException e) {
            respuesta = null;
        }
        
        return respuesta;
    }
    
    public static void main(String[] args) {
        
        
        
        ConexionBD bd = new ConexionBD();
        bd.getConexion("Ventocilla","ella");


    
    }
    
}
