package com.flexon.userregistration;

import java.time.LocalDate;
import java.util.Scanner;

import com.flexon.userregistration.User.Gender;

public class AccountUI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("This is the Account sign up page.\n");
		
		System.out.println(" ******** \n");
		
		User new_user = new User();
		Scanner scan = new Scanner(System.in);
		
		inputFirstName(new_user, scan);
		inputLastName(new_user, scan);
		inputEmailAddress(new_user, scan);
		inputPassword(new_user, scan);
		inputBirthday(new_user, scan);
		inputGender(new_user, scan);
		
		
		System.out.println("******* \n "
				+ "User created successfully!");
		
	    UserDAO users = new UserDAO();
	    users.addUser(new_user);
	    users.printUserInfo(new_user);
	}
	
	private static void inputFirstName(User new_user, Scanner scan) {
		System.out.println("Please enter your first name:");
		while (true) {
			String s = scan.next();
			new_user.setFirstName(s);
			if (s.toLowerCase().equals(new_user.getFirstName())) {
				break;
			}
			System.out.println("Please enter a valid first name: ");
		}
		System.out.println();
	}
	
	private static void inputLastName(User new_user, Scanner scan) {
		System.out.println("Please enter your Last name:");
		while (true) {
			String s = scan.next();
			new_user.setLastName(s);
			if (s.toLowerCase().equals(new_user.getLastName())) {
				break;
			}
			System.out.println("Please enter a valid Last name: ");
		}
		System.out.println();
	}
	
	private static void inputEmailAddress(User new_user, Scanner scan) {
		System.out.println("Please enter your Email Address:");
		while (true) {
			String s = scan.next();
			new_user.setEmailAddress(s);
			if (s.equals(new_user.getEmailAddress())) {
				break;
			}
			System.out.println("Please enter a valid Email Address");
		}
		System.out.println();
	}
	
	private static void inputPassword(User new_user, Scanner scan) {
		System.out.println("Please enter your Password:");
		while (true) {
			String s = scan.next();
			new_user.setPassword(s);
			if (s.equals(new_user.getPassword())) {
				break;
			}
			System.out.println("Please enter a valid Password");
		}
		System.out.println();
	}
	
	private static void inputBirthday(User new_user, Scanner scan) {
		int year = 0, month = 0, day = 0;
		System.out.println("Please enter your birth year: ");
		year = scan.nextInt();
		while (year < 1900 || year > 2020) {
			System.out.println("please enter a valid year:");
			year = scan.nextInt();
		}
		System.out.println("Please enter your birth month: ");
		month = scan.nextInt();
		while (month < 1 || month > 12) {
			System.out.println("please enter a valid month:");
			month = scan.nextInt();
		}
		System.out.println("Please enter your birth day: ");
		day = scan.nextInt();
		while (day < 1 || day > 31) {
			System.out.println("please enter a valid date:");
			day = scan.nextInt();
		}
		
		LocalDate birthday = LocalDate.of(year, month, day);
		new_user.setBirthday(birthday);
	}
	
	private static void inputGender(User new_user, Scanner scan) {
		System.out.println("Please choose a gender: ");
		System.out.println("1 - Male, 2 - Female, 3 - Others / Choose not to say \n");
		
		int gender = scan.nextInt();
		while (gender != 1 && gender != 2 && gender != 3) {
			System.out.println("Please choose a valid number");
			System.out.println("1 - Male, 2 - Female, 3 - Others / Choose not to say");
			gender = scan.nextInt();
		}
		if (gender == 1) {
			new_user.setGender(Gender.Male);
		}
		if (gender == 2) {
			new_user.setGender(Gender.Female);
		}
		if (gender == 3) {
			new_user.setGender(Gender.Other);
		}
	}

}
