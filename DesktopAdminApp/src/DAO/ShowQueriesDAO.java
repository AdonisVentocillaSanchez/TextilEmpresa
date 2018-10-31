/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Bean.UsuarioBean;
import Conexiones.ConexionBD;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ANDRES
 */
public class ShowQueriesDAO extends ConexionBD{
    UsuarioBean bean=new UsuarioBean();
    String consultaSQL = null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    CallableStatement clst=null;
    String usersave=bean.getUsusave();
    String passwordsave=bean.getPasssave();
    
    public String[] getPrivilegio(String tipo){
        int i=0;
        consultaSQL="SELECT * FROM SESSION_PRIVS " +
                    "WHERE PRIVILEGE LIKE '%"+tipo+"%' ";
        String[] privi =null;    
         
        try{
        rs=Consulta(usersave, passwordsave, consultaSQL);
            System.out.println("Llega hasta aquí");
            
        int filas=0;
            while(rs.next()){
                filas++;
            }
         rs=null; 
        privi = new String[filas];
        System.out.println("estas son las filas "+filas);
        rs=Consulta(usersave, passwordsave, consultaSQL);

            while(rs.next()){
                privi[i]=rs.getString("PRIVILEGE");
                i++;
            }
        }catch(SQLException ex){
            System.out.println("Algo salió mal en getPrivilege : "+ex);
        }
        return privi;
    }
}
