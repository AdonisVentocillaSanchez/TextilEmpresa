package DAO;

import Bean.UsuarioBean;
import Connection.ConexionBD;
import java.sql.*;
import javax.swing.JOptionPane;

public class UsuarioDAO {
    
    
    String consultaSQL = null;
    static ResultSet cargausu;
    static Statement sentencia;
    PreparedStatement pst=null;
    ResultSet rs=null;
    
    
    public boolean Login(UsuarioBean admin){
        
        String usu = admin.getUser();
        String pass = admin.getPassword();
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
        
        System.out.println(usuario);
        System.out.println(op);
        return op;
    }
    
}
