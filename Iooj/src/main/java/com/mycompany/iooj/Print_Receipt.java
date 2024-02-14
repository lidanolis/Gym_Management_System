package com.mycompany.iooj;

import java.io.IOException;
import javax.swing.JOptionPane;

public class Print_Receipt extends javax.swing.JFrame {
    
    public Print_Receipt() {
    }
    public Print_Receipt(String filedirectory) {
        initComponents();
        Textreceipt.setEditable(false);
        // insted of passing information, the session id is passed in instead
        userPayment ut = new userPayment(filedirectory);
        try{
        String [] receiptinfo = ut.getfilecontent();
        for (int writeL = 0; writeL<receiptinfo.length;writeL++){
            Textreceipt.append(receiptinfo[writeL]);
            Textreceipt.append("\n");
        }
        }catch (IOException e){
            JOptionPane.showMessageDialog(null,"Invalid file");
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panelreceipt = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Textreceipt = new javax.swing.JTextArea();
        Labelreceipt = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(420, 430));
        setPreferredSize(new java.awt.Dimension(420, 430));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Panelreceipt.setOpaque(false);
        Panelreceipt.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Textreceipt.setColumns(20);
        Textreceipt.setRows(5);
        jScrollPane1.setViewportView(Textreceipt);

        Panelreceipt.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 360, 370));

        getContentPane().add(Panelreceipt, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 6, 380, 390));

        Labelreceipt.setIcon(new javax.swing.ImageIcon("D:\\ZzZ\\Degree2\\WPCS\\Iooj\\receipt.png")); // NOI18N
        getContentPane().add(Labelreceipt, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Print_Receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Print_Receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Print_Receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Print_Receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Print_Receipt().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Labelreceipt;
    private javax.swing.JPanel Panelreceipt;
    private javax.swing.JTextArea Textreceipt;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
