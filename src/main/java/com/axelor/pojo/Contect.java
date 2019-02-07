package com.axelor.pojo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "contect")
public class Contect {
	
	@Id
	@GeneratedValue
	@Column(name="cid")	
	private int cid;
	
	@Column(name="name")
	private String name;
	
	@JoinColumn(name = "uid")
	@ManyToOne
	private User user;
	
	@OneToMany(fetch = FetchType.EAGER,mappedBy = "contect", cascade = CascadeType.ALL,  orphanRemoval = true)
	private List<Phone> numbers;
	
	public Contect() {
		super();
	}
	public Contect( String name, User user) {
		super();
		this.name = name;
		this.user = user;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Phone> getNumbers() {
		return numbers;
	}
	public void setNumbers(List<Phone> numbers) {
		this.numbers = numbers;
	}
	
	
}
