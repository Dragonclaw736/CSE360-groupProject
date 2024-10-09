package application;

import java.sql.*;

class name {
String first;
char mI;
String last;
String prefered;
}


public class Users {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "org.h2.Driver";   
	static final String DB_URL = "jdbc:h2:~/firstDatabase";
	
//  Database credentials 
	static final String USER = "sa"; 
	static final String PASS = "";
	
	private Connection connection = null;
	private Statement statement = null;
	
	public void connectToDatabase() throws SQLException {
		try {
			Class.forName(JDBC_DRIVER); // Load the JDBC driver
			System.out.println("Connecting to database...");
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.createStatement(); 
			createTables();  // Create the necessary tables if they don't exist
		} catch (ClassNotFoundException e) {
			System.err.println("JDBC Driver not found: " + e.getMessage());
		}
	}
	private void createTables() throws SQLException {
		String userTable = "CREATE TABLE IF NOT EXISTS cse360users ("
				+ "id INT AUTO_INCREMENT PRIMARY KEY, "
				+ "email VARCHAR(255) UNIQUE, "
				+ "password VARCHAR(255), "
				+ "role VARCHAR(20))";
		statement.execute(userTable);
	}
	// Check if the database is empty
		public boolean isDatabaseEmpty() throws SQLException {
			String query = "SELECT COUNT(*) AS count FROM cse360users";
			ResultSet resultSet = statement.executeQuery(query);
			if (resultSet.next()) {
				return resultSet.getInt("count") == 0;
			}
			return true;
		}
	private String _email;
	private String _username;
	private String _password;
	private name _name;
	private boolean _one_pass;
	private int expire;
	private int perms;
	
	// Default Constructor
	public Users() {}
	
	
	
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
	public void userList() throws SQLException{
		String sql = "SELECT * FROM cse360users";
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
	
	// Permission Accessors and Mutators
	public void setRole(int perms) {
		this.perms = perms;
	}
	
	public int getRole() {
		return perms;
	}
}

