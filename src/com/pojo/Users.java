package com.pojo;

import java.util.ArrayList;

public class Users {
	private ArrayList<User> users;

	public Users(ArrayList<User> users) {
		this.users = users;
	}
	public Users() {
		this.users = new ArrayList<>();
	}
	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}
	
}
