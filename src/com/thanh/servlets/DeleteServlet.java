package com.thanh.servlets;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thanh.dao.BabyDao;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection connection = (Connection) getServletContext().getAttribute("DBConnection");
		
		String[] idList = req.getParameterValues("idList");
		
		boolean flag = BabyDao.deleteBabyByIdList(idList, connection);
		String deleteBabyByIdListMessage = null;
		if(flag) {
			deleteBabyByIdListMessage = "Delete babies successfully!!!";
		}
		else {
			deleteBabyByIdListMessage = "There are something wrong when deleting babies. Please try again!!";
		}
		
		req.setAttribute("deleteBabyByIdListMessage", deleteBabyByIdListMessage);
		resp.sendRedirect("deleteBaby");
	}
}
