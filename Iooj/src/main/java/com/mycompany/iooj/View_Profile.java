package com.mycompany.iooj;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;


public class View_Profile extends javax.swing.JFrame {
    private String username;
    private String alias;

    public View_Profile() {
        initComponents();
    }
    
    public View_Profile(String username,String alias) {
        this.username = username;
        this.alias = alias;
        initComponents();
        userTrainer profile = new userTrainer();
        try{
        String information = profile.displayspecificprofile(username);
        String [] splitinfo = information.split(",");
        Textusername.setText(splitinfo[0]);
        Textalias.setText(splitinfo[1]);
        Textemail.setText(splitinfo[3]);
        Textcontact.setText(splitinfo[5]);
        Textpassword.setText(splitinfo[2]);
        //make all column for viewing only
        Textusername.setEditable(false);
        Textalias.setEditable(false);
        Textemail.setEditable(false);
        Textcontact.setEditable(false);
        Textpassword.setEditable(false);
        }catch (IOException e){
            JOptionPane.showMessageDialog(null,"Failed","Error",JOptionPane.ERROR_MESSAGE); 
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Textusername = new javax.swing.JTextField();
        Labelusername = new javax.swing.JLabel();
        Labelalias = new javax.swing.JLabel();
        Labeleamail = new javax.swing.JLabel();
        Labelcontact = new javax.swing.JLabel();
        Labelpassword = new javax.swing.JLabel();
        Textalias = new javax.swing.JTextField();
        Textpassword = new javax.swing.JTextField();
        Textemail = new javax.swing.JTextField();
        Buttonback = new javax.swing.JButton();
        Textcontact = new javax.swing.JTextField();
        Labelprofile = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(480, 380));
        setPreferredSize(new java.awt.Dimension(480, 380));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setMaximumSize(new java.awt.Dimension(450, 340));
        jPanel1.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(450, 340));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(Textusername, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 38, 337, 36));

        Labelusername.setFont(new java.awt.Font("Gill Sans MT", 1, 14)); // NOI18N
        Labelusername.setForeground(new java.awt.Color(255, 255, 255));
        Labelusername.setText("USERNAME");
        jPanel1.add(Labelusername, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 42, -1, 28));

        Labelalias.setFont(new java.awt.Font("Gill Sans MT", 1, 14)); // NOI18N
        Labelalias.setForeground(new java.awt.Color(255, 255, 255));
        Labelalias.setText("ALIAS");
        jPanel1.add(Labelalias, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 86, -1, 26));

        Labeleamail.setFont(new java.awt.Font("Gill Sans MT", 1, 14)); // NOI18N
        Labeleamail.setForeground(new java.awt.Color(255, 255, 255));
        Labeleamail.setText("EMAIL");
        jPanel1.add(Labeleamail, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 126, 54, 30));

        Labelcontact.setFont(new java.awt.Font("Gill Sans MT", 1, 14)); // NOI18N
        Labelcontact.setForeground(new java.awt.Color(255, 255, 255));
        Labelcontact.setText("CONTACT");
        jPanel1.add(Labelcontact, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 167, -1, 29));

        Labelpassword.setFont(new java.awt.Font("Gill Sans MT", 1, 14)); // NOI18N
        Labelpassword.setForeground(new java.awt.Color(255, 255, 255));
        Labelpassword.setText("PASSWORD");
        jPanel1.add(Labelpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 218, -1, -1));
        jPanel1.add(Textalias, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 80, 337, 32));
        jPanel1.add(Textpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 207, 338, 39));
        jPanel1.add(Textemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 118, 337, 38));

        Buttonback.setBackground(new java.awt.Color(102, 255, 102));
        Buttonback.setFont(new java.awt.Font("Gill Sans Ultra Bold", 1, 18)); // NOI18N
        Buttonback.setText("BACK");
        Buttonback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonbackActionPerformed(evt);
            }
        });
        jPanel1.add(Buttonback, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 270, 436, 44));
        jPanel1.add(Textcontact, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 162, 338, 39));

        Labelprofile.setIcon(new javax.swing.ImageIcon("D:\\ZzZ\\Degree2\\WPCS\\Iooj\\profile.png")); // NOI18N
        jPanel1.add(Labelprofile, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 320));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 320));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonbackActionPerformed
        this.setVisible(false);
        new Main_Trainer(username+","+alias).setVisible(true);
    }//GEN-LAST:event_ButtonbackActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(View_Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View_Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View_Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View_Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new View_Profile().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Buttonback;
    private javax.swing.JLabel Labelalias;
    private javax.swing.JLabel Labelcontact;
    private javax.swing.JLabel Labeleamail;
    private javax.swing.JLabel Labelpassword;
    private javax.swing.JLabel Labelprofile;
    private javax.swing.JLabel Labelusername;
    private javax.swing.JTextField Textalias;
    private javax.swing.JTextField Textcontact;
    private javax.swing.JTextField Textemail;
    private javax.swing.JTextField Textpassword;
    private javax.swing.JTextField Textusername;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
