package application.AccountCreation;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * The FinalRegistrationUI class displays the final step in the registration process.
 * It collects the user's email and full name details, completing the account creation process.
 */
public class FinalRegistrationUI {

    /**
     * Displays the final registration page for account creation.
     */
    public static void show(Stage primaryStage, String username, String password) {
        // Labels for each field in the form
        Label emailLabel = new Label("Email:");
        Label firstNameLabel = new Label("First Name:");
        Label middleNameLabel = new Label("Middle Name:");
        Label lastNameLabel = new Label("Last Name:");
        Label preferredNameLabel = new Label("Preferred Name:");

        // Text fields for user input
        TextField emailField = new TextField();
        emailField.setPromptText("Enter email");            // Display prompt for email input

        TextField firstNameField = new TextField();
        firstNameField.setPromptText("Enter first name");   // Prompt for first name input

        TextField middleNameField = new TextField();
        middleNameField.setPromptText("Enter middle name"); // Prompt for middle name input

        TextField lastNameField = new TextField();
        lastNameField.setPromptText("Enter last name");     // Prompt for last name input

        TextField preferredNameField = new TextField();
        preferredNameField.setPromptText("Enter preferred name"); // Prompt for preferred name input

        // Button to submit the form and complete registration
        Button submitButton = new Button("Submit");
        submitButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;"); // Set button style
        submitButton.setOnAction(event -> {
            // Retrieve entered values
            String email = emailField.getText();
            String firstName = firstNameField.getText();
            String middleName = middleNameField.getText();
            String lastName = lastNameField.getText();
            String preferredName = preferredNameField.getText();

            // Ensure required fields (email, first name, last name) are filled before proceeding
            if (!email.isEmpty() && !firstName.isEmpty() && !lastName.isEmpty()) {
                // Simulate account creation with a log message
                System.out.println("Account created for: " + username + ", " + firstName + " " + lastName);
            }
        });

        // Set up a GridPane layout for the form
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);            // Center the grid in the scene
        grid.setVgap(10);                         // Set vertical gap between elements
        grid.setHgap(10);                         // Set horizontal gap between elements
        grid.setPadding(new Insets(20));          // Set padding around the grid

        // Add components to the grid layout
        grid.add(emailLabel, 0, 0);               // Email label at row 0, column 0
        grid.add(emailField, 1, 0);               // Email input field at row 0, column 1
        grid.add(firstNameLabel, 0, 1);           // First name label at row 1, column 0
        grid.add(firstNameField, 1, 1);           // First name input field at row 1, column 1
        grid.add(middleNameLabel, 0, 2);          // Middle name label at row 2, column 0
        grid.add(middleNameField, 1, 2);          // Middle name input field at row 2, column 1
        grid.add(lastNameLabel, 0, 3);            // Last name label at row 3, column 0
        grid.add(lastNameField, 1, 3);            // Last name input field at row 3, column 1
        grid.add(preferredNameLabel, 0, 4);       // Preferred name label at row 4, column 0
        grid.add(preferredNameField, 1, 4);       // Preferred name input field at row 4, column 1
        grid.add(submitButton, 1, 5);             // Submit button at row 5, column 1

        // Create a new scene with the grid layout and set it on the primary stage
        Scene scene = new Scene(grid, 400, 350);
        primaryStage.setScene(scene);             // Set the scene to the stage
        primaryStage.show();                      // Display the stage
    }
}
