package com.mycompany.iooj;
import javax.swing.*;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import java.util.GregorianCalendar;

public class View_schedule extends javax.swing.JFrame {
    
    private int validation = -1;
    private String username;
    private String alias;
    private String currentdate;
    private Date currentdates;
    
    public View_schedule() {
        initComponents();
    }

    public View_schedule(String username,String alias) throws ParseException {
        initComponents();
        Labeltrainer.setText("Welcome back " + alias);
        //make the routine column uneditable
        Textroutine.setEditable(false);
        userTrainer ur = new userTrainer();
        this.username = username;
        this.alias = alias;
       
        //compare time
        GregorianCalendar cal = new GregorianCalendar();
        currentdate = cal.get(GregorianCalendar.DAY_OF_MONTH)+"/"+(cal.get(GregorianCalendar.MONTH)+1)+"/"+cal.get(GregorianCalendar.YEAR);
        SimpleDateFormat st = new SimpleDateFormat("dd/MM/yyyy");
        currentdates = st.parse(currentdate);
        
        
        try{
        //extract all the content of txt file
        String [] info = ur.getfilecontent();
        DefaultTableModel tbm = (DefaultTableModel)Tableschedule.getModel();
        for (int infocount = 0;infocount<info.length;infocount++){
        String [] addinfo = info[infocount].split("~");
        
        //add[0] = String.format("%04d",Integer.parseInt(add[0]));
        addinfo[3] = "-";
        if (addinfo[5].equals(username) && addinfo[6].equals("incomplete")){
            //check if the username aligns and the session has yet been completed
            if (currentdates.compareTo(st.parse(addinfo[1])) <=0){
                //add info into table
                tbm.addRow(addinfo);
                }
            }
        }

//////////////reaarange content
        String [][] arrange = new String [Tableschedule.getRowCount()][Tableschedule.getColumnCount()];
        for(int ii =0; ii<Tableschedule.getRowCount();ii++){
            for(int j =0;j<Tableschedule.getColumnCount();j++){
                arrange[ii][j] = String.valueOf(Tableschedule.getValueAt(ii,j));
            }
        }

        //rearrange the array
        String [][] arrange2 = ur.rearrangecontent(arrange);

            int numberofrow = tbm.getRowCount();
            if(tbm.getRowCount()>-1){
                for(int i3 = 0;i3<numberofrow; i3++){
                tbm.removeRow(0);
                }
            }

            for (int i4 = 0;i4 <arrange.length;i4++){
                    tbm.addRow(arrange2[i4]);
                }
//////////////////////////////////////////////////////////// 
        
        //remove all of the rows in the table
        int numberofrowneededtoberemove = tbm.getRowCount();
        if(tbm.getRowCount()>-1){
            for(int i = 0;i<numberofrowneededtoberemove; i++){
            tbm.removeRow(0);
            }
        }
        
        //add the rearranged row
        for (int i = 0;i <arrange.length;i++){
                tbm.addRow(arrange[i]);
            }
//rearrange the row
        
        }
        catch (IOException e){
        JOptionPane.showMessageDialog(null,"Invalid File","Error",JOptionPane.ERROR_MESSAGE);
        }
        //make the table uneditable
        Tableschedule.setDefaultEditor(Object.class, null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Grouplog = new javax.swing.ButtonGroup();
        Paneltrainer = new javax.swing.JPanel();
        Labeltrainer = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tableschedule = new javax.swing.JTable();
        Buttonmodify = new javax.swing.JButton();
        Buttonback = new javax.swing.JButton();
        Buttonlog = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        Textstartlog = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        Textendlog = new javax.swing.JTextArea();
        Labellogstart = new javax.swing.JLabel();
        Labellogend = new javax.swing.JLabel();
        Checkstatus = new javax.swing.JCheckBox();
        Checkprevioussession = new javax.swing.JCheckBox();
        Checktoday = new javax.swing.JCheckBox();
        Textroutine = new javax.swing.JTextArea();
        Labelroutine = new javax.swing.JLabel();
        Buttonclear = new javax.swing.JButton();
        Labelschedule = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Paneltrainer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Labeltrainer.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 18)); // NOI18N
        Labeltrainer.setForeground(new java.awt.Color(255, 255, 255));
        Labeltrainer.setText("-");
        Paneltrainer.add(Labeltrainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 878, -1));

        Tableschedule.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Date", "Time", "Routine", "Customer", "Trainer"
            }
        ));
        Tableschedule.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(Tableschedule);

        Paneltrainer.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 28, 543, -1));

        Buttonmodify.setBackground(new java.awt.Color(102, 255, 102));
        Buttonmodify.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 18)); // NOI18N
        Buttonmodify.setText("MODIFY");
        Buttonmodify.setActionCommand(" MODIFY LOG");
        Buttonmodify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonmodifyActionPerformed(evt);
            }
        });
        Paneltrainer.add(Buttonmodify, new org.netbeans.lib.awtextra.AbsoluteConstraints(561, 410, 309, 120));

        Buttonback.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 14)); // NOI18N
        Buttonback.setText("BACK");
        Buttonback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonbackActionPerformed(evt);
            }
        });
        Paneltrainer.add(Buttonback, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 498, 170, 32));

        Buttonlog.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 18)); // NOI18N
        Buttonlog.setText("SHOW LOG");
        Buttonlog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonlogActionPerformed(evt);
            }
        });
        Paneltrainer.add(Buttonlog, new org.netbeans.lib.awtextra.AbsoluteConstraints(182, 498, 367, 32));

        Textstartlog.setColumns(20);
        Textstartlog.setLineWrap(true);
        Textstartlog.setRows(5);
        Textstartlog.setPreferredSize(new java.awt.Dimension(230, 84));
        jScrollPane2.setViewportView(Textstartlog);

        Paneltrainer.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(555, 50, 315, 141));

        Textendlog.setColumns(20);
        Textendlog.setLineWrap(true);
        Textendlog.setRows(5);
        Textendlog.setPreferredSize(new java.awt.Dimension(230, 84));
        jScrollPane3.setViewportView(Textendlog);

        Paneltrainer.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(555, 219, 315, 141));

        Labellogstart.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 18)); // NOI18N
        Labellogstart.setForeground(new java.awt.Color(255, 255, 255));
        Labellogstart.setText("Pre-session log:");
        Paneltrainer.add(Labellogstart, new org.netbeans.lib.awtextra.AbsoluteConstraints(555, 28, 329, -1));

        Labellogend.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 18)); // NOI18N
        Labellogend.setForeground(new java.awt.Color(255, 255, 255));
        Labellogend.setText("Post-session log:");
        Paneltrainer.add(Labellogend, new org.netbeans.lib.awtextra.AbsoluteConstraints(555, 197, -1, -1));

        Checkstatus.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 18)); // NOI18N
        Checkstatus.setForeground(new java.awt.Color(255, 255, 255));
        Checkstatus.setText("Session Completed");
        Paneltrainer.add(Checkstatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(561, 378, -1, -1));

        Grouplog.add(Checkprevioussession);
        Checkprevioussession.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 14)); // NOI18N
        Checkprevioussession.setForeground(new java.awt.Color(255, 255, 255));
        Checkprevioussession.setText("Show all sessions");
        Checkprevioussession.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckprevioussessionActionPerformed(evt);
            }
        });
        Paneltrainer.add(Checkprevioussession, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 466, 170, -1));

        Grouplog.add(Checktoday);
        Checktoday.setFont(new java.awt.Font("Gill Sans MT Condensed", 1, 18)); // NOI18N
        Checktoday.setForeground(new java.awt.Color(255, 255, 255));
        Checktoday.setText("Show sessions for the day");
        Checktoday.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChecktodayActionPerformed(evt);
            }
        });
        Paneltrainer.add(Checktoday, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 466, 176, -1));

        Textroutine.setColumns(20);
        Textroutine.setRows(5);
        Paneltrainer.add(Textroutine, new org.netbeans.lib.awtextra.AbsoluteConstraints(874, 50, 250, 480));

        Labelroutine.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 18)); // NOI18N
        Labelroutine.setForeground(new java.awt.Color(255, 255, 255));
        Labelroutine.setText("Routines:");
        Paneltrainer.add(Labelroutine, new org.netbeans.lib.awtextra.AbsoluteConstraints(884, 28, -1, -1));

        Buttonclear.setBackground(new java.awt.Color(255, 102, 102));
        Buttonclear.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 14)); // NOI18N
        Buttonclear.setText("CLEAR FILTER");
        Buttonclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonclearActionPerformed(evt);
            }
        });
        Paneltrainer.add(Buttonclear, new org.netbeans.lib.awtextra.AbsoluteConstraints(384, 463, 165, 26));

        Labelschedule.setIcon(new javax.swing.ImageIcon("D:\\ZzZ\\Degree2\\WPCS\\Iooj\\schedule.png")); // NOI18N
        Paneltrainer.add(Labelschedule, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1130, 540));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Paneltrainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Paneltrainer, javax.swing.GroupLayout.PREFERRED_SIZE, 539, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonbackActionPerformed
        this.setVisible(false);
        userTrainer trainer = new userTrainer();
        new Main_Trainer(username + "," + alias).setVisible(true);  
        
    }//GEN-LAST:event_ButtonbackActionPerformed

    private void ButtonmodifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonmodifyActionPerformed
        //ensure a row is selected
        if (Tableschedule.getSelectedRow() != -1){
            
            //ensure that the row is not chanegd during modification
            if (validation == Tableschedule.getSelectedRow()){
                
                //change the status of the sessions
                String status ;
                if (Checkstatus.isSelected()){
                    status = "complete";
                }else{
                    status = "incomplete";
                }

                int column = 0;
                int row = Tableschedule.getSelectedRow();
                
                //get the specific session id of the session
                String value = Tableschedule.getModel().getValueAt(row, column).toString();
                
                //contain the information needed to update the file
                String modifiedcontent = value+"~"+Textstartlog.getText()+"~"+Textendlog.getText()+"~"+status;

                userTrainer ur = new userTrainer ();
                try{
                    //update the txt file
                    ur.modifylog(modifiedcontent);
                    JOptionPane.showMessageDialog(null,"Successfully Modified");
                    
                    //update the table to reflect the changes
                    DefaultTableModel tbm = (DefaultTableModel)Tableschedule.getModel();
                    //remove all of the rows
                    int numberofrowneededtoberemove = tbm.getRowCount();
                    if(tbm.getRowCount()>-1){
                    for(int i = 0;i<numberofrowneededtoberemove; i++){
                    tbm.removeRow(0);
                    }
                     }
                    
                    //show only sessions that are incomplete
                    if (Checkprevioussession.isSelected() == false && Checktoday.isSelected() == false){
                                Textstartlog.setText("");
                                Textendlog.setText("");
                                Textroutine.setText("");
                                Checkstatus.setSelected(false);
                                GregorianCalendar cal = new GregorianCalendar();
                                currentdate = cal.get(GregorianCalendar.DAY_OF_MONTH)+"/"+(cal.get(GregorianCalendar.MONTH)+1)+"/"+cal.get(GregorianCalendar.YEAR);
                                SimpleDateFormat st = new SimpleDateFormat("dd/MM/yyyy");
                                try{
                                currentdates = st.parse(currentdate);
                                }catch (ParseException e){
                                    JOptionPane.showMessageDialog(null,"Conversion failed","Error",JOptionPane.ERROR_MESSAGE);
                                }
                        try{
                            //get all of the content of the file
                            String [] info = ur.getfilecontent();

                            for (int i = 0;i <info.length;i++){
                            String [] add = info[i].split("~");

                            //add[0] = String.format("%04d",Integer.parseInt(add[0]));
                            add[3] = "-";

                            try{
                            if (add[5].equals(username) && add[6].equals("incomplete")){
                                if (currentdates.compareTo(st.parse(add[1])) <=0){
                                    //add the content into the table
                                    tbm.addRow(add);
                                }

                            }
                            }catch (ParseException e){
                                JOptionPane.showMessageDialog(null,"Conversion failed","Error",JOptionPane.ERROR_MESSAGE);
                            }

                            }
                        }
                        catch (IOException e){
                        JOptionPane.showMessageDialog(null,"Invalid File","Error",JOptionPane.ERROR_MESSAGE);
                        }
                        
//////////////reaarange content
                        String [][] arrange = new String [Tableschedule.getRowCount()][Tableschedule.getColumnCount()];
                        for(int ii =0; ii<Tableschedule.getRowCount();ii++){
                            for(int j =0;j<Tableschedule.getColumnCount();j++){
                                arrange[ii][j] = String.valueOf(Tableschedule.getValueAt(ii,j));
                            }
                        }
                        //rearrange the array
                        String [][] arrange2 = ur.rearrangecontent(arrange);
                        
                            int numberofrow = tbm.getRowCount();
                            if(tbm.getRowCount()>-1){
                                for(int i3 = 0;i3<numberofrow; i3++){
                                tbm.removeRow(0);
                                }
                            }
                            
                            for (int i4 = 0;i4 <arrange.length;i4++){
                                    tbm.addRow(arrange2[i4]);
                                }
//////////////////////////////////////////////////////////// 
                        
                        
                    }
                    //show previous sessions as well
                    else if(Checkprevioussession.isSelected() == true && Checktoday.isSelected() == false){
                        
                        Textstartlog.setText("");
                        Textendlog.setText("");
                        Textroutine.setText("");
                        Checkstatus.setSelected(false);


                        try{
                        String [] info = ur.getfilecontent();
                        numberofrowneededtoberemove = tbm.getRowCount();
                        if(tbm.getRowCount()>-1){
                            for(int i = 0;i<numberofrowneededtoberemove; i++){
                            tbm.removeRow(0);
                            }
                        }
                        for (int i = 0;i <info.length;i++){
                        String [] add = info[i].split("~");

                        //add[0] = String.format("%04d",Integer.parseInt(add[0]));
                        add[3] = "-";

                        if (add[5].equals(username)){
                            tbm.addRow(add);
                        }
                        }
//////////////reaarange content
                        
                        String [][] arrange = new String [Tableschedule.getRowCount()][Tableschedule.getColumnCount()];
                        for(int ii =0; ii<Tableschedule.getRowCount();ii++){
                            for(int j =0;j<Tableschedule.getColumnCount();j++){
                                arrange[ii][j] = String.valueOf(Tableschedule.getValueAt(ii,j));
                            }
                        }

                        //rearrange the array
                        String [][] arrange2 = ur.rearrangecontent(arrange);
                        
                            int numberofrow = tbm.getRowCount();
                            if(tbm.getRowCount()>-1){
                                for(int i3 = 0;i3<numberofrow; i3++){
                                tbm.removeRow(0);
                                }
                            }
                            
                            for (int i4 = 0;i4 <arrange.length;i4++){
                                    tbm.addRow(arrange2[i4]);
                                }
//////////////////////////////////////////////////////////// 
                        
                        }
                        catch (IOException e){
                        JOptionPane.showMessageDialog(null,"Invalid File","Error",JOptionPane.ERROR_MESSAGE);
                        }
                    //show today's sessions only
                    }else if(Checkprevioussession.isSelected() == false && Checktoday.isSelected() == true){
                        
                                Textstartlog.setText("");
                                Textendlog.setText("");
                                Textroutine.setText("");
                                Checkstatus.setSelected(false);
                                
                                GregorianCalendar cal = new GregorianCalendar();
                                currentdate = cal.get(GregorianCalendar.DAY_OF_MONTH)+"/"+(cal.get(GregorianCalendar.MONTH)+1)+"/"+cal.get(GregorianCalendar.YEAR);
                                SimpleDateFormat st = new SimpleDateFormat("dd/MM/yyyy");
                                try{
                                currentdates = st.parse(currentdate);
                                }catch (ParseException e){
                                    JOptionPane.showMessageDialog(null,"Conversion failed","Error",JOptionPane.ERROR_MESSAGE);
                                }
                                
                                try{
                                String [] info = ur.getfilecontent();
                                numberofrowneededtoberemove = tbm.getRowCount();
                                if(tbm.getRowCount()>-1){
                                    for(int i = 0;i<numberofrowneededtoberemove; i++){
                                    tbm.removeRow(0);
                                    }
                                }
                                for (int i = 0;i <info.length;i++){
                                String [] add = info[i].split("~");

                                //add[0] = String.format("%04d",Integer.parseInt(add[0]));
                                add[3] = "-";
                                
                                        try{
                                        if (add[5].equals(username) && add[6].equals("incomplete")){
                                            if (currentdates.compareTo(st.parse(add[1])) ==0){
                                                tbm.addRow(add);
                                            }

                                        }
                                        }catch (ParseException e){
                                            JOptionPane.showMessageDialog(null,"Conversion failed","Error",JOptionPane.ERROR_MESSAGE);
                                        }
                                }
                                
//////////////reaarange content
                        
                        String [][] arrange = new String [Tableschedule.getRowCount()][Tableschedule.getColumnCount()];
                        for(int ii =0; ii<Tableschedule.getRowCount();ii++){
                            for(int j =0;j<Tableschedule.getColumnCount();j++){
                                arrange[ii][j] = String.valueOf(Tableschedule.getValueAt(ii,j));
                            }
                        }

                        //rearrange the array
                        String [][] arrange2 = ur.rearrangecontent(arrange);
                        
                            int numberofrow = tbm.getRowCount();
                            if(tbm.getRowCount()>-1){
                                for(int i3 = 0;i3<numberofrow; i3++){
                                tbm.removeRow(0);
                                }
                            }
                            
                            for (int i4 = 0;i4 <arrange.length;i4++){
                                    tbm.addRow(arrange2[i4]);
                                }
//////////////////////////////////////////////////////////// 
                                
                                
                                }
                                catch (IOException e){
                                JOptionPane.showMessageDialog(null,"Invalid File","Error",JOptionPane.ERROR_MESSAGE);
                                }
                    }
                }
                catch(IOException e){
                    JOptionPane.showMessageDialog(null,"Invalid file","Error",JOptionPane.ERROR_MESSAGE);
                }

            }
            else{
                JOptionPane.showMessageDialog(null,"You have to click the show log button to view the info","Error",JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null,"Nothing was selected","Error",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_ButtonmodifyActionPerformed

    private void ButtonlogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonlogActionPerformed
        
        if (Tableschedule.getSelectedRow() != -1){
            userTrainer ur = new userTrainer();
            try{
                int column = 0;
                int row = Tableschedule.getSelectedRow();
                String value = Tableschedule.getModel().getValueAt(row, column).toString();
                
                String logvalue = ur.displayspecificlog(value);
                String [] splitlog = logvalue.split("~");
                
                Textstartlog.setText(splitlog[7]);
                Textendlog.setText(splitlog[8]);
                Textroutine.setText(splitlog[3]);
                
                if (splitlog[1].equals("complete")){
                    Checkstatus.setSelected(true);
                }else{
                    Checkstatus.setSelected(false);
                }
               
                validation = Tableschedule.getSelectedRow();

            }
            catch(IOException e){
                JOptionPane.showMessageDialog(null,"Invalid File","Error",JOptionPane.ERROR_MESSAGE);
            }
            }
        
        else{
            JOptionPane.showMessageDialog(null,"No role selected","Error",JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_ButtonlogActionPerformed

    private void CheckprevioussessionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckprevioussessionActionPerformed
        if (Checkprevioussession.isSelected()){
        Textstartlog.setText("");
        Textendlog.setText("");
        Textroutine.setText("");
        Checkstatus.setSelected(false);
        try{
        userTrainer ur = new userTrainer();
        String [] info = ur.getfilecontent();
        
        DefaultTableModel tbm = (DefaultTableModel)Tableschedule.getModel();
        int numberofrowneededtoberemove = tbm.getRowCount();
        if(tbm.getRowCount()>-1){
            for(int i = 0;i<numberofrowneededtoberemove; i++){
            tbm.removeRow(0);
            }
        }
        
        for (int i = 0;i <info.length;i++){
        String [] add = info[i].split("~");
        
        //add[0] = String.format("%04d",Integer.parseInt(add[0]));
        add[3] = "-";
        
        if (add[5].equals(username)){
            tbm.addRow(add);
        }
        }

        String [][] arrange = new String [Tableschedule.getRowCount()][Tableschedule.getColumnCount()];
        for(int ii =0; ii<Tableschedule.getRowCount();ii++){
            for(int j =0;j<Tableschedule.getColumnCount();j++){
                arrange[ii][j] = String.valueOf(Tableschedule.getValueAt(ii,j));
            }
        }

        String [][] arrange2 = ur.rearrangecontent(arrange);

            int numberofrow = tbm.getRowCount();
            if(tbm.getRowCount()>-1){
                for(int i3 = 0;i3<numberofrow; i3++){
                tbm.removeRow(0);
                }
            }

            for (int i4 = 0;i4 <arrange.length;i4++){
                    tbm.addRow(arrange2[i4]);
                }
        }
        catch (IOException e){
        JOptionPane.showMessageDialog(null,"Invalid File","Error",JOptionPane.ERROR_MESSAGE);
        }
        }

        
        // TODO add your handling code here:
    }//GEN-LAST:event_CheckprevioussessionActionPerformed

    private void ButtonclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonclearActionPerformed
    Grouplog.clearSelection();
        Textstartlog.setText("");
        Textendlog.setText("");
        Textroutine.setText("");
        Checkstatus.setSelected(false);
        
        GregorianCalendar cal = new GregorianCalendar();
        currentdate = cal.get(GregorianCalendar.DAY_OF_MONTH)+"/"+(cal.get(GregorianCalendar.MONTH)+1)+"/"+cal.get(GregorianCalendar.YEAR);
        SimpleDateFormat st = new SimpleDateFormat("dd/MM/yyyy");
        try{
        currentdates = st.parse(currentdate);
        }catch (ParseException e){
            JOptionPane.showMessageDialog(null,"Conversion failed","Error",JOptionPane.ERROR_MESSAGE);
        }
        
        try{
        userTrainer ur = new userTrainer();
        String [] info = ur.getfilecontent();
        DefaultTableModel tbm = (DefaultTableModel)Tableschedule.getModel();
        int numberofrowneededtoberemove = tbm.getRowCount();
        if(tbm.getRowCount()>-1){
        for(int i = 0;i<numberofrowneededtoberemove; i++){
            tbm.removeRow(0);
            }
        }
        
        for (int i = 0;i <info.length;i++){
        String [] add = info[i].split("~");

        //add[0] = String.format("%04d",Integer.parseInt(add[0]));
        add[3] = "-";

        try{
        if (add[5].equals(username) && add[6].equals("incomplete")){
            if (currentdates.compareTo(st.parse(add[1])) <=0){
                tbm.addRow(add);
            }

        }
        }catch (ParseException e){
            JOptionPane.showMessageDialog(null,"Conversion failed","Error",JOptionPane.ERROR_MESSAGE);
        }
        }
        
//////////////reaarange content
        String [][] arrange = new String [Tableschedule.getRowCount()][Tableschedule.getColumnCount()];
        for(int ii =0; ii<Tableschedule.getRowCount();ii++){
            for(int j =0;j<Tableschedule.getColumnCount();j++){
                arrange[ii][j] = String.valueOf(Tableschedule.getValueAt(ii,j));
            }
        }

        //rearrange the array
        String [][] arrange2 = ur.rearrangecontent(arrange);

            int numberofrow = tbm.getRowCount();
            if(tbm.getRowCount()>-1){
                for(int i3 = 0;i3<numberofrow; i3++){
                tbm.removeRow(0);
                }
            }

            for (int i4 = 0;i4 <arrange.length;i4++){
                    tbm.addRow(arrange2[i4]);
                }
//////////////////////////////////////////////////////////// 
        
        }
        catch (IOException e){
        JOptionPane.showMessageDialog(null,"Invalid File","Error",JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_ButtonclearActionPerformed

    private void ChecktodayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChecktodayActionPerformed
        if (Checktoday.isSelected()){
        Textstartlog.setText("");
        Textendlog.setText("");
        Textroutine.setText("");
        Checkstatus.setSelected(false);
        
        GregorianCalendar cal = new GregorianCalendar();
        currentdate = cal.get(GregorianCalendar.DAY_OF_MONTH)+"/"+(cal.get(GregorianCalendar.MONTH)+1)+"/"+cal.get(GregorianCalendar.YEAR);
        SimpleDateFormat st = new SimpleDateFormat("dd/MM/yyyy");
        try{
        currentdates = st.parse(currentdate);
        }catch (ParseException e){
            JOptionPane.showMessageDialog(null,"Conversion failed","Error",JOptionPane.ERROR_MESSAGE);
        }
        
        try{
        userTrainer ur = new userTrainer();
        String [] info = ur.getfilecontent();
        DefaultTableModel tbm = (DefaultTableModel)Tableschedule.getModel();
        int numberofrowneededtoberemove = tbm.getRowCount();
        if(tbm.getRowCount()>-1){
            for(int i = 0;i<numberofrowneededtoberemove; i++){
            tbm.removeRow(0);
            }
        }
        for (int i = 0;i <info.length;i++){
        String [] add = info[i].split("~");
        
        //add[0] = String.format("%04d",Integer.parseInt(add[0]));
        add[3] = "-";
        
        try{
        if (add[5].equals(username) && add[6].equals("incomplete")){
            if (currentdates.compareTo(st.parse(add[1])) ==0){
                tbm.addRow(add);
            }

        }
        }catch (ParseException e){
            JOptionPane.showMessageDialog(null,"Conversion failed","Error",JOptionPane.ERROR_MESSAGE);
        }
                                
        }
        
 //////////////reaarange content                
        String [][] arrange = new String [Tableschedule.getRowCount()][Tableschedule.getColumnCount()];
        for(int ii =0; ii<Tableschedule.getRowCount();ii++){
            for(int j =0;j<Tableschedule.getColumnCount();j++){
                arrange[ii][j] = String.valueOf(Tableschedule.getValueAt(ii,j));
            }
        }

        //rearrange the array
        String [][] arrange2 = ur.rearrangecontent(arrange);

            int numberofrow = tbm.getRowCount();
            if(tbm.getRowCount()>-1){
                for(int i3 = 0;i3<numberofrow; i3++){
                tbm.removeRow(0);
                }
            }

            for (int i4 = 0;i4 <arrange.length;i4++){
                    tbm.addRow(arrange2[i4]);
                }
//////////////////////////////////////////////////////////// 
        
        
        }
        catch (IOException e){
        JOptionPane.showMessageDialog(null,"Invalid File","Error",JOptionPane.ERROR_MESSAGE);
        }
        }
        
    }//GEN-LAST:event_ChecktodayActionPerformed

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
            java.util.logging.Logger.getLogger(View_schedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View_schedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View_schedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View_schedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new View_schedule().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Buttonback;
    private javax.swing.JButton Buttonclear;
    private javax.swing.JButton Buttonlog;
    private javax.swing.JButton Buttonmodify;
    private javax.swing.JCheckBox Checkprevioussession;
    private javax.swing.JCheckBox Checkstatus;
    private javax.swing.JCheckBox Checktoday;
    private javax.swing.ButtonGroup Grouplog;
    private javax.swing.JLabel Labellogend;
    private javax.swing.JLabel Labellogstart;
    private javax.swing.JLabel Labelroutine;
    private javax.swing.JLabel Labelschedule;
    private javax.swing.JLabel Labeltrainer;
    private javax.swing.JPanel Paneltrainer;
    private javax.swing.JTable Tableschedule;
    private javax.swing.JTextArea Textendlog;
    private javax.swing.JTextArea Textroutine;
    private javax.swing.JTextArea Textstartlog;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
