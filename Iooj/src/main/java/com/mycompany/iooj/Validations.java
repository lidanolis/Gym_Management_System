package com.mycompany.iooj;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public abstract class Validations {

	public static Boolean dateIsValid (String date) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		try {
			formatter.parse(date);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static Boolean yearIsValid (String date) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy");
		try {
			formatter.parse(date);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static Boolean customerIdIsValid(String cusID) {
		
		// Validate Customer ID
		String line;
		String[] eachColVal;
		try {
			BufferedReader br = new BufferedReader(new FileReader("userinfo.txt"));
			while((line = br.readLine()) != null) {
				eachColVal = line.split(",");
				if (eachColVal[0].equals(cusID) && eachColVal[4].equals("Customer")) {
					return true;
				}
			}
			br.close();
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return false;
	}
	
	// check file to see if regitration username is unique
	public static Boolean usernameUnique(String username, int index, String filepath) {
		String line;
		String[] eachColVal;
		try {
			BufferedReader br = new BufferedReader(new FileReader(filepath));
			while((line = br.readLine()) != null) {
				eachColVal = line.split(",");
				if (eachColVal[index].equals(username)) {
					return false;
				}
			}
			br.close();		
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return true;
	}

	
	// check that the alias is all words
	public static Boolean aliasIsValid(String alias) {
		return Pattern.matches("[a-zA-Z]+", alias);
	}
	
	// password must be not have whitespace and have at least one special character
	public static Boolean passwordIsValid(String password) {
		// check for whitespaces
		for (char currentChar : password.toCharArray()) 
		{
			if (Character.isWhitespace(currentChar)) {
				return false;
			}
		}
		// this is regex code for word and number only
		Pattern pt = Pattern.compile("[a-zA-Z0-9]*");
		// compare password with regex to know if there is special character
		Matcher matcher = pt.matcher(password);
		// password match regex, return false (means no special character)
		if(matcher.matches()) {
			return false;
		}	
		return true;	
	}
	
	public static Boolean emailIsValid(String email) {
		
		// Regex pattern for validating email
		String emailRegex =  "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
		// create Pattern object to compile the regex into a pattern
		Pattern emailPt = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
		// create Matcher object to compare the pattern to the email argument
		Matcher matcher = emailPt.matcher(email);
		// return true if valid or false if not valid
		return matcher.find();
	}
	
	public static Boolean contactNumIsValid(String phnum) {
		
		// phoneNumber must start with 60..., with lengths between 10 -12
		if (phnum.charAt(0) == '6' && phnum.charAt(1) == '0' && phnum.matches("[0-9]+")
				&& phnum.length() == 10 || phnum.length() == 11 || phnum.length() == 12) 
		{
			return true;
		}
		else {
			return false;
		}
	}
	
	
	public static void main(String[] args) {
		System.out.println(aliasIsValid("aa"));
		System.out.println(passwordIsValid(""));
		
		
	}
	
	
}










