package com.mycompany.iooj;
import javax.swing.*;
import java.io.*;
import java.time.LocalDateTime;

public class userTrainer extends userinfo{
    public userTrainer(){};
    
    public userTrainer(String username,String role,String alias){
        setUsername(username);
        setRole(role);
        setAlias(alias);
    };
    
    
    public String [] getfilecontent () throws IOException{
        BufferedReader input = new BufferedReader (new FileReader("sessions.txt"));
        String Line;
        String [] fileinfo = new String [0];
        while((Line = input.readLine())!=null){
            fileinfo = addmoretoarray(fileinfo);
            fileinfo[fileinfo.length-1] = Line;
        }
       return fileinfo;
    }
    
    public String displayspecificlog(String rowname) throws IOException{
        BufferedReader loginput = new BufferedReader (new FileReader("sessions.txt"));
        String Line;
        String validate = null;
        while((Line = loginput.readLine())!=null)
        {
            String [] check = Line.split("~");
            if (rowname.equals(check[0])){
                validate = Line;
                break;
            }
        }
        return validate;
    }
    
    public void modifylog(String modifiedcontent) throws IOException{
        String [] splitmodifiedcontent = modifiedcontent.split("~");
        userinfo user = new userinfo();
        BufferedReader input = new BufferedReader (new FileReader("sessions.txt"));
        String Line;
        String [] changedcontent = new String[0];
        int count = 0;
        while((Line = input.readLine())!=null)
        {
            changedcontent = user.addmoretoarray(changedcontent);
            changedcontent[count] = Line;
            String [] check = Line.split("~");
            if (splitmodifiedcontent[0].equals(check[0])){
                check[7] = splitmodifiedcontent[1];
                check[8] = splitmodifiedcontent[2];
                check[6] = splitmodifiedcontent[3];
                changedcontent[count] = (check[0]+"~"+check[1]+"~"+check[2]+"~"+check[3]+"~"+check[4]+"~"+check[5]+"~"+check[6]+"~"+check[7]+"~"+check[8]+"~"+check[9]+"~"+check[10]);
            }
            count++;
        }
        
        try{
        BufferedWriter clearfile = new BufferedWriter (new FileWriter("sessions.txt"));
        clearfile.write("");
        clearfile.close();
        }
        catch(IOException e){
        System.out.println("not cleared");JOptionPane.showMessageDialog(null,"Failed to Cleared","Error",JOptionPane.ERROR_MESSAGE);
        }
        
        for(int number = 0;number <changedcontent.length;number++){
            try{
            BufferedWriter updatefile = new BufferedWriter (new FileWriter("sessions.txt",true));
            updatefile.write(changedcontent[number]);
            updatefile.newLine();
            updatefile.close();
            }
            catch(IOException e){
            JOptionPane.showMessageDialog(null,"Failed","Error",JOptionPane.ERROR_MESSAGE); 
            }
        }
    }   
    
    public String [][] rearrangecontent(String [][] needarrange){
        String [][] tobearrange = needarrange;

        for(int i =0; i<tobearrange.length;i++){
            for(int j =i+1;j<tobearrange.length;j++){

                String [] temporaryarray;
                //split both dates into day, month and year to be parse into specific format
                String[] date_one = tobearrange[i][1].split("/");
                String[] date_two = tobearrange[j][1].split("/");
                
                //parse the values into integer
                int day_one = Integer.parseInt(date_one[0]);
                int month_one = Integer.parseInt(date_one[1]);
                int year_one = Integer.parseInt(date_one[2]);
                
                int day_two = Integer.parseInt(date_two[0]);
                int month_two = Integer.parseInt(date_two[1]); 
                int year_two = Integer.parseInt(date_two[2]);
                
                //split the time 
                String[] time_one = tobearrange[i][2].split("-");
                String[] time_two = tobearrange[j][2].split("-");
                
                //split the start time into hour and minute
                String[] splittime_one = time_one[0].split(":");
                String[] splittime_two = time_two[0].split(":");
                
                //split the start time into hour and minute
                int hour_start = Integer.parseInt(splittime_one[0]);
                int hour_end = Integer.parseInt(splittime_one[1]);
                
                //split the end time into hour and minute
                int hour_two_start = Integer.parseInt(splittime_two[0]);
                int hour_two_end = Integer.parseInt(splittime_two[1]);      
                
                //combine the parsed start time into local date time format
                LocalDateTime time_first=LocalDateTime.of(year_one,month_one,day_one,hour_start, hour_end, 00);
                LocalDateTime time_second=LocalDateTime.of(year_two,month_two,day_two,hour_two_start, hour_two_end, 00);
                
                //compare the time and place the earlier start time first
                if (time_first.compareTo(time_second) >=0){
                    temporaryarray = tobearrange[i];
                    tobearrange[i] = tobearrange[j];
                    tobearrange[j] = temporaryarray;
                    
                }
            }
        }
        return tobearrange;
    }
    
    public String displayspecificprofile(String username) throws IOException{
        BufferedReader loginput = new BufferedReader (new FileReader("userinfo.txt"));
        String Line;
        String validate = null;
        while((Line = loginput.readLine())!=null)
        {
            String [] check = Line.split(",");
            if (check[0].equals(username)){
                validate = Line;
                break;
            }
        }
        return validate;
    }
}
