package com.axelor.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.axelor.pojo.User;
import com.axelor.serviceimp.LoginServiceImp;
import com.google.inject.Singleton;

@Singleton
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public Login() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoginServiceImp login = new LoginServiceImp();
		try (PrintWriter out = response.getWriter()) {

			boolean result = login.checkLogin(request.getParameter("email"), request.getParameter("password"));
				
			if (result) {
				User user = login.getUser();
				HttpSession session = request.getSession();
		        session.setAttribute("user", user);
				
                response.sendRedirect("contect.jsp");
			} else {
				response.sendRedirect("index.html");
			}
	
		}

	}
}
