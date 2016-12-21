package SWP;

import java.util.ArrayList;
import java.util.Scanner;

public class Teacher {
	String test="";
	String name;
	String  username;
	String email;
	String phNum;
	String gender;
	int age;
	String password;
	String  code;
	ArrayList <String> valid=new ArrayList <> ();
	Teacher(){
		
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
		System.out.println("Enter the code ");
		code=s.nextLine();
		test=validation(code);
		while(test.equals("failed"))
		{
			System.out.println("validation failed please try again ");
			System.out.println("Enter the code ");
			code=s.nextLine();
			test=validation(code);
			
		}
		System.out.println("Enter the age  ");
		age=s.nextInt();
		
		
	}
	String validation (String c)
	{
		String s="";
		valid.add("1234");
		valid.add("5678");
		valid.add("9123");
		for( int i=0;i<valid.size();i++)
		{
			if(valid.get(i).equals(c))
			{
				System.out.println("validate code success ");
				s="success";
				break;
			}
			else 
			{
				
				s="failed";
			}
		}
		//System.out.println("validate code failed ");
		return s;
			
		
	}

}