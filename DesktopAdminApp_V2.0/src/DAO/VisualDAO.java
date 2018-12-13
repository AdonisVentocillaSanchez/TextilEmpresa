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
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

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
    DefaultTableModel View = null;
    DefaultListModel list = null;
    ResultSetMetaData rsMd = null;
    
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
            rsMd =rs.getMetaData();
            int filas= 0;
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
    public DefaultComboBoxModel Obt_date(String column){
        ListaModelo= new DefaultComboBoxModel();
        ListaModelo.addElement("[SELECCIONAR]");
        consultaSQL="SELECT DISTINCT " + column + " FROM DBA_USERS";
        
        try {
            cn=getConex();
            pst=cn.prepareStatement(consultaSQL);
            rs=pst.executeQuery();
            
            while (rs.next()) {                
                ListaModelo.addElement(rs.getString(column));
            }
            pst.close();
            rs.close();
            cn.close();
        } catch (SQLException e) {
        }
        
        return ListaModelo;
    }
    
    
    
    public DefaultTableModel Obt_date1(String vista){
        View = new DefaultTableModel();
        consultaSQL="SELECT * FROM "+vista;
        try{
            cn=getConex();
            pst=cn.prepareStatement(consultaSQL);
            rs=pst.executeQuery();
            rsMd = rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();
            
            for (int i = 1; i <= cantidadColumnas; i++) {
                View.addColumn(rsMd.getColumnLabel(i));
            }
            while(rs.next()){
                Object[] fila = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    fila[i]=rs.getObject(i+1);
                }
                View.addRow(fila);
            }
            pst.close();
            rs.close();
            cn.close();
        }catch(SQLException ex){
        }
        return View;
    }
    public DefaultTableModel Obt_dateRole(String column, String vista, String where){
        View = new DefaultTableModel();
        consultaSQL="SELECT DISTINCT "+column+" FROM "+vista+" WHERE "+where;
        try{
            cn=getConex();
            pst=cn.prepareStatement(consultaSQL);
            rs=pst.executeQuery();
            rsMd = rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();
            
            for (int i = 1; i <= cantidadColumnas; i++) {
                View.addColumn(rsMd.getColumnLabel(i));
            }
            while(rs.next()){
                Object[] fila = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    fila[i]=rs.getObject(i+1);
                }
                View.addRow(fila);
            }
            pst.close();
            rs.close();
            cn.close();
        }catch(SQLException ex){
        }
        return View;
    }
    
    public DefaultComboBoxModel Obt_date2(String column,String tabla){
        ListaModelo= new DefaultComboBoxModel();
        ListaModelo.addElement("[SELECCIONAR]");
        consultaSQL="SELECT DISTINCT "+ column +" FROM " + tabla ;
        
        try {
            cn=getConex();
            pst=cn.prepareStatement(consultaSQL);
            rs=pst.executeQuery();
            
            while (rs.next()) {                
                ListaModelo.addElement(rs.getString(column));
            }
            pst.close();
            rs.close();
            cn.close();
        } catch (SQLException e) {
        }
        
        return ListaModelo;
    }
    
    public DefaultListModel Obt_List (String column, String table){
        list = new DefaultListModel();
        consultaSQL="SELECT \""+column+"\" FROM "+table;
        
        
        try{
            cn=getConex();
            pst=cn.prepareStatement(consultaSQL);
            rs=pst.executeQuery();
            while(rs.next()){
                list.addElement(rs.getString(column));
            }
            rs.close();
            pst.close();
            cn.close();
        }catch(SQLException e){
        
        }
        
        return list;
    }
    
    public DefaultComboBoxModel Obt_Schema (String column, String table){
        ListaModelo = new DefaultComboBoxModel();
        ListaModelo.addElement("[SELECCIONAR]");
        consultaSQL="SELECT \""+column+"\" FROM "+ table +" GROUP BY "+column;
        
        
        try{
            cn=getConex();
            pst=cn.prepareStatement(consultaSQL);
            rs=pst.executeQuery();
            while(rs.next()){
                ListaModelo.addElement(rs.getString(column));
            }
            rs.close();
            pst.close();
            cn.close();
        }catch(SQLException e){
        
        }
        
        return ListaModelo;
    }
    
    public DefaultComboBoxModel Obt_SchemaTables (String column, String table, String schema){
        ListaModelo = new DefaultComboBoxModel();
        ListaModelo.addElement("[SELECCIONAR]");
        consultaSQL="SELECT "+column+" FROM "+table+" WHERE OWNER ='"+schema+"' ORDER BY "+column;
        try{
            cn=getConex();
            pst=cn.prepareStatement(consultaSQL);
            rs=pst.executeQuery();
            while(rs.next()){
                ListaModelo.addElement(rs.getString(column));
            }
            rs.close();
            pst.close();
            cn.close();
        }catch(SQLException e){
        
        }
        
        return ListaModelo;
    }
    
}
