package com.instant.mesenger.project;
import java.sql.*;

import javax.swing.JOptionPane;

public class DBMS {
	final static String JDBC_DRIVER =  "com.mysql.jdbc.Driver";
	final static String DB_URL = "jdbc:mysql://localhost:3306/Clients";
	
	final static String user = "root";
	final static String password = "";
	
	public static Connection connection() {
		String query = "select * from ourclients";
		try {
			Class.forName(JDBC_DRIVER);
			Connection conn = DriverManager.getConnection(DB_URL, user, password);
			System.out.println("Database Connected.");
			
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(query);
			
			while(result.next()) {
				String clientData = "";
				for(int i = 1; i <= 3; i++) {
					clientData += result.getString(i) + ":";
				}
				System.out.println(clientData);
			}
			
			return conn;
		} catch(Exception e) {
			System.out.println("Connection to database failed");
		}
		return null;
	}
	
	
	// printing the database
	public static void main(String args[]) {
		
		//connect to the database
		connection();
		
	}

}
