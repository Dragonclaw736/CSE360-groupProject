package application;

import java.sql.*;

/**
 * The name class stores personal name details, including first name, middle initial, last name, and preferred name.
 */
class name {
    String first;  // First name
    char mI;       // Middle initial
    String last;   // Last name
    String prefered; // Preferred name
}

/**
 *  Users class handles database interactions, user management, and role management for the application.
 * It connects to an H2 database, manages user records, and allows for operations such as user creation, 
 * role assignment, and resetting user details.
 */
public class Users {
    
    // JDBC driver and database URL for H2
    static final String JDBC_DRIVER = "org.h2.Driver";   
    static final String DB_URL = "jdbc:h2:~/firstDatabase";
    
    // Database credentials (default H2 setup)
    static final String USER = "sa"; 
    static final String PASS = "";
    
    // Connection and statement objects for interacting with the database
    private Connection connection = null;
    private Statement statement = null;
    
    /**
     * Connects to the database and creates the necessary tables if they don't exist.
     */
    public void connectToDatabase() throws SQLException {
        try {
            // Load the JDBC driver
            Class.forName(JDBC_DRIVER); 
            System.out.println("Connecting to database...");
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            statement = connection.createStatement();
            createTables();  // Create tables if they don't already exist
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC Driver not found: " + e.getMessage());
        }
    }
    
    /**
     * Creates the cse360users table if it does not already exist.
     * This table stores user email, password, and role information.
     */
    private void createTables() throws SQLException {
        String userTable = "CREATE TABLE IF NOT EXISTS cse360users ("
                         + "id INT AUTO_INCREMENT PRIMARY KEY, "
                         + "email VARCHAR(255) UNIQUE, "
                         + "password VARCHAR(255), "
                         + "role VARCHAR(20))";
        statement.execute(userTable);
    }

    /**
     * Checks if the database is empty by counting the number of users.
     */
    public boolean isDatabaseEmpty() throws SQLException {
        String query = "SELECT COUNT(*) AS count FROM cse360users";
        ResultSet resultSet = statement.executeQuery(query);
        if (resultSet.next()) {
            return resultSet.getInt("count") == 0;
        }
        return true;
    }

    // User fields
    private String _email;     // User email
    private String _username;  // Username
    private String _password;  // User password
    private name _name;        // User name (first, middle, last, preferred)
    private boolean _one_pass; // Flag indicating if the password is a one-time password
    private int expire;        // Expiration time for one-time passwords
    private int perms;         // User permissions (role)
    
    // Default constructor
    public Users() {}

    // Email accessor and mutator
    public String getEmail() {
        return _email;
    }
    public void setEmail(String newEmail) {
        _email = newEmail;
    }

    // Username accessor and mutator
    public String getUser() {
        return _username;
    }
    public void setUser(String newUser) {
        _username = newUser;
    }

    // Password accessor and mutator
    public String getPassword() {
        return _password;
    }
    public void setPassword(String newPassword) {
        _password = newPassword;
    }

    // Name accessor and mutator
    public name getName() {
        return _name;
    }
    public void setName(name newName) {
        _name = newName;
    }

    /**
     * Placeholder method for deleting a user (not yet implemented).
     */
    public void deleteUser() {
        // TODO: Implement user deletion
    }

    /**
     * Placeholder method for adding or removing a user role (not yet implemented).
     */
    public void addRemoveRole() {
        // TODO: Implement role management
    }

    /**
     * Displays the list of users from the cse360users table.
     
     */
    public void userList() throws SQLException {
        String sql = "SELECT * FROM cse360users";
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        
        while(rs.next()) {
            // TODO: Process and display user data from the ResultSet
        }
        System.out.print("");
    }

    /**
     * Placeholder method for inviting a user (not yet implemented).
     */
    public void inviteUser() {
        // TODO: Implement user invitation
    }

    /**
     * Placeholder method for resetting a user account (not yet implemented).
     */
    public void resetUser() {
        // TODO: Implement user reset
    }

    /**
     * Sets the user's role (permissions).
     */
    public void setRole(int perms) {
        this.perms = perms;
    }

    /**
     * Retrieves the user's role (permissions).
     */
    public int getRole() {
        return perms;
    }
}


