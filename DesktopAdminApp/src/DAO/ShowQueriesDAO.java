/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Bean.UsuarioBean;
import Conexiones.ConexionBD;
import static Conexiones.ConexionBD.getConexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

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
    Connection cn = getConexion(usersave,passwordsave);
    public static ResultSet Consulta(String usesave,String passave,String consulta){
        ResultSet respuesta = null;
        
        
        Statement declara = null;
        
        try {
            Connection con = getConexion(usesave,passave);
            declara = con.createStatement();
            respuesta = declara.executeQuery(consulta);
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al ejecutar la sentencia: \n" + consulta + "\n Error: \n" + e.getMessage(), "Error en la ejecución",  JOptionPane.ERROR_MESSAGE);
        }
        
        return respuesta;
    }
    //Creacion  de los combobox fluidos
    public String[] getPrivilegio(String tipo){
        int i=0;
        consultaSQL="SELECT * FROM SESSION_PRIVS " +
                    "WHERE PRIVILEGE LIKE '%"+tipo+"%' ";
        String[] privi =null;    
         
        try{
            pst=cn.prepareStatement(consultaSQL);
            rs=pst.executeQuery();
            System.out.println("Llega hasta aquí");
            
        int filas=0;
            while(rs.next()){
                filas++;
            }
         rs=null; 
        privi = new String[filas];
        System.out.println("estas son las filas "+filas);
        rs=pst.executeQuery();

            while(rs.next()){
                privi[i]=rs.getString("PRIVILEGE");
                i++;
            }
        pst.close();
        rs.close();
        //cn.close();
        }catch(SQLException ex){
            System.out.println("Algo salió mal en getPrivilege : "+ex);
        }
        
        return privi;
    }
    
    
}
