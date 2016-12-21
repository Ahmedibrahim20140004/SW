package SWP;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class SWProject {

	public static void main(String[] args) {
	
		ArrayList<Game> games=new ArrayList<>();
		ArrayList<StudentScore> slist=new ArrayList<>();
		Scanner sc=new Scanner (System.in);
		int c=0;
		int w=0;
		String Test = "";
		String username="";
		Interface o=new Interface();
		boolean ask=true;
		//1int i=0;
		for(int i=0;true;i++)
		//while(true)
		{
			if(i==0||ask==true)
				
			{
				System.out.println("1- Registeration ");
				System.out.println("2- Login ");
				System.out.println("Your Choice is :       (1 or 2)");
				c=sc.nextInt();
				if(c==1)
				{
					
					 System.out.println("1- For Student");
					 System.out.println("2- For Teacher");
					 System.out.println("Your Choice is :       (1 or 2)");
					 
					 w=sc.nextInt();
					 if(w==1)
					 {
						 o.Registeration("student");
						 
					 }
					 if(w==2)
					 {
						 o.Registeration("teacher");
						 
					 }
				
					
					
				}
			
				if(c==2)
				{
					
					System.out.println("1- For Student");
					 System.out.println("2- For Teacher");
					 System.out.println("Your Choice is :       (1 or 2)");
					 
					 w=sc.nextInt();
					 if(w==1)
					 {
						 username=o.Login("student");
						 while(username.equals("password")|| username.equals("user"))
						 {
							 username=o.Login("student");
							 
						 }
						 
						 
					 }
					 if(w==2)
					 {
						 username=o.Login("teacher");
						
						 while(username.equals("password")|| username.equals("user"))
						 {
							 
							 username=o.Login("teacher");
							 
						 }
						 
					 }
					
				}
				
				ask=false;
				
				continue;
				
				
				
			}
			if(i==1)
			{
				if(w==1)
				{
					Game g=new Game();
					int a;
					System.out.println(" 1 - play game");
					System.out.println(" 2 - log out");
					System.out.println(" 3 - exit");
					System.out.println("Your Choice is :       (1 or 2 or 3)");
					
					a=sc.nextInt();
					if(a==1)
					{
						g.PlayGame(games, username, slist);
					}
					if (a==2)
					{
						ask=o.Logout(ask);
						
					}
					if(a==3)
					{
						System.out.println("bye bye");
						break;
					}
					
					System.out.println("");
					
				}
				else if(w==2)
				{
					
				
					Game g=new Game();
					int a;
					System.out.println(" 1 - Creat game");
					System.out.println(" 2 - log out");
					System.out.println(" 3 - exit");
					System.out.println("Your Choice is :       (1 or 2 or 3)");
					a=sc.nextInt();
					if(a==1)
					{
						g.CreatGame(games);
					}
					if (a==2)
					{
						ask=o.Logout(ask);
						
					}
					if(a==3)
					{
						System.out.println("bye bye");
						break;
					}
					
					System.out.println("");
					
					
				}
				
				continue;
				
			}
			if(i>1)
			{
				if(w==1)
				{
					Game g=new Game();
					int a;
					System.out.println(" 1 - play game again");
					System.out.println(" 2 - log out");
					System.out.println(" 3 - exit");
					System.out.println("Your Choice is :       (1 or 2 or 3)");
					
					a=sc.nextInt();
					if(a==1)
					{
						g.PlayGame(games, username, slist);
					}
					if (a==2)
					{
						ask=o.Logout(ask);
						
					}
					if(a==3)
					{
						System.out.println("bye bye");
						break;
					}
					
					System.out.println("");
					
				}
				else if(w==2)
				{
				
					Game g=new Game();
					int a;
					System.out.println(" 1 - Creat anthor game ");
					System.out.println(" 2 - log out");
					System.out.println(" 3 - exit");
					System.out.println("Your Choice is :       (1 or 2 or 3)");
					a=sc.nextInt();
					if(a==1)
					{
						g.CreatGame(games);
					}
					if (a==2)
					{
						ask=o.Logout(ask);
						
					}
					if(a==3)
					{
						System.out.println("bye bye");
						break;
					}
					
					System.out.println("");
				
					
				}
				
				continue;
			}
			
			
			
		}

}
}
