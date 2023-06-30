package edu.kh.jsp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dinnerOrder")
public class DinnerOrderServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String dinner = req.getParameter("dinner");
		String bob = req.getParameter("bob");
		int count = Integer.parseInt(req.getParameter("count"));
		
		int temp = 0;
		
		if(bob.equals("bobch")) {
			temp=1000;
		}
		
		int result = (18000+temp)*count;
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/dinnerOrder.jsp");
		req.setAttribute("res", result);
		dispatcher.forward(req, resp);
		
	}


}
