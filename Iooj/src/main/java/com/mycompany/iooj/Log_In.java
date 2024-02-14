package com.mycompany.iooj;
import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class Log_In extends javax.swing.JFrame {
    
    private int numberoftimes;
    public Log_In() {
        numberoftimes = 3;
        initComponents();
        Buttonforgot.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panellogin = new javax.swing.JPanel();
        Labelusername = new javax.swing.JLabel();
        Labelpassword = new javax.swing.JLabel();
        Textusername = new javax.swing.JTextField();
        Labelrole = new javax.swing.JLabel();
        Comborole = new javax.swing.JComboBox<>();
        Textpassword = new javax.swing.JPasswordField();
        Buttonlogin = new javax.swing.JButton();
        Buttonforgot = new javax.swing.JButton();
        Labelbackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 255));
        setPreferredSize(new java.awt.Dimension(630, 420));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Panellogin.setBackground(new java.awt.Color(255, 255, 255));
        Panellogin.setOpaque(false);

        Labelusername.setBackground(new java.awt.Color(0, 204, 204));
        Labelusername.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 18)); // NOI18N
        Labelusername.setForeground(new java.awt.Color(255, 255, 255));
        Labelusername.setText("USERNAME");

        Labelpassword.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 18)); // NOI18N
        Labelpassword.setForeground(new java.awt.Color(255, 255, 255));
        Labelpassword.setText("PASSWORD");

        Textusername.setFont(new java.awt.Font("Gill Sans Ultra Bold Condensed", 0, 18)); // NOI18N

        Labelrole.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 18)); // NOI18N
        Labelrole.setForeground(new java.awt.Color(255, 255, 255));
        Labelrole.setText("ROLE");

        Comborole.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 18)); // NOI18N
        Comborole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Trainer", "Manager" }));

        Textpassword.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 18)); // NOI18N

        Buttonlogin.setBackground(new java.awt.Color(153, 255, 153));
        Buttonlogin.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 18)); // NOI18N
        Buttonlogin.setText("LOGIN");
        Buttonlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonloginActionPerformed(evt);
            }
        });

        Buttonforgot.setBackground(new java.awt.Color(255, 51, 51));
        Buttonforgot.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 18)); // NOI18N
        Buttonforgot.setText("FORGOT PASSWORD");
        Buttonforgot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonforgotActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelloginLayout = new javax.swing.GroupLayout(Panellogin);
        Panellogin.setLayout(PanelloginLayout);
        PanelloginLayout.setHorizontalGroup(
            PanelloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelloginLayout.createSequentialGroup()
                .addGroup(PanelloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(PanelloginLayout.createSequentialGroup()
                        .addGroup(PanelloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelloginLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(Labelrole)
                                .addGap(92, 92, 92))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelloginLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(PanelloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelloginLayout.createSequentialGroup()
                                        .addComponent(Labelusername)
                                        .addGap(24, 24, 24))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelloginLayout.createSequentialGroup()
                                        .addComponent(Labelpassword)
                                        .addGap(18, 18, 18)))))
                        .addGroup(PanelloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Textusername)
                            .addGroup(PanelloginLayout.createSequentialGroup()
                                .addComponent(Comborole, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(Textpassword)))
                    .addGroup(PanelloginLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(PanelloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Buttonlogin, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Buttonforgot, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        PanelloginLayout.setVerticalGroup(
            PanelloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelloginLayout.createSequentialGroup()
                .addContainerGap(53, Short.MAX_VALUE)
                .addGroup(PanelloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Textusername, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Labelusername, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Textpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Labelpassword))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Labelrole, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Comborole, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Buttonlogin, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Buttonforgot, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        getContentPane().add(Panellogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 4, 620, 380));

        Labelbackground.setIcon(new javax.swing.ImageIcon("D:\\ZzZ\\Degree2\\WPCS\\Iooj\\login.png")); // NOI18N
        Labelbackground.setMaximumSize(new java.awt.Dimension(630, 391));
        Labelbackground.setMinimumSize(new java.awt.Dimension(630, 391));
        Labelbackground.setPreferredSize(new java.awt.Dimension(630, 391));
        getContentPane().add(Labelbackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 391));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonforgotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonforgotActionPerformed
        this.setVisible(false);
        new Reset_Password(Textusername.getText()).setVisible(true);          
    }//GEN-LAST:event_ButtonforgotActionPerformed

    private void ButtonloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonloginActionPerformed
        //check credentials validations
        String returnprompt;

        if (Textusername.getText().equals("")||Textpassword.getPassword().equals("")){
          JOptionPane.showMessageDialog(null,"Incompelete Info","Error",JOptionPane.ERROR_MESSAGE);
          Textpassword.setText("");
        }
        else
        {
          //initiate credentials verifications
          userlogin login = new userlogin(Textusername.getText(),String.valueOf(Textpassword.getPassword()),Comborole.getSelectedItem().toString());
          returnprompt = login.infovalidation();
          
          //check if username exist
            if (returnprompt.equals("correct"))
            {                   
                this.setVisible(false);
                 if (Comborole.getSelectedItem().toString().equals("Trainer")){
                    login.logtime();
                    //username and alias is accessed via getUsername() and getAlias()
                    new Main_Trainer(login.getUsername()+","+login.getAlias()).setVisible(true);
                }
                else if (Comborole.getSelectedItem().toString().equals("Manager")){
                    new frmManagerMainPage(login.outinfo()).setVisible(true);
                }
            }
            else if(returnprompt.equals("incorrect password")){
                JOptionPane.showMessageDialog(null,"Incorrect password","Error",JOptionPane.ERROR_MESSAGE);
                Textpassword.setText("");
                Buttonforgot.setVisible(true);
                numberoftimes--;
                    boolean checking = login.incorrectlogin(numberoftimes);
                    if (checking){
                        try{
                            TimeUnit.SECONDS.sleep(10);
                            JOptionPane.showMessageDialog(null,"Try again now");
                            numberoftimes=3;
                        }catch(InterruptedException e){
                            JOptionPane.showMessageDialog(null,"Error occured","Error",JOptionPane.ERROR_MESSAGE);
                        }
                    }
            }else if (returnprompt.equals("Incorrect role")){  
                JOptionPane.showMessageDialog(null,("No " + Comborole.getSelectedItem().toString() + " named " + Textusername.getText()),"Error",JOptionPane.ERROR_MESSAGE);
                numberoftimes--;
                    boolean checking = login.incorrectlogin(numberoftimes);
                    if (checking){
                        try{
                            TimeUnit.SECONDS.sleep(10);
                            JOptionPane.showMessageDialog(null,"Try again now");
                            numberoftimes=3;
                        }catch(InterruptedException e){
                            JOptionPane.showMessageDialog(null,"Error occured","Error",JOptionPane.ERROR_MESSAGE);
                        }
                    }   
            }else if (returnprompt.equals("username does not exist")){
                JOptionPane.showMessageDialog(null,"Incorrect Username","Error",JOptionPane.ERROR_MESSAGE);
                Textusername.setText("");
                Textpassword.setText("");
                numberoftimes--;
                    boolean checking = login.incorrectlogin(numberoftimes);
                    if (checking){
                            try{
                                TimeUnit.SECONDS.sleep(10);
                                JOptionPane.showMessageDialog(null,"Try again now");
                                numberoftimes=3;

                            }catch(InterruptedException e){
                                JOptionPane.showMessageDialog(null,"Error occured","Error",JOptionPane.ERROR_MESSAGE);
                            }
                        }
            }               
        }         
    }//GEN-LAST:event_ButtonloginActionPerformed

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
            java.util.logging.Logger.getLogger(Log_In.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Log_In.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Log_In.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Log_In.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Log_In().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Buttonforgot;
    private javax.swing.JButton Buttonlogin;
    private javax.swing.JComboBox<String> Comborole;
    private javax.swing.JLabel Labelbackground;
    private javax.swing.JLabel Labelpassword;
    private javax.swing.JLabel Labelrole;
    private javax.swing.JLabel Labelusername;
    private javax.swing.JPanel Panellogin;
    private javax.swing.JPasswordField Textpassword;
    private javax.swing.JTextField Textusername;
    // End of variables declaration//GEN-END:variables
}
