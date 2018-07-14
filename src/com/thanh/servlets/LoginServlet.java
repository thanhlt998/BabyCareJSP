package com.thanh.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("name");
		String password = req.getParameter("password");
		
		if(username.equals("admin") && password.equals("admin123")) {
			req.getSession().setAttribute("user", username);
			req.getRequestDispatcher("/html/adminView.html").forward(req, resp);
		}
		else {
			String loginMessage = "Login failed, please try again!!!";
			req.setAttribute("loginMessage", loginMessage);
			req.getRequestDispatcher("/jsp/loginForm.jsp").forward(req, resp);
		}
	}
}
