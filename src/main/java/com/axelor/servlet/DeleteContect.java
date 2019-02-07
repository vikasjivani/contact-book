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
public class DeleteContect extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ContectService cs=null;
	@Inject
	public DeleteContect(ContectService cs) {
		super();
		this.cs =cs;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//ContectService cs = new ContectServiceImp();
		String ans = request.getParameter("id");
		int id = Integer.parseInt(ans);
		cs.deleteContect(id);
		RequestDispatcher rd = request.getRequestDispatcher("contectlist.jsp");
		request.setAttribute("", "");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
