package SWP;

import java.util.Scanner;

public class Question {
	String q,c1,c2,c3,c4,r;
	Question(){}
	
	
	Question Choose()
	{
		Question g=new Question();
		Scanner s=new Scanner (System.in);
		System.out.println("ENTER THE Question :");
		g.q=s.nextLine();
		System.out.println("ENTER THE 4 choice seprated by enter:");
		g.c1=s.nextLine();
		g.c2=s.nextLine();
		g.c3=s.nextLine();
		g.c4=s.nextLine();
		System.out.println("ENTER THE Answer :");
		g.r=s.nextLine();
		return g;
		
	}
	Question TF()
	{
		Question g=new Question();
		Scanner s=new Scanner (System.in);
		System.out.println("ENTER THE Question :");
		g.q=s.nextLine();
		System.out.println("ENTER THE Answer :");
		g.r=s.nextLine();
		
		return g;
		
	}
	
	

}
