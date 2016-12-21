package SWP;

import java.util.Scanner;

public class Student {
	String name;
	String  username;
	String email;
	String phNum;
	String gender;
	int age;
	String password;
	
	Student()
	{
		Scanner s= new Scanner (System.in);
		System.out.println("Enter the name  ");
		name=s.nextLine();
		System.out.println("Enter the user name");
		username=s.nextLine();
		System.out.println("Enter the email  ");
		email=s.nextLine();
		System.out.println("Enter the gender ");
		gender=s.nextLine();
		System.out.println("Enter the password ");
		password=s.nextLine();	
		System.out.println("Enter the phone_number  ");
		phNum=s.nextLine();
		System.out.println("Enter the age  ");
		age=s.nextInt();
		
		
	}

}