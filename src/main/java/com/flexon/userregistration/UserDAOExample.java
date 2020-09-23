package com.flexon.userregistration;

import java.time.LocalDate;

import com.flexon.userregistration.User.Gender;

public class UserDAOExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserDAO userList = new UserDAO();
		User user1 = new User("John", 
				              "Mike", 
				              "john@gmail.com", 
				              "dasDDF3D3#", 
				              Gender.Male, 
				              LocalDate.of(1950, 10, 10));
		User user2 = new User("Sarah", 
				              "Lee", 
				              "Sarah@gmail.com", 
				              "daseDF3D3#", 
				              Gender.Female, 
				              LocalDate.of(1972, 10, 10));
		User user3 = new User("Kitara", 
				              "Aang", 
				              "Aang@gmail.com", 
				              "daseDF3D3#", 
				              Gender.Female, 
				              LocalDate.of(1962, 10, 10));
		userList.addUser(user1);
		userList.addUser(user2);
		userList.addUser(user3);
		userList.printAll();
		userList.deleteUser("john@gmail.com");
		userList.printAll();
	}

}
