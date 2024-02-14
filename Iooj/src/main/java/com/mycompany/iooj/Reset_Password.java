package com.mycompany.iooj;
import javax.swing.*;


public class Reset_Password extends javax.swing.JFrame {
    private String username;
    public Reset_Password() {
        initComponents();
    }
    public Reset_Password(String username) {
        initComponents();
        this.username = username;
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panelreset = new javax.swing.JPanel();
        Labelpassword = new javax.swing.JLabel();
        Labelconfirmpassword = new javax.swing.JLabel();
        Buttonreset = new javax.swing.JButton();
        Buttonback = new javax.swing.JButton();
        Textpassword = new javax.swing.JPasswordField();
        Textconfirmpassword = new javax.swing.JPasswordField();
        Checkagree = new javax.swing.JCheckBox();
        Labelforgot = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Panelreset.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Labelpassword.setFont(new java.awt.Font("Gill Sans MT Condensed", 1, 18)); // NOI18N
        Labelpassword.setForeground(new java.awt.Color(255, 255, 255));
        Labelpassword.setText("PASSWORD");
        Panelreset.add(Labelpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        Labelconfirmpassword.setFont(new java.awt.Font("Gill Sans MT", 1, 14)); // NOI18N
        Labelconfirmpassword.setForeground(new java.awt.Color(255, 255, 255));
        Labelconfirmpassword.setText("CONFIRM PASSWORD");
        Panelreset.add(Labelconfirmpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        Buttonreset.setBackground(new java.awt.Color(255, 51, 51));
        Buttonreset.setFont(new java.awt.Font("Gill Sans Ultra Bold", 1, 18)); // NOI18N
        Buttonreset.setText("RESET");
        Buttonreset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonresetActionPerformed(evt);
            }
        });
        Panelreset.add(Buttonreset, new org.netbeans.lib.awtextra.AbsoluteConstraints(137, 202, 218, 30));

        Buttonback.setBackground(new java.awt.Color(51, 255, 51));
        Buttonback.setFont(new java.awt.Font("Gill Sans Ultra Bold", 1, 14)); // NOI18N
        Buttonback.setText("BACK");
        Buttonback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonbackActionPerformed(evt);
            }
        });
        Panelreset.add(Buttonback, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 202, 84, 30));
        Panelreset.add(Textpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 67, 175, -1));
        Panelreset.add(Textconfirmpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 118, 175, -1));

        Checkagree.setFont(new java.awt.Font("Gill Sans MT", 1, 14)); // NOI18N
        Checkagree.setForeground(new java.awt.Color(255, 255, 255));
        Checkagree.setText("I Have Agreeded To Change The Password");
        Panelreset.add(Checkagree, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 176, -1, -1));

        Labelforgot.setIcon(new javax.swing.ImageIcon("D:\\ZzZ\\Degree2\\WPCS\\Iooj\\forgot.png")); // NOI18N
        Panelreset.add(Labelforgot, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 290));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Panelreset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Panelreset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonbackActionPerformed
        this.setVisible(false);
        new Log_In().setVisible(true);  
    }//GEN-LAST:event_ButtonbackActionPerformed

    private void ButtonresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonresetActionPerformed
        if (Textpassword.getPassword().length ==0 && Textconfirmpassword.getPassword().length ==0){
            JOptionPane.showMessageDialog(null,"Incompelete Info","Error",JOptionPane.ERROR_MESSAGE);
        }
        else{
            if (String.valueOf(Textpassword.getPassword()).equals(String.valueOf(Textconfirmpassword.getPassword()))){
                if(Checkagree.isSelected()){
                    userlogin login = new userlogin();
                    login.setUsername(username);
                    login.setPassword(String.valueOf(Textpassword.getPassword()));
                    login.resetpassword();
                    //check if it is to return to login page or profile page
                        this.setVisible(false);
                        new Log_In().setVisible(true);

                }
                else{
                    JOptionPane.showMessageDialog(null,"Action has yet been agreeded","Error",JOptionPane.ERROR_MESSAGE);
                }
            }
            else{
                JOptionPane.showMessageDialog(null,"Unalligned password","Error",JOptionPane.ERROR_MESSAGE);
            }
        }
        
    }//GEN-LAST:event_ButtonresetActionPerformed


    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Reset_Password.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reset_Password.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reset_Password.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reset_Password.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reset_Password().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Buttonback;
    private javax.swing.JButton Buttonreset;
    private javax.swing.JCheckBox Checkagree;
    private javax.swing.JLabel Labelconfirmpassword;
    private javax.swing.JLabel Labelforgot;
    private javax.swing.JLabel Labelpassword;
    private javax.swing.JPanel Panelreset;
    private javax.swing.JPasswordField Textconfirmpassword;
    private javax.swing.JPasswordField Textpassword;
    // End of variables declaration//GEN-END:variables
}
