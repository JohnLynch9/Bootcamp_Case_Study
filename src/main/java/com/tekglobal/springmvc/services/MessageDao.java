package com.tekglobal.springmvc.services;

import com.tekglobal.springmvc.models.Message;

public class MessageDao extends DBConnection{
	public boolean addMessage(Message message) {
		try {
			this.connect();
			em.getTransaction().begin();
			em.persist(message);
			em.getTransaction().commit();
			this.disconnect();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
