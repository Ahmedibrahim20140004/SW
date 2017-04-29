package com.SWEProject.Entities;

import java.util.ArrayList;

public class Game {
	private String CourseName;
	public String getCourseName() {
		return CourseName;
	}

	public void setCourseName(String courseName) {
		CourseName = courseName;
	}
	private int GameID;
	private String GameName;
	private String GameType;
	private ArrayList<Question> Questions = new ArrayList<Question>();
	
	public ArrayList<Question> getQuestions() {
		return Questions;
	}

	public void setQuestions(ArrayList<Question> questions) {
		Questions = questions;
	}

	public Game()
	{
		GameName="";
		GameID=0;
		GameType="";	
	}
	
	public Game(String GameName, int GameID, String GameType) {
		super();
		this.GameName = GameName;
		this.GameID = GameID;
		this.GameType = GameType;
		
	}
	public String getGameName() {
		return GameName;
	}
	public void setGameName(String GameName) {
		this.GameName = GameName;
	}
	public int getGameID() {
		return GameID;
	}
	public void setGameID(int GameID) {
		this.GameID = GameID;
	}
	
	public String getGameType() {
		return this.GameType;
	}
	public void setGameType(String GameType) {
		this.GameType = GameType;
	}

}
