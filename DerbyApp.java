package com.citi.banking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String dbURL = "jdbc:derby:carDB;create=true";
		
		try {
			Connection conn = DriverManager.getConnection( dbURL );
			   //Connection con = DriverManager.getConnection
				  //      ("jdbc:derby://localhost:1527/junkdb;create=true","app","app");  
			System.out.println( "Database created successfully" );
			 Statement stmt = conn.createStatement();
			 
		      stmt.executeUpdate("CREATE TABLE USERS (ID INT PRIMARY KEY, NAME VARCHAR(12))");
		      System.out.println("Created Table");
		 
		      stmt.executeUpdate("INSERT INTO USERS VALUES (1,'TOM'),(2,'BILL'),(3,'AMY'),(4,'OWEN')");
		      System.out.println("Populated Table");
		 
		      System.out.println("Done");
			 PreparedStatement statement = conn
	                    .prepareStatement("SELECT * from USERS");

	           ResultSet resultSet = statement.executeQuery();
	            while (resultSet.next()) {
	                String user = resultSet.getString("NAME");
	                String number = resultSet.getString("ID");
	                System.out.println("User: " + user);
	                System.out.println("ID: " + number);
	            }
			  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
