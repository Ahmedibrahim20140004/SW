package com.SWEProject.Entities;

public class Question {
	private String GameName1;
	public String getGameName1() {
		return GameName1;
	}
	public void setGameName1(String gameName1) {
		GameName1 = gameName1;
	}
	private String Question;
	private String A1;
	private String A2;
	private String A3;
	private String A4;
	private String result;
	
	
	public String getQuestion() {
		return Question;
	}
	public void setQuestion(String question) {
		Question = question;
	}
	public String getA1() {
		return A1;
	}
	public void setA1(String a1) {
		A1 = a1;
	}
	public String getA2() {
		return A2;
	}
	public void setA2(String a2) {
		A2 = a2;
	}
	public String getA3() {
		return A3;
	}
	public void setA3(String a3) {
		A3 = a3;
	}
	public String getA4() {
		return A4;
	}
	public void setA4(String a4) {
		A4 = a4;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public Question()
	{
		Question="";
		A1="";
		A2="";
		A3="";
		A4="";
		result="";
	}
	public Question(String Question, String A1,String A2,String A3,String A4, String result) {
		super();
		this.Question = Question;
		this.A1 = A1;
		this.A2 = A2;
		this.A3 = A3;
		this.A4 = A4;
		this.result = result;
		
	}

}
