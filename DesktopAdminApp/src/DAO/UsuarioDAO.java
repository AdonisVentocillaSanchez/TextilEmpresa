
package DAO;

import Bean.UsuarioBean;
import static Conexiones.ConexionBD.getConexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;


public class UsuarioDAO extends Conexiones.ConexionBD {
    UsuarioBean bean=new UsuarioBean();
    String consultaSQL = null;
    static ResultSet cargausu;
    static Statement sentencia;
    PreparedStatement pst=null;
    ResultSet rs=null;
    
    
    String usersave=bean.getUsusave();
    String passwordsave=bean.getPasssave();
            
    public boolean Login(String usu, String pass){
        boolean op = false;
        String usuario = "";
        consultaSQL = "SELECT USERNAME FROM dba_users WHERE USERNAME = '"+usu+"'";
        
        try {
            pst=getConexion(usu,pass).prepareStatement(consultaSQL);
            rs=pst.executeQuery();
            while (rs.next()) {                
                usuario = rs.getString("USERNAME");
            }
            if (!(usuario.isEmpty())) {
                pst.close();
                rs.close();
                getConexion(usu, pass).close();
                op = true;
            }   
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Los datos ingresados son incorrectos",
                    "Error en el inicio de sesión",JOptionPane.ERROR_MESSAGE);
            op= false;
        }
        
        System.out.println(usuario);
        System.out.println(op);
        return op;
    }
    
    public DefaultComboBoxModel Obt_date(String usu,String pass,String tabla){
        DefaultComboBoxModel ListaModelo = new DefaultComboBoxModel();
        ListaModelo.addElement("[SELECCIONAR]");
        consultaSQL="SELECT DISTINCT " + tabla + " FROM DBA_USERS";
        
        //rs = Conexiones.ConexionBD.Consulta();
        try {
            pst=getConexion(usu,pass).prepareStatement(consultaSQL);
            rs=pst.executeQuery();
            while (rs.next()) {                
                ListaModelo.addElement(rs.getString(tabla));
            }
            pst.close();
            rs.close();
            getConexion(usu, pass);
        } catch (SQLException e) {
        }
        
        return ListaModelo;
    }   
    
}
