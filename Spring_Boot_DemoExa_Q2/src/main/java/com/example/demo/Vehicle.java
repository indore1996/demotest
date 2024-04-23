package com.example.demo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
public class Vehicle {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String vfirstname;
	private String vlastname;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JsonIgnore
	private User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVfirstname() {
		return vfirstname;
	}

	public void setVfirstname(String vfirstname) {
		this.vfirstname = vfirstname;
	}

	public String getVlastname() {
		return vlastname;
	}

	public void setVlastname(String vlastname) {
		this.vlastname = vlastname;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Vehicle(String vfirstname, String vlastname, User user) {
		super();
		this.vfirstname = vfirstname;
		this.vlastname = vlastname;
		this.user = user;
	}

	public Vehicle() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
