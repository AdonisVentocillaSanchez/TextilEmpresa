/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Erika Sanchez
 */
public class UsuarioDAO extends Conexiones.ConexionBD {
    
    PreparedStatement pst=null;
    ResultSet rs=null;
    String consulta="";
    public boolean modificar(String usu,String pass,String tablespace,String temptablespace,int quota)
    {
        try{
            modificarUsuXPass(usu,pass);
            modificarTableSpace(usu, tablespace);
            modificarTempTableSpace(usu, temptablespace);
            modificarQuota(usu, quota, tablespace);
            
        }catch(Exception ex)
        {
            System.out.println(""+ex);
        }
        return false;
    }
    public boolean modificarUsuXPass(String usu,String pass)
    {
        try{
            consulta="alter user ? identified by ?;commit;";
            pst=getConexion("", "").prepareStatement(consulta);
            pst.setString(1, usu);
            pst.setString(2, pass);
            pst.executeUpdate();
            pst.close();
            getConexion("", "").close();
            return true;
        }catch(SQLException ex)
        {
            System.out.println("Ocurrió un error modificar USUXPASS"+ex);
        }
        
        return false;
    }
    
    public boolean modificarTableSpace(String usu,String tablespace)
    {
        try{
            consulta="ALTER USER ? DEFAULT TABLESPACE ?;commit;";
            pst=getConexion("", "").prepareStatement(consulta);
            pst.setString(1, usu);
            pst.setString(2, tablespace);
            pst.executeUpdate();
            pst.close();
            getConexion("", "").close();
            return true;
        }catch(SQLException ex)
        {
            System.out.println("Ocurrió un error modificar TABLESPACE"+ex);
        }
        return false;
    }
    public boolean modificarTempTableSpace(String usu,String temptablespace)
    {
        try{
            consulta="ALTER USER ? TEMPORARY TABLESPACE ?;commit;";
            pst=getConexion("", "").prepareStatement(consulta);
            pst.setString(1, usu);
            pst.setString(2, temptablespace);
            pst.executeUpdate();
            pst.close();
            getConexion("", "").close();
            return true;
        }catch(SQLException ex)
        {
            System.out.println("Ocurrió un error modificar TEMP"+ex);
        }
        return false;
    }
    public boolean modificarQuota(String usu,int quota,String tablespace)
    {
        try{
            consulta="alter user ? quota ?K on ?;commit;";
            pst=getConexion("", "").prepareStatement(consulta);
            pst.setString(1, usu);
            pst.setInt(2, quota);
            pst.setString(3, tablespace);
            pst.executeUpdate();
            pst.close();
            getConexion("", "").close();
            return true;
        }catch(SQLException ex)
        {
            System.out.println("Ocurrió un error modificar QUOTA"+ex);
        }
        return false;
    }
}
