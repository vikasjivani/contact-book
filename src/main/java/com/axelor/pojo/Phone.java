package com.axelor.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "phone")
public class Phone {
	
	@Id
	@GeneratedValue
	@Column(name = "pid")
	private int pid;
	
	@Column(name="number")
	private String number;
	
	@JoinColumn(name = "cid")
	@ManyToOne
	private Contect contect;

	public Phone() {
		super();
	}

	public Phone( String number, Contect contect) {
		super();
		
		this.number = number;
		this.contect = contect;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Contect getContect() {
		return contect;
	}

	public void setContect(Contect contect) {
		this.contect = contect;
	}
	
	
}
