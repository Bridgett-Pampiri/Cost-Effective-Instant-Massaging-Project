package com.instant.mesenger.project;
import java.sql.*;

import javax.swing.JOptionPane;

public class DBMS {
	final static String JDBC_DRIVER =  "com.mysql.jdbc.Driver";
	final static String DB_URL = "jdbc:mysql://localhost:3306/Clients";
	
	final static String user = "root";
	final static String pass = "";
	
	public static Connection connection() {
		try {
			Class.forName(JDBC_DRIVER);
			Connection conn = DriverManager.getConnection(DB_URL, user, pass);
			
			return conn;
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		return null;
	}
	
	
	// printing the database
	public static void main(String args[]) {
		/*try {
			Connection connection = DriverManager.getConnection("DB_URL,user, pass);		// clients is the name of the database
			Statement statement =connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from ourClients");
			while(rs.next())
				System.out.println(rs.getInt(1) + " "+rs.getString(2) + " " + rs.getString(3));
			connection.close();
		} catch(Exception e) {
			e.printStackTrace();
		}*/
	}

}
