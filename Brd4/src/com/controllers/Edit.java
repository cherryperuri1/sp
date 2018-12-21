package com.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.DbInsert;
@WebServlet("/Edit")
public class Edit extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/view/EditRecord.jsp");
		String customerCode=request.getParameter("id");
        dispatcher.forward(request, response); 
		PrintWriter out=response.getWriter();

	}

}
