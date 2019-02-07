package com.axelor.serviceimp;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.axelor.pojo.User;
import com.axelor.utility.HibernateUtility;

public class LoginServiceImp  {
	Transaction tr;
	Session ss;
	int flag = 0;
	User user;
	
	HibernateUtility hu = new HibernateUtility();
	public boolean checkLogin(String email, String password) {
		ss = hu.createSession();
	user = (User) ss.createQuery("from User where email = '" + email + "'and password = '" + password + "'").uniqueResult();
		
	if(user != null) {
		flag = 1;
	}
	
	ss.close();
	hu.closeFactory();
	if (flag == 1)
		return true;
	else 
		return false;
}
public  User getUser() {
	return user;
}	

	

}
