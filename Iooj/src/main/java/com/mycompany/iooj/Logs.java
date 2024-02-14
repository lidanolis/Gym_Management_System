package com.mycompany.iooj;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public abstract class Logs {
	
	public static void bookingLog(String username,String operation, String training) {
		
		String message;
		if (operation.equals("Add")) {
			message = "AddedCustomerBooking";
		}
		// operation == "Del"
		else {
			message = "DeletedCustomerBooking";
		}
		
		String filename = "Booking_Logs.txt";
		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true));
			
			LocalDate todayDate = LocalDate.now();
			String formatted_todayDate = todayDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			LocalTime currentTime = LocalTime.now();
			String formatted_currentTime = currentTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
			
			bw.write(username + "," + formatted_todayDate + "," + formatted_currentTime + "," + message + "," + training);
			bw.newLine();
			bw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
