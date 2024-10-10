package application.LoginPage;

import application.Core.Navigation;
import application.Users;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * LoginPageUI class is responsible for displaying the login page user interface.
 * It allows the user to enter a username and password and navigate to the role selection page upon successful login.
 */
public class LoginPageUI {

    /**
     * Creates the login page interface and registers it with the navigation system.
     * The method returns a new user object, but the actual database logic is not yet implemented.
     */
    public static Users RegisterWithNavigation() {
    	
    	Users user = new Users();  // Initialize a new user object

    	// Create a label for the page title
        Label titleLabel = new Label("Welcome, Please Log In");
        titleLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");  // Apply styling to the title label

        // Username input field
        TextField usernameField = new TextField();
        usernameField.setPromptText("Enter username");  // Display prompt text when the field is empty
        usernameField.setMaxWidth(200);  // Set the maximum width of the field

        // Password input field
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Enter password");  // Display prompt text when the field is empty
        passwordField.setMaxWidth(200);  // Set the maximum width of the field

        // Login button with styling and padding
        Button loginButton = new Button("Login");
        loginButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 14px;");  // Set button styling
        loginButton.setPadding(new Insets(10, 20, 10, 20));  // Set padding for the button
        loginButton.setOnAction((ActionEvent event) -> {
            // Retrieve the entered username and password
            String username = usernameField.getText();
            String password = passwordField.getText();
            
            // TODO: Add database logic for user authentication
            
            // Navigate to the role selection page after login
            Navigation.navigateTo("RoleSelection");
        });

        // Layout adjustments using VBox
        VBox layout = new VBox(15);  // VBox with 15px spacing between elements
        layout.setPadding(new Insets(20));  // Add 20px padding around the layout
        layout.setAlignment(Pos.CENTER);  // Center the elements in the layout
        layout.getChildren().addAll(titleLabel, usernameField, passwordField, loginButton);  // Add elements to the layout
    	
        // Create a scene with the layout and set its size
        Scene scene = new Scene(layout, 350, 250);
    	
        // Register the scene with the navigation system using the name "LoginPage"
    	Navigation.registerScene("LoginPage", scene);
    	
    	return user;  // Return the user object (currently not functional with database logic)
    }
}
