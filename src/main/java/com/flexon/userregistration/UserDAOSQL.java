package com.flexon.userregistration;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import com.flexon.userregistration.User.Gender;

public class UserDAOSQL {
	private static final String USERNAME = "root";
	private static final String PASSWORD = "password";
	private static final String CONN_STRING = "jdbc:mysql://localhost:3306/userDatabase";
	private static final String TABLE = "users";
	
	public static void main(String[] args) {

		addUser("Lisa", 
	            "Wu", 
	            "lisa@gmail.com", 
	            "dasDDF3D3#", 
	            Gender.Female, 
	            LocalDate.of(1956, 10, 10));
		printUserInfo();
		deleteUser("lisa@gmail.com");
		printUserInfo();
		changePassword("shuo@wang.com", "12345");
		changePassword("shuo@wang.com", "DFE#dwe3#$sd");
	}
	
	//Create / Insert a User
	public static void addUser(String firstName, 
					    String lastName, 
					    String email, 
					    String password,
					    Gender gender,
					    LocalDate birthday) {
		try {
			Connection conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
		    Statement statement = conn.createStatement();
		  
			User user = new User(firstName, lastName, email, password, gender, birthday);
					
			// Add new user to user table 
			System.out.println("Adding new user to User Table...");
			Date birthSQL = Date.valueOf(birthday);
			int genderSQL = gender == Gender.Female ? 1 : gender == Gender.Male ? 2 : 3;
			String values = String.format("'%s', '%s', '%s', '%s', %d, '%s'", firstName, lastName, email, password, genderSQL, birthSQL);
			String sql = String.format("Insert Into %s (firstName, lastName, email, password, gender, birthday) Values (%s)", TABLE, values);
					
			statement.executeUpdate(sql);
			System.out.println("User added successfully... \n");
			
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	// Delete a user by it's email
	public static void deleteUser(String email) {
		try {
			Connection conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
			Statement statement = conn.createStatement();
			
			System.out.println("Deleting the user with email: " + email);
			String sql = String.format("Delete from users where email='%s'", email);
			statement.executeUpdate(sql);
			System.out.println("User deleted successfully. \n");
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// Update user password 
	public static void changePassword(String email, String password) {
		try {
			Connection conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
			Statement statement = conn.createStatement();
			
			System.out.println("Updating the user password with email: " + email);
			
			if (!password.matches("((?=.*[a-z])(?=.*\\d)(?=.*[@#$%!])(?=.*[A-Z]).{6,16})")) {
				System.out.println(password + " is not an valid password");
				System.out.println("password needs to have at least one lowercase letter,\n"
						  + "at least one digit, \n"
						  + "at least one special character, \n"
						  + "at least one capital letter. \n");
				return;
			}
			
			String sql = String.format("UPDATE users SET password='%s' where email='%s'", password, email);
			statement.executeUpdate(sql);
			System.out.println("User password updated successfully. \n");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// print a user information
	public static void printUserInfo() {
		try {
			Connection conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
			Statement statement = conn.createStatement();
	        String query = "SELECT * FROM users";

	        // execute the query, and get a java resultset
	        ResultSet resultSet = statement.executeQuery(query);
	        
	        // iterate through the java resultset
	        while (resultSet.next())
	        {
	          String firstName = resultSet.getString("firstname");
	          String lastName = resultSet.getString("lastname");
	          String emailAdd = resultSet.getString("email");

	          // print the results
	          System.out.format("%s, %s, %s\n", firstName, lastName, emailAdd);
	        }
	        System.out.println();
	        statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    
	}
		
}
