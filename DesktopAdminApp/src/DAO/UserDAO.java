/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Bean.UsuarioBean;
import static Conexiones.ConexionBD.getConexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ANDRES
 */
public class UserDAO {
    UsuarioBean bean=new UsuarioBean();
    String consultaSQL = null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    CallableStatement clst=null;
    String usersave=bean.getUsusave();
    String passwordsave=bean.getPasssave();
    Connection cn= getConexion(usersave, passwordsave);
    public boolean AddUser(String user,String password, String table,String temp, String quota){
        try{
            consultaSQL="CREATE USER "+user+" IDENTIFIED BY "+password
                    + " DEFAULT TABLESPACE "+table
                    + " TEMPORARY TABLESPACE "+temp
                    + " QUOTA "+quota+" ON "+table;
            System.out.println("Consulta : "+consultaSQL);
            clst=cn.prepareCall(consultaSQL);
            clst.execute(consultaSQL);
            clst.close();
            cn.close();
            return true;
        }catch(SQLException ex){
            System.out.println("Ocurrió un error en AddUser : "+ex);
            return false;
        }finally{
            
        }
    }
    public boolean AddPrivilegeToUser(String user, String privilege){
        try{
            consultaSQL="GRANT "+privilege+" TO "+user;
            System.out.println("Consulta : "+consultaSQL);
            clst=cn.prepareCall(consultaSQL);
            clst.execute();
            clst.close();
            cn.close();
            return true;
        }catch(SQLException ex){
            System.out.println("Ocurrió un error en AddPrivilegeToUSER : "+ex);
            return false;    
        }
        
    }
/////////////////////////Aquí empiezan metodos que no son del login ni del mostrar tablas//////////////////////    
    public boolean modificar(String usu,String pass,String tablespace,String temptablespace,String quota)
    {
        try{
            System.out.println(""+usu+pass+tablespace+temptablespace+quota);
            if(pass.isEmpty()){
            }else{
                modificarUsuXPass(usu,pass);
            }
            modificarTableSpace(usu, tablespace);
            modificarTempTableSpace(usu, temptablespace);
            modificarQuota(usu, quota, tablespace);
            return true;
        }catch(Exception ex)
        {
            System.out.println(""+ex);
        }
        return false;
    }
    public boolean modificarUsuXPass(String usu,String pass)
    {
        try{
            consultaSQL="ALTER USER "+usu+" IDENTIFIED BY "+pass;
            clst=cn.prepareCall(consultaSQL);
            clst.execute();
            clst.close();
            cn.close();
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
            consultaSQL="ALTER USER "+usu+" DEFAULT TABLESPACE "+tablespace;
            clst=cn.prepareCall(consultaSQL);
            clst.execute();
            clst.close();
            cn.close();
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
            consultaSQL="ALTER USER "+usu+" TEMPORARY TABLESPACE "+temptablespace;
            clst=cn.prepareCall(consultaSQL);
            clst.execute();
            clst.close();
            cn.close();
            return true;
        }catch(SQLException ex)
        {
            System.out.println("Ocurrió un error modificar TEMP : "+ex);
        }
        return false;
    }
    public boolean modificarQuota(String usu,String quota,String tablespace)
    {
        
        try{
            consultaSQL="ALTER USER "+usu+" QUOTA "+quota+" ON "+tablespace;
            clst=cn.prepareCall(consultaSQL);
            clst.execute();
            clst.close();
            cn.close();
            return true;
        }catch(SQLException ex)
        {
            System.out.println("Ocurrió un error modificar QUOTA : "+ex);
        }
        return false;
    }
////////////////////////////REVOKE PRIVILEGES/////////////////////////////////////////////////////
    public boolean RevokeProvolegeTo(String user,String privi){
        try{
            consultaSQL="REVOKE "+privi+" FROM "+user;
            clst=cn.prepareCall(consultaSQL);
            clst.execute();
            clst.close();
            cn.close();
            return true;
        }catch(SQLException ex){
            System.out.println("Ocurrió un error revocar PRIVILEGE : "+ex);
            return false;
        }
            
    }
}
