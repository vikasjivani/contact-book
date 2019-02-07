package com.axelor.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.axelor.pojo.User;
import com.axelor.service.ContectService;
import com.axelor.serviceimp.ContectServiceImp;
import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class AddContect extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	ContectService cs=null;
	@Inject
    public AddContect(ContectService cs) {
        super();
        this.cs = cs;     
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String no1 = request.getParameter("no1");
		String no2 = request.getParameter("no2");
		
		System.out.println("working");
		
		
		HttpSession session=request.getSession();  
	    User user =   (User) session.getAttribute("user");
		
		//ContectService cs = new ContectServiceImp();
		
		
		boolean res = cs.addContect(name, no1, no2,user.getUid());
		
		if(res) {
           response.sendRedirect("contect.jsp");
		}
		else {
            response.sendRedirect("addcontect.jsp");
		}
		
		
		
		
		
		
		
		
//		
//		Configuration con;
//		SessionFactory sf;
//		Session ss;
//		Transaction tr;
//		Query query;
//		
//		con = new Configuration().configure("com/axelor/xml/hibernate.cfg.xml");
//
//		sf = con.buildSessionFactory();
//		ss = sf.openSession();
//	      
//	      User usr = ss.find(User.class,user.getUid());
//	      
//	      Contect c = new Contect(name,usr);
//	      Phone p1 = new Phone(no1,c);
//	      Phone p2 = new Phone(no2,c);
//	      List<Phone> numbers = new ArrayList<>();
//	      numbers.add(p1);
//	      numbers.add(p2);
//	      
//	    c.setNumbers(numbers);
//	      
//	      tr = ss.beginTransaction();
//	      ss.save(c);
//	      ss.save(p1);
//	      ss.save(p2);
//	      tr.commit();
//	      ss.close();
//	      sf.close();
		
	}

}
