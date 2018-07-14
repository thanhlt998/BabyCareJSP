package com.thanh.servlets;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thanh.beans.Baby;
import com.thanh.dao.BabyDao;

@WebServlet("/addBaby")
public class AddBabyServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection connection = (Connection) getServletContext().getAttribute("DBConnection");
		String name = req.getParameter("name");
		String meaning = req.getParameter("meaning");
		String sex = req.getParameter("sex");
		String religion = req.getParameter("religion");
		
		Baby baby = new Baby(name, meaning, sex, religion);
		boolean flag = BabyDao.addBaby(baby, connection);
		String addBabyMessage = null;
		if(flag) {
			addBabyMessage = "Add a baby name successfully!!";
		}
		else {
			addBabyMessage = "There are something wrong while adding a baby name! Please try again!!!";
		}
		
		req.setAttribute("addBabyMessage", addBabyMessage);
		req.getRequestDispatcher("/jsp/addbabyname.jsp").forward(req, resp);
	}
}
