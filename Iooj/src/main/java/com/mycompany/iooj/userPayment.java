package com.mycompany.iooj;

import java.io.*;
import javax.swing.JOptionPane;

public class userPayment extends userTrainer{
    
    private String information;
    userPayment(){

    }
    userPayment(String information){
        this.information = information;
    }
    
    public void completepayment(String customerid)throws IOException{
        userinfo user = new userinfo();
        BufferedReader input = new BufferedReader (new FileReader("sessions.txt"));
        String Line;
        String [] answer = new String[0];
        int count = 0;
        while((Line = input.readLine())!=null)
        {
            answer = user.addmoretoarray(answer);
            answer[count] = Line;
            String [] check = Line.split("~");
            
            if (String.format("%04d",Integer.parseInt(check[0])).equals(customerid)){
                check[10] = "paid";
                answer[count] = (check[0]+"~"+check[1]+"~"+check[2]+"~"+check[3]+"~"+check[4]+"~"+check[5]+"~"+check[6]+"~"+check[7]+"~"+check[8]+"~"+check[9]+"~"+check[10]);
            }
            count++;
        }
        
        try{
        BufferedWriter output = new BufferedWriter (new FileWriter("sessions.txt"));
        output.write("");
        output.close();
        }
        catch(IOException e){
        System.out.println("not cleared");JOptionPane.showMessageDialog(null,"Failed to Cleared","Error",JOptionPane.ERROR_MESSAGE);
        }
        
        for(int number = 0;number <answer.length;number++){
            try{
            BufferedWriter outputagn = new BufferedWriter (new FileWriter("sessions.txt",true));
            outputagn.write(answer[number]);
            outputagn.newLine();
            outputagn.close();
            }
            catch(IOException e){
            JOptionPane.showMessageDialog(null,"Failed","Error",JOptionPane.ERROR_MESSAGE); 
            }
        }

    }
    
    public void generatereceipt(){
        String [] receiptinformation = information.split(",");
        try {
            BufferedWriter receipt = new BufferedWriter(new FileWriter("userreceipt.txt", true));
            //print the headings
            receipt.write("Session ID:" + receiptinformation[0]);
            receipt.newLine();
            receipt.write("-------------------------------------");
            receipt.newLine();
            receipt.write("         GYm.com        ");
            receipt.newLine();
            receipt.write("   No 00000 Address Line One ");
            receipt.newLine();
            receipt.write("   Address Line 02 SRI LANKA ");
            receipt.newLine();
            receipt.write("   www.facebook.com/GYm ");
            receipt.newLine();
            receipt.write("        +0198844331      ");
            receipt.newLine();
            receipt.write("-------------------------------------");
            receipt.newLine();
            receipt.write("Customer: " + receiptinformation[8]);
            receipt.newLine();
            receipt.write("Trainer: " + receiptinformation[9]);
            receipt.newLine();
            receipt.write(receiptinformation[6]);
            receipt.newLine();
            receipt.write(receiptinformation[4]);
            receipt.newLine();
            receipt.write(receiptinformation[5]);
            receipt.newLine();
            receipt.write(receiptinformation[7]);
            receipt.newLine();
            receipt.write("Price: "+ receiptinformation[1]);
            receipt.newLine();
            receipt.write("-------------------------------------");
            receipt.newLine();
            receipt.write("Amount Paid: "+receiptinformation[2]);
            receipt.newLine();
            receipt.write("-------------------------------------");
            receipt.newLine();
            receipt.write("Change: "+receiptinformation[3]);
            receipt.newLine();
            receipt.write("-------------------------------------");
            receipt.newLine();
            receipt.write("*************************************");
            receipt.newLine();
            receipt.write("       THANK YOU COME AGAIN            ");
            receipt.newLine();
            receipt.write("*************************************");
            receipt.newLine();
            receipt.write("   CONTACT: contact@GYm.com       "); 
            receipt.newLine();
            receipt.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Invalid File", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    @Override
    public String[] getfilecontent() throws IOException {
        BufferedReader input = new BufferedReader(new FileReader("userreceipt.txt"));
        String Line;
        int count = 0;
        String[] receiptinfo = new String[0];
        while ((Line = input.readLine()) != null) {
            if (Line.equals("Session ID:" + information)) {
                count = 24;
            }

            if (count > 0) {
                receiptinfo = addmoretoarray(receiptinfo);
                receiptinfo[receiptinfo.length - 1] = Line;
                count--;
            }
        }
        return receiptinfo;
    }
    
    public String[] getfilecontent(String past) throws IOException {
        BufferedReader input = new BufferedReader(new FileReader("sessions.txt"));
        String Line;
        String[] fileinfo = new String[0];
        while ((Line = input.readLine()) != null) {
            fileinfo = addmoretoarray(fileinfo);
            fileinfo[fileinfo.length - 1] = Line;
        }
        return fileinfo;
    }
}


