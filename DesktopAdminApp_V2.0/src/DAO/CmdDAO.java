
package DAO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JOptionPane;

/**
 *
 * @author adoni
 */
public class CmdDAO {
    
    public static void ejecutarCMD(String cmd){
    Process p;
    try {
      p = Runtime.getRuntime().exec(cmd);
      p.waitFor();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
            String line;
            while ((line = reader.readLine())!= null) {
                System.out.println(line);
            } }
    } catch (IOException | InterruptedException e) {
        JOptionPane.showMessageDialog(null, "Falla en : \n" + e, "Error al ejecutar comando", JOptionPane.INFORMATION_MESSAGE);
    }
  }
    
}
