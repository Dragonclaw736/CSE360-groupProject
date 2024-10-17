package application.LoginPage;

import application.Core.Navigation;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class NewUserPageUI {
    public static void RegisterWithNavigation() {
        
        // Create a label for the page title
        Label titleLabel = new Label("New User");
        titleLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        // Username field
        TextField usernameField = new TextField();
        usernameField.setPromptText("Enter your username");
        usernameField.setMaxWidth(200);

        // Admin code field
        TextField adminCodeField = new TextField();
        adminCodeField.setPromptText("Enter one-time code (Optional)");
        adminCodeField.setMaxWidth(200);

        // Error message label
        Label errorMessageLabel = new Label("");
        errorMessageLabel.setTextFill(Color.RED);

        // Create account button
        Button createAccountButton = new Button("Create Account");
        createAccountButton.setStyle("-fx-background-color: #2196F3; -fx-text-fill: white; -fx-font-size: 14px; -fx-cursor: hand;");
        createAccountButton.setPadding(new Insets(10, 20, 10, 20));
        createAccountButton.setOnAction((ActionEvent event) -> {
            String username = usernameField.getText();
            String adminCode = adminCodeField.getText();
            
            // For now, accept any code if provided
            boolean codeAccepted = adminCode.isEmpty() || true; // In the future, replace with actual validation
            
            if (username.isEmpty()) {
                errorMessageLabel.setText("Username is required.");
            } else if (codeAccepted) {
                errorMessageLabel.setText(""); // Clear any previous error message
                Navigation.navigateToWithUsername("AccountCreationUI", username); // Correct method call
            } else {
                errorMessageLabel.setText(""); // Clear any previous error message
                // Show some error message (not implemented here)
            }
        });

        // Skip button
        Button skipButton = new Button("Skip");
        skipButton.setStyle("-fx-background-color: #2196F3; -fx-text-fill: white; -fx-font-size: 12px; -fx-cursor: hand;");
        skipButton.setPadding(new Insets(10, 10, 10, 10)); // Smaller padding for skip button
        skipButton.setOnAction((ActionEvent event) -> {
            Navigation.navigateTo("LoginPage");
        });

        // Layout for buttons
        HBox buttonLayout = new HBox(10); // Small gap between buttons
        buttonLayout.setAlignment(Pos.CENTER);
        buttonLayout.getChildren().addAll(createAccountButton, skipButton);

        // Enable Enter key to create account or skip
        usernameField.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case ENTER:
                    createAccountButton.fire();
                    break;
                default:
                    break;
            }
        });

        // Layout adjustments
        VBox layout = new VBox(10);  // Reduced spacing between elements
        layout.setPadding(new Insets(20));  // Add padding around the layout
        layout.setAlignment(Pos.CENTER);  // Center the elements
        layout.getChildren().addAll(titleLabel, usernameField, adminCodeField, buttonLayout, errorMessageLabel);

        Scene scene = new Scene(layout, 350, 300);

        Navigation.registerScene("NewUserPage", scene);
    }
}
