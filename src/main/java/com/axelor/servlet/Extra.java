package com.axelor.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.axelor.service.ContectService;
import com.google.inject.Inject;
import com.google.inject.Singleton;


@Singleton
public class Extra extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	ContectService a=null;
	@Inject
    public Extra(ContectService a) {
        super();
   this.a = a;     
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
	
		
		a.show();

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
