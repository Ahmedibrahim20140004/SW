package SWP;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {

	String GameName;
	String GameType;
	String GameCatogory;
	Scanner sc=new Scanner(System.in);
	// Question j=new Question();
	// Question z=new Question();
	ArrayList<Question> Questions = new ArrayList<>();

	Game() {
	}

	void PlayGame(ArrayList<Game> game, String username, ArrayList<StudentScore> slist) {
		Game g = new Game();
		Scanner s=new Scanner(System.in);
		ArrayList<Question> q = new ArrayList<>();
		int countscore = 0;
		String cat="";
		String type="";
		System.out.println("ENTER THE category OF THE GAME :    1 for sport,2 for math,3 for Chemistry");
		int a=s.nextInt();
		if(a==1)
		{
			cat = "sport";
		}
		if(a==2)
		{
			cat = "math";
		}
		if(a==3)
		{
			cat = "Chemistry";
		}
		
		System.out.println("ENTER THE type OF THE GAME :        1 for true or false,2 for choose");
		a=s.nextInt();
		if(a==1)
		{
			type = "tof";
		}
		if(a==2)
		{
			type = "choose";
		}

		System.out.println("--------------The Avaiable Games------------");
		for (int i = 0; i < game.size(); i++) {

			if (game.get(i).GameCatogory.equals(cat) && game.get(i).GameType.equals(type)) {

				System.out.println(game.get(i).GameName);

			}
		}
		System.out.println("--------------Choose your Games------------");
		Scanner r3 = new Scanner(System.in);
		String gname = r3.next();

		for (int i = 0; i < game.size(); i++) {

			if (game.get(i).GameName.equals(gname)) {
				g = game.get(i);
				q = game.get(i).Questions;
			}
		}
		System.out.println(" -------------Let the Game begin !!!--------- ");
		System.out.println("");
		for (int i = 0; i < q.size(); i++) {
			Scanner r4 = new Scanner(System.in);
			String ans = "";
			if (g.GameType.equals("choose")) {
				System.out.println(q.get(i).q);
				System.out.println("");
				System.out.println(q.get(i).c1);
				System.out.println(q.get(i).c2);
				System.out.println(q.get(i).c3);
				System.out.println(q.get(i).c4);
				System.out.println("");

				System.out.print("Your Answer : ");
		        System.out.println("");


				ans = r4.next();
			} else if (g.GameType.equals("tof")) {
				System.out.println(q.get(i).q);
		        System.out.println("");

				System.out.print("Your Answer : ");
		        System.out.println("");


				ans = r4.next();
			}

			if (q.get(i).r.equals(ans)) {
				countscore++;
				System.out.println(" Correct Answer ");
				System.out.println(" your Score Now  " + countscore);
		        System.out.println("");

			} else {
				System.out.println(" Wrong Answer ");
				System.out.println(" The Correct Answer is " + q.get(i).r);
				System.out.println(" your Score Now  " + countscore);
		        System.out.println("");
			}

		}
        System.out.println("------------------Game finish !!-----------------");

		System.out.println(" Game Over by score " + countscore);
		StudentScore Sscore = new StudentScore();
		Sscore.gameName = gname;
		Sscore.StudentUsername = username;
		Sscore.score = countscore;
		StudentScore call = new StudentScore();
        System.out.println("");
        System.out.println("");

		call.checkStudentScore(Sscore, slist);

		// return Sscore;

	}

	void CreatGame(ArrayList<Game> games)

	{
		Game g = new Game();
		Question j = new Question();
		Question z = new Question();
		Scanner s = new Scanner(System.in);
		System.out.println("ENTER THE NAME OF THE GAME :");
		g.GameName = s.nextLine();
		System.out.println("ENTER THE category OF THE GAME :    1 for sport,2 for math,3 for Chemistry");
		int a=s.nextInt();
		if(a==1)
		{
			g.GameCatogory = "sport";
		}
		if(a==2)
		{
			g.GameCatogory = "math";
		}
		if(a==3)
		{
			g.GameCatogory = "Chemistry";
		}
		
		System.out.println("ENTER THE type OF THE GAME :        1 for true or false,2 for choose");
		a=s.nextInt();
		if(a==1)
		{
			g.GameType = "tof";
		}
		if(a==2)
		{
			g.GameType = "choose";
		}
		
		System.out.println("ENTER HOW MANY Questions IN THIS GAME");
		int t=sc.nextInt();
		// games.add(this);
		if (g.GameType.equals("choose")) {
			// z=j.Choose();
			for(int i=0;i<t;i++)
			{
				g.Questions.add(j.Choose());
			}
			
			// g.Questions=Questions;
			games.add(g);
		} else if (g.GameType.equals("tof")) {
			// z=j.TF();
			for(int i=0;i<t;i++)
			{
				g.Questions.add(j.TF());
			}
			
			// g.Questions=Questions;
			games.add(g);

		}

		// for(int i=0;i<games.size()-1;i++)
		// {
		//
		// System.out.println(games.get(i).GameName+"
		// "+games.get(i).GameCatogory+" "+games.get(i).GameType);
		//
		// }
		//
		//
		// for(int d=0;d<games.size();d++)
		// {
		// for( int y=0;y<games.get(d).Questions.size();y++)
		// {
		// System.out.println(games.get(d).Questions.get(y).q+"
		// "+games.get(d).Questions.get(y).r+" ");
		//
		// }
		//
		// }
	}

}
