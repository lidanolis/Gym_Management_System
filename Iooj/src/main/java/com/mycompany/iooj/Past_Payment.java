package com.mycompany.iooj;

import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Past_Payment extends javax.swing.JFrame {

    private int rowselected = -1;
    private String username;
    private String alias;

    public Past_Payment() {
        initComponents();
    }
    public Past_Payment(String username, String alias) {
        initComponents();
        this.username = username;
        this.alias = alias;
        Textdetail.setEditable(false);
        Tablereceipts.setDefaultEditor(Object.class, null);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panelpastpayment = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tablereceipts = new javax.swing.JTable();
        Buttonback = new javax.swing.JButton();
        Buttonshow = new javax.swing.JButton();
        Buttonsearch = new javax.swing.JButton();
        Textusername = new javax.swing.JTextField();
        Labelcustomer = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Textdetail = new javax.swing.JTextArea();
        Buttonreceipt = new javax.swing.JButton();
        Labelpastpayment = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Panelpastpayment.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Tablereceipts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Customer", "Amount (RM)"
            }
        ));
        Tablereceipts.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(Tablereceipts);

        Panelpastpayment.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 540, 350));

        Buttonback.setBackground(new java.awt.Color(255, 51, 51));
        Buttonback.setFont(new java.awt.Font("Gill Sans Ultra Bold", 1, 18)); // NOI18N
        Buttonback.setText("BACK");
        Buttonback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonbackActionPerformed(evt);
            }
        });
        Panelpastpayment.add(Buttonback, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 180, 50));

        Buttonshow.setFont(new java.awt.Font("Gill Sans Ultra Bold", 1, 18)); // NOI18N
        Buttonshow.setText("SHOW");
        Buttonshow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonshowActionPerformed(evt);
            }
        });
        Panelpastpayment.add(Buttonshow, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 460, 340, 50));

        Buttonsearch.setBackground(new java.awt.Color(153, 255, 204));
        Buttonsearch.setFont(new java.awt.Font("Gill Sans Ultra Bold", 1, 18)); // NOI18N
        Buttonsearch.setText("SEARCH");
        Buttonsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonsearchActionPerformed(evt);
            }
        });
        Panelpastpayment.add(Buttonsearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 530, 50));
        Panelpastpayment.add(Textusername, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 360, 350, 32));

        Labelcustomer.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 12)); // NOI18N
        Labelcustomer.setForeground(new java.awt.Color(255, 255, 255));
        Labelcustomer.setText("Enter Customer Name:");
        Panelpastpayment.add(Labelcustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, -1, -1));

        Textdetail.setColumns(20);
        Textdetail.setRows(5);
        jScrollPane2.setViewportView(Textdetail);

        Panelpastpayment.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(554, 10, 270, 440));

        Buttonreceipt.setBackground(new java.awt.Color(153, 255, 102));
        Buttonreceipt.setFont(new java.awt.Font("Gill Sans Ultra Bold", 1, 18)); // NOI18N
        Buttonreceipt.setText("PRINT RECEIPT");
        Buttonreceipt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonreceiptActionPerformed(evt);
            }
        });
        Panelpastpayment.add(Buttonreceipt, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 460, 260, 50));

        Labelpastpayment.setIcon(new javax.swing.ImageIcon("D:\\ZzZ\\Degree2\\WPCS\\Iooj\\pastpayment.png")); // NOI18N
        Panelpastpayment.add(Labelpastpayment, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 520));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panelpastpayment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panelpastpayment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonbackActionPerformed
        this.setVisible(false);
        new Main_Trainer(username +","+ alias).setVisible(true);
    }//GEN-LAST:event_ButtonbackActionPerformed

    private void ButtonshowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonshowActionPerformed

        if (Tablereceipts.getSelectedRow() != -1){
            userPayment payment = new userPayment();
            try{
                int column = 0;
                int row = Tablereceipts.getSelectedRow();
                String value = Tablereceipts.getModel().getValueAt(row, column).toString();

                String logvalue = payment.displayspecificlog(value);
                String [] splitlog = logvalue.split("~");
                Textdetail.setText("Trainer: "+splitlog[5]+"\n"+"DATE: "+splitlog[1] + "\n" +"TIME: "+splitlog[2]+ "\n" +"ROUTINE: "+splitlog[3]+ "\n" +"STATUS: "+splitlog[6]);
                rowselected = Tablereceipts.getSelectedRow();

            }
            catch(IOException e){
                JOptionPane.showMessageDialog(null,"Invalid File","Error",JOptionPane.ERROR_MESSAGE);
            }
        }

        else{
            JOptionPane.showMessageDialog(null,"No name inputted","Error",JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_ButtonshowActionPerformed

    private void ButtonsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonsearchActionPerformed
        //check if info is given
        if (Textusername.getText().equals("")){
            JOptionPane.showMessageDialog(null,"No name was inputted","Error",JOptionPane.ERROR_MESSAGE);
        }
        else{
            Textdetail.setText("");
            userPayment payment = new userPayment();
            //remove the content of the table
            DefaultTableModel tbm = (DefaultTableModel)Tablereceipts.getModel();
            int numberofrowneededtoberemove = tbm.getRowCount();
            if(tbm.getRowCount()>-1){
                for(int i = 0;i<numberofrowneededtoberemove; i++){
                    tbm.removeRow(0);
                }
            }

            try{
                
                //use parent class method
                String [] info = payment.getfilecontent("parent");
                for (int i = 0;i <info.length;i++){
                    String [] add = info[i].split("~");

                    //add[0] = String.format("%04d",Integer.parseInt(add[0]));
                    String [] paidinfo = {add[0],add[4],add[9]};
                    if(add[4].equals(Textusername.getText()) && add[10].equals("paid") && add[5].equals(username)){
                        tbm.addRow(paidinfo);
                    }
                }
                
                //check columns
                if(tbm.getRowCount() ==0){
                JOptionPane.showMessageDialog(null,"This person has yet to made any payments","Error",JOptionPane.ERROR_MESSAGE);
                }
            }
            catch (IOException e){
                JOptionPane.showMessageDialog(null,"Invalid File","Error",JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_ButtonsearchActionPerformed

    private void ButtonreceiptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonreceiptActionPerformed

        if (Tablereceipts.getSelectedRow()!=-1){
            if (rowselected == Tablereceipts.getSelectedRow()) {
                int column = 0;
                int row = Tablereceipts.getSelectedRow();
                String value = Tablereceipts.getModel().getValueAt(row, column).toString();
                new Print_Receipt(value).setVisible(true);

            } else {
                JOptionPane.showMessageDialog(null,"Please click show to display the new selected session","Error",JOptionPane.ERROR_MESSAGE);
            }

        }
        else{
            JOptionPane.showMessageDialog(null,"No name inputted");
        }
    }//GEN-LAST:event_ButtonreceiptActionPerformed


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
            java.util.logging.Logger.getLogger(Past_Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Past_Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Past_Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Past_Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Past_Payment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Buttonback;
    private javax.swing.JButton Buttonreceipt;
    private javax.swing.JButton Buttonsearch;
    private javax.swing.JButton Buttonshow;
    private javax.swing.JLabel Labelcustomer;
    private javax.swing.JLabel Labelpastpayment;
    private javax.swing.JPanel Panelpastpayment;
    private javax.swing.JTable Tablereceipts;
    private javax.swing.JTextArea Textdetail;
    private javax.swing.JTextField Textusername;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
