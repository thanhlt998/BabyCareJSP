package com.thanh.listeners;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.thanh.dao.DBConnection;

public class ApplicationListener implements ServletContextListener{
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		Connection connection = DBConnection.getConnectionToDatabase();
		sce.getServletContext().setAttribute("DBConnection", connection);
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		Connection connection = (Connection) sce.getServletContext().getAttribute("DBConnection");
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
