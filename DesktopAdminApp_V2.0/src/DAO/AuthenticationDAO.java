/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Bean.UsuarioBean;
import Connection.ConexionBD;
import static Connection.ConexionBD.getConex;
import java.beans.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ANDRES
 */
public class AuthenticationDAO {
    
    String consultaSQL = null;
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
                getConex().close();
                op = true;
            }   
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Los datos ingresados son incorrectos: " +e.toString(),
                    "Error en el inicio de sesión",JOptionPane.ERROR_MESSAGE);
            op= false;
        }
        return op;
    }
}
