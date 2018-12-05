/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Bean.UsuarioBean;
import static Connection.ConexionBD.getConex;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ANDRES
 */
public class RoleDAO {
    String consultaSQL = null;
    ResultSet rs=null;
    CallableStatement clst=null;
    Connection cn= null;
    
    public boolean AddRole(String role){
        
        try{
            cn=getConex();
            consultaSQL="CREATE ROLE "+role;
            System.out.println("Consulta : "+consultaSQL);
            clst=cn.prepareCall(consultaSQL);
            clst.execute();
            clst.close();
            cn.close();
            return true;
        }catch(SQLException ex){
            System.out.println("Ocurrió un error en AddRole : "+ex);
            return false;
        }
    }
    public boolean AddPrivilegeToRole(String role, String privilege){
        try{
            cn=getConex();
            consultaSQL="GRANT "+privilege+" TO "+role;
            System.out.println("Consulta : "+consultaSQL);
            clst=cn.prepareCall(consultaSQL);
            clst.execute();
            clst.close();
            cn.close();
            return true;
        }catch(SQLException ex){
            System.out.println("Ocurrió un error en AddPrivilegeToRole : "+ex);
            return false;    
        }
        
    }
}
