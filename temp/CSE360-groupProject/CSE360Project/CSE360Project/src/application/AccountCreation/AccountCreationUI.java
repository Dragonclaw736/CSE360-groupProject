package application.AccountCreation;

import application.Core.Navigation;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AccountCreationUI {

    public static void RegisterWithNavigation() {
        // Create Labels
        Label emailLabel = new Label("Email:");
        Label usernameLabel = new Label("Username:");
        Label passwordLabel = new Label("Password:");
        Label phoneLabel = new Label("Phone Number:");
        Label roleLabel = new Label("Role:");

        // Create Input Fields
        TextField emailField = new TextField();
        emailField.setPromptText("Enter your email");

        TextField usernameField = new TextField();
        usernameField.setPromptText("Choose a username");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Choose a password");

        TextField phoneField = new TextField();
        phoneField.setPromptText("Enter your phone number");

        // Create Role Dropdown
        ComboBox<String> roleComboBox = new ComboBox<>();
        roleComboBox.getItems().addAll("User", "Admin", "Other");
        roleComboBox.setValue("User"); // Default value

        // Create Submit Button
        Button submitButton = new Button("Create Account");
        submitButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");
        submitButton.setOnAction(event -> {
            // Collect input data
            String email = emailField.getText();
            String username = usernameField.getText();
            String password = passwordField.getText();
            String phone = phoneField.getText();
            String role = roleComboBox.getValue();

            // TODO: Add validation and account creation logic
            System.out.println("Account created for: " + username + " with role: " + role);
        });

        // Layout using GridPane
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setPadding(new Insets(20));

        // Add components to the grid
        grid.add(emailLabel, 0, 0);
        grid.add(emailField, 1, 0);

        grid.add(usernameLabel, 0, 1);
        grid.add(usernameField, 1, 1);

        grid.add(passwordLabel, 0, 2);
        grid.add(passwordField, 1, 2);

        grid.add(phoneLabel, 0, 3);
        grid.add(phoneField, 1, 3);

        grid.add(roleLabel, 0, 4);
        grid.add(roleComboBox, 1, 4);

        grid.add(submitButton, 1, 5);

        // Scene setup
        Scene scene = new Scene(grid, 400, 350);

        Navigation.registerScene("AccountCreationPage", scene);
    }
}