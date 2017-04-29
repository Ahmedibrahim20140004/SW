package com.SWEProject.Entities;

import java.util.ArrayList;

public class Course {

	private String CourseName;
	private int CourseID;
	private int CourseDuration;
	private String CourseDescription;
	public ArrayList<Game> Games = new ArrayList<Game>();
	public Course()
	{
		CourseName="";
		CourseID=0;
		CourseDuration=0;
		CourseDescription="";
	}
	
	public Course(String CourseName, int CourseID, int CourseDuration , String CourseDescription) {
		super();
		this.CourseName = CourseName;
		this.CourseID = CourseID;
		this.CourseDuration = CourseDuration;
		this.CourseDescription = CourseDescription;
		
	}
	public String getCourseName() {
		return CourseName;
	}
	public void setCourseName(String CourseName) {
		this.CourseName = CourseName;
	}
	public int getCourseID() {
		return CourseID;
	}
	public void setCourseID(int CourseID) {
		this.CourseID = CourseID;
	}
	
	public int getCourseDuration() {
		return this.CourseDuration;
	}
	public void setCourseDuration(int CourseDuration) {
		this.CourseDuration = CourseDuration;
	}
	
	public String getCourseDescription() {
		return this.CourseDescription;
	}
	public void setCourseDescription(String CourseDescription) {
		this.CourseDescription = CourseDescription;
	}
	

}
