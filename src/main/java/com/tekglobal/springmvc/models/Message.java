package com.tekglobal.springmvc.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.GenerationType;

@Entity
public class Message {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int messageId;
	private String name;
	private String message;
	
	public Message() {
		super();
	}
	public Message(int messageId, String name, String message) {
		super();
		this.messageId = messageId;
		this.name = name;
		this.message = message;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
