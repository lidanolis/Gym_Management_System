package com.mycompany.iooj;
import javax.swing.*;
import java.io.*;
import javax.swing.table.DefaultTableModel;
import java.text.DecimalFormat;

public class Payment extends javax.swing.JFrame {
    private static final DecimalFormat df = new DecimalFormat("0.00");
    private int rowselected = -1;
    private double ensurepayment = 0;
    private String username;
    private String alias;
    
    public Payment() {
    initComponents();
    }
    public Payment(String username,String alias) {
        initComponents();
        this.username = username;
        this.alias = alias;
        Textamount.setEditable(false);
        Textchange.setEditable(false);
        Textdetail.setEditable(false);
        DefaultTableModel tbm = (DefaultTableModel)Tablesessions.getModel();
        Tablesessions.setDefaultEditor(Object.class, null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panelpayment = new javax.swing.JPanel();
        Buttoncalculate = new javax.swing.JButton();
        Labelpaidamount = new javax.swing.JLabel();
        Labelamount = new javax.swing.JLabel();
        Textpaidamount = new javax.swing.JTextField();
        Textamount = new javax.swing.JTextField();
        Buttonpay = new javax.swing.JButton();
        Labelchange = new javax.swing.JLabel();
        Textchange = new javax.swing.JTextField();
        Labelcustomer = new javax.swing.JLabel();
        Textusername = new javax.swing.JTextField();
        Buttonsearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tablesessions = new javax.swing.JTable();
        Buttonshowamount = new javax.swing.JButton();
        Buttonback = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        Textdetail = new javax.swing.JTextArea();
        Labeldetail = new javax.swing.JLabel();
        Labelpayment = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1040, 550));
        setMinimumSize(new java.awt.Dimension(1040, 550));
        setPreferredSize(new java.awt.Dimension(1040, 550));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Panelpayment.setOpaque(false);

