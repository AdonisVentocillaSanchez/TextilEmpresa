/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebServices;

import java.sql.*;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 *
 * @author AUTONOMA
 */
@WebService(serviceName = "WebServices")
@Stateless()
public class WebServices {

    /**
     * Web service operation
     */
    String respuesta;
    
    Connection conexion = null;
    Statement sentencia = null;
    ResultSet resultado = null;
    PreparedStatement ps = null;
    
    @WebMethod(operationName = "login")
    public String login(@WebParam(name = "user") String user, @WebParam(name = "pass") String pass) {
        //TODO write your implementation code here
        String contra="";
        try {
            conexion = Conexion.ConexionBD.getConexion("", "");
            sentencia = conexion.createStatement();
        String sql = "SELECT USERNAME, USER_ID FROM dba_users WHERE USERNAME = '"+pass+"' AND USER_ID='"+user+"'";
        resultado = sentencia.executeQuery(sql);
            while (resultado.next()) {                
                contra = resultado.getString("USERNAME");
                
            }
            if (contra.equals("")) {
                respuesta = "NO SE CONECTO";
                System.out.println(""+respuesta);
            }else{
                respuesta = "CONECTADO";
                System.out.println(""+respuesta);
            }
        } catch (SQLException e) {
            respuesta = "Error en la base de datos";
        }
        
        return respuesta;
    }
}
