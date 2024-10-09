package application.AccountCreation;

import application.Core.Navigation;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class AccountCreationUI extends GridPane {

    private TextField usernameField;

    public AccountCreationUI() {
        // Create Labels
        Label emailLabel = new Label("Email:");
        Label usernameLabel = new Label("Username:");
        Label passwordLabel = new Label("Password:");
        Label phoneLabel = new Label("Phone Number:");
        Label roleLabel = new Label("Role:");

        // Create Input Fields
        TextField emailField = new TextField();
        emailField.setPromptText("Enter your email");

        usernameField = new TextField();
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
        setAlignment(Pos.CENTER);
        setVgap(10);
        setHgap(10);
        setPadding(new Insets(20));

        // Add components to the grid
        add(emailLabel, 0, 0);
        add(emailField, 1, 0);
        add(usernameLabel, 0, 1);
        add(usernameField, 1, 1);
        add(passwordLabel, 0, 2);
        add(passwordField, 1, 2);
        add(phoneLabel, 0, 3);
        add(phoneField, 1, 3);
        add(roleLabel, 0, 4);
        add(roleComboBox, 1, 4);
        add(submitButton, 1, 5);
    }

    public void setUsername(String username) {
        if (usernameField != null) {
            usernameField.setText(username);
        }
    }

    public static void RegisterWithNavigation() {
        AccountCreationUI ui = new AccountCreationUI();
        Scene scene = new Scene(ui, 400, 350);
        Navigation.registerScene("AccountCreationUI", scene);
    }
}
