package application.AccountCreation;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *  AccountCreationUI class represents the user interface for account creation. 
 * It prompts the user for a username and password to proceed to the final registration step
 */
public class AccountCreationUI {

    /**
     * Displays the account creation page where the user enters a username and password.
     */
    public static void show(Stage primaryStage) {
        // Labels for the username and password fields
        Label usernameLabel = new Label("Username:");
        Label passwordLabel = new Label("Password:");

        // Text field for entering the username
        TextField usernameField = new TextField();
        usernameField.setPromptText("Enter username"); // Display prompt text for username input

        // Password field for entering the password
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Enter password"); // Display prompt text for password input

        // Button to proceed to the next step
        Button nextButton = new Button("Next");
        nextButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;"); // Set button style
        nextButton.setOnAction(event -> {
            // Retrieve entered username and password
            String username = usernameField.getText();
            String password = passwordField.getText();
            
            // Proceed to final registration if both fields are filled
            if (!username.isEmpty() && !password.isEmpty()) {
                FinalRegistrationUI.show(primaryStage, username, password);
            }
        });

        // Set up a GridPane layout for the form
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);                                 // Center the grid in the scene
        grid.setVgap(10);                                        // Set vertical gap between elements
        grid.setHgap(10);                                        // Set horizontal gap between elements
        grid.setPadding(new Insets(20));            // Set padding around the grid

        // Add components to the grid layout
        grid.add(usernameLabel, 0, 0);            // Username label at row 0, column 0
        grid.add(usernameField, 1, 0);            // Username input field at row 0, column 1
        grid.add(passwordLabel, 0, 1);            // Password label at row 1, column 0
        grid.add(passwordField, 1, 1);            // Password input field at row 1, column 1
        grid.add(nextButton, 1, 2);               // Next button at row 2, column 1

        // Create a new scene with the grid layout and set it on the primary stage
        Scene scene = new Scene(grid, 400, 300);
        primaryStage.setScene(scene);             // Set the scene to the stage
        primaryStage.show();                      // Display the stage
    }
    
    /**
     * Placeholder for future navigation handling during the registration process.
     * This method currently has no implementation.
     */
    public static void RegisterWithNavigation() {
        // No functionality implemented yet
    }
}

