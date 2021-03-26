package com.tekglobal.springmvc.services;


import com.tekglobal.springmvc.models.User;

public class UserDao extends DBConnection{
	
	public boolean addUser(User user) {
		try {
			this.connect();
			em.getTransaction().begin();
			em.persist(user);
			em.getTransaction().commit();
			this.disconnect();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public User getUser(String email) {
		try {
			this.connect();
			User thisUser = em.find(User.class, email);
			this.disconnect();
			return thisUser;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	public boolean validate(User user) {
		boolean thisYou = false;
		try {
			this.connect();
			User thisUser = em.find(User.class, user.getEmail());
			if (thisUser==null) {
				System.out.println("Could not find user. Enter valid username or password.");
			}else {
			thisYou = thisUser.getPassword().equals(user.getPassword());
			}
			this.disconnect();
			return thisYou;
		}catch (Exception e) {
			e.printStackTrace();
			return thisYou;
		}
	}
}
