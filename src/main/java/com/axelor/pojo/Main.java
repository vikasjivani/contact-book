package com.axelor.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
		public static void main(String args[]) {
	
			
			Configuration con;
			SessionFactory sf;
			Session ss;
			Transaction tr;
			Query query;
			
			con = new Configuration().configure("com/axelor/xml/hibernate.cfg.xml");
	
			sf = con.buildSessionFactory();
			ss = sf.openSession();
		      
		      
		      
		      Contect c = ss.find(Contect.class,48);
		      Phone p1 = new Phone();
		      p1.setNumber("2344");
		      Phone p2 = new Phone();
		      p2.setNumber("23212");
		      List<Phone> numbers = new ArrayList<>();
		      numbers.add(p1);
		      numbers.add(p2);
		      
		    c.setNumbers(numbers);
		      
		      tr = ss.beginTransaction();
		      ss.update(c);
		     
		      tr.commit();
		      ss.close();
		      sf.close();
	
	}

}
