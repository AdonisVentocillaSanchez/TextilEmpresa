/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connection.ConexionBD;
import static Connection.ConexionBD.getConex;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author adoni
 */
public class VisualDAO extends ConexionBD{
    
    
    String consultaSQL = null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    CallableStatement clst=null;
    Connection cn =null;
    DefaultComboBoxModel ListaModelo = null;
    public static ResultSet Consulta(String usesave,String passave,String consulta){
        ResultSet respuesta = null;        
        
        Statement declara = null;
        
        try {
            Connection con = getConex();
            declara = con.createStatement();
            respuesta = declara.executeQuery(consulta);
            con.close();
            
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
            cn=getConex();
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
        cn.close();
        }catch(SQLException ex){
            System.out.println("Algo salió mal en getPrivilege : "+ex);
        }
        
        return privi;
    }
    
    //Setea a combobox los usuarios
    public DefaultComboBoxModel Obt_date(String tabla){
        ListaModelo= new DefaultComboBoxModel();
        ListaModelo.addElement("[SELECCIONAR]");
        consultaSQL="SELECT DISTINCT " + tabla + " FROM DBA_USERS";
        
        try {
            cn=getConex();
            pst=cn.prepareStatement(consultaSQL);
            rs=pst.executeQuery();
            while (rs.next()) {                
                ListaModelo.addElement(rs.getString(tabla));
            }
            pst.close();
            rs.close();
            cn.close();
        } catch (SQLException e) {
        }
        
        return ListaModelo;
    }
    
}
