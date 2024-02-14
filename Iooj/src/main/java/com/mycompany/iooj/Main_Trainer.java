package com.mycompany.iooj;

import java.text.ParseException;

public class Main_Trainer extends javax.swing.JFrame {
    private String information;
    private String username;
    private String alias;
    
    public Main_Trainer() {
        initComponents();
    }
    
    //retrive entire list
    public Main_Trainer(String information) {
        this.information = information;
        String [] userinformation = this.information.split(",");
        this.username = userinformation[0];
        this.alias = userinformation[1];
        initComponents();

        Labelwelcome.setText("Welcome back " + alias );
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Paneltrainermainpage = new javax.swing.JPanel();
        Buttonperformance = new javax.swing.JButton();
        Labelwelcome = new javax.swing.JLabel();
        Buttonview = new javax.swing.JButton();
        Buttonpay = new javax.swing.JButton();
        Buttonbak = new javax.swing.JButton();
        Buttonprofile = new javax.swing.JButton();
        Buttonreceipt = new javax.swing.JButton();
        Labelmaintrainer = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(620, 480));
        setPreferredSize(new java.awt.Dimension(620, 480));

        Paneltrainermainpage.setMaximumSize(new java.awt.Dimension(650, 420));
        Paneltrainermainpage.setMinimumSize(new java.awt.Dimension(650, 420));
        Paneltrainermainpage.setPreferredSize(new java.awt.Dimension(650, 420));
        Paneltrainermainpage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Buttonperformance.setBackground(new java.awt.Color(102, 102, 255));
        Buttonperformance.setFont(new java.awt.Font("Gill Sans Ultra Bold", 1, 18)); // NOI18N
        Buttonperformance.setText("VIEW PERFORMANCE");
        Buttonperformance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonperformanceActionPerformed(evt);
            }
        });
        Paneltrainermainpage.add(Buttonperformance, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 222, 270, 110));

        Labelwelcome.setFont(new java.awt.Font("Gill Sans Ultra Bold", 1, 18)); // NOI18N
        Labelwelcome.setForeground(new java.awt.Color(255, 255, 255));
        Labelwelcome.setText("-");
        Paneltrainermainpage.add(Labelwelcome, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 580, -1));

        Buttonview.setBackground(new java.awt.Color(102, 255, 102));
        Buttonview.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 18)); // NOI18N
        Buttonview.setText("VIEW SCHEDULE");
        Buttonview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonviewActionPerformed(evt);
            }
        });
        Paneltrainermainpage.add(Buttonview, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 280, 90));

        Buttonpay.setBackground(new java.awt.Color(255, 153, 102));
        Buttonpay.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 18)); // NOI18N
        Buttonpay.setText("MANAGE PAYMENT");
        Buttonpay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonpayActionPerformed(evt);
            }
        });
        Paneltrainermainpage.add(Buttonpay, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 220, 280, 110));

        Buttonbak.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 18)); // NOI18N
        Buttonbak.setText("BACK");
        Buttonbak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonbakActionPerformed(evt);
            }
        });
        Paneltrainermainpage.add(Buttonbak, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 570, 60));

        Buttonprofile.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 18)); // NOI18N
        Buttonprofile.setText("PROFILE");
        Buttonprofile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonprofileActionPerformed(evt);
            }
        });
        Paneltrainermainpage.add(Buttonprofile, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, 180, 80));

        Buttonreceipt.setBackground(new java.awt.Color(255, 204, 102));
        Buttonreceipt.setFont(new java.awt.Font("Gill Sans Ultra Bold", 1, 18)); // NOI18N
        Buttonreceipt.setText("VIEW PAYMENTS");
        Buttonreceipt.setOpaque(true);
        Buttonreceipt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonreceiptActionPerformed(evt);
            }
        });
        Paneltrainermainpage.add(Buttonreceipt, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 120, 280, 90));

        Labelmaintrainer.setIcon(new javax.swing.ImageIcon("D:\\ZzZ\\Degree2\\WPCS\\Iooj\\maintrainer.png")); // NOI18N
        Labelmaintrainer.setMaximumSize(new java.awt.Dimension(590, 420));
        Labelmaintrainer.setMinimumSize(new java.awt.Dimension(0, 0));
        Labelmaintrainer.setPreferredSize(new java.awt.Dimension(590, 420));
        Paneltrainermainpage.add(Labelmaintrainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 420));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Paneltrainermainpage, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Paneltrainermainpage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonviewActionPerformed
        this.setVisible(false);
        try{
        new View_schedule(username,alias).setVisible(true);
        }
        catch(ParseException e){}
    }//GEN-LAST:event_ButtonviewActionPerformed

    private void ButtonpayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonpayActionPerformed

        this.setVisible(false);
        new Payment(username,alias).setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonpayActionPerformed

    private void ButtonbakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonbakActionPerformed

    this.setVisible(false);
    new Log_In().setVisible(true);
    }//GEN-LAST:event_ButtonbakActionPerformed

    private void ButtonprofileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonprofileActionPerformed

    this.setVisible(false);
    new View_Profile(username,alias).setVisible(true);
    }//GEN-LAST:event_ButtonprofileActionPerformed

    private void ButtonreceiptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonreceiptActionPerformed
    this.setVisible(false);
    new Past_Payment(username,alias).setVisible(true);
    }//GEN-LAST:event_ButtonreceiptActionPerformed

    private void ButtonperformanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonperformanceActionPerformed
    this.setVisible(false);
    new Personal_Performance(username,alias).setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonperformanceActionPerformed


    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main_Trainer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Buttonbak;
    private javax.swing.JButton Buttonpay;
    private javax.swing.JButton Buttonperformance;
    private javax.swing.JButton Buttonprofile;
    private javax.swing.JButton Buttonreceipt;
    private javax.swing.JButton Buttonview;
    private javax.swing.JLabel Labelmaintrainer;
    private javax.swing.JLabel Labelwelcome;
    private javax.swing.JPanel Paneltrainermainpage;
    // End of variables declaration//GEN-END:variables
}
