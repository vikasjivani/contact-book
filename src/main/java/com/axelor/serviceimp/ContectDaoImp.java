package com.axelor.serviceimp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.axelor.pojo.Contect;
import com.axelor.pojo.Phone;
import com.axelor.pojo.User;
import com.axelor.service.ContectDao;
import com.axelor.utility.HibernateUtility;

public class ContectDaoImp implements ContectDao {
	SessionFactory sf;
	Session ss;
	Transaction tr;
	Query q;
	List<Contect> list;
	HibernateUtility hu = new HibernateUtility();
	
	
	public boolean addContect(String name, String no1, String no2,int id) {
		System.out.println("hello...!!!!!!");
		ss = hu.createSession();
		
		

		User usr = ss.find(User.class,id);
		System.out.println("hello...!!!!!!11");

		  Contect c = new Contect(name,usr);
	      Phone p1 = new Phone(no1,c);
	      Phone p2 = new Phone(no2,c);
	      
	      List<Phone> numbers = new ArrayList<>();
	      numbers.add(p1);
	      numbers.add(p2);
	      
	      c.setNumbers(numbers);				//add phone list into contect name
		
	      tr = ss.beginTransaction();
	      int ans1 = (int) ss.save(c);
	      int ans2 = (int) ss.save(p1);
	      int ans3 = (int) ss.save(p2);
	      tr.commit();
	      ss.close();
	    
		if(ans1 != 0 && ans2 != 0 && ans3 != 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	public List<Contect> getContectList(int id){
		ss = hu.createSession();
		list = (List<Contect>) ss.createQuery("from Contect where uid="+id+"").list();
		ss.close();
		return list;
	}

	
	public List<Contect> getContectList(String name){
		ss = hu.createSession();
		list = (List<Contect>) ss.createQuery("from Contect where name="+name+"").list();
		ss.close();
		return list;
	}


	
	public void deleteContect(int id) {
		ss = hu.createSession();
		Contect c = ss.load(Contect.class,id);
		//q = ss.createQuery("delete from Phone where cid="+id+"");
		tr = ss.beginTransaction();
		//q.executeUpdate();
		ss.delete(c);
		tr.commit();
		ss.close();	
	}

	
	
	
	public Contect getSingleContect(int id) {
		ss = hu.createSession();
		Contect c = ss.get(Contect.class, id);
		return c;
	}
	
	
	

	@Override
	public void show() {
		System.out.println("working....!!");
	}


	@Override
	public void updateContect(String name, String no1, String no2, int id) {
		ss = hu.createSession();
		Contect con = ss.find(Contect.class,id);
		Phone p1 = new Phone(no1,con);
	    Phone p2 = new Phone(no2,con);
		q = ss.createQuery("delete from Phone where cid="+id+"");
		tr = ss.beginTransaction();
		q.executeUpdate();
		ss.update(con);
		ss.save(p1);
		ss.save(p2);
		tr.commit();
		
		ss.close();
	}
	
	

}
