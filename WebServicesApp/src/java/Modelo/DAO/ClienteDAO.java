/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.DAO;

import Modelo.Bean.ClienteBean;
import java.sql.PreparedStatement;

/**
 *
 * @author AUTONOMA
 */
public class ClienteDAO extends Conexion.ConexionBD {
    ClienteBean p;
    
    public boolean registrar(ClienteBean p)
      {
          System.out.println("Ha llegado al método"+p.getNombre());
        PreparedStatement pst=null;
        try{
        String consulta= "INSERT INTO \"APARCANA\".\"CLIENTE\" (IDCLIENTE, NOMBRE, DNI, NOMBRE_EMPRESA, CELULAR, TELEFONO, USUARIO_CLIENTE, \"CONTRASEÑA_CLIENTE\", EMAIL) VALUES"
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
        
    }catch(Exception ex){
        System.out.println("error "+ex);
        
        return false;
    }
    return true;
     
    }
}
