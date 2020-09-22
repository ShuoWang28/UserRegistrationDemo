package com.flexon.userregistration;

import java.time.LocalDate;

public class User {
	
	public enum Gender {Male, Female, Other};
	
	private String firstName;
	private String lastName;
	private String emailAddress;
	private String password;
	private LocalDate birthday;
	private Gender gender;
	
	public User() {
		
	}
	
	public User (String firstName, 
			     String lastName, 
			     String emailAddress, 
			     String password,
			     Gender gender,
			     LocalDate birthday) {
		setFirstName(firstName);
		setLastName(lastName);
		setEmailAddress(emailAddress);
		setPassword(password);
		setGender(gender);
		setBirthday(birthday);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		if (!validateName(firstName)) {
			System.out.println(firstName + " is not a valid name.");
			System.out.println("Please enter a valid name.");
			return;
		}
		this.firstName = firstName.toLowerCase();
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		if (!validateName(lastName)) {
			System.out.println(lastName + " is not a valid name.");
			System.out.println("Please enter a valid name.");
			return;
		}
		this.lastName = lastName.toLowerCase();
	}
	
	private boolean validateName(String s) {
		return s.matches("^[a-zA-Z]+([ '-][a-zA-Z]+)*");
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		if (!emailAddress.matches("^[a-zA-Z0-9+-._]+@+[a-zA-Z0-9.-]+$")) {
			System.out.println(emailAddress + " is not a valid email.");
			return;
		}
		this.emailAddress = emailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		if (!password.matches("((?=.*[a-z])(?=.*\\d)(?=.*[@#$%!])(?=.*[A-Z]).{6,16})")) {
			System.out.println(password + " is not an valid password");
			System.out.println("password needs to have at least one lowercase letter,\n"
					  + "at least one digit, \n"
					  + "at least one special character, \n"
					  + "at least one capital letter. ");
			return;
		}
		this.password = password;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
}
