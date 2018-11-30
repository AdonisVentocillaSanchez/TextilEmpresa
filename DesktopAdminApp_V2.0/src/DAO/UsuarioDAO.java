package DAO;

import Bean.UsuarioBean;
import Connection.ConexionBD;
import java.sql.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class UsuarioDAO extends ConexionBD {
    
    
    String consultaSQL = null;
    static ResultSet cargausu;
    static Statement sentencia;
    PreparedStatement pst=null;
    ResultSet rs=null;      
    
    public boolean Login(UsuarioBean admin){
        
        String usu = admin.getUser();
        boolean op = true;
        String usuario = "";
        consultaSQL = "SELECT USERNAME FROM dba_users WHERE USERNAME = '"+usu+"'";
        
        try {
            pst=ConexionBD.getConexion(admin).prepareStatement(consultaSQL);
            rs=pst.executeQuery();
            while (rs.next()) {                
                usuario = rs.getString("USERNAME");
            }
            if (!(usuario.isEmpty())) {
                pst.close();
                rs.close();
                ConexionBD.getConexion(admin).close();
                op = true;
            }   
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Los datos ingresados son incorrectos: " +e.toString(),
                    "Error en el inicio de sesión",JOptionPane.ERROR_MESSAGE);
            op= false;
        }
        return op;
    }
    
    public DefaultComboBoxModel Obt_date(String tabla){
        DefaultComboBoxModel ListaModelo = new DefaultComboBoxModel();
        ListaModelo.addElement("[SELECCIONAR]");
        consultaSQL="SELECT DISTINCT " + tabla + " FROM DBA_USERS";
        
        //rs = Conexiones.ConexionBD.Consulta();
        try {
            pst=getConex().prepareStatement(consultaSQL);
            rs=pst.executeQuery();
            while (rs.next()) {                
                ListaModelo.addElement(rs.getString(tabla));
            }
            pst.close();
            rs.close();
            getConex().close();
        } catch (SQLException e) {
        }
        
        return ListaModelo;
    }
}
