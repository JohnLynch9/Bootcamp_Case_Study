package com.tekglobal.springmvc.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class User {
	@Size(min=2, max=17)
	private String name;
	@Id
	@NotBlank
	private String email;
	private String password;
	
	public User() {
		super();
	}
	public User(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String user) {
		this.name = user;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return ("|| Name: " + this.getName() + " || Email: " + this.getEmail() + " ||");
	}
}
