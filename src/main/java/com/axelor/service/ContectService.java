package com.axelor.service;

import java.util.List;

import com.axelor.pojo.Contect;

public interface ContectService {
	boolean addContect(String name,String no1,String no2,int id);

	void deleteContect(int id);

	void show();

	void updateContect(String name, String no1, String no2, int id);
}
