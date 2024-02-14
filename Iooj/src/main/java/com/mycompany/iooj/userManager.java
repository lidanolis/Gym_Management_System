package com.mycompany.iooj;
public class userManager extends userinfo{
	
    public userManager(){};
    
    public userManager(String username,String role,String alias){
        setUsername(username);
        setRole(role);
        setAlias(alias);
    };
}