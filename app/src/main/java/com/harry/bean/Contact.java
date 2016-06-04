package com.harry.bean;

import java.io.Serializable;

public class Contact implements Serializable{

	private String name;
	private String phonenumber;
	private int image;
	public Contact(String name, String phonenumber, int image) {
		super();
		this.name = name;
		this.phonenumber = phonenumber;
		this.image = image;
	}
	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public int getImage() {
		return image;
	}
	public void setImage(int image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "Contact [name=" + name + ", phonenumber=" + phonenumber
				+ ", image=" + image + "]";
	}
	
}