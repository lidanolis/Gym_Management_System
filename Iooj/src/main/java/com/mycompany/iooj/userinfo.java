package com.mycompany.iooj;
import java.io.*;


public class userinfo {
    private String username;
    private String password;
    private String role;
    private String alias;
    private String contact;
    private String email;
    
    //set all inputted information
    public userinfo(String username,String password,String role){
        this.username = username;
        this.password = password;
        this.role = role;
    }
    public String getContact() {
        return contact;
    }
    public void setContact(String contact) {
        this.contact = contact;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public userinfo(){
    };
    public userinfo(String username){
        this.username = username;
    }
    public userinfo(String username,String password){
        this.username = username;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getAlias() {
        return alias;
    }
    public void setAlias(String alias) {
        this.alias = alias;
    }
    
    
    
    public String[] addmoretoarray (String [] sample){
        //used to increase the array length by 1
        String [] addone = new String [sample.length+1];
            for (int i = 0;i <sample.length;i++){
            //add all of the previous value back to array
            addone[i] = sample[i];
            }
        return addone;
    }
    
    //validate user info
    public String infovalidation(){
        String lineofinfo;
        String returnprompt = "username does not exist";
        try{
            BufferedReader inforead = new BufferedReader (new FileReader("userinfo.txt"));
            while((lineofinfo = inforead.readLine())!=null){
                String [] correctinfo = lineofinfo.split(",");
                if (correctinfo[0].equals(username)){
                    if(correctinfo[2].equals(password)){
                        if(correctinfo[4].equals(role)){
                            returnprompt = "correct";
                            alias = correctinfo[1];
                            break;
                        }else{
                            returnprompt = "Incorrect role";
                            break;
                        }
                    }else{
                        returnprompt = "incorrect password";
                        break;
                    }
                }
                
            }

            }
        catch (IOException e){
            return returnprompt;
            }
        return returnprompt;}

}
