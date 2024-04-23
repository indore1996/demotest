package com.example.demo;

import java.util.*;

import jakarta.persistence.*;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String firstname;
	private String lastname;
	
	@OneToMany(mappedBy="user", cascade=CascadeType.ALL)
	private List<Vehicle> vehicles = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	public User(String firstname, String lastname, List<Vehicle> vehicles) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.vehicles = vehicles;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
