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
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AdminCodePageUI {
	public static void RegisterWithNavigation() {
	
	// Create a label for page title
	Label titleLabel = new Label("Enter Admin Code");
	titleLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
		
	// Admin code field
	TextField adminCodeField = new TextField();
	adminCodeField.setPromptText("Enter admin code");
	adminCodeField.setMaxWidth(200);
	
	// Submit code button
    Button submitButton = new Button("Submit");
    submitButton.setStyle("-fx-background-color: #2196F3; -fx-text-fill: white; -fx-font-size: 14px; -fx-cursor: hand;");
    submitButton.setPadding(new Insets(10, 20, 10, 20));
    submitButton.setOnAction((ActionEvent event) ->{
    	String adminCode = adminCodeField.getText();
    	
    	// For now, accept any code
    	boolean codeAccepted = true; // In the future replace with validation
    	
    	if (codeAccepted) {
    		Navigation.navigateTo("AccountCreationPage");
    	} else {
    		// Show some error message
    	}
    });
    
    // Skip button
    Button skipButton = new Button("Skip");
    skipButton.setStyle("-fx-background-color: #2196F3; -fx-text-fill: white; -fx-font-size: 14px; -fx-cursor: hand;");
    skipButton.setPadding(new Insets(10, 20, 10, 20));
    skipButton.setOnAction((ActionEvent event) -> {
        Navigation.navigateTo("LoginPage");
    });
    
    // Enable Enter key to submit admin code
    adminCodeField.setOnKeyPressed(event -> {
    	switch (event.getCode()) {
    		case ENTER:
    			submitButton.fire();
    			break;
			default:
				break;
    	}
    });
    
 // Layout adjustments
    VBox layout = new VBox(15);  // Increased spacing between elements
    layout.setPadding(new Insets(20));  // Add padding around the layout
    layout.setAlignment(Pos.CENTER);  // Center the elements
    layout.getChildren().addAll(titleLabel, adminCodeField, submitButton, skipButton);
	
    Scene scene = new Scene(layout, 350, 250);
	
	Navigation.registerScene("AdminCodePage", scene);
}
}