        Buttoncalculate.setBackground(new java.awt.Color(153, 255, 102));
        Buttoncalculate.setFont(new java.awt.Font("Gill Sans Ultra Bold", 1, 18)); // NOI18N
        Buttoncalculate.setText("CALCULATE");
        Buttoncalculate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtoncalculateActionPerformed(evt);
            }
        });

        Labelpaidamount.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 14)); // NOI18N
        Labelpaidamount.setForeground(new java.awt.Color(255, 255, 255));
        Labelpaidamount.setText("PAID AMOUNT:");

        Labelamount.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 14)); // NOI18N
        Labelamount.setForeground(new java.awt.Color(255, 255, 255));
        Labelamount.setText("AMOUNT:");

        Buttonpay.setBackground(new java.awt.Color(255, 102, 102));
        Buttonpay.setFont(new java.awt.Font("Gill Sans Ultra Bold", 1, 18)); // NOI18N
        Buttonpay.setText("PAY");
        Buttonpay.setActionCommand(" MODIFY LOG");
        Buttonpay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonpayActionPerformed(evt);
            }
        });

        Labelchange.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 14)); // NOI18N
        Labelchange.setForeground(new java.awt.Color(255, 255, 255));
        Labelchange.setText("CHANGE:");

        Labelcustomer.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 12)); // NOI18N
        Labelcustomer.setForeground(new java.awt.Color(255, 255, 255));
        Labelcustomer.setText("Enter Customer Name:");

        Buttonsearch.setBackground(new java.awt.Color(153, 255, 204));
        Buttonsearch.setFont(new java.awt.Font("Gill Sans Ultra Bold", 1, 18)); // NOI18N
        Buttonsearch.setText("SEARCH");
        Buttonsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonsearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelpaymentLayout = new javax.swing.GroupLayout(Panelpayment);
        Panelpayment.setLayout(PanelpaymentLayout);
        PanelpaymentLayout.setHorizontalGroup(
            PanelpaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelpaymentLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelpaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Textamount)
                    .addComponent(Buttonsearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Textusername)
                    .addGroup(PanelpaymentLayout.createSequentialGroup()
                        .addGroup(PanelpaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Labelchange)
                            .addComponent(Labelcustomer)
                            .addComponent(Labelamount)
                            .addComponent(Labelpaidamount))
                        .addGap(0, 117, Short.MAX_VALUE))
                    .addComponent(Textpaidamount)
                    .addComponent(Textchange)
                    .addComponent(Buttoncalculate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Buttonpay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        PanelpaymentLayout.setVerticalGroup(
            PanelpaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelpaymentLayout.createSequentialGroup()
                .addComponent(Labelcustomer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Textusername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Buttonsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(Labelamount)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Textamount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Labelpaidamount)
                .addGap(3, 3, 3)
                .addComponent(Textpaidamount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Labelchange)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Textchange, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(Buttoncalculate, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Buttonpay, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(Panelpayment, new org.netbeans.lib.awtextra.AbsoluteConstraints(482, 6, 300, 461));

        Tablesessions.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Customer", "Trainer"
            }
        ));
        Tablesessions.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(Tablesessions);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 470, 391));

        Buttonshowamount.setFont(new java.awt.Font("Gill Sans Ultra Bold", 1, 18)); // NOI18N
        Buttonshowamount.setText("SHOW");
        Buttonshowamount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonshowamountActionPerformed(evt);
            }
        });
        getContentPane().add(Buttonshowamount, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 409, 334, 58));

        Buttonback.setBackground(new java.awt.Color(255, 51, 51));
        Buttonback.setFont(new java.awt.Font("Gill Sans Ultra Bold", 1, 18)); // NOI18N
        Buttonback.setText("BACK");
        Buttonback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonbackActionPerformed(evt);
            }
        });
        getContentPane().add(Buttonback, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 409, 130, 58));

        Textdetail.setColumns(20);
        Textdetail.setRows(5);
        jScrollPane2.setViewportView(Textdetail);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(785, 29, -1, 438));

        Labeldetail.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 14)); // NOI18N
        Labeldetail.setForeground(new java.awt.Color(255, 255, 255));
        Labeldetail.setText("Session Details:");
        getContentPane().add(Labeldetail, new org.netbeans.lib.awtextra.AbsoluteConstraints(785, 6, -1, -1));

        Labelpayment.setIcon(new javax.swing.ImageIcon("D:\\ZzZ\\Degree2\\WPCS\\Iooj\\payment.png")); // NOI18N
        getContentPane().add(Labelpayment, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1030, 490));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonpayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonpayActionPerformed
        if (Tablesessions.getSelectedRow()!=-1){
            if(rowselected == Tablesessions.getSelectedRow()){
                if(Double.parseDouble(Textpaidamount.getText()) == ensurepayment){
                    int column = 0;
                    int row = Tablesessions.getSelectedRow();
                    String value = Tablesessions.getModel().getValueAt(row, column).toString();
                    userTrainer ur = new userTrainer();
                    userPayment ut = new userPayment();
                    try{
                        ut.completepayment(value);
                        //print receipt
                        String []detail = Textdetail.getText().split("\n");
                        String combineddetailed=",";
                        for (int detailcombine = 0;detailcombine<detail.length;detailcombine++){
                            combineddetailed = combineddetailed + detail[detailcombine] +",";
                        }
                        String receiptinformation = value+","+Textamount.getText()+","+Textpaidamount.getText()+","+ Textchange.getText()+combineddetailed+ Textusername.getText()+","+username;
                        //print information
                        userPayment up = new userPayment(receiptinformation);
                        up.generatereceipt();
                        //indicate successfull transaction
                        JOptionPane.showMessageDialog(null,"Successfull Payment");
                        //display receipt
                        new Print_Receipt(value).setVisible(true);
                        
                        //remove update the table
                        DefaultTableModel tbm = (DefaultTableModel)Tablesessions.getModel();
                        int numberofrowneededtoberemove = tbm.getRowCount();
                        if(tbm.getRowCount()>-1){
                            for(int i = 0;i<numberofrowneededtoberemove; i++){
                            tbm.removeRow(0);
                            }
                        }
                        
                        String [] updatetable = ur.getfilecontent();
        
                            for (int i = 0;i <updatetable.length;i++){
                            String [] add = updatetable[i].split("~");

                            String [] price = {add[0],add[4],add[5]};
                                if(add[4].equals(Textusername.getText()) && add[10].equals("unpaid") && add[5].equals(username)){
                                            tbm.addRow(price);
                                }   
                                

                        }
                        Textpaidamount.setText("");
                        Textamount.setText("");
                        Textchange.setText("");
                        Textdetail.setText("");
                        
                    }
                    catch(IOException e){
                        JOptionPane.showMessageDialog(null,"Process failed","Error",JOptionPane.ERROR_MESSAGE);
                    }


                }
                else{
                    JOptionPane.showMessageDialog(null,"Amount modified please recalculate to proceed","Error",JOptionPane.ERROR_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(null,"You have changed the row, please recalculate value","Error",JOptionPane.ERROR_MESSAGE);
            }

        }
        else{
            JOptionPane.showMessageDialog(null,"No row selected","Error",JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_ButtonpayActionPerformed

    private void ButtonbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonbackActionPerformed
        this.setVisible(false);
        new Main_Trainer(username +","+ alias).setVisible(true);

    }//GEN-LAST:event_ButtonbackActionPerformed

    private void ButtonshowamountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonshowamountActionPerformed
                
        if (Tablesessions.getSelectedRow() != -1){
            userTrainer ur = new userTrainer();
            try{
                int column = 0;
                int row = Tablesessions.getSelectedRow();
                String value = Tablesessions.getModel().getValueAt(row, column).toString();
                
                String logvalue = ur.displayspecificlog(value);
                String [] splitlog = logvalue.split("~");
                Textamount.setText(splitlog[9]);
                Textdetail.setText("DATE: "+ splitlog[1] + "\n" +"TIME: "+splitlog[2]+ "\n" +"ROUTINE: "+splitlog[3]+ "\n" +"STATUS: "+splitlog[6]);
                rowselected = Tablesessions.getSelectedRow();
                
            }
            catch(IOException e){
                JOptionPane.showMessageDialog(null,"Invalid File","Error",JOptionPane.ERROR_MESSAGE);
            }
            }
        
        else{
            JOptionPane.showMessageDialog(null,"No name inputted","Error",JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_ButtonshowamountActionPerformed

    private void ButtoncalculateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtoncalculateActionPerformed
        
        if (Tablesessions.getSelectedRow()!=-1){
            if(rowselected == Tablesessions.getSelectedRow()){
                if(Textpaidamount.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"No amount inputted","Error",JOptionPane.ERROR_MESSAGE);
                }
                else{
                    try{ 
                        //calculate the difference in amount
                        double change = Double.parseDouble(Textpaidamount.getText()) - Double.parseDouble(Textamount.getText());
                        if (change < 0){
                            JOptionPane.showMessageDialog(null,"Insufficient amount","Error",JOptionPane.ERROR_MESSAGE);
                        }else{
                            //ensure format is 2 decimal
                            Textchange.setText(String.valueOf(df.format(change)));
                            ensurepayment = Double.parseDouble(Textpaidamount.getText());
                        }
                    }catch (Exception e){
                        JOptionPane.showMessageDialog(null,"Invalid number inputted","Error",JOptionPane.ERROR_MESSAGE);
                    }

                }
            }else{
                JOptionPane.showMessageDialog(null,"You have changed the row, please recalculate value","Error",JOptionPane.ERROR_MESSAGE);
            }

        }
        else{
            JOptionPane.showMessageDialog(null,"No row selected","Error",JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_ButtoncalculateActionPerformed

    private void ButtonsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonsearchActionPerformed
        //check if info is given
        if (Textusername.getText().equals("")){
            JOptionPane.showMessageDialog(null,"No name was inputted","Error",JOptionPane.ERROR_MESSAGE);
        }
        else{
        Textdetail.setText("");
        userTrainer trainer = new userTrainer();
        //remove the content of the table
        DefaultTableModel tbm = (DefaultTableModel)Tablesessions.getModel();
        int numberofrowneededtoberemove = tbm.getRowCount();
        if(tbm.getRowCount()>-1){
            for(int i = 0;i<numberofrowneededtoberemove; i++){
            tbm.removeRow(0);
        }
        }

        try{
        String [] info = trainer.getfilecontent();
        
        for (int i = 0;i <info.length;i++){
        String [] add = info[i].split("~");
        
        //add[0] = String.format("%04d",Integer.parseInt(add[0]));
        String [] price = {add[0],add[4],add[5]};
            if(add[4].equals(Textusername.getText()) && add[10].equals("unpaid") && add[5].equals(username)){
                        tbm.addRow(price);
            }
        }
        
        //check session payments number
            if (tbm.getRowCount() ==0) {
                JOptionPane.showMessageDialog(null, "This person has yet to book any sessions");
            }
        
        
        }
        catch (IOException e){
        JOptionPane.showMessageDialog(null,"Invalid File","Error",JOptionPane.ERROR_MESSAGE);
        }
        }
        
    }//GEN-LAST:event_ButtonsearchActionPerformed

   
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
            java.util.logging.Logger.getLogger(Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Payment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Buttonback;
    private javax.swing.JButton Buttoncalculate;
    private javax.swing.JButton Buttonpay;
    private javax.swing.JButton Buttonsearch;
    private javax.swing.JButton Buttonshowamount;
    private javax.swing.JLabel Labelamount;
    private javax.swing.JLabel Labelchange;
    private javax.swing.JLabel Labelcustomer;
    private javax.swing.JLabel Labeldetail;
    private javax.swing.JLabel Labelpaidamount;
    private javax.swing.JLabel Labelpayment;
    private javax.swing.JPanel Panelpayment;
    private javax.swing.JTable Tablesessions;
    private javax.swing.JTextField Textamount;
    private javax.swing.JTextField Textchange;
    private javax.swing.JTextArea Textdetail;
    private javax.swing.JTextField Textpaidamount;
    private javax.swing.JTextField Textusername;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
