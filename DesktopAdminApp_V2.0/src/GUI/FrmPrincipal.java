/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import GUI.Panel.*;
import java.awt.BorderLayout;
import javax.swing.*;
/**
 *
 * @author GRUPOADONIS
 */
public class FrmPrincipal extends javax.swing.JFrame {

    MantUser pUser = new MantUser();
    MantTablespace pTablespace = new MantTablespace();
    MantRole pRole = new MantRole();
    MantTable pTable = new MantTable();
    MantData pData = new MantData();
    
    AjustAbout aAbout = new AjustAbout();
    AjustSecurity aSecurity = new AjustSecurity();
                
    public FrmPrincipal() {
        initComponents(); 
        this.setLocationRelativeTo(null);
        
        this.setLocationRelativeTo(null);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Desktop = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmMaintenance = new javax.swing.JMenu();
        jmiUser = new javax.swing.JMenuItem();
        jmiTablespace = new javax.swing.JMenuItem();
        jmiRole = new javax.swing.JMenuItem();
        jmiTable = new javax.swing.JMenuItem();
        jmiData = new javax.swing.JMenuItem();
        jmSettings = new javax.swing.JMenu();
        jmiSecurity = new javax.swing.JMenuItem();
        jmiAbout = new javax.swing.JMenuItem();
        jmiLogOut = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout DesktopLayout = new javax.swing.GroupLayout(Desktop);
        Desktop.setLayout(DesktopLayout);
        DesktopLayout.setHorizontalGroup(
            DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
        );
        DesktopLayout.setVerticalGroup(
            DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 531, Short.MAX_VALUE)
        );

        jMenuBar1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jmMaintenance.setText("Mantenimiento");
        jmMaintenance.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jmiUser.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jmiUser.setText("Usuarios");
        jmiUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiUserActionPerformed(evt);
            }
        });
        jmMaintenance.add(jmiUser);

        jmiTablespace.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jmiTablespace.setText("Tablespace");
        jmiTablespace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiTablespaceActionPerformed(evt);
            }
        });
        jmMaintenance.add(jmiTablespace);

        jmiRole.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jmiRole.setText("Roles");
        jmiRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiRoleActionPerformed(evt);
            }
        });
        jmMaintenance.add(jmiRole);

        jmiTable.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jmiTable.setText("Tablas");
        jmiTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiTableActionPerformed(evt);
            }
        });
        jmMaintenance.add(jmiTable);

        jmiData.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jmiData.setText("Datos");
        jmiData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiDataActionPerformed(evt);
            }
        });
        jmMaintenance.add(jmiData);

        jMenuBar1.add(jmMaintenance);

        jmSettings.setText("Ajustes");
        jmSettings.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jmiSecurity.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jmiSecurity.setText("Seguridad");
        jmiSecurity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiSecurityActionPerformed(evt);
            }
        });
        jmSettings.add(jmiSecurity);

        jmiAbout.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jmiAbout.setText("Acerca de");
        jmiAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAboutActionPerformed(evt);
            }
        });
        jmSettings.add(jmiAbout);

        jmiLogOut.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jmiLogOut.setText("Cerrar sesión");
        jmiLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiLogOutActionPerformed(evt);
            }
        });
        jmSettings.add(jmiLogOut);

        jMenuBar1.add(jmSettings);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Desktop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Desktop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmiUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiUserActionPerformed
        OpenPanel(pUser);
    }//GEN-LAST:event_jmiUserActionPerformed

    private void jmiLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiLogOutActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jmiLogOutActionPerformed

    private void jmiTablespaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiTablespaceActionPerformed
        OpenPanel(pTablespace);
    }//GEN-LAST:event_jmiTablespaceActionPerformed

    private void jmiRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiRoleActionPerformed
        OpenPanel(pRole);
    }//GEN-LAST:event_jmiRoleActionPerformed

    private void jmiTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiTableActionPerformed
        OpenPanel(pTable);
    }//GEN-LAST:event_jmiTableActionPerformed

    private void jmiDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiDataActionPerformed
        OpenPanel(pData);
    }//GEN-LAST:event_jmiDataActionPerformed

    private void jmiSecurityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiSecurityActionPerformed
        OpenPanel(aSecurity);
    }//GEN-LAST:event_jmiSecurityActionPerformed

    private void jmiAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAboutActionPerformed
       OpenPanel(aAbout);
    }//GEN-LAST:event_jmiAboutActionPerformed

    public void OpenPanel(JPanel Panel) {
        Panel.setSize(Desktop.getWidth(), Desktop.getHeight());
        Panel.setLocation(0, 0);
        
        Desktop.removeAll();
        Desktop.add(Panel,BorderLayout.CENTER);
        Desktop.revalidate();
        Desktop.repaint();
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
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            
            public void run() {                
                new FrmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JPanel Desktop;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jmMaintenance;
    private javax.swing.JMenu jmSettings;
    private javax.swing.JMenuItem jmiAbout;
    private javax.swing.JMenuItem jmiData;
    private javax.swing.JMenuItem jmiLogOut;
    private javax.swing.JMenuItem jmiRole;
    private javax.swing.JMenuItem jmiSecurity;
    private javax.swing.JMenuItem jmiTable;
    private javax.swing.JMenuItem jmiTablespace;
    private javax.swing.JMenuItem jmiUser;
    // End of variables declaration//GEN-END:variables
  
}
