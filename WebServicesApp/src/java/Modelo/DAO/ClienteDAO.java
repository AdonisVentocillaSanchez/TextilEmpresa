/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.DAO;

import Modelo.Bean.ClienteBean;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author AUTONOMA
 */
public class ClienteDAO extends Conexion.ConexionBD {
    ClienteBean p;
    String consulta="";
    ResultSet rs=null;
    PreparedStatement pst=null;
    public boolean registrar(ClienteBean p)
      {
          System.out.println("Ha llegado al método"+p.getNombre());
        
        try{
        consulta= "INSERT INTO \"APARCANA\".\"CLIENTE\" (IDCLIENTE, NOMBRE, DNI, NOMBRE_EMPRESA, CELULAR, TELEFONO, USUARIO_CLIENTE, \"CONTRASEÑA_CLIENTE\", EMAIL) VALUES"
                + "(?,?,?,?,?,?,?,?,?)";
        pst= getConexion("", "").prepareStatement(consulta); 
        pst.setInt(1, p.getIdcliente());
        pst.setString(2, p.getNombre());
        pst.setString(3, p.getDni());
        System.out.println("Esta ejecutando la sentencia SQL"+p.getNombre());
        pst.setString(4, p.getNombre_empresa());
        pst.setString(5, p.getCelular());
        pst.setString(6, p.getTelefono());
        pst.setString(7, p.getUsuario_cliente());
        pst.setString(8, p.getContraseña_cliente());
        pst.setString(9, p.getEmail());
        
        pst.executeUpdate();
        pst.close();
        getConexion("","").close();
        
    }catch(SQLException ex){
        System.out.println("error "+ex);
        
        return false;
    }
    return true;
     
    }
    public boolean Logear(String user,String pass)
    {
        try
        {
            System.out.println("u: "+user+" ps: "+pass);
            consulta="select * from \"APARCANA\".\"CLIENTE\" where USUARIO_CLIENTE=? and \"CONTRASEÑA_CLIENTE\"=? ";
            System.out.println("Consulta : "+consulta);
            pst = getConexion("","").prepareStatement(consulta);
            pst.setString(1, user);
            pst.setString(2, pass);
            System.out.println(""+pst.toString());
            rs=pst.executeQuery();
            if(rs.next()){
                System.out.println("HOLA");
                return true;
            }
        }catch(SQLException ex){
            System.out.println("Error : "+ex);
        }
        return false;
    }
}
