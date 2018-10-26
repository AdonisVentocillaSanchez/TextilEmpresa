
package Bean;

import java.sql.ResultSet;
import Conexiones.ConexionBD;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class UsuarioBean {
    
    String consultaSQL = null;
    ResultSet respuesta = null;
    ConexionBD conbd = new ConexionBD();
    
    static ResultSet cargausu;
    static Statement sentencia;
    
    public boolean Login(String usu, String pass){
        boolean op = false;
        
        String usuario = "";
        conbd.getConexion(usu,pass);
        consultaSQL = "SELECT USERNAME FROM dba_users WHERE USERNAME = '"+usu+"'";
        respuesta = conbd.Consulta(consultaSQL);
        
        try {
            while (respuesta.next()) {                
                usuario = respuesta.getString("USERNAME");
            }
            if (!(usuario.isEmpty())) {
                op = true;     
            }   
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Los datos ingresados son incorrectos", "Error en el inicio de sesión",JOptionPane.ERROR_MESSAGE);
        }
        
        System.out.println(usuario);
        System.out.println(op);
        return op;
    }
    
    public DefaultComboBoxModel Obt_user(){
        DefaultComboBoxModel ListaModelo = new DefaultComboBoxModel();
        ListaModelo.addElement("[SELECCIONAR]");
        ResultSet res = Conexiones.ConexionBD.Consulta("SELECT * FROM DBA_USERS");
        try {
            while (res.next()) {                
                ListaModelo.addElement(res.getString("USERNAME"));
            }
        } catch (Exception e) {
        }
        return ListaModelo;
    }
    
}
