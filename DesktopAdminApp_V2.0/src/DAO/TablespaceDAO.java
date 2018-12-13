/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static Connection.ConexionBD.getConex;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ANDRES
 */
public class TablespaceDAO {
    
    String consultaSQL = null;
    static Statement sentencia;
    PreparedStatement pst=null;
    CallableStatement clst =null;
    ResultSet rs=null;      
    Connection cn = null;
    
    public boolean createTablespace(String tablespace,String datafile,
            String size, String autoextend,String maxsize){
        consultaSQL="CREATE TABLESPACE "+tablespace+
                " DATAFILE '"+datafile+tablespace+".dbf'"+
                " SIZE "+size+
                " AUTOEXTEND ON NEXT "+autoextend+
                " MAXSIZE "+maxsize+
                " DEFAULT STORAGE(INITIAL 16K NEXT 16K"+
                " MINEXTENTS 1 MAXEXTENTS 3) ";
        try{
            cn=getConex();
            clst=cn.prepareCall(consultaSQL);
            clst.execute();
            
            clst.close();
            cn.close();
            return true;
        }catch(SQLException ex){
            System.out.println("af"+ex);
            return false;
        }
    }
    
    public boolean createTemporarytablespace(String tablespace,String datafile,
            String size, String autoextend,String maxsize){
        consultaSQL="CREATE TEMPORARY TABLESPACE "+tablespace+
                " DATAFILE "+datafile+tablespace+".dbf"+
                " SIZE "+size+
                " AUTOEXTEND ON NEXT "+autoextend+
                " MAXSIZE "+maxsize+
                " EXTENT MANAGAMENT LOCAL UNIFORM SIZE 300K ";
        try{
            cn=getConex();
            clst=cn.prepareCall(consultaSQL);
            clst.execute();
            
            clst.close();
            cn.close();
            return true;
        }catch(SQLException ex){
            System.out.println("af"+ex);
            return false;
        }
    }
    
    public boolean alterTablespace (String tablespace, String newtable,
            String datafilenew, String sizenew){
        consultaSQL="ALTER TABLESPACE "+tablespace+
                " ADD DATAFILE "+datafilenew+"/"+newtable+".dbf"+
                " SIZE "+sizenew;
        try{
            cn=getConex();
            clst=cn.prepareCall(consultaSQL);
            clst.execute();
            
            clst.close();
            cn.close();
            return true;
        }catch(SQLException e){
            
         return false;   
        }
    }
}
