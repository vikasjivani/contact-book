package com.axelor.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.axelor.service.ContectService;
import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ContectService cs=null;
	@Inject
    public Update(ContectService cs) {
        super();
        this.cs = cs;     
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String no1 = request.getParameter("1");
		String no2 = request.getParameter("2");
		int  id = Integer.parseInt(request.getParameter("id"));
		
		cs.updateContect(name,no1,no2,id);
		
		response.sendRedirect("contectlist.jsp");

		
		doGet(request, response);
	}

}
