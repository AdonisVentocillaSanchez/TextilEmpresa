
package Bean;

import java.sql.ResultSet;
import Conexiones.ConexionBD;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class UsuarioBean extends ConexionBD{
    
    public static String ususave;
    public static String passsave;

    public UsuarioBean() {
    }

    public UsuarioBean(String ususave, String passsave) {
        this.ususave = ususave;
        this.passsave = passsave;
    }

    public String getUsusave() {
        return ususave;
    }

    public void setUsusave(String ususave) {
        this.ususave = ususave;
    }

    public String getPasssave() {
        return passsave;
    }

    public void setPasssave(String passsave) {
        this.passsave = passsave;
    }
    
}
