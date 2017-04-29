package com.SWEProject.Entities;

public class Account {

	private String name;
	private String password;
	private String type;
	private String email;

	public Account()
	{
		name="";
		password="";
		email="";
		type="";
		
	}

	public Account(String name, String password, String type, String email) {
		super();
		this.name = name;
		this.password = password;
		this.type = type;
		this.email = email;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getname() {
		return this.name;
	}

	public void setname(String name) {
		this.name = name;
	}

	public String getpassword() {
		return this.password;
	}

	public void setpassword(String password) {
		this.password = password;
	}

}
