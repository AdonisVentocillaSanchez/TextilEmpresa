/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Bean.UsuarioBean;
import Connection.ConexionBD;
import java.sql.Connection;
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
    ConexionBD cBD = new ConexionBD();
    Connection cn = null;
    
    public boolean Login(UsuarioBean admin){
        
        String usu = admin.getUser();
        boolean op = false;
        String usuario = "";
        consultaSQL = "SELECT USERNAME FROM USERSDBA WHERE USERNAME = '"+usu+"'";
        
        try {
            cn=cBD.getConexion(admin);
            pst=cn.prepareStatement(consultaSQL);
            rs=pst.executeQuery();
            while (rs.next()) {                
                usuario = rs.getString("USERNAME");
            }
            if (!(usuario.isEmpty())) {
                System.out.println("Llega");
                op = true;
            }else{
                op=false;
            }
            pst.close();
            rs.close();
            cn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Los datos ingresados son incorrectos: " +e.toString(),
                    "Error en el inicio de sesión",JOptionPane.ERROR_MESSAGE);
            op= false;
        }
        return op;
    }
}
