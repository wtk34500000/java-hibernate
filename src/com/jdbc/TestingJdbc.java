package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestingJdbc {

	public static void main(String[] args) {
		String jdbcUrl="jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
		String user="hbstudent";
		
		String pass="hbstudent";
		
		try {
			
			System.out.println("Connection to database:"+ jdbcUrl);
			
			Connection myConn = 
					DriverManager.getConnection(jdbcUrl, user, pass);
			
			System.out.println("Connection succesfully!");
			
		}catch(Exception exc) {
			exc.printStackTrace();
		}
	}

}
