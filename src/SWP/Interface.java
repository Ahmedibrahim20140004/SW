package SWP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Interface {
	ArrayList<Student> slist = new ArrayList<>();
	ArrayList<Teacher> tlist = new ArrayList<>();
	Map<String, String> smap = new HashMap();
	Map<String, String> tmap = new HashMap();
	Game x = new Game();

	void Registeration(String Test) {

		// System.out.println("Register As Student Or Teacher ?");
		// Scanner p=new Scanner (System.in);
		// Test=p.nextLine();
		if (Test.equals("student")) {
			Student i = new Student();
			System.out.println("Welcome To Our Webste");
			slist.add(i);
			smap.put(i.username, i.password);

		}

		else if (Test.equals("teacher")) {
			Teacher s = new Teacher();
			System.out.println("Welcome To Our Webste");
			tlist.add(s);
			tmap.put(s.username, s.password);

		}

	}

	String Login(String Test) {
		String s="";
		Scanner sc = new Scanner(System.in);

		String user_name = "";
		String password = "";
		// System.out.println("Login As Student Or Teacher ?");
		// Scanner p=new Scanner (System.in);
		// Test=p.nextLine();
		if (Test.equals("student")) {

			System.out.println(" User_name ");
			user_name = sc.nextLine();
			System.out.println("Password");
			password = sc.nextLine();
			if (smap.containsKey(user_name)) {
				if (password.equals(smap.get(user_name))) {
					System.out.println("HI  "+user_name+" :-D");
					s=user_name ;
				} else {
					System.out.println("Password is incorrect    ....please try again ");
					s="password" ;
				}
			} else {
				System.out.println("userName is incorrect   ....please try again ");
				s="user" ;
			}

		}

		else if (Test.equals("teacher")) {
			System.out.println(" User_name ");
			user_name = sc.nextLine();
			System.out.println("Password");
			password = sc.nextLine();
			if (tmap.containsKey(user_name)) {
				if (password.equals(tmap.get(user_name))) {
					System.out.println("HI  "+user_name+"  :-D");
					s=user_name ;
					
				} else {
					System.out.println("Password is incorrect ....please try again ");
					s="password" ;
				}
			} else {
				System.out.println("userName is incorrect   ....please try again ");
				s="user" ;
			}
		}
		return s;

		
	}

	boolean Logout(boolean b) {
		b = true;
		return b;
	}

}