package com.axelor.service;

import com.axelor.pojo.Contect;

public interface ContectDao {
	boolean addContect(String name, String no1, String no2, int id);

	void deleteContect(int id);

	void show();

	Contect getSingleContect(int id);

	void updateContect(String name, String no1, String no2, int id);

	
}
