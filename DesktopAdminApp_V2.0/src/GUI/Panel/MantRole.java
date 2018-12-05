/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Panel;

import DAO.RoleDAO;

/**
 *
 * @author adoni
 */
public class MantRole extends javax.swing.JPanel {
    
    RoleDAO roledao = new RoleDAO();
    
    public MantRole() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtrole = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtarearole = new javax.swing.JTextArea();
        btnaddprivileges = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        cbxtipo = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        cbxprivi = new javax.swing.JComboBox<>();
        btnaddrole = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtshowroletoaddprivileges = new javax.swing.JTextField();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("ROLES");

        jLabel7.setText("Rol :");

        txtarearole.setColumns(20);
        txtarearole.setRows(5);
        jScrollPane1.setViewportView(txtarearole);

        btnaddprivileges.setText("Agregar privilegio");
        btnaddprivileges.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddprivilegesActionPerformed(evt);
            }
        });

        jLabel8.setText("Tipo :");

        cbxtipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "[SELECCIONAR]", "CLUSTER", "DATABASE", "DATABASE LINK", "DIMENSION", "INDEX", "PROCEDURE", "PROFILE", "ROLE", "ROLLBACK SEGMENT", "SEQUENCE", "SESSION", "SYNONYM", "TABLE", "TABLESPACE", "TRIGGER", "USER", "VIEW" }));
        cbxtipo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxtipoItemStateChanged(evt);
            }
        });

        jLabel9.setText("Privilegios :");

        btnaddrole.setText("Crear rol");
        btnaddrole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddroleActionPerformed(evt);
            }
        });

        jLabel10.setText("Usted está otorgando privilegios a :");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(jLabel9)
                                .addGap(63, 63, 63)
                                .addComponent(cbxprivi, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(txtshowroletoaddprivileges, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(txtrole, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnaddrole))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(78, 78, 78)
                                .addComponent(jLabel8)
                                .addGap(28, 28, 28)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbxtipo, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnaddprivileges))))
                        .addGap(0, 438, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtrole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnaddrole))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtshowroletoaddprivileges, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxtipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cbxprivi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(btnaddprivileges)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Agregar", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnaddroleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddroleActionPerformed
        // TODO add your handling code here:
        String role=txtrole.getText();
        if(roledao.AddRole(role)){
            txtshowroletoaddprivileges.setText(role);
            txtarearole.append(role+" created");
        }
    }//GEN-LAST:event_btnaddroleActionPerformed

    private void cbxtipoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxtipoItemStateChanged
        // TODO add your handling code here:
//        if (evt.getStateChange() == ItemEvent.SELECTED) {
//            if (this.cbxtipo.getSelectedIndex()>=0) {
//                this.cbxprivi.setModel(new DefaultComboBoxModel(sdao.getPrivilegio(this.cbxtipo.getSelectedItem().toString())));
//            }
//        }
    }//GEN-LAST:event_cbxtipoItemStateChanged

    private void btnaddprivilegesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddprivilegesActionPerformed
        // TODO add your handling code here:
        String rolegranted=txtshowroletoaddprivileges.getText();
        if(roledao.AddPrivilegeToRole(rolegranted, (String)cbxprivi.getSelectedItem())){
            txtarearole.append("\n"+(String)cbxprivi.getSelectedItem()+" granted");
        }
    }//GEN-LAST:event_btnaddprivilegesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnaddprivileges;
    private javax.swing.JButton btnaddrole;
    private javax.swing.JComboBox<String> cbxprivi;
    private javax.swing.JComboBox<String> cbxtipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea txtarearole;
    private javax.swing.JTextField txtrole;
    private javax.swing.JTextField txtshowroletoaddprivileges;
    // End of variables declaration//GEN-END:variables
}
