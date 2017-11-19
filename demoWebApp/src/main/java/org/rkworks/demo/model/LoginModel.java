package org.rkworks.demo.model;

public class LoginModel {
	
	public LoginModel(String userName,String password,String message){
		this.userName=userName;
		this.password=password;
		this.message=message ;		
	}
	
	private String userName;
	private String password;
	private String message;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
