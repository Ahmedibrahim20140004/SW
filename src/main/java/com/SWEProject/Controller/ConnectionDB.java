package com.SWEProject.Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

	public static void connection1() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("connected");
		} catch (Exception e) {
			System.out.println("cannt connect");
		}
	}

	public static Connection connect() {

		try {
			connection1();
			String url = "jdbc:mysql://localhost/swiproject";
			String username = "root";
			String password = "";
			Connection connection = DriverManager.getConnection(url, username, password);
			System.out.println("OK");
			return connection;
		} catch (SQLException ex) {
			// Logger.getLogger(JavaApplication21.class.getName()).log(Level.SEVERE,
			// null, ex);
		}
		return null;
	}
}
