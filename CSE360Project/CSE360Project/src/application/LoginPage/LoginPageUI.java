package application.LoginPage;

import application.Core.Navigation;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class LoginPageUI {
    public static void RegisterWithNavigation() {
        
        // Create a label for the page title
        Label titleLabel = new Label("Welcome, Please Log In");
        titleLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        // Username field
        TextField usernameField = new TextField();
        usernameField.setPromptText("Enter username");
        usernameField.setMaxWidth(200);

        // Password field
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Enter password");
        passwordField.setMaxWidth(200);

        // Login button with improved styling
        Button loginButton = new Button("Login");
        loginButton.setStyle("-fx-background-color: #2196F3; -fx-text-fill: white; -fx-font-size: 14px; -fx-cursor: hand;");
        loginButton.setPadding(new Insets(10, 20, 10, 20));
        loginButton.setMaxWidth(200);
        loginButton.setOnAction((ActionEvent event) -> {
            String username = usernameField.getText();
            String password = passwordField.getText();
            
            //add database logic here
            
            Navigation.navigateTo("HomePage");
        });

        // Admin login button
        Button adminLoginButton = new Button("Admin Login");
        adminLoginButton.setStyle("-fx-background-color: #FF0000; -fx-text-fill: white; -fx-font-size: 12px; -fx-cursor: hand;");
        adminLoginButton.setPadding(new Insets(10, 10, 10, 10));
        adminLoginButton.setMaxWidth(100); // Slightly wider to fit the text
        adminLoginButton.setOnAction((ActionEvent event) -> {
            Navigation.navigateTo("AdminHomePage");
        });

        // Align admin button to the right
        StackPane adminButtonWrapper = new StackPane(adminLoginButton);
        StackPane.setAlignment(adminLoginButton, Pos.CENTER_RIGHT);
        adminButtonWrapper.setMaxWidth(200);

        // Layout adjustments
        VBox layout = new VBox(15);  // Increased spacing between elements
        layout.setPadding(new Insets(20));  // Add padding around the layout
        layout.setAlignment(Pos.CENTER);  // Center the elements
        layout.getChildren().addAll(titleLabel, usernameField, passwordField, loginButton, adminButtonWrapper);

        Scene scene = new Scene(layout, 350, 300);

        Navigation.registerScene("LoginPage", scene);
    }
}
