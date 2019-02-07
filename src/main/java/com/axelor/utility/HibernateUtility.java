package com.axelor.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateUtility {
	private Configuration con=null;
	private SessionFactory sf=null;
	private Session ss=null;
	private Transaction tr=null;
	
	
	
	public SessionFactory createFactory() {
		Configuration con = new Configuration().configure("com/axelor/xml/hibernate.cfg.xml");
		sf = con.buildSessionFactory();
		return sf;
			
	}
	
	public Session createSession() {
		if(sf != null) {
			return ss = sf.openSession();
		}
		else {
			return ss = createFactory().openSession();
		}
	}
	
	public Transaction getTranjection() {
		if(ss != null) {
			return tr = ss.beginTransaction();
		}
		else {
			return tr = createSession().beginTransaction();
		}
	}
	
	public void commitTransaction() {
		if(tr != null) {
			tr.commit();
		}
	}
	
	public void closeSession() {
		if(ss != null) {
			ss.close();
		}
	}
	
	public void closeFactory() {
		if(sf != null) {
			sf.close();	
		}
		
	}
}
