package application;

import java.sql.*;

class name {
String first;
char mI;
String last;
String prefered;
}


public class Users {
	private String _email;
	private String _username;
	private String _password;
	private name _name;
	private boolean _one_pass;
	private int expire;
	private int perms;
	
	public String getEmail(){
		return _email;
	}
	public void setEmail(String newEmail) {
		_email = newEmail;
	}
	
	public String getUser() {
		return _username;
	}
	public void setUser(String newUser) {
		_username = newUser;
	}
	public String getPassword() {
		return _password;
	}
	public void setPassword(String newPassword) {
		_password = newPassword;
	}
	public name getName(){
		return _name;
	}
	public void setName(name newName) {
		_name = newName;
	}
	public void deleteUser() {
		
	}
	public void addRemoveRole() {
		
	}
	public void userList() {
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next()) 
		{
			
		}
		System.out.print("");
	}
	public void inviteUser() {
		
	}
	public void resetUser() {
		
	}
}

