package com.cetpa.admin.entities;

import javax.persistence.*;

@Entity
public class Account 
{
	@Id
	@Column(length = 50)
	private String userid;
	private String password;
	private String name;
	@Column(length = 20,unique = true)
	private String phone;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
