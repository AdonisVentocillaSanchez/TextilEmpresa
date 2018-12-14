
package GUI;

import Bean.UsuarioBean;
import DAO.AuthenticationDAO;
import javax.swing.*;

public class FrmLogin extends javax.swing.JFrame {

    UsuarioBean adminDAO = new UsuarioBean();
    AuthenticationDAO authdao = new AuthenticationDAO();
        
    public FrmLogin() {
        initComponents();
        txtServer.setText("localhost");
        txtPort.setText("1521");
        txtSid.setText("xe");
        txtUsername.requestFocus();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtServer = new javax.swing.JTextField();
        txtPort = new javax.swing.JTextField();
        txtSid = new javax.swing.JTextField();
        txtUsername = new javax.swing.JTextField();
        btnConnect = new javax.swing.JButton();
        txtPassword = new javax.swing.JPasswordField();
        btnminimize = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtServer.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtServer.setBorder(null);
        getContentPane().add(txtServer, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 250, 210, -1));

        txtPort.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtPort.setBorder(null);
        txtPort.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPortKeyTyped(evt);
            }
        });
        getContentPane().add(txtPort, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 310, 210, -1));

        txtSid.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtSid.setBorder(null);
        txtSid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSidActionPerformed(evt);
            }
        });
        getContentPane().add(txtSid, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 370, 210, -1));

        txtUsername.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtUsername.setBorder(null);
        txtUsername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUsernameKeyTyped(evt);
            }
        });
        getContentPane().add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 430, 210, -1));

        btnConnect.setBackground(new java.awt.Color(255, 255, 255));
        btnConnect.setFont(new java.awt.Font("Martina", 1, 24)); // NOI18N
        btnConnect.setForeground(new java.awt.Color(198, 76, 76));
        btnConnect.setText("Connect to Oracle Database");
        btnConnect.setBorderPainted(false);
        btnConnect.setContentAreaFilled(false);
        btnConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConnectActionPerformed(evt);
            }
        });
        getContentPane().add(btnConnect, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 530, -1, -1));

        txtPassword.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtPassword.setBorder(null);
        getContentPane().add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 490, 210, -1));

        btnminimize.setBackground(new java.awt.Color(255, 255, 255));
        btnminimize.setForeground(new java.awt.Color(255, 255, 255));
        btnminimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/minimize.png"))); // NOI18N
        btnminimize.setBorder(null);
        btnminimize.setContentAreaFilled(false);
        btnminimize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnminimizeActionPerformed(evt);
            }
        });
        getContentPane().add(btnminimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 10, 30, 30));

        btnsalir.setBackground(new java.awt.Color(255, 255, 255));
        btnsalir.setForeground(new java.awt.Color(255, 255, 255));
        btnsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/close.png"))); // NOI18N
        btnsalir.setBorder(null);
        btnsalir.setContentAreaFilled(false);
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnsalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 10, 30, 30));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/fondo.png"))); // NOI18N
        fondo.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                fondoMouseDragged(evt);
            }
        });
        fondo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                fondoMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                fondoMouseReleased(evt);
            }
        });
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 590));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    int xx,xy;
    private void txtPortKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPortKeyTyped

        char []p={'1','2','3','4','5','6','7','8','9','0'};
        int b=0;
        for(int i=0;i<=9;i++){
        if (p[i]==evt.getKeyChar()){b=1;}
 
        }
        if(b==0 || txtPort.getText().length() == 5 ){evt.consume();  getToolkit().beep(); 
        }
        
    }//GEN-LAST:event_txtPortKeyTyped

    private void btnConnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConnectActionPerformed
        
        String server = txtServer.getText();
        int port = Integer.parseInt(txtPort.getText());
        String sid = txtSid.getText();
        String username = txtUsername.getText();
        String password = new String(txtPassword.getPassword());
        
        adminDAO.setServer(server);
        adminDAO.setPort(port);
        adminDAO.setSid(sid);
        adminDAO.setUser(username);
        adminDAO.setPassword(password);
        
        boolean p =authdao.Login(adminDAO);
        
        if (p) {
            
            new FrmPrincipal().setVisible(true);            
            dispose();
        } else {
            Cleantxt();
        }
        
    }//GEN-LAST:event_btnConnectActionPerformed

    private void txtUsernameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsernameKeyTyped
        // TODO add your handling code here:
        Character c = evt.getKeyChar();
        if(Character.isLetter(c)) {
            evt.setKeyChar(Character.toUpperCase(c));
        }
    }//GEN-LAST:event_txtUsernameKeyTyped

    private void txtSidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSidActionPerformed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnsalirActionPerformed

    private void btnminimizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnminimizeActionPerformed
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_btnminimizeActionPerformed

    private void fondoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fondoMousePressed
        setOpacity((float)0.8);
        xx=evt.getX();
        xy=evt.getY();
    }//GEN-LAST:event_fondoMousePressed

    private void fondoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fondoMouseReleased
        setOpacity((float)1.0);
    }//GEN-LAST:event_fondoMouseReleased

    private void fondoMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fondoMouseDragged
        int x= evt.getXOnScreen();
        int y= evt.getYOnScreen();
        this.setLocation(x-xx, y-xy);
    }//GEN-LAST:event_fondoMouseDragged

    public void Cleantxt() {
        txtUsername.setText("");
        txtPassword.setText("");
        
        txtUsername.requestFocus();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConnect;
    private javax.swing.JButton btnminimize;
    private javax.swing.JButton btnsalir;
    private javax.swing.JLabel fondo;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtPort;
    private javax.swing.JTextField txtServer;
    private javax.swing.JTextField txtSid;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables

    
}
