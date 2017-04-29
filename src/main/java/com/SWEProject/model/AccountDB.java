package com.SWEProject.model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.SWEProject.Controller.ConnectionDB;
import com.SWEProject.Entities.Account;

public class AccountDB {
	private Connection connect;
	public java.sql.Statement st;

	public AccountDB()

	{
		try {
			ConnectionDB connectiondb = new ConnectionDB();
			connect = (Connection) connectiondb.connect();
			st =  connect.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String LoginTeacherDB(String email, String password) {
		try {

			String g = "SELECT * FROM teacher ";
			// System.out.println(g);
			ResultSet result =  st.executeQuery(g);
			while (result.next()) {
				// System.out.println("-->"+result.getString("Email")+" "+
				// result.getString("password"));
				if (result.getString("email").equals(email)
						&& result.getString("password").equals(password)) {
//					String str = result.getString("type");
//					return str;
					return "true";
				}

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return "expetion";
		}
		return "false";
	}

	public String LoginStudentDB(String email, String password) {
		try {

			String g = "SELECT * FROM student ";
			// System.out.println(g);
			ResultSet result =  st.executeQuery(g);
			while (result.next()) {
				// System.out.println("-->"+result.getString("Email")+" "+
				// result.getString("password"));
				if (result.getString("email").equals(email)
						&& result.getString("password").equals(password)) {
					String str = result.getString("type");
					return str;
				}

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return "false";
		}
		return "false";
	}
	public boolean CreateTeacherAccountDB(Account account) {

		try {
			System.out.println("hhhhh");
			PreparedStatement ps = (PreparedStatement) connect.prepareStatement("INSERT INTO teacher(name, password,email) VALUES (?,?,?)");
			
			ps.setString(1, account.getname());
			ps.setString(2, account.getpassword());
			ps.setString(3, account.getEmail());
			
			int j = ps.executeUpdate();
			//return true;
		} catch (SQLException e) {
			return false;
		}

		return true;
	}

	public boolean CreateStudentAccountDB(Account account) {

		try {
			PreparedStatement ps = (PreparedStatement) connect.prepareStatement("INSERT INTO student(name, password,email) VALUES (,?,?,?)");
			
			ps.setString(1, account.getname());
			ps.setString(2, account.getpassword());
			ps.setString(3, account.getEmail());
			
			
			//return true;
		} catch (SQLException e) {
			return false;
		}

		return true;
	}
	
}
