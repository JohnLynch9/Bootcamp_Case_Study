package com.Tek_Systems.case_study_final.Models;


import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;


@Entity
public class Art {
	@Id
	private String artname;
	@Column(nullable=false)
	private String artistname;
	@Column(nullable=false)
	private String imageaddress;
	@ManyToOne
	@JoinColumn(name="useremail")
	private User user;
	
	public Art() {
		super();
	}
	public Art(String artname, String artistname, String imageaddress) {
		super();
		this.artname = artname;
		this.artistname = artistname;
		this.imageaddress = imageaddress;
	}
	public String getArtname() {
		return artname;
	}
	public void setArtname(String artname) {
		this.artname = artname;
	}
	public String getArtistname() {
		return artistname;
	}
	public void setArtistname(String artistname) {
		this.artistname = artistname;
	}
	public String getImageaddress() {
		return imageaddress;
	}
	public void setImageaddress(String imageaddress) {
		this.imageaddress = imageaddress;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
