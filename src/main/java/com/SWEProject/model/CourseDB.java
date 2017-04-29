package com.SWEProject.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.SWEProject.Controller.ConnectionDB;
import com.SWEProject.Entities.Course;



public class CourseDB {
	
	private Connection connect2;
	public java.sql.Statement st2;
	public CourseDB()
	{
		try {
			ConnectionDB connectiondb = new ConnectionDB();
			connect2 = (Connection) connectiondb.connect();
			st2 =  connect2.createStatement();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

	}

	public List ShowCoursesDB() {
		List<Course> Courses = new  ArrayList<Course>();
		
		int i=0;
		try {
			String g = "SELECT * FROM Course ";
			ResultSet result =  st2.executeQuery(g);
			while(result.next())
			{
				Course o= new Course ();
				o.setCourseID(result.getInt("CourseID"));
				o.setCourseName(result.getString("CourseName"));
				o.setCourseDuration(result.getInt("CourseDuration"));
				o.setCourseDescription(result.getString("CourseDescription"));
				
				Courses.add(o);
				i++;
			}
			} catch (SQLException e) {
				// TODO Auto-generated catch block	
			}
		List courses = (List) Courses;
		return courses;
	}

	public boolean CreateCourseDB(Course Course) {

		try {
//			for(int i=0 ; i<Course.Games.size();i++)
//			{
//				for(int j=0 ; j<Course.Games.get(i).Questions.size() ; j++)
//				{
//					PreparedStatement ps = (PreparedStatement) connect2.prepareStatement("INSERT INTO Question(question,A1,A2,A3,A4,result,GameID) VALUES (?,?,?,?,?,?,?)");
//					ps.setString(1, Course.Games.get(i).Questions.get(j).Question);
//					ps.setString(2, Course.Games.get(i).Questions.get(j).A1);
//					ps.setString(3, Course.Games.get(i).Questions.get(j).A2);
//					ps.setString(4, Course.Games.get(i).Questions.get(j).A3);
//					ps.setString(5, Course.Games.get(i).Questions.get(j).A4);
//					ps.setString(6, Course.Games.get(i).Questions.get(j).result);
//					ps.setInt(7, Course.Games.get(i).getGameID());
//					int q = ps.executeUpdate();
//					
//				}
//				PreparedStatement ps2 = (PreparedStatement) connect2.prepareStatement("INSERT INTO Game(GameID,,GameName,GameType,CourseID) VALUES (?,?,?,?)");
//				ps2.setInt(1, Course.Games.get(i).getGameID());
//				ps2.setString(2, Course.Games.get(i).getGameName());
//				ps2.setString(3, Course.Games.get(i).getGameType());
//				ps2.setInt(4, Course.getCourseID());
//				int g = ps2.executeUpdate();
//			}
			
			PreparedStatement ps3 = (PreparedStatement) connect2.prepareStatement("INSERT INTO Course(CourseID,CourseName, CourseDuration,CourseDescription) VALUES (?,?,?,?)");
			ps3.setInt(1, Course.getCourseID());
			ps3.setString(2, Course.getCourseName());
			ps3.setInt(3, Course.getCourseDuration());
			ps3.setString(4, Course.getCourseDescription());
			int c = ps3.executeUpdate();
				//return true;
			} catch (SQLException e) {
				return false;
				}

			return true;
	}
}



