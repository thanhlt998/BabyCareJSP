package com.thanh.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	public static Connection getConnectionToDatabase () {
		Connection connection = null;
		String url = "jdbc:mysql://localhost:3306/";
		String DBName = "baby_care";
		String user = "root";
		String password = "tuanthanh98";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url + DBName, user, password);
			System.out.println("Connect to the database successfully!!!");
		} catch (Exception e) {
			System.out.println("There are something wrong when connect to the database!!");
			e.printStackTrace();
		}
		return connection;
	}
}
