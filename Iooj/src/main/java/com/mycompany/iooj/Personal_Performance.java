package com.mycompany.iooj;

import java.awt.print.PrinterException;
import java.io.IOException;
import java.text.MessageFormat;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Personal_Performance extends javax.swing.JFrame {
    private String username;
    private String alias;
    //track performance for personal report generation
    private int goodperformance=0;
    private int badperformance=0;
    public Personal_Performance() {
        initComponents();
    }
    
    public Personal_Performance(String username,String alias) {
        initComponents();
        DefaultTableModel tbm = (DefaultTableModel)Tableattendance.getModel();
        Tableattendance.setDefaultEditor(Object.class, null);
        this.username = username;
        this.alias = alias;
        
        userPersonalPerformance upf = new userPersonalPerformance();
        try {
            String[] updatetable = upf.getfilecontent();

            for (int i = 0; i < updatetable.length; i++) {
                String[] add = updatetable[i].split("~");
                String recorddate = String.valueOf(add[5])+"/"+String.valueOf(add[6])+"/"+String.valueOf(add[7]);

                String[] attendance = {add[0], recorddate, add[3],add[4]};
                if (add[0].equals(username)) {
                    if(add[3].equals("Ontime")){
                        goodperformance++;
                    }else{
                        badperformance++;
                    }
                    tbm.addRow(attendance);
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Failed", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panelreport = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tableattendance = new javax.swing.JTable();
        Buttonreport = new javax.swing.JButton();
        Buttonback = new javax.swing.JButton();
        Labelreport = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Panelreport.setMaximumSize(new java.awt.Dimension(650, 430));
        Panelreport.setPreferredSize(new java.awt.Dimension(650, 430));
        Panelreport.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Tableattendance.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Trainer", "Date", "Status", "Arival (hour)"
            }
        ));
        Tableattendance.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(Tableattendance);

        Panelreport.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 632, 347));

        Buttonreport.setBackground(new java.awt.Color(102, 255, 102));
        Buttonreport.setFont(new java.awt.Font("Gill Sans Ultra Bold", 1, 18)); // NOI18N
        Buttonreport.setText("PRINT REPORT");
        Buttonreport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonreportActionPerformed(evt);
            }
        });
        Panelreport.add(Buttonreport, new org.netbeans.lib.awtextra.AbsoluteConstraints(196, 359, 442, 49));

        Buttonback.setBackground(new java.awt.Color(255, 102, 102));
        Buttonback.setFont(new java.awt.Font("Gill Sans Ultra Bold", 1, 18)); // NOI18N
        Buttonback.setText("BACK");
        Buttonback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonbackActionPerformed(evt);
            }
        });
        Panelreport.add(Buttonback, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 359, 184, 49));

        Labelreport.setIcon(new javax.swing.ImageIcon("D:\\ZzZ\\Degree2\\WPCS\\Iooj\\image (1).png")); // NOI18N
        Panelreport.add(Labelreport, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 410));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Panelreport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Panelreport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonreportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonreportActionPerformed
        String verdict=null;
        
        if (badperformance-goodperformance>=3){
            verdict = "Bad";
        }if (badperformance-goodperformance>-3 &&badperformance-goodperformance<3){
            verdict = "Average";
        }else if (badperformance-goodperformance<=-3){
            verdict = "Good";
        }
        MessageFormat header = new MessageFormat("Overall Performance: "+verdict);
        MessageFormat footer = new MessageFormat("Issued by GYm fitness center");
        try{
        Tableattendance.print(JTable.PrintMode.FIT_WIDTH,header,footer);
        }catch(PrinterException e){
            JOptionPane.showMessageDialog(null, "Failed", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_ButtonreportActionPerformed

    private void ButtonbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonbackActionPerformed
        this.setVisible(false);
        new Main_Trainer(username +","+ alias).setVisible(true);
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
            java.util.logging.Logger.getLogger(Personal_Performance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Personal_Performance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Personal_Performance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Personal_Performance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Personal_Performance().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Buttonback;
    private javax.swing.JButton Buttonreport;
    private javax.swing.JLabel Labelreport;
    private javax.swing.JPanel Panelreport;
    private javax.swing.JTable Tableattendance;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
