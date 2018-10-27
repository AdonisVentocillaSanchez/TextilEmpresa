
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
    String consulta="";
    
    String usersave=bean.getUsusave();
    String passwordsave=bean.getPasssave();
            
    public boolean Login(String usu, String pass){
        boolean op = false;
        String usuario = "";
        consultaSQL = "SELECT USERNAME FROM dba_users WHERE USERNAME = '"+usu+"'";
        
        //respuesta = conbd.Consulta(consultaSQL);
        
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
/////////////////////////Aquí empiezan metodos que no son del login ni del mostrar tablas//////////////////////    
    public boolean modificar(String usu,String pass,String tablespace,String temptablespace,int quota)
    {
        try{
            System.out.println(""+usu+pass+tablespace+temptablespace+quota);
            if(pass.isEmpty()){
            }else{
                modificarUsuXPass(usu,pass);
            }
            modificarTableSpace(usu, tablespace);
            modificarTempTableSpace(usu, temptablespace);
            modificarQuota(usu, quota, tablespace);
            return true;
        }catch(Exception ex)
        {
            System.out.println(""+ex);
        }
        return false;
    }
    public boolean modificarUsuXPass(String usu,String pass)
    {
        try{
            consulta="ALTER USER \"?\" IDENTIFIED BY ? ;commit;";
            pst=getConexion(usersave,passwordsave).prepareStatement(consulta);
            pst.setString(1, usu);
            pst.setString(2, pass);
            pst.executeUpdate();
            pst.close();
            getConexion(usersave,passwordsave).close();
            return true;
        }catch(SQLException ex)
        {
            System.out.println("Ocurrió un error modificar USUXPASS"+ex);
        }
        
        return false;
    }
    
    public boolean modificarTableSpace(String usu,String tablespace)
    {
        try{
            consulta="ALTER USER \"?\" DEFAULT TABLESPACE ? ;";
            pst=getConexion(usersave,passwordsave).prepareStatement(consulta);
            pst.setString(1, usu);
            pst.setString(2, tablespace);
            pst.executeUpdate();
            pst.close();
            getConexion(usersave,passwordsave).close();
            return true;
        }catch(SQLException ex)
        {
            System.out.println("Ocurrió un error modificar TABLESPACE"+ex);
        }
        return false;
    }
    public boolean modificarTempTableSpace(String usu,String temptablespace)
    {
        try{
            consulta="ALTER USER \"?\" TEMPORARY TABLESPACE ? ;commit;";
            pst=getConexion(usersave,passwordsave).prepareStatement(consulta);
            pst.setString(1, usu);
            pst.setString(2, temptablespace);
            pst.executeUpdate();
            pst.close();
            getConexion(usersave,passwordsave).close();
            return true;
        }catch(SQLException ex)
        {
            System.out.println("Ocurrió un error modificar TEMP : "+ex);
        }
        return false;
    }
    public boolean modificarQuota(String usu,int quota,String tablespace)
    {
        try{
            consulta="alter user \"?\" quota ? K on ? ;";
            pst=getConexion(usersave,passwordsave).prepareStatement(consulta);
            pst.setString(1, usu);
            pst.setInt(2, quota);
            pst.setString(3, tablespace);
            pst.executeUpdate();
            pst.close();
            getConexion(usersave, passwordsave).close();
            return true;
        }catch(SQLException ex)
        {
            System.out.println("Ocurrió un error modificar QUOTA : "+ex);
        }
        return false;
    }
     
    
}
