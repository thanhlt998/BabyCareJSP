package com.thanh.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thanh.beans.Baby;
import com.thanh.dao.BabyDao;

@WebServlet("/viewBabyByReligion")
public class ViewBabyByReligionServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection connection = (Connection) getServletContext().getAttribute("DBConnection");
		String religion = req.getParameter("religion");
		ArrayList<Baby> babies = BabyDao.getBabiesByReligion(religion, connection);
		req.setAttribute("babies", babies);
		req.getRequestDispatcher("/jsp/ViewBabyNames.jsp").forward(req, resp);
	}
}
