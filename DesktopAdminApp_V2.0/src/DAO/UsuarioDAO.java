package DAO;

import Bean.UsuarioBean;
import Connection.ConexionBD;
import java.sql.*;
import javax.swing.JOptionPane;

public class UsuarioDAO extends ConexionBD {
    
    
    String consultaSQL = null;
    static Statement sentencia;
    PreparedStatement pst=null;
    CallableStatement clst =null;
    ResultSet rs=null;      
    Connection cn = null;
    
    ///////////////////Añadir un nuevo usuario///////////////////77
    public boolean AddUser(String user,String password, String table,String temp, String quota, String value){
        try{
            cn=getConex();
            consultaSQL="CREATE USER "+user+" IDENTIFIED BY "+password
                    + " DEFAULT TABLESPACE "+table
                    + " TEMPORARY TABLESPACE "+temp
                    + " QUOTA "+quota+value+" ON "+table;
            System.out.println("Consulta : "+consultaSQL);
            clst=cn.prepareCall(consultaSQL);
            clst.execute(consultaSQL);
            clst.close();
            cn.close();
            return true;
        }catch(SQLException ex){
            System.out.println("Ocurrió un error en AddUser : "+ex);
            return false;
        }
    }
    
    /////////////////////////Añadir priviliegios a usuarios ////////////////////////
    public boolean AddPrivilegeToUser(String user, String privilege){
        try{
            cn=getConex();
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
            cn=getConex();
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
            cn=getConex();
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
            cn=getConex();
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
            cn=getConex();
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
            cn=getConex();
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
