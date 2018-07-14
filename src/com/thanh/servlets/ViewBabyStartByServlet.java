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

@WebServlet("/viewBabyStartBy")
public class ViewBabyStartByServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection connection = (Connection) getServletContext().getAttribute("DBConnection");
		String start = req.getParameter("start");
		ArrayList<Baby> babies = BabyDao.getBabiesStartBy(start, connection);
		req.setAttribute("babies", babies);
		req.getRequestDispatcher("/jsp/ViewBabyNames.jsp").forward(req, resp);
	}
}
