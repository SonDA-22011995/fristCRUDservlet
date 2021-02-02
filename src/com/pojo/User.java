package com.pojo;

public class User {
	
	private String email;
	private String FristName;
	private String LastName;
	
	public User(String email, String fristName, String lastName) {
		this.email = email;
		FristName = fristName;
		LastName = lastName;
	}
	public User() {
		this.email = "";
		FristName = "";
		LastName = "";
	}
	
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFristName() {
		return FristName;
	}
	public void setFristName(String fristName) {
		FristName = fristName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	
	
}
