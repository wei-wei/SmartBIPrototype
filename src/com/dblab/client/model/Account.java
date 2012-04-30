package com.dblab.client.model;

public class Account {
	private String userName;
	private String password;
	
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
	
	public boolean isEqual(Account account) {
		String userName = account.getUserName();
		String password = account.getPassword();
		
		if (userName.equals(this.userName) && password.equals(this.password))
			return true;
		
		return false;
	}
}
