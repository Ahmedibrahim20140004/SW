package com.SWEProject.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.SWEProject.Controller.ConnectionDB;
import com.SWEProject.Entities.Course;
import com.SWEProject.Entities.Game;
import com.SWEProject.Entities.Question;

public class GameDB {
	private Connection connect3;
	public java.sql.Statement st3;

	public GameDB() {
		try {
			ConnectionDB connectiondb = new ConnectionDB();
			connect3 = (Connection) connectiondb.connect();
			st3 = connect3.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public boolean CreateQuestionDB(Question Question ,String GameName) {
		int GameID = 0;
		try {
			String s = "SELECT * FROM game" ;
			
			ResultSet result = st3.executeQuery(s);	
			
			while (result.next()) {
				if (result.getString("GameName").equals(GameName)){
					 GameID = result.getInt("GameID");
				}
			}
			
			PreparedStatement ps2 = (PreparedStatement) connect3
					.prepareStatement("INSERT INTO question (question,A1,A2,A3,A4,result,GameID) VALUES (?,?,?,?,?,?,?)");
			ps2.setString(1, Question.getQuestion());
			ps2.setString(2, Question.getA1());
			ps2.setString(3, Question.getA2());
			ps2.setString(4, Question.getA3());
			ps2.setString(5, Question.getA4());
			ps2.setString(6, Question.getResult());
			ps2.setInt(7, GameID);
			int g = ps2.executeUpdate();
		} catch (SQLException e) {
			return false;
		}
	 
		
		return true;
	}

	
	public List ShowGamesDB(String CourseName) {
		List<Game> Games = new  ArrayList<Game>();
		int i = 0;
		try {
			int courseID=0;
			String s = "SELECT * FROM course" ;
			System.out.println(s);
			ResultSet result = st3.executeQuery(s);		
			while (result.next()) {
				System.out.println(result.getString("CourseName"));

				if (result.getString("CourseName").equals(CourseName)){
					 courseID = result.getInt("CourseID");
				}
			}

			String g = "SELECT * FROM Game WHERE CourseID = " + courseID;
			ResultSet result1 = st3.executeQuery(g);
			System.out.println(g);
			
			while (result1.next()) {
				Game o=new Game();
				o.setGameID(result1.getInt("GameID"));
				o.setGameName(result1.getString("GameName"));
				o.setGameType(result1.getString("GameType"));
				Games.add(o);
				System.out.println("jjjjjj");
				
				i++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}
		List games = (List) Games;
		return games;
	}

	public boolean CreateGameDB(Game Game, String courseName) {
		int courseID = 0;
		try {
			String s = "SELECT * FROM course" ;
			System.out.println(s);
			ResultSet result = st3.executeQuery(s);		
			while (result.next()) {
				System.out.println(result.getString("CourseName"));

				if (result.getString("CourseName").equals(courseName)){
					courseID = result.getInt("CourseID");
				}
			}
			//

			// for(int i=0 ; i<Game.Questions.size() ; i++)
			// {
			// PreparedStatement ps = (PreparedStatement)
			// connect3.prepareStatement("INSERT INTO
			// Question(question,A1,A2,A3,A4,result,GameID) VALUES
			// (?,?,?,?,?,?,?)");
			// ps.setString(1, Game.Questions.get(i).Question);
			// ps.setString(2, Game.Questions.get(i).A1);
			// ps.setString(3, Game.Questions.get(i).A2);
			// ps.setString(4, Game.Questions.get(i).A3);
			// ps.setString(5, Game.Questions.get(i).A4);
			// ps.setString(6, Game.Questions.get(i).result);
			// ps.setInt(7, Game.getGameID());
			// int q = ps.executeUpdate();
			//
			// }
			PreparedStatement ps2 = (PreparedStatement) connect3
					.prepareStatement("INSERT INTO Game(GameID,GameName,GameType,CourseID) VALUES (?,?,?,?)");
			ps2.setInt(1, Game.getGameID());
			ps2.setString(2, Game.getGameName());
			ps2.setString(3, Game.getGameType());
			ps2.setInt(4, courseID);
			int g = ps2.executeUpdate();

		} catch (SQLException e) {
			System.out.println("exeption");
			return false;
		}

		return true;
	}
	public List<Question> ShowQuestions ( String GameName )
	{
		List<Question> questions = new ArrayList<Question>();
		Question Question = new Question();
		int i=0;
		try{
			int GameID=0;
			String s = "SELECT * FROM game" ;
			System.out.println(s);
			ResultSet result = st3.executeQuery(s);		
			while (result.next()) {
				System.out.println(result.getString("GameName"));

				if (result.getString("GameName").equals(GameName)){
					GameID = result.getInt("GameID");
				}
			}
System.out.println("hhhhh"+GameID);
			String g = "SELECT * FROM  question WHERE GameID = " + GameID;
			ResultSet r2 = st3.executeQuery(g);
			while(r2.next())
			{
	                	//homa dol kda sa7 wala n5aleha setter w getter !?
				Question.setQuestion(r2.getString("question"));
				Question.setA1(r2.getString("A1"));
				Question.setA2(r2.getString("A2"));
				Question.setA3(r2.getString("A3"));
				Question.setA4(r2.getString("A4"));
				Question.setResult(r2.getString("result"));
				questions.add(new Question(r2.getString("question"), r2.getString("A1"), r2.getString("A2"), r2.getString("A3"), r2.getString("A4"), r2.getString("result")));
 			}
		}
		catch(SQLException e){
			}
		return questions;	
	}

}
