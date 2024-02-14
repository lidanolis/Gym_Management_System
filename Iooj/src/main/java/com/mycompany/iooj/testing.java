package com.mycompany.iooj;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class testing {

	public static void main(String[] args) {

		String a = String.format("%04d", 30);
		System.out.println(a);
		int b = Integer.parseInt(a);
		System.out.println(b);
		int c = b + 1;
		System.out.println(c);
		String d = String.format("%04d", c);
		System.out.println(d);
		
		eraseLastLine();

	}
	
	public static void eraseLastLine() {
		byte b;
		long length;
		try {
			RandomAccessFile f = new RandomAccessFile("sessions.txt", "rw");
			length = f.length() - 1;
			do {                     
				  length -= 1;
				  f.seek(length);
				  b = f.readByte();
				} while(b != 10);
				f.setLength(length+1);
				f.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
