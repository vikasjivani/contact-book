package com.axelor.serviceimp;

import java.util.List;

import com.axelor.pojo.Contect;
import com.axelor.service.ContectDao;
import com.axelor.service.ContectService;
import com.google.inject.Inject;

public class ContectServiceImp implements ContectService {

	
	ContectDao contectDao = null;
	
	@Inject
	ContectServiceImp(ContectDao contectDao) {
		this.contectDao = contectDao;
	}
	
	
	public ContectServiceImp() {
		super();
	}


	@Override
	public boolean addContect(String name, String no1, String no2, int id) {
		System.out.println("working.....");
		boolean ans = contectDao.addContect(name, no1, no2, id);

		return ans;
	}

	public List<Contect> getContectList() {
		List<Contect> list = ((ContectServiceImp) contectDao).getContectList();
		return list;
	}

	@Override
	public void deleteContect(int id) {
		contectDao.deleteContect(id);
		
		
	}
	
	public Contect getSingleContect(int id) {
		return contectDao.getSingleContect(id);
	}
	
	
	public void show() {
		contectDao.show();
	}


	@Override
	public void updateContect(String name, String no1, String no2, int id) {
		
		contectDao.updateContect(name,no1,no2,id);
	}

	
}
